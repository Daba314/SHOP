package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders", schema = "public", catalog = "OnlineShop")
@Getter @Setter @NoArgsConstructor
public class OrderEntity {
    @Id
    @Column(name = "orderid")
    private int orderid;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "destination")
    private String destination;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    private CustomerEntity customerEntityByIdCust;

}
