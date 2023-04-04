package com.JasonAnh.LaptopLABackEnd.repository.order;

import com.JasonAnh.LaptopLABackEnd.entity.Order;
import com.JasonAnh.LaptopLABackEnd.entity.response.StatisticResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order,Long> ,OrderRepositoryCustom{

   @Query(value = "SELECT SUM(total_price) as `value`, day(created_at) as `key` FROM orders "
           + "WHERE status = 'COMPLETED'and year(created_at) = year(?1) and month(created_at) = month(?1) GROUP BY day(created_at) ORDER BY day(created_at)", nativeQuery = true)
   List<StatisticResponse> revenueOrdersByMonth(Date date);
   Order findOrderByCode(String code);

}
