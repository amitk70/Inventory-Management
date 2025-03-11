package com.management.microservices.product_service.Controller;


import com.management.microservices.product_service.Dto.ProductRequest;
import com.management.microservices.product_service.Dto.ProductResponse;
import com.management.microservices.product_service.Model.Product;
import com.management.microservices.product_service.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
       return productService.createProduct(productRequest);
    }

    @GetMapping("/products")
    public List<ProductResponse> geAllProduct(){
        return productService.getAllProduct();
    }
}
