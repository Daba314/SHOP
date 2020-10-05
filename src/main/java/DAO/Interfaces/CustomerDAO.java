package DAO.Interfaces;

import models.CustomerEntity;
import models.OrderEntity;
import java.util.List;

public interface CustomerDAO {
    CustomerEntity getByLastName(String LastName);
    void deleteCustomerByLastName(String LastName);
    List<CustomerEntity> getOrderById(int id);
}
