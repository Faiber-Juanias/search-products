package com.platzi.search.products.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {

    public static Map<String, Object> toMap(CLIArguments cliArguments) {
        Map<String, Object> params = new HashMap<>();
//        params.put("keyword", cliArguments.getKeyword());
//        params.put("id", cliArguments.getId());
        params.put("title", cliArguments.getTitle());
        params.put("price", cliArguments.getPrice());
        params.put("price_min", cliArguments.getPriceMin());
        params.put("price_max", cliArguments.getPriceMax());
        params.put("categoryId", cliArguments.getCategory());
        params.put("offset", cliArguments.getOffset());
        params.put("limit", cliArguments.getLimit());
        return params;
    }

}
