package com.rcal.work_orders.repository.write;

import com.rcal.work_orders.entity.RouterStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("writeTransactionManager")
public interface WriteRouterStepRepository
    extends
      JpaRepository<RouterStep, Integer>{

}
