package com.JasonAnh.LaptopLABackEnd.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = -1879170131L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrder order = new QOrder("order1");

    public final QDateAudit _super = new QDateAudit(this);

    public final StringPath address = createString("address");

    public final StringPath code = createString("code");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath note = createString("note");

    public final SetPath<OrderCart, QOrderCart> orderCarts = this.<OrderCart, QOrderCart>createSet("orderCarts", OrderCart.class, QOrderCart.class, PathInits.DIRECT2);

    public final QUser owner;

    public final NumberPath<Long> ownerId = createNumber("ownerId", Long.class);

    public final DateTimePath<java.util.Date> payDate = createDateTime("payDate", java.util.Date.class);

    public final EnumPath<com.JasonAnh.LaptopLABackEnd.entity.constants.PaymentMethod> paymentMethod = createEnum("paymentMethod", com.JasonAnh.LaptopLABackEnd.entity.constants.PaymentMethod.class);

    public final EnumPath<com.JasonAnh.LaptopLABackEnd.entity.constants.PaymentStatus> paymentStatus = createEnum("paymentStatus", com.JasonAnh.LaptopLABackEnd.entity.constants.PaymentStatus.class);

    public final StringPath phone = createString("phone");

    public final EnumPath<com.JasonAnh.LaptopLABackEnd.entity.constants.OrderProductStatus> status = createEnum("status", com.JasonAnh.LaptopLABackEnd.entity.constants.OrderProductStatus.class);

    public final NumberPath<Long> totalPrice = createNumber("totalPrice", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final StringPath username = createString("username");

    public QOrder(String variable) {
        this(Order.class, forVariable(variable), INITS);
    }

    public QOrder(Path<? extends Order> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrder(PathMetadata metadata, PathInits inits) {
        this(Order.class, metadata, inits);
    }

    public QOrder(Class<? extends Order> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.owner = inits.isInitialized("owner") ? new QUser(forProperty("owner"), inits.get("owner")) : null;
    }

}

