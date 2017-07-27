package com.cycloneboy.springmvc.dao;

import com.cycloneboy.springmvc.entity.Orders;
import com.cycloneboy.springmvc.entity.OrdersExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OrdersMapper {
    @SelectProvider(type=OrdersSqlProvider.class, method="countByExample")
    int countByExample(OrdersExample example);

    @DeleteProvider(type=OrdersSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrdersExample example);

    @Delete({
        "delete from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into orders (id, user_id, ",
        "number, createtime, ",
        "note)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{number,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Orders record);

    @InsertProvider(type=OrdersSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insertSelective(Orders record);

    @SelectProvider(type=OrdersSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType= JdbcType.INTEGER),
        @Result(column="number", property="number", jdbcType= JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="note", property="note", jdbcType= JdbcType.VARCHAR)
    })
    List<Orders> selectByExample(OrdersExample example);

    @Select({
        "select",
        "id, user_id, number, createtime, note",
        "from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType= JdbcType.INTEGER),
        @Result(column="number", property="number", jdbcType= JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="note", property="note", jdbcType= JdbcType.VARCHAR)
    })
    Orders selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrdersSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    @UpdateProvider(type=OrdersSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    @UpdateProvider(type=OrdersSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Orders record);

    @Update({
        "update orders",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "number = #{number,jdbcType=VARCHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Orders record);
}