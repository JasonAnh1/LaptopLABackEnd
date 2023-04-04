package com.JasonAnh.LaptopLABackEnd.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSuppliers is a Querydsl query type for Suppliers
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSuppliers extends EntityPathBase<Suppliers> {

    private static final long serialVersionUID = 1843172614L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSuppliers suppliers = new QSuppliers("suppliers");

    public final QDateAudit _super = new QDateAudit(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QUploadFile media;

    public final NumberPath<Long> mediaId = createNumber("mediaId", Long.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public QSuppliers(String variable) {
        this(Suppliers.class, forVariable(variable), INITS);
    }

    public QSuppliers(Path<? extends Suppliers> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSuppliers(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSuppliers(PathMetadata metadata, PathInits inits) {
        this(Suppliers.class, metadata, inits);
    }

    public QSuppliers(Class<? extends Suppliers> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.media = inits.isInitialized("media") ? new QUploadFile(forProperty("media")) : null;
    }

}

