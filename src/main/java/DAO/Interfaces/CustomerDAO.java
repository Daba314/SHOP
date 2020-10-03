package DAO.Interfaces;

import models.CustomerEntity;
import models.OrderEntity;

public interface CustomerDAO extends DAO<OrderEntity>{
    CustomerEntity getByLastName(String LastName);
    int deleteCustomerByLastName(String LastName);
    OrderEntity getOrderById(int id);
}
