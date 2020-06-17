package com.ljs.dao;

import com.ljs.entity.Goods;
import com.ljs.entity.Sale;

/**
 * create by ljs on 2020/6/16 15:41
 * <p>
 * description:
 */
public interface GoodsDao {


    Integer modifyGoods(Sale sale);


    Goods selectGoods(Integer id);



}
