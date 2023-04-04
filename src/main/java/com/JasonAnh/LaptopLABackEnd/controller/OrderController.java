package com.JasonAnh.LaptopLABackEnd.controller;

import com.JasonAnh.LaptopLABackEnd.configuration.Translator;
import com.JasonAnh.LaptopLABackEnd.entity.Order;
import com.JasonAnh.LaptopLABackEnd.entity.constants.OrderProductStatus;
import com.JasonAnh.LaptopLABackEnd.entity.request.AddOrderRequest;
import com.JasonAnh.LaptopLABackEnd.entity.response.BaseResponse;
import com.JasonAnh.LaptopLABackEnd.repository.order.OrderRepository;
import com.JasonAnh.LaptopLABackEnd.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/")
@Transactional
public class OrderController extends BaseController{
    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("admin/v1/order/get")
    public ResponseEntity<?> get(@RequestParam(required = false) final OrderProductStatus status) {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
                    orderService.getOrders(status)));
            //            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
//                    productServer.getListProduct(page, false)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
    @GetMapping("admin/v1/order/revenueMonth")
    public ResponseEntity<?> revenueMonth(@RequestParam(required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
                    orderService.staticByMonth(date)));
            //            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
//                    productServer.getListProduct(page, false)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
    @PostMapping("admin/v1/order/update")
    public ResponseEntity<?> update(@RequestBody final Order order) {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
                    orderService.updateOrder(order)));
            //            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
//                    productServer.getListProduct(page, false)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }

    }
    @GetMapping("admin/v1/static/countMoney")
    public ResponseEntity<?> countmn(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
                    orderRepository.getTotalMoneySell(userId)));
            //            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
//                    productServer.getListProduct(page, false)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }

    }
    @GetMapping("admin/v1/static/countOrder")
    public ResponseEntity<?> countod(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
                    orderRepository.getTotalOrder(userId)));
            //            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
//                    productServer.getListProduct(page, false)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }

    }
    @PostMapping("v1/order/add")
    public ResponseEntity<?> addOrder(@RequestBody AddOrderRequest addRequest) {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
                    orderService.addOrder(addRequest)));
            //            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
//                    productServer.getListProduct(page, false)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }

    }
}
