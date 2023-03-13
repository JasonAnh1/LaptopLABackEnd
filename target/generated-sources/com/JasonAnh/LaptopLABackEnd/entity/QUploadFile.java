package com.JasonAnh.LaptopLABackEnd.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUploadFile is a Querydsl query type for UploadFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUploadFile extends EntityPathBase<UploadFile> {

    private static final long serialVersionUID = 1768805918L;

    public static final QUploadFile uploadFile = new QUploadFile("uploadFile");

    public final QDateAudit _super = new QDateAudit(this);

    //inherited
    public final DateTimePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final BooleanPath deleted = _super.deleted;

    public final NumberPath<Integer> duration = createNumber("duration", Integer.class);

    public final NumberPath<Integer> height = createNumber("height", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath originName = createString("originName");

    public final StringPath originUrl = createString("originUrl");

    public final NumberPath<Long> size = createNumber("size", Long.class);

    public final StringPath thumbUrl = createString("thumbUrl");

    public final EnumPath<com.JasonAnh.LaptopLABackEnd.entity.constants.UploadFileType> type = createEnum("type", com.JasonAnh.LaptopLABackEnd.entity.constants.UploadFileType.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedAt = _super.updatedAt;

    public final NumberPath<Integer> width = createNumber("width", Integer.class);

    public QUploadFile(String variable) {
        super(UploadFile.class, forVariable(variable));
    }

    public QUploadFile(Path<? extends UploadFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUploadFile(PathMetadata metadata) {
        super(UploadFile.class, metadata);
    }

}

