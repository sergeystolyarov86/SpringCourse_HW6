package shop;


import dao.CustomerDaoImpl;
import dao.OrderDaoImpl;
import dao.SessionFactoryUtils;
import interfaces.CustomerDao;
import interfaces.OrderDao;

public class Main {
    public static void main(String[] args) {

        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();


        try {
           OrderDao orderDao = new OrderDaoImpl(sessionFactoryUtils);
          //  ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
           // System.out.println(productDao.findAll());
            System.out.println(orderDao.findAll());



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shotdown();
        }
    }
}

