package com.rcal.work_orders.service;

import com.rcal.work_orders.entity.WorkOrder;
import com.rcal.work_orders.repository.read.ReadWorkOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderService{

  private ReadWorkOrderRepository readWorkOrderRepository;

  public WorkOrderService(ReadWorkOrderRepository readWorkOrderRepository) {
    this.readWorkOrderRepository = readWorkOrderRepository;
  }

  public WorkOrder findByWorkOrderNumber(String workOrderNumber){
    return readWorkOrderRepository.findByWorkOrderNumber(workOrderNumber);
  }

  public List<String> getRouterlessWorkOrdersLast6Months(){
    return readWorkOrderRepository.findRouterlessWorkOrdersLast6Months();
  }

  public String getMostRecentPreviousWorkOrder(String workOrderNumber){
    return readWorkOrderRepository
        .findMostRecentPreviousWorkOrder(workOrderNumber);
  }
}
