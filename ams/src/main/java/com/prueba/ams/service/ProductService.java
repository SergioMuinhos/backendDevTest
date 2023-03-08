package com.prueba.ams.service;

import com.prueba.ams.dto.ProductDetailDto;
import com.prueba.ams.exceptions.ProductException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    /**
     *
     * @param productId
     * @return
     * @throws ProductException
     */
    List<ProductDetailDto> getSimilarProducts(String productId) throws ProductException;

}
