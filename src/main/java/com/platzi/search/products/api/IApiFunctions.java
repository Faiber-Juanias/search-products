package com.platzi.search.products.api;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Define todos los métodos que permiten operar con Feign
 */
public interface IApiFunctions {
    /**
     * Permite crear una instancia de Feign
     * @param clazz El contrato del servicio
     * @param url la URI del servicio que se desea consumir
     * @return El tipo de contrato del servicio
     * @param <T> El tipo de contrato del servicio
     */
    static <T> T buildApi(Class<T> clazz, String url) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(clazz, url);
    }
}
