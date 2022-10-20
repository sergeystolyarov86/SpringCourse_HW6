package dao;

import org.hibernate.Session;

import interfaces.OrderDao;
import tables.Order;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public OrderDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }


    @Override
    public Order findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Order order = session.get(Order.class, id);
            session.getTransaction().commit();
            return order;
        }
    }

    @Override
    public List<Order> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Order> orders = session.createQuery("select o from Order o", Order.class).getResultList();
            session.getTransaction().commit();
            return orders;
        }
    }


    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.createQuery("delete  Order o where o.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void save(Order order) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }
    }
}

