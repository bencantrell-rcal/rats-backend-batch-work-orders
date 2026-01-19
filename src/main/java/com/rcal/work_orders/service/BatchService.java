package com.rcal.work_orders.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BatchService{

  private WorkOrderService workOrderService;
  private RouterStepService routerStepService;

  public BatchService(WorkOrderService workOrderService,
      RouterStepService routerStepService) {
    this.workOrderService = workOrderService;
    this.routerStepService = routerStepService;
  }

  public void normalJob(){
    List<String> routerlessWorkOrders = workOrderService
        .getRouterlessWorkOrdersLast6Months();
    for (String workOrderNumber : routerlessWorkOrders){
      routerStepService.copyRouterSteps(
          workOrderService.getMostRecentPreviousWorkOrder(workOrderNumber),
          workOrderNumber);
    }
  }
}
