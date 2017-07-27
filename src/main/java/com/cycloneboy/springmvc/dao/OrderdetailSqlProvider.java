package com.cycloneboy.springmvc.dao;

import com.cycloneboy.springmvc.entity.Orderdetail;
import com.cycloneboy.springmvc.entity.OrderdetailExample;
import com.cycloneboy.springmvc.entity.OrderdetailExample.Criteria;
import com.cycloneboy.springmvc.entity.OrderdetailExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class OrderdetailSqlProvider {

    public String countByExample(OrderdetailExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("orderdetail");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(OrderdetailExample example) {
        BEGIN();
        DELETE_FROM("orderdetail");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Orderdetail record) {
        BEGIN();
        INSERT_INTO("orderdetail");
        
        VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getOrdersId() != null) {
            VALUES("orders_id", "#{ordersId,jdbcType=INTEGER}");
        }
        
        if (record.getItemsId() != null) {
            VALUES("items_id", "#{itemsId,jdbcType=INTEGER}");
        }
        
        if (record.getItemsNum() != null) {
            VALUES("items_num", "#{itemsNum,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(OrderdetailExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("orders_id");
        SELECT("items_id");
        SELECT("items_num");
        FROM("orderdetail");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Orderdetail record = (Orderdetail) parameter.get("record");
        OrderdetailExample example = (OrderdetailExample) parameter.get("example");
        
        BEGIN();
        UPDATE("orderdetail");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getOrdersId() != null) {
            SET("orders_id = #{record.ordersId,jdbcType=INTEGER}");
        }
        
        if (record.getItemsId() != null) {
            SET("items_id = #{record.itemsId,jdbcType=INTEGER}");
        }
        
        if (record.getItemsNum() != null) {
            SET("items_num = #{record.itemsNum,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("orderdetail");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("orders_id = #{record.ordersId,jdbcType=INTEGER}");
        SET("items_id = #{record.itemsId,jdbcType=INTEGER}");
        SET("items_num = #{record.itemsNum,jdbcType=INTEGER}");
        
        OrderdetailExample example = (OrderdetailExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Orderdetail record) {
        BEGIN();
        UPDATE("orderdetail");
        
        if (record.getOrdersId() != null) {
            SET("orders_id = #{ordersId,jdbcType=INTEGER}");
        }
        
        if (record.getItemsId() != null) {
            SET("items_id = #{itemsId,jdbcType=INTEGER}");
        }
        
        if (record.getItemsNum() != null) {
            SET("items_num = #{itemsNum,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(OrderdetailExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}