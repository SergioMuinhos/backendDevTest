package com.prueba.ams.service.impl;

import com.prueba.ams.dto.ProductDetailDto;
import com.prueba.ams.exceptions.ProductException;
import com.prueba.ams.helper.ProductHelper;
import com.prueba.ams.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductHelper productHelper;


    @Override
    public List<ProductDetailDto> getSimilarProducts(String productId) throws ProductException {
        if (productId == null) {
            throw new ProductException("Product " + productId + " not found");
        }

        List<ProductDetailDto> products = new ArrayList<>();

        String[] similarProductsIds = productHelper.getSimilarProductsIds(productId);
        if (similarProductsIds == null) throw new ProductException("Not similar products found");

        for (String similarId : similarProductsIds) {
            ProductDetailDto product = productHelper.getProductById(similarId);
            if (product != null) {
                products.add(product);
            }
        }

        return products;
    }
}
