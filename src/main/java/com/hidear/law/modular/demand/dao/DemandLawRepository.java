package com.hidear.law.modular.demand.dao;

import com.hidear.law.modular.demand.model.DemandLaw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017/7/13.
 */
public interface DemandLawRepository extends JpaRepository<DemandLaw,Integer>,JpaSpecificationExecutor<DemandLaw> {
}
