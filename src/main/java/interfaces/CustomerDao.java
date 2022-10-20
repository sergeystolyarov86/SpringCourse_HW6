package interfaces;

import tables.Customer;

import java.util.List;

public interface CustomerDao {
    Customer findById(Long id);

    List<Customer> findAll();

    Customer findByName(String name);

    void deleteById(Long id);

    void save(Customer customer);

    void update(Long id, String name);
}
