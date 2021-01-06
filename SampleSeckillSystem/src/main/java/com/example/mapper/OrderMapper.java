package com.example.mapper;

import com.example.domain.mOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Deep-Feeling-1999
 * @create 2021/1/4
 */
@Mapper
@Repository
public interface OrderMapper {
    /**
     * 获得所有的订单信息
     * @return 订单集合
     */
    List<mOrder> getAllOrder();

    /**
     * 获得对应单号的订单信息
     * @param oId 单号
     * @return 对应订单
     */
    mOrder getOrder(int oId);

    /**
     * 查询对应账号的订单信息
     * @param uAccount 用户账号
     * @return 对应订单信息
     */
    mOrder getOrderWithAccount(String uAccount);

    /**
     * 增加一个订单
     * @param order 订单
     */
    void addOrder(mOrder order);
}
