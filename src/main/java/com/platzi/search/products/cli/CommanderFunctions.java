package com.platzi.search.products.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Define todas las funciones necesarias para operar con JCommander
 */
public class CommanderFunctions {

    /**
     * Crea una isntancia de JCommander
     * @param cliName Nombre del comando
     * @param argumentSupplier Provee la clase de argumentos
     * @return Objeto de tipo JCommander
     * @param <T>
     */
    public static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentSupplier) {
        JCommander jCommander = JCommander
                .newBuilder()
                .addObject(argumentSupplier.get())
                .build();
        jCommander.setProgramName(cliName);
        return jCommander;
    }

    /**
     * Convierte los argumentos recibidos
     * @param jCommander Objeto JCommander
     * @param arguments Arreglo de argumentos
     * @param onError Permite manejar los posibles errores
     * @return
     */
    public static Optional<List<Object>> parseArguments(JCommander jCommander, String[] arguments, Consumer<JCommander> onError) {
        try {
            jCommander.parse(arguments);
            return Optional.of(jCommander.getObjects());
        } catch (ParameterException paramEx) {
            onError.accept(jCommander);
        }
        return Optional.empty();
    }

}
