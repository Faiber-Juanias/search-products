package com.platzi.search.products.api;

import com.platzi.search.products.models.Product;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/**
 * Sirve como la base de las peticiones que se harán con FEIGN
 */
@Headers("Accept: application/json")
public interface IApiProducts {

    /**
     * Permite devolver todo el listado de productos
     * @return La lista de productos
     */
    @RequestLine("GET /products")
    List<Product> products(@QueryMap Map<String, Object> queryMap);
}
