package com.JasonAnh.LaptopLABackEnd.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -1098592882L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final QDateAudit _super = new QDateAudit(this);

    public final QProductCategory category;

    public final NumberPath<Long> categoryId = createNumber("categoryId", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final QLocation location;

    public final NumberPath<Long> location_id = createNumber("location_id", Long.class);

    public final QUploadFile media;

    public final NumberPath<Long> mediaId = createNumber("mediaId", Long.class);

    public final StringPath mediaIds = createString("mediaIds");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final NumberPath<Long> priceAfterDiscount = createNumber("priceAfterDiscount", Long.class);

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    public final NumberPath<Integer> remain = createNumber("remain", Integer.class);

    public final NumberPath<Integer> sold = createNumber("sold", Integer.class);

    public final EnumPath<com.JasonAnh.LaptopLABackEnd.entity.constants.ProductStatus> status = createEnum("status", com.JasonAnh.LaptopLABackEnd.entity.constants.ProductStatus.class);

    public final QSuppliers supplier;

    public final NumberPath<Long> supplier_id = createNumber("supplier_id", Long.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QProductCategory(forProperty("category")) : null;
        this.location = inits.isInitialized("location") ? new QLocation(forProperty("location")) : null;
        this.media = inits.isInitialized("media") ? new QUploadFile(forProperty("media")) : null;
        this.supplier = inits.isInitialized("supplier") ? new QSuppliers(forProperty("supplier"), inits.get("supplier")) : null;
    }

}

