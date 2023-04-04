package com.JasonAnh.LaptopLABackEnd.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderCart is a Querydsl query type for OrderCart
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderCart extends EntityPathBase<OrderCart> {

    private static final long serialVersionUID = 1473934445L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderCart orderCart = new QOrderCart("orderCart");

    public final QDateAudit _super = new QDateAudit(this);

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QOrder order;

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final QProduct product;

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QOrderCart(String variable) {
        this(OrderCart.class, forVariable(variable), INITS);
    }

    public QOrderCart(Path<? extends OrderCart> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderCart(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderCart(PathMetadata metadata, PathInits inits) {
        this(OrderCart.class, metadata, inits);
    }

    public QOrderCart(Class<? extends OrderCart> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.order = inits.isInitialized("order") ? new QOrder(forProperty("order"), inits.get("order")) : null;
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

