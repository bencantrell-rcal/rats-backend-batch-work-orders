package com.rcal.work_orders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.rcal.work_orders.service.BatchService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WorkOrdersApplication implements CommandLineRunner{

  private final BatchService batchService;

  // Constructor injection for Spring-managed bean
  public WorkOrdersApplication(BatchService batchService) {
    this.batchService = batchService;
  }

  public static void main(String[] args){
    SpringApplication.run(WorkOrdersApplication.class,args);
  }

  @Override
  public void run(String... args){
    try{
      batchService.normalJob();
      System.exit(0);
    } catch (Exception ex){
      System.exit(1);
    }
  }
}
