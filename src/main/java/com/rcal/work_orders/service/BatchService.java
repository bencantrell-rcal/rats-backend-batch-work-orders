package com.rcal.work_orders.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class BatchService{

  private WorkOrderService workOrderService;

  public BatchService(WorkOrderService workOrderService) {
    this.workOrderService = workOrderService;
  }

  public void normalJob(){
    System.out.println(workOrderService.findByWorkOrderNumber("9337-1"));
  }
}
