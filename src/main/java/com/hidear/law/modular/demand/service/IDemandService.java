package com.hidear.law.modular.demand.service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface IDemandService<D,S> {

    /**
     * 根据搜索条件查询
     * @param s 搜索条件
     * @return 搜索结果
     */
    public List<D> findDemandBySearch(S s);
}
