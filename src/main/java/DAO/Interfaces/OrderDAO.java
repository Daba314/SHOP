package DAO.Interfaces;

import models.CustomerEntity;
import models.OrderEntity;
import java.util.List;

public interface OrderDAO extends DAO<OrderEntity> {
    List<CustomerEntity> getClientsById(int id) ;
    List<OrderEntity> getByStatus(String status);

}
