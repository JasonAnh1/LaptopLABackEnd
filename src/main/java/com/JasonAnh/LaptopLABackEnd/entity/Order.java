package com.JasonAnh.LaptopLABackEnd.entity;

import com.JasonAnh.LaptopLABackEnd.entity.constants.OrderProductStatus;
import com.JasonAnh.LaptopLABackEnd.entity.constants.OrderType;
import com.JasonAnh.LaptopLABackEnd.entity.constants.PaymentMethod;
import com.JasonAnh.LaptopLABackEnd.entity.constants.PaymentStatus;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "orders")
@Where(clause="deleted=0")
public class Order extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String phone;

    private String email;

    private String address;

    private long ownerId;

    private String code;





    @Enumerated(EnumType.STRING)
    private OrderProductStatus status;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String note;

    @OneToMany(mappedBy = "order", fetch = EAGER, cascade = CascadeType.ALL)
    private Set<OrderCart> orderCarts;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ownerId", referencedColumnName = "id", insertable = false, updatable = false)
    private User owner;

    private long totalPrice;



    @Basic
    private Date payDate;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private PaymentStatus paymentStatus = PaymentStatus.DEFAULT;

    @Transient
    private String paymentUrl;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public OrderProductStatus getStatus() {
        return status;
    }

    public void setStatus(OrderProductStatus status) {
        this.status = status;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public Set<OrderCart> getOrderCarts() {
        return orderCarts;
    }

    public void setOrderCarts(Set<OrderCart> orderCarts) {
        this.orderCarts = orderCarts;
    }






}
