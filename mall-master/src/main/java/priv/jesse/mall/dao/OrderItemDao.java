package priv.jesse.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.jesse.mall.entity.OrderItem;

import java.util.List;

/**
 * 这个接口继承了JpaRepository<实体,ID>，
 * spring-data-jpa只需要这个信息，
 * 就可以帮你完成常用的操作：增删查改。
 */

public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {
    /**
     * 根据订单Id查询
     * @param orderId
     * @return
     */
    List<OrderItem> findByOrderId(int orderId);


}
