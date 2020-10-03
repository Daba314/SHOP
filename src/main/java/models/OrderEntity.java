package models;

import javax.persistence.*;

@Entity
@Table(name = "orders", schema = "public", catalog = "OnlineShop")
public class OrderEntity {
    private int orderid;
    private String status;
    private String destination;

    @Id
    @Column(name = "orderid")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderid != that.orderid) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (destination != null ? !destination.equals(that.destination) : that.destination != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderid;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "orderid=" + orderid +
                ", status='" + status + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
