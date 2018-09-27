package com.pingyougou.entity;

import com.pingyougou.pojo.TbGoods;
import com.pingyougou.pojo.TbGoodsDesc;
import com.pingyougou.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

public class goods implements Serializable{
    private TbGoods goods;
    private TbGoodsDesc goodsDesc;
    private List<TbItem> ItemList;

    public TbGoods getGoods() {
        return goods;
    }

    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }

    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List <TbItem> getItemList() {
        return ItemList;
    }

    public void setItemList(List <TbItem> itemList) {
        ItemList = itemList;
    }

    @Override
    public String toString() {
        return "goods{" +
                "goods=" + goods +
                ", goodsDesc=" + goodsDesc +
                ", ItemList=" + ItemList +
                '}';
    }
}
