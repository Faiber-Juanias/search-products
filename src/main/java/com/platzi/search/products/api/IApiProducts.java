package com.platzi.search.products.api;

import com.platzi.search.products.models.Product;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/**
 * Define el contrato de servicio que se consumirá
 */
@Headers("Accept: application/json")
public interface IApiProducts {

    /**
     * Permite devolver todo el listado de productos
     * @param queryMap Los query string necesarios para la petición
     * @return La lista de productos devueltos por el servicio
     */
    @RequestLine("GET /products")
    List<Product> products(@QueryMap Map<String, Object> queryMap);
}
