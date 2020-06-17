package com.ljs.service.impl;

import com.ljs.dao.GoodsDao;
import com.ljs.dao.SaleDao;
import com.ljs.entity.Goods;
import com.ljs.entity.Sale;
import com.ljs.exception.NotEnoughException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by ljs on 2020/6/16 15:46
 * <p>
 * description:
 */

@Service
public class SaleGoodService implements com.ljs.service.SaleGoodService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private SaleDao saleDao;

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED
    )
    public void SaleGood(int gid, int count) {

        /**
         *  1） 先记录销售记录
         *  2） 去库存
         */

        Sale sale = new Sale();
        sale.setGid(gid);
        sale.setCount(count);

        Integer integer = saleDao.insertSale(sale);

        /**
         *  1) 查看是否存在这个商品
         *  2） 商品货存是否足够
         *
         */

        Goods goods = goodsDao.selectGoods(gid);
        if ( goods == null ){
            System.out.println("不存在这个商品");
            throw new NullPointerException();
        }

        if ( goods.getStock() < count ){
            System.out.println("商品库存不足");
            throw new NotEnoughException();
        }


        goodsDao.modifyGoods(sale);


    }
}
