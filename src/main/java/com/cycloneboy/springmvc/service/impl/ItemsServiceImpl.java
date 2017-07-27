package com.cycloneboy.springmvc.service.impl;

import com.cycloneboy.springmvc.dao.vo.ItemsMapperCustom;
import com.cycloneboy.springmvc.entity.vo.ItemsCustom;
import com.cycloneboy.springmvc.entity.vo.ItemsQueryVo;
import com.cycloneboy.springmvc.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/27.
 */
public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {

        return  itemsMapperCustom.findItemsList(itemsQueryVo);
    }
}
