package com.example.demo.api;

import com.example.demo.business.ProductBusiness;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductApi {


    final ProductBusiness productBusiness;
    public ProductApi(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }

    @GetMapping("{ids}")
    public ResponseEntity<String> getProductById(@PathVariable("ids") String id) {
        final String productById = this.productBusiness.getProductById(id);
        return ResponseEntity.ok(productById);
    }

    @GetMapping("/delete")
    public  String deleteProductById(@RequestParam(value = "ids") String id){
        return  "RequestParam: "+id;
    }
}
