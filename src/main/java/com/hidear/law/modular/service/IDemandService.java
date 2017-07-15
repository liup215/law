package com.hidear.law.modular.service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface IDemandService<D,S> {
    public List<D> findDemandBySearch(S s);
}
