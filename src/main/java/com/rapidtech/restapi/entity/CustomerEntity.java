package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.CustomerModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer_tab")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "customer_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="customer_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_id_generator")
    private Long id;
    @Column(name = "customer_name",length = 120, nullable = false)
    private String fullName;
    @Column(name = "address",length = 200)
    private String address;

    @Column(name = "gender",length = 32,nullable = false)
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "city",length = 100)
    private String city;
    @Column(name = "country",length = 100)
    private String country;

    @Column(name = "postal_code",length = 100)
    private String postalCode;

    public CustomerEntity(CustomerModel model) {
        BeanUtils.copyProperties(model,this);
    }
// Butuh relasi
//    @ManyToOne

    @OneToMany(mappedBy = "customer")
    private List<PurchaseOrderEntity> purchaseOrders = new ArrayList<>();

}
