package com.JasonAnh.LaptopLABackEnd.repository.order;

import com.JasonAnh.LaptopLABackEnd.entity.Order;
import com.JasonAnh.LaptopLABackEnd.entity.constants.OrderProductStatus;

import java.util.List;

public interface OrderRepositoryCustom {
    List<Order> getOrderList(OrderProductStatus status);
    Long getTotalMoneySell(long userId);
    Long getTotalOrder(long userId);
}
