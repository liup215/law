package com.hidear.law.modular.service.serviceImpl;

import com.hidear.law.modular.dao.DemandTaxRepository;
import com.hidear.law.modular.model.DemandTax;
import com.hidear.law.modular.service.IDemandService;
import com.hidear.law.modular.transfer.TaxSearchTF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */
@Service
public class TaxDemandServiceImpl implements IDemandService<DemandTax,TaxSearchTF>{

    @Autowired
    DemandTaxRepository demandTaxRepository;

    @Override
    public List<DemandTax> findDemandBySearch(TaxSearchTF taxSearchTF) {
        List<DemandTax> list = null;

        Sort sort = new Sort(Sort.Direction.fromStringOrNull(taxSearchTF.getSortType()),taxSearchTF.getSortColumn());
        Pageable page = new PageRequest(taxSearchTF.getPageNumber()!=null? (taxSearchTF.getPageNumber()-1):0,taxSearchTF.getPageSize()!=null?taxSearchTF.getPageSize():25,sort);

        list = demandTaxRepository.findAll(getSpec(taxSearchTF),page).getContent();
        return list;
    }

    private Specification<DemandTax> getSpec(TaxSearchTF taxSearchTF){
        return new Specification<DemandTax>() {
            @Override
            public Predicate toPredicate(Root<DemandTax> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                Predicate p = null;
                if (taxSearchTF.getProvince()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("province"),taxSearchTF.getProvince());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }
                if (taxSearchTF.getCity()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("city"),taxSearchTF.getCity());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }
                if (taxSearchTF.getTown()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("town"),taxSearchTF.getTown());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }
                if (taxSearchTF.getCounty()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("county"),taxSearchTF.getCounty());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }
                if (taxSearchTF.getScaleMin()!=null){
                    Predicate px = criteriaBuilder.greaterThanOrEqualTo(root.get("scale"),taxSearchTF.getScaleMin());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if (taxSearchTF.getScaleMax()!=null){
                    Predicate px = criteriaBuilder.lessThan(root.get("scale"),taxSearchTF.getScaleMax());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }
                if (taxSearchTF.getAssetsMin()!=null){
                    Predicate px = criteriaBuilder.greaterThanOrEqualTo(root.get("assets"),taxSearchTF.getAssetsMin());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if (taxSearchTF.getAssetsMax()!=null){
                    Predicate px = criteriaBuilder.lessThan(root.get("assets"),taxSearchTF.getAssetsMax());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if (taxSearchTF.getOutputMin()!=null){
                    Predicate px = criteriaBuilder.greaterThanOrEqualTo(root.get("output"),taxSearchTF.getOutputMin());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }
                if (taxSearchTF.getOutputMax()!=null){
                    Predicate px = criteriaBuilder.lessThan(root.get("output"),taxSearchTF.getOutputMax());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }
                if (taxSearchTF.getWorkType()!=null){
                    System.out.println("******************"+taxSearchTF.getWorkType());
                    Predicate px = criteriaBuilder.equal(root.get("workType"),taxSearchTF.getWorkType());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }
                if (taxSearchTF.getPost()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("post"),taxSearchTF.getPost());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }
                if (taxSearchTF.getStatus()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("status"),taxSearchTF.getStatus());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if(taxSearchTF.getUpdateTimeMin()!=null){
                    Predicate px = criteriaBuilder.greaterThanOrEqualTo(root.get("assets"),taxSearchTF.getUpdateTimeMin());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if(taxSearchTF.getUpdateTimeMax()!=null){
                    Predicate px = criteriaBuilder.lessThan(root.get("assets"),taxSearchTF.getUpdateTimeMax());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }


                return p;
            }
        };
    }

}
