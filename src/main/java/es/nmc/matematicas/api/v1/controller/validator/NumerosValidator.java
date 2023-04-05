package es.nmc.matematicas.api.v1.controller.validator;

import es.nmc.matematicas.exception.NumerosNoValidosException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumerosValidator {
    private NumerosValidator() {
        throw new IllegalStateException("Utility class");
    }
    public static void validar(List<Integer> numeros) throws NumerosNoValidosException {

        if (numeros == null || numeros.isEmpty()) {
            throw new NumerosNoValidosException("La lista de números no puede estar vacía");
        }

        if (numeros.size() != 100) {
            throw new NumerosNoValidosException("La lista de números debe tener exactamente 100 elementos");
        }

        Set<Integer> numerosUnicos = new HashSet<>(numeros);
        if (numerosUnicos.size() != 100) {
            throw new NumerosNoValidosException("La lista de números no puede tener números repetidos");
        }

        if (numeros.stream().mapToInt(Integer::intValue).anyMatch(numero -> numero < 1 || numero > 100)) {
            throw new NumerosNoValidosException("La lista de números debe contener valores entre 1 y 100");
        }
    }
}
