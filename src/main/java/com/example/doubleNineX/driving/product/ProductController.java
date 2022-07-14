package com.example.doubleNineX.driving.product;

import com.example.doubleNineX.domain.model.Product;
import com.example.doubleNineX.domain.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<Object> all() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.findAll()
                    .stream()
                    .map(this::toProductResponse)
                    .collect(Collectors.toList())
        );
    }

    @GetMapping("/products/{name}/calculate/{quantity}")
    public ResponseEntity<Object> getOne(@PathVariable("name") String name, @PathVariable int quantity) {
        Optional<Product> optional = productService.findByName(name);
        if (optional.isEmpty())
            return ResponseEntity.notFound().build();

        Product p = optional.get();
        double price;
        try {
            price = productService.calcPrice(p, quantity);
        } catch (IllegalArgumentException iae) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(iae.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(price);
    }

    private ProductResponse toProductResponse(Product product) {
        var response = new ProductResponse();
        response.setName(product.name());
        response.setItemPerCarton(product.itemPerCarton());
        response.setCartonPrice(product.cartonPrice());
        return response;
    }
}
