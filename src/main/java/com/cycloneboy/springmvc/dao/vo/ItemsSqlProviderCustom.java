package com.cycloneboy.springmvc.dao.vo;

import com.cycloneboy.springmvc.dao.ItemsSqlProvider;
import com.cycloneboy.springmvc.entity.vo.ItemsQueryVo;

import static org.apache.ibatis.jdbc.SqlBuilder.*;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;

/**
 * Created by CycloneBoy on 2017/7/27.
 */
public class ItemsSqlProviderCustom extends ItemsSqlProvider{

    public String findItemsList(ItemsQueryVo itemsQueryVo){
        BEGIN();
        SELECT("id");
        SELECT("name");
        SELECT("price");
        SELECT("pic");
        SELECT("createtime");
        SELECT("detail");
        FROM("items");

        if(itemsQueryVo != null){
            if (itemsQueryVo.getItemsCustom().getName() != null &&
                    itemsQueryVo.getItemsCustom().getName() != ""){
                WHERE("name LIKE CONCAT('%',#{itemsCustom.name},'%') ");
            }
        }

        return SQL();
    }
}
