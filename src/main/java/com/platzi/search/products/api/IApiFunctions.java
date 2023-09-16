package com.platzi.search.products.api;

import feign.Feign;
import feign.json.JsonDecoder;

public interface IApiFunctions {
    static <T> T buildApi(Class<T> clazz, String url) {
        return Feign.builder()
                .decoder(new JsonDecoder())
                .target(clazz, url);
    }
}
