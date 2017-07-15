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

        if(taxSearchTF==null){
            list = demandTaxRepository.findAll();
            return list;
        }

        Sort sort = new Sort(Sort.Direction.fromStringOrNull(taxSearchTF.getSortType()),taxSearchTF.getSortColumn());
        Pageable page = new PageRequest(taxSearchTF.getPageNumber()-1,taxSearchTF.getPageSize(),sort);

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
                    }
                }
                if (taxSearchTF.getCity()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("city"),taxSearchTF.getCity());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }
                }
                if (taxSearchTF.getTown()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("town"),taxSearchTF.getTown());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }
                }
                if (taxSearchTF.getCounty()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("county"),taxSearchTF.getCounty());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }
                }
                if (taxSearchTF.getScaleMin()!=null && taxSearchTF.getScaleMax()!=null){
                    Predicate px = criteriaBuilder.between(root.get("scale"),taxSearchTF.getScaleMin(),taxSearchTF.getScaleMax());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }
                }
                if (taxSearchTF.getAssetsMin()!=null && taxSearchTF.getAssetsMin()!=null){
                    Predicate px = criteriaBuilder.between(root.get("assets"),taxSearchTF.getAssetsMin(),taxSearchTF.getAssetsMax());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }
                }
                if (taxSearchTF.getOutputMin()!=null && taxSearchTF.getOutputMax()!=null){
                    Predicate px = criteriaBuilder.between(root.get("output"),taxSearchTF.getOutputMin(),taxSearchTF.getOutputMax());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }
                }
                if (taxSearchTF.getWorkType()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("workType"),taxSearchTF.getWorkType());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }
                }
                if (taxSearchTF.getPost()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("post"),taxSearchTF.getPost());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }
                }
                if (taxSearchTF.getStatus()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("status"),taxSearchTF.getStatus());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }
                }

                if(taxSearchTF.getUpdateTimeMin()!=null&&taxSearchTF.getUpdateTimeMax()!=null){
                    Predicate px = criteriaBuilder.between(root.get("assets"),taxSearchTF.getUpdateTimeMin(),taxSearchTF.getUpdateTimeMax());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }
                }



                return p;
            }
        };
    }

}
