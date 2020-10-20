package Servlets;

import DAO.Implementations.CustImp;
import DAO.Implementations.OrderImp;
import models.CustomerEntity;
import models.OrderEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("customer/")

public class App {
    CustImp custImp = new CustImp();
    OrderImp order = new OrderImp();

    @GET
    @Path("getbyId")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerEntity getCustomerById(@QueryParam("id") int id) {
        CustomerEntity customerEntity = custImp.get(id);
        if (customerEntity != null) return customerEntity;
        else return new CustomerEntity();

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public List<CustomerEntity> getAll(){
        List<CustomerEntity> customerEntities = custImp.getAll();
        return customerEntities;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getbyid")
    public OrderEntity getOrderById(@QueryParam("id") int id) {
        OrderEntity orderEntity = order.get(id);
        if (orderEntity != null) return orderEntity;
        else return new OrderEntity();

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getbycustomerid")
    public List <OrderEntity> getOrderByCustomerId(@QueryParam("id") int id) {
        List<OrderEntity> orderEntity = custImp.getOrderByCustomerId(id);
        return orderEntity;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getByid/{id}")
    public CustomerEntity getById(@PathParam("id") int id) {
    CustomerEntity customerEntity = custImp.get(id);
    if (customerEntity != null) return customerEntity;
    else return new CustomerEntity();
    }






}
