package com.cycloneboy.springmvc.service;

import com.cycloneboy.springmvc.entity.vo.ItemsCustom;
import com.cycloneboy.springmvc.entity.vo.ItemsQueryVo;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/27.
 */
public interface ItemsService {

    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
