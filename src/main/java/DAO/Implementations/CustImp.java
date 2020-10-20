package DAO.Implementations;

import DAO.Interfaces.CustomerDAO;
import models.CustomerEntity;
import models.OrderEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CustImp implements CustomerDAO {
    private Session hibernateSession(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }

    @Override
    public CustomerEntity getByLastName(String lastName) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from CustomerEntity where lastname=:param");
        query.setParameter("param",lastName);
        CustomerEntity customerEntity = (CustomerEntity) query.getSingleResult();
        transaction.commit();
        session.close();
        return customerEntity;

    }

    @Override
    public void deleteCustomerByLastName(String lastName) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        CustomerEntity customerEntity = session.load(CustomerEntity.class,lastName);
        session.delete(customerEntity);
        transaction.commit();
    }

    @Override
    public List<OrderEntity> getOrderByCustomerId(int customerID) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        List<OrderEntity> orders = new ArrayList<>();
        Query query  = session.createQuery("from CustomerEntity where customerid=:param");
        query.setParameter("param",customerID);
        CustomerEntity customerEntity = (CustomerEntity) query.getSingleResult();
        //TODO change method for getting customer
        orders.add((OrderEntity) customerEntity.getOrders());
        transaction.commit();
        session.close();
        return orders;
    }

    @Override
    public CustomerEntity get(int id) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from CustomerEntity where customerid=:param");
        query.setParameter("param",id);
        CustomerEntity customerEntity = (CustomerEntity) query.list().get(0);
        transaction.commit();
        session.close();
        return customerEntity;
    }

    @Override
    public void insert(String firstName, String lastName, Long phoneNumber, String address) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstname(firstName);
        customerEntity.setLastname(lastName);
        customerEntity.setPhonenumber(phoneNumber);
        customerEntity.setAddress(address);
        session.save(customerEntity);
        transaction.commit();
    }

    @Override
    public void update(int customerID,String firstName, String lastName, Long phoneNumber, String address) {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        CustomerEntity customerEntity = session.load(CustomerEntity.class,customerID);
        customerEntity.setFirstname(firstName);
        customerEntity.setLastname(lastName);
        customerEntity.setPhonenumber(phoneNumber);
        customerEntity.setAddress(address);

        session.update(customerEntity);
        transaction.commit();
    }


    @Override
    public List<CustomerEntity> getAll() {
        Session session = hibernateSession();
        Transaction transaction = session.beginTransaction();
        List<CustomerEntity> customerEntities= session.createQuery("from CustomerEntity ").list();
        transaction.commit();
        return customerEntities;
    }
}



