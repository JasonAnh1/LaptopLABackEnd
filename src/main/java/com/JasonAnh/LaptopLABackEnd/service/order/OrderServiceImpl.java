package com.JasonAnh.LaptopLABackEnd.service.order;

import com.JasonAnh.LaptopLABackEnd.configuration.Translator;
import com.JasonAnh.LaptopLABackEnd.entity.Order;
import com.JasonAnh.LaptopLABackEnd.entity.OrderCart;
import com.JasonAnh.LaptopLABackEnd.entity.Product;
import com.JasonAnh.LaptopLABackEnd.entity.User;
import com.JasonAnh.LaptopLABackEnd.entity.constants.OrderProductStatus;
import com.JasonAnh.LaptopLABackEnd.entity.constants.PaymentMethod;
import com.JasonAnh.LaptopLABackEnd.entity.constants.PaymentStatus;
import com.JasonAnh.LaptopLABackEnd.entity.constants.RoleName;
import com.JasonAnh.LaptopLABackEnd.entity.request.AddOrderRequest;
import com.JasonAnh.LaptopLABackEnd.entity.response.StatisticResponse;
import com.JasonAnh.LaptopLABackEnd.repository.order.OrderCartRepository;
import com.JasonAnh.LaptopLABackEnd.repository.order.OrderRepository;
import com.JasonAnh.LaptopLABackEnd.repository.product.ProductRepository;
import com.JasonAnh.LaptopLABackEnd.service.BaseService;
import com.JasonAnh.LaptopLABackEnd.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl extends BaseService implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderCartRepository orderCartRepository;
    @Override
    public List<Order> getOrders(OrderProductStatus status) throws Exception{
        User user = getUser();
        if (user.getRoles().get(0).getName() == RoleName.ROLE_USER) {
            throw new Exception(Translator.toLocale("access_denied"));
        }
        return orderRepository.getOrderList(status);
    }

    @Override
    public Order updateOrder(Order order) throws Exception {
       Order od =orderRepository.findById(order.getId()).orElseThrow(() -> new Exception("Không tìm thấy order"));
       od.setStatus(order.getStatus());
       orderRepository.save(od);
       return od;
    }

    @Override
    public List<StatisticResponse> staticByMonth(Date date) throws Exception {
        return orderRepository.revenueOrdersByMonth(date);
    }

    @Override
    public Order addOrder(AddOrderRequest addRequest) throws Exception {
        String code = generateCodeOrderProduct();
        Long OrderId;
        Order order = new Order();

        order.setAddress(addRequest.getAddress());
        order.setPhone(addRequest.getPhone());
        order.setUsername(addRequest.getUserName());
        order.setTotalPrice(addRequest.getTotal_price());
        order.setPaymentMethod(PaymentMethod.BANKING);
        order.setPaymentStatus(PaymentStatus.DEFAULT);
        order.setStatus(OrderProductStatus.WAITING);
        order.setCode(code);
        order.setOwnerId(addRequest.getOwner_id());
        Order finalOrder =  orderRepository.save(order);

        OrderId = finalOrder.getId();

        for(Product item: addRequest.getProducts()){
            OrderCart orderCart = new OrderCart();
            orderCart.setProductId(item.getId());
            orderCart.setAmount(item.getQuantity());
            orderCart.setPrice(item.getPriceAfterDiscount());
            orderCart.setStatus(0);
            orderCart.setOrderId(OrderId);

            orderCartRepository.save(orderCart);
        }


        return finalOrder;
    }
    private String generateCodeOrderProduct() {
        String code = Util.randomAlphaNumeric(9, "P");
        if (orderRepository.findOrderByCode(code) != null) {
            return generateCodeOrderProduct();
        }
        return code;
    }
}
