package com.hidear.law.modular.demand.dao;

import com.hidear.law.modular.demand.model.DemandTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017/7/10.
 */
public interface DemandTaxRepository extends JpaRepository<DemandTax,Integer>,JpaSpecificationExecutor<DemandTax> {

}
