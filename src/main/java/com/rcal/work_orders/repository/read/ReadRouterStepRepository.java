package com.rcal.work_orders.repository.read;

import com.rcal.work_orders.entity.RouterStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(transactionManager = "readTransactionManager", readOnly = true)
public interface ReadRouterStepRepository
    extends
      JpaRepository<RouterStep, Integer>{
  List<RouterStep> findByWorkOrderNumber(String workOrderNumber);
}