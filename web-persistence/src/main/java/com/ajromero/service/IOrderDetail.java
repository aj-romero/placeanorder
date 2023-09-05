package com.ajromero.service;

import com.ajromero.domain.entity.OrderDetail;

import java.util.List;

public interface IOrderDetail {
    OrderDetail save(OrderDetail orderDetail);

    List<OrderDetail> getOrderDetails();

    OrderDetail findById(Integer id);
}
