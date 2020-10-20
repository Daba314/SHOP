package DAO.Interfaces;

import models.CustomerEntity;
import models.OrderEntity;
import java.util.List;

public interface OrderDAO  {
    void save(OrderEntity entity);

    void insert(String status, String destination);

    OrderEntity get(int id);

    List<OrderEntity> getAll();

    void update(String status, String destination, int orderid);

    void delete(int id);
    CustomerEntity getClientsById(int id) ;
    List<OrderEntity> getByStatus(String status);

}
