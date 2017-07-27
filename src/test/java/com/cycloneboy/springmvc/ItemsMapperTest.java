package com.cycloneboy.springmvc;

import com.cycloneboy.springmvc.dao.ItemsMapper;
import com.cycloneboy.springmvc.dao.vo.ItemsMapperCustom;
import com.cycloneboy.springmvc.entity.Items;
import com.cycloneboy.springmvc.entity.vo.ItemsCustom;
import com.cycloneboy.springmvc.entity.vo.ItemsQueryVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/27.
 */
public class ItemsMapperTest {

    ApplicationContext applicationContext = null;

    @Before
    public void setUp() throws  Exception{

        applicationContext = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext-dao.xml");

    }

    @Test
    public void testSelectByPrimaryKey(){
        ItemsMapper itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
        Items items = itemsMapper.selectByPrimaryKey(1);
        System.out.println(items);
    }

    @Test
    public void testFindItemsList() throws Exception {
        ItemsMapperCustom itemsMapper = (ItemsMapperCustom) applicationContext.getBean("itemsMapperCustom");

        ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
        ItemsCustom itemsCustom = new ItemsCustom();
        itemsCustom.setName("米");
        itemsQueryVo.setItemsCustom(itemsCustom);


        List<ItemsCustom> itemsCustomList = itemsMapper.findItemsList(itemsQueryVo);
        System.out.println(itemsCustomList);
    }

}
