package com.cycloneboy.springmvc.dao;

import com.cycloneboy.springmvc.entity.Items;
import com.cycloneboy.springmvc.entity.ItemsExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ItemsMapper {
    @SelectProvider(type=ItemsSqlProvider.class, method="countByExample")
    int countByExample(ItemsExample example);

    @DeleteProvider(type=ItemsSqlProvider.class, method="deleteByExample")
    int deleteByExample(ItemsExample example);

    @Delete({
        "delete from items",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into items (id, name, ",
        "price, pic, createtime, ",
        "detail)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=REAL}, #{pic,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{detail,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Items record);

    @InsertProvider(type=ItemsSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insertSelective(Items record);

    @SelectProvider(type=ItemsSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType= JdbcType.REAL),
        @Result(column="pic", property="pic", jdbcType= JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="detail", property="detail", jdbcType= JdbcType.LONGVARCHAR)
    })
    List<Items> selectByExampleWithBLOBs(ItemsExample example);

    @SelectProvider(type=ItemsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType= JdbcType.REAL),
        @Result(column="pic", property="pic", jdbcType= JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType= JdbcType.TIMESTAMP)
    })
    List<Items> selectByExample(ItemsExample example);

    @Select({
        "select",
        "id, name, price, pic, createtime, detail",
        "from items",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType= JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType= JdbcType.REAL),
        @Result(column="pic", property="pic", jdbcType= JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType= JdbcType.TIMESTAMP),
        @Result(column="detail", property="detail", jdbcType= JdbcType.LONGVARCHAR)
    })
    Items selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ItemsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    @UpdateProvider(type=ItemsSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Items record, @Param("example") ItemsExample example);

    @UpdateProvider(type=ItemsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    @UpdateProvider(type=ItemsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Items record);

    @Update({
        "update items",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=REAL},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "detail = #{detail,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Items record);

    @Update({
        "update items",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=REAL},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Items record);
}