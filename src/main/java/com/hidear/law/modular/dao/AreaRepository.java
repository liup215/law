package com.hidear.law.modular.dao;

import com.hidear.law.modular.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
public interface AreaRepository extends JpaRepository<Area,Integer>,JpaSpecificationExecutor<Area>{

    public List<Area> findByParentId(Integer id);
    public List<Area> findByParentIdAndStatus(Integer id,Integer status);

    @Query("from Area a where a.id = (select parentId from a where a.id=:id)")
    public Area findParentArea(@Param("id") Integer id);
}
