package com.prueba.ams.helper.impl;

import com.prueba.ams.dto.ProductDetailDto;
import com.prueba.ams.exceptions.ProductException;
import com.prueba.ams.helper.ProductHelper;
import com.prueba.ams.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ProductHelperImpl implements ProductHelper {
    private static final RestTemplate restTemplate = new RestTemplate();

    @Override
    public String[] getSimilarProductsIds(String id) throws ProductException {
        ResponseEntity<String[]> response = restTemplate.getForEntity(Constants.HOST_MOCKS + Constants.PRODUCT
                + "/" + id + Constants.PRODUCT_SIMILARS_ID, String[].class);
        return response.getBody();
    }

    @Override
    public ProductDetailDto getProductById(String id) throws ProductException {
        ResponseEntity<ProductDetailDto> response = restTemplate.getForEntity(Constants.HOST_MOCKS
                + Constants.PRODUCT + "/" + id, ProductDetailDto.class);
        return response.getBody();
    }
}
