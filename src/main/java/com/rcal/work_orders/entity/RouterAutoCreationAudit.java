package com.rcal.work_orders.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "router_auto_creation_audit")
public class RouterAutoCreationAudit{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "audit_id")
  private Long id;

  @Column(name = "assy")
  private String assembly;

  @Column(name = "source_wo")
  private String sourceWorkOrder;

  @Column(name = "destination_wo")
  private String destinationWorkOrder;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", insertable = false, updatable = false)
  private Date createdAt;

}
