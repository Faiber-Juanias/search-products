package com.platzi.search.products;

import com.beust.jcommander.JCommander;
import com.platzi.search.products.api.IApiFunctions;
import com.platzi.search.products.api.IApiProducts;
import com.platzi.search.products.cli.CLIArguments;
import com.platzi.search.products.cli.CLIFunctions;
import com.platzi.search.products.models.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.platzi.search.products.cli.CommanderFunctions.buildCommanderWithName;
import static com.platzi.search.products.cli.CommanderFunctions.parseArguments;

public class ManageProducts {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("search-products", CLIArguments::newInstance);

        // Obtiene la clase de argumentos después de parsearlos
        Stream<CLIArguments> streamOfCLI = parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CLIArguments) obj);

        // Obtiene la clase de argumentos filtrada
        Optional<CLIArguments> cliArgumentsOptional = streamOfCLI
                .filter(cli -> !cli.isHelp())
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();

        // Obtiene los query string necesarios y realiza la petición GET
        cliArgumentsOptional
                .map(CLIFunctions::toMap)
                .map(ManageProducts::executeRequest)
                .orElse(new ArrayList<>())
                .forEach(System.out::println);
    }

    /**
     * Construye la petición con FEIGN y obtiene el resultado de la consulta
     * @param params Los query string de la petición
     * @return El listado de productos que devuelve el servicio
     */
    private static List<Product> executeRequest(Map<String, Object> params) {
        IApiProducts product = IApiFunctions.buildApi(IApiProducts.class, "https://api.escuelajs.co/api/v1");
        return Stream.of(params)
                .map(product::products)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
