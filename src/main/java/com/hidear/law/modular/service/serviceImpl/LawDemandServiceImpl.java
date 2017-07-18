package com.hidear.law.modular.service.serviceImpl;

import com.hidear.law.modular.dao.DemandLawRepository;
import com.hidear.law.modular.model.DemandLaw;
import com.hidear.law.modular.service.IDemandService;
import com.hidear.law.modular.transfer.LawSearchTF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
public class LawDemandServiceImpl implements IDemandService<DemandLaw,LawSearchTF>{

    @Autowired
    DemandLawRepository demandLawRepository;

    @Override
    public List<DemandLaw> findDemandBySearch(LawSearchTF lawSearchTF) {

        List<DemandLaw> list = null;

        //处理排序
        Sort sort = new Sort(Sort.Direction.fromStringOrNull(lawSearchTF.getSortType()),lawSearchTF.getSortColumn());
        //处理分页
        Pageable page = new PageRequest(lawSearchTF.getPageNumber()!=null? (lawSearchTF.getPageNumber()-1):0,lawSearchTF.getPageSize()!=null?lawSearchTF.getPageSize():25,sort);

        list = demandLawRepository.findAll(getSpec(lawSearchTF),page).getContent();
        return list;
    }

    /**
     * 创建动态查询
     * @param lawSearchTF 搜索条件
     * @return 返回查询
     */
    private Specification<DemandLaw> getSpec(LawSearchTF lawSearchTF){
        return new Specification<DemandLaw>() {
            @Override
            public Predicate toPredicate(Root<DemandLaw> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p = null;

                if(lawSearchTF.getContactAddress()!=null && !lawSearchTF.getContactAddress().trim().equals("")){
                    Predicate px = criteriaBuilder.like(root.get("contactAddress"),lawSearchTF.getContactAddress()+"%");
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if(lawSearchTF.getAccusedArea()!=null && !lawSearchTF.getAccusedArea().trim().equals("")){
                    Predicate px = criteriaBuilder.like(root.get("accusedArea"),lawSearchTF.getAccusedArea()+"%");
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if(lawSearchTF.getContractArea()!=null && !lawSearchTF.getContractArea().trim().equals("")){
                    Predicate px = criteriaBuilder.like(root.get("contractArea"),lawSearchTF.getContractArea()+"%");
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if(lawSearchTF.getVenueArea()!=null && !lawSearchTF.getVenueArea().trim().equals("")){
                    Predicate px = criteriaBuilder.like(root.get("venueArea"),lawSearchTF.getVenueArea()+"%");
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if (lawSearchTF.getCaseType()!=null){

                    Predicate px = criteriaBuilder.equal(root.get("caseType"),lawSearchTF.getCaseType());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if (lawSearchTF.getWorkType()!=null){

                    Predicate px = criteriaBuilder.equal(root.get("workType"),lawSearchTF.getWorkType());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if (lawSearchTF.getStatus()!=null){
                    Predicate px = criteriaBuilder.equal(root.get("status"),lawSearchTF.getStatus());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if(lawSearchTF.getUpdateTimeMin()!=null){
                    Predicate px = criteriaBuilder.greaterThanOrEqualTo(root.get("updateTime"),lawSearchTF.getUpdateTimeMin());
                    if(p!=null){
                        p = criteriaBuilder.and(p,px);
                    }else{
                        p = px;
                    }
                }

                if(lawSearchTF.getUpdateTimeMax()!=null){
                    Predicate px = criteriaBuilder.lessThan(root.get("updateTime"),lawSearchTF.getUpdateTimeMax());
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
