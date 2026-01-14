package com.rcal.work_orders.service;

import com.rcal.work_orders.entity.WorkOrder;
import com.rcal.work_orders.repository.read.ReadWorkOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkOrderService{

  private ReadWorkOrderRepository readWorkOrderRepository;

  public WorkOrderService(ReadWorkOrderRepository readWorkOrderRepository) {
    this.readWorkOrderRepository = readWorkOrderRepository;
  }

  public WorkOrder findByWorkOrderNumber(String workOrderNumber){
    return readWorkOrderRepository.findByWorkOrderNumber(workOrderNumber);
  }
}
