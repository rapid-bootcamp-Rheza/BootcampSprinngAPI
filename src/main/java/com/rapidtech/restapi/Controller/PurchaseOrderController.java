package com.rapidtech.restapi.Controller;

import com.rapidtech.restapi.model.ProductModel;
import com.rapidtech.restapi.model.PurchaseOrderModel;
import com.rapidtech.restapi.model.ResponseModel;
import com.rapidtech.restapi.service.ProductService;
import com.rapidtech.restapi.service.PurchaseOrderService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/po_order")
public class PurchaseOrderController {
    private PurchaseOrderService service;

    @Autowired
    public  PurchaseOrderController(PurchaseOrderService service){
        this.service = service;
    }


    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Object> save (@RequestBody PurchaseOrderModel request){
//        Optional<PurchaseOrderModel> result = service.save(request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCES",service.save(request))
        );
    }

}
