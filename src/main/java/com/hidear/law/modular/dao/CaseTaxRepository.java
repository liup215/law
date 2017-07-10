package com.hidear.law.modular.dao;

import com.hidear.law.modular.model.DemandTax;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/10.
 */
public interface CaseTaxRepository extends JpaRepository<DemandTax,Integer>{
}
