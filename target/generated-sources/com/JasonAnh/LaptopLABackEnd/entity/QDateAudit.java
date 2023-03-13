package com.JasonAnh.LaptopLABackEnd.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDateAudit is a Querydsl query type for DateAudit
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QDateAudit extends EntityPathBase<DateAudit> {

    private static final long serialVersionUID = 1589489068L;

    public static final QDateAudit dateAudit = new QDateAudit("dateAudit");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final BooleanPath deleted = createBoolean("deleted");

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QDateAudit(String variable) {
        super(DateAudit.class, forVariable(variable));
    }

    public QDateAudit(Path<? extends DateAudit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDateAudit(PathMetadata metadata) {
        super(DateAudit.class, metadata);
    }

}

