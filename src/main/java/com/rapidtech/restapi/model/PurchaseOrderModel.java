package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.CustomerEntity;
import com.rapidtech.restapi.entity.PurchaseOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderModel implements Serializable {

    private Long id;

    private String poCode;

    private Long employeeId;

    private Long shipperId;
    private Long customerId;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date poDate;

    private Double totalAmount;

    private List<PurchaseOrderDetailModel> details;

    public PurchaseOrderModel (PurchaseOrderEntity entity){
        BeanUtils.copyProperties(entity,this);

        }

}
