package com.rcal.work_orders.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "wos")
public class WorkOrder{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "wo_id")
  private Integer id;

  @Column(name = "wo_number")
  private String workOrderNumber;

  @Column(name = "Customer_Number")
  private Integer customerNumber;

  @Column(name = "Assy")
  private String assembly;

  @Column(name = "Description")
  private String description;

  @Column(name = "Qty_Completed")
  private Float qtyCompleted;

  @Column(name = "Qty_Scrapped")
  private Float qtyScrapped;

  @Column(name = "Qty")
  private Float qty;

  @Column(name = "Scheduled_Finish")
  private Date scheduledFinish;

  @Column(name = "Scheduled_Start")
  private Date scheduledStart;

  @Column(name = "Type")
  private Integer type;

  @Column(name = "Kit_Line_Percent")
  private Double kitLinePercent;
}
