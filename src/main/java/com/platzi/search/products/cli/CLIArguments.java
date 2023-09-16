package com.platzi.search.products.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "KEYWORD",
            validateWith = CLIKeywordValidator.class
    )
    private String keyword;
    @Parameter(
            descriptionKey = "ID"
    )
    private int id;
    @Parameter(
            description = "Cada búsqueda puede incluir un título",
            names = {"--title", "-t"}
    )
    private String title;
    @Parameter(
            description = "Cada búsqueda puede incluir un precio",
            names = {"--price", "-p"}
    )
    private double price;
    @Parameter(
            description = "Cada búsqueda puede incluir un precio mínimo",
            names = {"--price_min"}
    )
    private double priceMin;
    @Parameter(
            description = "Cada búsqueda puede incluir un precio máximo",
            names = {"--price_max"}
    )
    private double priceMax;
    @Parameter(
            description = "Cada búsqueda se puede filtrar por categoría",
            names = {"--category", "-c"}
    )
    private int category;
    @Parameter(
            description = "Las búsquedas se pueden limitar a un número de resultados",
            names = {"--limit", "-l"}
    )
    private int limit = 0;
    @Parameter(
            description = "Las búsquedas se pueden obtener de manera paginada",
            names = {"--offset", "-o"}
    )
    private int offset = 0;
    @Parameter(
            description = "Mostrar esta ayuda",
            names = {"--help"},
            help = true,
            validateWith = CLIHelpValidator.class
    )
    private boolean isHelp;
    public CLIArguments() {
    }

    public String getKeyword() {
        return keyword;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public double getPriceMin() {
        return priceMin;
    }

    public double getPriceMax() {
        return priceMax;
    }

    public int getCategory() {
        return category;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", priceMin=" + priceMin +
                ", priceMax=" + priceMax +
                ", category=" + category +
                ", limit=" + limit +
                ", offset=" + offset +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }
}
