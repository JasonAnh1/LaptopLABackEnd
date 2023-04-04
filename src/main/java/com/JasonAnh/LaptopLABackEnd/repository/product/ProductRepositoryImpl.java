package com.JasonAnh.LaptopLABackEnd.repository.product;

import com.JasonAnh.LaptopLABackEnd.entity.Product;
import com.JasonAnh.LaptopLABackEnd.entity.QProduct;
import com.JasonAnh.LaptopLABackEnd.entity.constants.ProductFilterStatus;
import com.JasonAnh.LaptopLABackEnd.entity.constants.ProductStatus;
import com.JasonAnh.LaptopLABackEnd.repository.BaseRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.JasonAnh.LaptopLABackEnd.util.Util.PAGE_SIZE;

public class ProductRepositoryImpl extends BaseRepository implements ProductRepositoryCustom {
    @Override
    public List<Product> getProducts(int page, String name, Long categoryId) {
        QProduct qProduct = QProduct.product;
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qProduct.deleted.eq(false));
//        builder.and(qProduct.status.notIn(ProductStatus.HIDE, ProductStatus.PENDING))
//                .and(qProduct.category.deleted.eq(false));
        if (StringUtils.isNotBlank(name)) {
            builder.and(qProduct.title.like("%" + name + "%"));
        }
        if(categoryId != null){
            builder.and(qProduct.categoryId.eq(categoryId));
        }
//        builder.and(qProduct.remain.gt(0));

        return query().from(qProduct)
                .where(builder)
                .select(qProduct)
                .offset(page * PAGE_SIZE)
                .limit(PAGE_SIZE)
                .orderBy(qProduct.id.desc())
                .fetch();
    }
}
