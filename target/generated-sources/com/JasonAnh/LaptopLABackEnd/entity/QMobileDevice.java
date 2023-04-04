package com.JasonAnh.LaptopLABackEnd.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMobileDevice is a Querydsl query type for MobileDevice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMobileDevice extends EntityPathBase<MobileDevice> {

    private static final long serialVersionUID = -1772379047L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMobileDevice mobileDevice = new QMobileDevice("mobileDevice");

    public final QDateAudit _super = new QDateAudit(this);

    public final StringPath appVersion = createString("appVersion");

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final StringPath deviceKey = createString("deviceKey");

    public final StringPath firebaseToken = createString("firebaseToken");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath osType = createString("osType");

    public final NumberPath<Long> ownerId = createNumber("ownerId", Long.class);

    public final EnumPath<com.JasonAnh.LaptopLABackEnd.entity.constants.MobileDeviceStatus> status = createEnum("status", com.JasonAnh.LaptopLABackEnd.entity.constants.MobileDeviceStatus.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final QUser user;

    public QMobileDevice(String variable) {
        this(MobileDevice.class, forVariable(variable), INITS);
    }

    public QMobileDevice(Path<? extends MobileDevice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMobileDevice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMobileDevice(PathMetadata metadata, PathInits inits) {
        this(MobileDevice.class, metadata, inits);
    }

    public QMobileDevice(Class<? extends MobileDevice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

