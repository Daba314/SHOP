package DAO.Implementations;

import DAO.Interfaces.OrderDAO;
import models.CustomerEntity;
import models.OrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.List;

public class OrderImp implements OrderDAO {
    private Session hibernateSession(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(OrderEntity order) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        session.persist(order);
        transaction.commit();
        session.close();
    }

    @Override
    public void insert(String status,String destination) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setStatus(status);
        orderEntity.setDestination(destination);
        session.save(orderEntity);
        transaction.commit();

    }

    @Override
    public OrderEntity get(int orderid) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from OrderEntity where orderid=:param");
        query.setParameter("param",orderid);
        OrderEntity orderEntity = (OrderEntity) query.getSingleResult();
        transaction.commit();
        session.close();
        return orderEntity;

    }

    @Override
    public List<OrderEntity> getAll() {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        List<OrderEntity> orderEntities= session.createQuery("from OrderEntity ").list();
        transaction.commit();
        return orderEntities;
    }

    @Override
    public void update(String status,String destination, int orderid) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        OrderEntity orderEntity = session.load(OrderEntity.class,orderid);
        orderEntity.setStatus(status);
        orderEntity.setDestination(destination);

        session.update(orderEntity);
        transaction.commit();
    }

    @Override
    public void delete(int orderid) {

        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        OrderEntity orderEntity = session.load(OrderEntity.class,orderid);
        session.delete(orderEntity);
        transaction.commit();
    }

    @Override
    public CustomerEntity getClientsById(int id) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from CustomerEntity where orderId=:param");
        query.setParameter("param",id);
        CustomerEntity customer = (CustomerEntity) query.getSingleResult();
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public List<OrderEntity> getByStatus(String status) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from OrderEntity where status =:param");
        query.setParameter("param",status);
        List<OrderEntity> order =  query.list();
        transaction.commit();
        session.close();
        return order;
    }
}
