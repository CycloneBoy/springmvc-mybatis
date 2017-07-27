package com.cycloneboy.springmvc.entity.vo;

import com.cycloneboy.springmvc.entity.Items;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/27.
 */
public class ItemsQueryVo {

    private Items items;
    private ItemsCustom itemsCustom;

    private List<ItemsCustom> itemsList;

    public List<ItemsCustom> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsCustom> itemsList) {
        this.itemsList = itemsList;
    }

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
