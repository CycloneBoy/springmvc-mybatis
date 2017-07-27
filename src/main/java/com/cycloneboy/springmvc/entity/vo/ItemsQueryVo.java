package com.cycloneboy.springmvc.entity.vo;

import com.cycloneboy.springmvc.entity.Items;

/**
 * Created by CycloneBoy on 2017/7/27.
 */
public class ItemsQueryVo {

    private Items items;
    private ItemsCustom itemsCustom;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }
}
