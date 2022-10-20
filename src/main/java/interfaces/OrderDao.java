package interfaces;

import tables.Order;
;

import java.util.List;

public interface OrderDao {
    Order findById(Long id);

    List<Order> findAll();

    void deleteById(Long id);

    void save(Order order);

}
