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
        List<CustomerEntity> customers = new ArrayList<>();
        Query query = session.createQuery("from OrderEntity where orderid=:param");
        for(CustomerEntity customer:customers){
            if(customer.getCustomerid()==customerID){

                query.setParameter("param",customer.getOrderId());
            }
        }
        List<OrderEntity> orderEntity =  query.list();
        transaction.commit();
        session.close();
        return orderEntity;
    }
}



