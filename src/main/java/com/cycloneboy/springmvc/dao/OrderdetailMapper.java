package com.cycloneboy.springmvc.dao;

import com.cycloneboy.springmvc.entity.Orderdetail;
import com.cycloneboy.springmvc.entity.OrderdetailExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OrderdetailMapper {
    @SelectProvider(type=OrderdetailSqlProvider.class, method="countByExample")
    int countByExample(OrderdetailExample example);

    @DeleteProvider(type=OrderdetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderdetailExample example);

    @Delete({
        "delete from orderdetail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into orderdetail (id, orders_id, ",
        "items_id, items_num)",
        "values (#{id,jdbcType=INTEGER}, #{ordersId,jdbcType=INTEGER}, ",
        "#{itemsId,jdbcType=INTEGER}, #{itemsNum,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Orderdetail record);

    @InsertProvider(type=OrderdetailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insertSelective(Orderdetail record);

    @SelectProvider(type=OrderdetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="orders_id", property="ordersId", jdbcType= JdbcType.INTEGER),
        @Result(column="items_id", property="itemsId", jdbcType= JdbcType.INTEGER),
        @Result(column="items_num", property="itemsNum", jdbcType= JdbcType.INTEGER)
    })
    List<Orderdetail> selectByExample(OrderdetailExample example);

    @Select({
        "select",
        "id, orders_id, items_id, items_num",
        "from orderdetail",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="orders_id", property="ordersId", jdbcType= JdbcType.INTEGER),
        @Result(column="items_id", property="itemsId", jdbcType= JdbcType.INTEGER),
        @Result(column="items_num", property="itemsNum", jdbcType= JdbcType.INTEGER)
    })
    Orderdetail selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrderdetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    @UpdateProvider(type=OrderdetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    @UpdateProvider(type=OrderdetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Orderdetail record);

    @Update({
        "update orderdetail",
        "set orders_id = #{ordersId,jdbcType=INTEGER},",
          "items_id = #{itemsId,jdbcType=INTEGER},",
          "items_num = #{itemsNum,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Orderdetail record);
}