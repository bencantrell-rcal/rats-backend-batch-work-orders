package com.rcal.work_orders.repository.read;

import com.rcal.work_orders.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional(transactionManager = "readTransactionManager", readOnly = true)
public interface ReadWorkOrderRepository
    extends
      JpaRepository<WorkOrder, Integer>{

  @Query(value = "SELECT * FROM wos WHERE wo_number = :workOrderNumber", nativeQuery = true)
  WorkOrder findByWorkOrderNumber(
      @Param("workOrderNumber") String workOrderNumber);

}
