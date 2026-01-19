package com.rcal.work_orders.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_routers")
public class RouterStep{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "rtid")
  private Long id;

  @Column(name = "WO", length = 40)
  private String workOrderNumber;

  @Column(name = "Task_Id")
  private Integer taskId;

  @Column(name = "Target_Time")
  private Float targetTime;

  @Column(name = "Target_Time_Units_Id")
  private Integer targetTimeUnitsId;

  @Column(name = "Target_Time_Per_Entity")
  private Integer targetTimePerEntity;

  @Column(name = "Scan_Required")
  private Short scanRequired;

  @Column(name = "Result_Required")
  private Short resultRequired;

  @Column(name = "Allow_Missing_Scans")
  private Short allowMissingScans;

  @Column(name = "Total_Time_Secs")
  private Integer totalTimeSecs;

  @Column(name = "Working_Time_Secs")
  private Integer workingTimeSecs;

  @Column(name = "Number_Completed")
  private Integer numberCompleted;

  @Column(name = "Number_Defective")
  private Integer numberDefective;

  @Column(name = "Description", length = 255)
  private String description;

  @Column(name = "Build_Order")
  private Short buildOrder;

  @Column(name = "Number_Failed_First")
  private Integer numberFailedFirst;

  @Column(name = "Number_Passed_First")
  private Integer numberPassedFirst;

  @Column(name = "Min_Workers")
  private Integer minWorkers;

  @Column(name = "Max_Workers")
  private Integer maxWorkers;

  @Column(name = "Schedule_Is_Available")
  private Integer scheduleIsAvailable;

  @Column(name = "Schedule_Efficiency", length = 45)
  private String scheduleEfficiency;

  @Column(name = "Skill_Level")
  private Double skillLevel;
}
