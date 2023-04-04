package com.JasonAnh.LaptopLABackEnd.repository.order;

import com.JasonAnh.LaptopLABackEnd.entity.Order;
import com.JasonAnh.LaptopLABackEnd.entity.QOrder;
import com.JasonAnh.LaptopLABackEnd.entity.QProduct;
import com.JasonAnh.LaptopLABackEnd.entity.constants.OrderProductStatus;
import com.JasonAnh.LaptopLABackEnd.repository.BaseRepository;
import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.JasonAnh.LaptopLABackEnd.util.Util.PAGE_SIZE;

public class OrderRepositoryImpl extends BaseRepository implements OrderRepositoryCustom{
    @Override
    public List<Order> getOrderList(OrderProductStatus status) {
        QOrder qOrder = QOrder.order;
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qOrder.deleted.eq(false));

            if(status!=null) {
                builder.and(qOrder.status.eq(status));
            }

//        builder.and(qProduct.remain.gt(0));

        return query().from(qOrder)
                .where(builder)
                .select(qOrder)
                .orderBy(qOrder.id.desc())
                .fetch();

    }
    @Override
    public Long getTotalMoneySell(long userId) {
        QOrder qOrder =  QOrder.order;

        return query()
                .select(qOrder.totalPrice.sum())
                .from(qOrder)
                .where(qOrder.ownerId.eq(userId))
                .groupBy(qOrder.ownerId)
                .fetchOne();
    }

    @Override
    public Long getTotalOrder(long userId) {
        QOrder qOrder =  QOrder.order;

        return query()
                .select(qOrder)
                .from(qOrder)
                .groupBy(qOrder.id)
                .where(qOrder.ownerId.eq(userId))
                .fetchCount();
    }
}
