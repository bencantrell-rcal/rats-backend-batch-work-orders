package com.rcal.work_orders.service;

import com.rcal.work_orders.entity.RouterAutoCreationAudit;
import com.rcal.work_orders.entity.RouterStep;
import com.rcal.work_orders.entity.WorkOrder;
import com.rcal.work_orders.repository.read.ReadRouterStepRepository;
import com.rcal.work_orders.repository.read.ReadWorkOrderRepository;
import com.rcal.work_orders.repository.write.WriteRouterAutoCreationAuditRepository;
import com.rcal.work_orders.repository.write.WriteRouterStepRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouterStepService{
  private ReadRouterStepRepository readRouterStepRepository;
  private ReadWorkOrderRepository readWorkOrderRepository;
  private WriteRouterStepRepository writeRouterStepRepository;
  private WriteRouterAutoCreationAuditRepository writeRouterAutoCreationAuditRepository;

  public RouterStepService(ReadRouterStepRepository readRouterStepRepository,
      ReadWorkOrderRepository readWorkOrderRepository,
      WriteRouterStepRepository writeRouterStepRepository,
      WriteRouterAutoCreationAuditRepository writeRouterAutoCreationAuditRepository) {
    this.readRouterStepRepository = readRouterStepRepository;
    this.readWorkOrderRepository = readWorkOrderRepository;
    this.writeRouterStepRepository = writeRouterStepRepository;
    this.writeRouterAutoCreationAuditRepository = writeRouterAutoCreationAuditRepository;
  }

  public void copyRouterSteps(String sourceWorkOrderNumber,
      String destinationWorkOrderNumber){

    if (readRouterStepRepository.findByWorkOrderNumber(sourceWorkOrderNumber)
        .isEmpty()){
      return;
    }

    if (!readRouterStepRepository
        .findByWorkOrderNumber(destinationWorkOrderNumber).isEmpty()){
      return;
    }

    List<RouterStep> sourceRouterSteps = readRouterStepRepository
        .findByWorkOrderNumber(sourceWorkOrderNumber);
    List<RouterStep> destinationRouterSteps = new ArrayList<>();
    for (RouterStep routerStep : sourceRouterSteps){

      RouterStep destinationRouterStep = new RouterStep();

      destinationRouterStep.setWorkOrderNumber(destinationWorkOrderNumber);
      destinationRouterStep.setTaskId(routerStep.getTaskId());
      destinationRouterStep.setTargetTime(routerStep.getTargetTime());
      destinationRouterStep
          .setTargetTimeUnitsId(routerStep.getTargetTimeUnitsId());
      destinationRouterStep
          .setTargetTimePerEntity(routerStep.getTargetTimePerEntity());
      destinationRouterStep.setScanRequired(routerStep.getScanRequired());
      destinationRouterStep.setResultRequired(routerStep.getResultRequired());
      destinationRouterStep
          .setAllowMissingScans(routerStep.getAllowMissingScans());
      destinationRouterStep.setTotalTimeSecs(null);
      destinationRouterStep.setWorkingTimeSecs(null);
      destinationRouterStep.setNumberCompleted(0);
      destinationRouterStep.setNumberDefective(0);
      destinationRouterStep.setDescription(routerStep.getDescription());
      destinationRouterStep.setBuildOrder(routerStep.getBuildOrder());
      destinationRouterStep.setNumberFailedFirst(0);
      destinationRouterStep.setNumberPassedFirst(0);
      destinationRouterStep.setMinWorkers(routerStep.getMinWorkers());
      destinationRouterStep.setMaxWorkers(routerStep.getMaxWorkers());
      destinationRouterStep
          .setScheduleIsAvailable(routerStep.getScheduleIsAvailable());
      destinationRouterStep
          .setScheduleEfficiency(routerStep.getScheduleEfficiency());
      destinationRouterStep.setSkillLevel(routerStep.getSkillLevel());

      destinationRouterSteps.add(destinationRouterStep);
    }

    writeRouterStepRepository.saveAll(destinationRouterSteps);

    // post to auditing table with assy, sourceWorkOrderNumber,
    // destinationWorkOrderNumber

    WorkOrder sourceWorkOrder = readWorkOrderRepository
        .findByWorkOrderNumber(sourceWorkOrderNumber);

    RouterAutoCreationAudit audit = new RouterAutoCreationAudit();
    audit.setAssembly(sourceWorkOrder.getAssembly());
    audit.setSourceWorkOrder(sourceWorkOrderNumber);
    audit.setDestinationWorkOrder(destinationWorkOrderNumber);

    writeRouterAutoCreationAuditRepository.save(audit);

    System.out.println("Copied router with source = " + sourceWorkOrderNumber
        + " and destination = " + destinationWorkOrderNumber);
  }
}
