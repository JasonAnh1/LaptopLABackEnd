package com.JasonAnh.LaptopLABackEnd.service.order;

import com.JasonAnh.LaptopLABackEnd.entity.Order;
import com.JasonAnh.LaptopLABackEnd.entity.constants.OrderProductStatus;
import com.JasonAnh.LaptopLABackEnd.entity.request.AddOrderRequest;
import com.JasonAnh.LaptopLABackEnd.entity.response.StatisticResponse;

import java.util.Date;
import java.util.List;

public interface OrderService {
    List<Order> getOrders(OrderProductStatus status) throws Exception;
     Order updateOrder(Order order) throws Exception;
     List<StatisticResponse> staticByMonth(Date date) throws Exception;
     Order addOrder(AddOrderRequest addRequest) throws Exception;
}
