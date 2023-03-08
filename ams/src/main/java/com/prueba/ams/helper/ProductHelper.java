package com.prueba.ams.helper;

import com.prueba.ams.dto.ProductDetailDto;
import com.prueba.ams.exceptions.ProductException;


public interface ProductHelper {

    /**
     *
     * @param id
     * @return
     * @throws ProductException
     */
    public String[] getSimilarProductsIds(String id) throws ProductException;

    /**
     *
     * @param id
     * @return
     * @throws ProductException
     */
    public ProductDetailDto getProductById(String id) throws ProductException;
}
