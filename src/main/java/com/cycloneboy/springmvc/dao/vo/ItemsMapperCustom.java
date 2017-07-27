package com.cycloneboy.springmvc.dao.vo;

import com.cycloneboy.springmvc.dao.ItemsSqlProvider;
import com.cycloneboy.springmvc.entity.vo.ItemsCustom;
import com.cycloneboy.springmvc.entity.vo.ItemsQueryVo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/27.
 */
public interface ItemsMapperCustom {



    @SelectProvider(type=ItemsSqlProviderCustom.class, method="findItemsList")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
            @Result(column="price", property="price", jdbcType= JdbcType.REAL),
            @Result(column="pic", property="pic", jdbcType= JdbcType.VARCHAR),
            @Result(column="createtime", property="createtime", jdbcType= JdbcType.TIMESTAMP)
    })
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo);
}
