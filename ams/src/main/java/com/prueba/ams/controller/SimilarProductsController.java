package com.prueba.ams.controller;


import com.prueba.ams.dto.ProductDetailDto;
import com.prueba.ams.exceptions.ProductException;
import com.prueba.ams.service.ProductService;
import com.prueba.ams.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(Constants.PRODUCT)
public class SimilarProductsController {
    @Autowired
    private ProductService productService;

    @GetMapping(Constants.PRODUCT_SIMILAR)
    public ResponseEntity<List<ProductDetailDto>> getSimilarProductsById(@PathVariable("productId") String id) throws ProductException {
        try {
            return new ResponseEntity<>(this.productService.getSimilarProducts(id), HttpStatus.OK);
        } catch (ProductException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
