package DAO.Interfaces;

import models.CustomerEntity;
import models.OrderEntity;
import java.util.List;

public interface CustomerDAO {
    CustomerEntity getByLastName(String LastName);
    void deleteCustomerByLastName(String LastName);
    List<OrderEntity> getOrderByCustomerId(int customerID);
    CustomerEntity get(int id);
    void insert(String firstName, String lastName, Long phoneNumber, String address);
    void update(int customerID, String firstName, String lastName, Long phoneNumber, String address);
    List<CustomerEntity> getAll();
}
