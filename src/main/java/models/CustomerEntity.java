package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers", schema = "public", catalog = "OnlineShop")
@Getter @Setter @NoArgsConstructor
public class CustomerEntity {
    @Id
    @Column(name = "customerid")
    private int customerid;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "phonenumber")
    private Long phonenumber;
    @Basic
    @Column(name = "address")
    private String address;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customerEntityByIdCust", cascade = CascadeType.ALL)
    private List<OrderEntity> orders;

}
