package com.JasonAnh.LaptopLABackEnd.entity.request;

import com.JasonAnh.LaptopLABackEnd.entity.Product;

import java.io.Serializable;
import java.util.List;

public class AddOrderRequest implements Serializable {
    private String phone;
    private String userName;
    private Long owner_id;
    private Long total_price;
    private List<Product> products;
    private String address;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public Long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Long total_price) {
        this.total_price = total_price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
