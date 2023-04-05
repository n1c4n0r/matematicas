package es.nmc.matematicas.service;

import es.nmc.matematicas.exception.NumerosNoValidosException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class NumerosServiceImplTest {

    @Autowired
    private NumerosService numerosService;

    private List<Integer> numeros;

    @BeforeEach
    public void setUp() {
        numeros = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("Debe devolver la suma de los cien primeros números cuando la lista de entrada es válida")
    public void testGetSumaCienPrimerosNumerosValidos() throws NumerosNoValidosException {
        int sumaEsperada = 5050;
        int sumaCalculada = numerosService.getSumaCienPrimerosNumeros(numeros);
        assertEquals(sumaEsperada, sumaCalculada);
    }

    @Test
    @DisplayName("Debe lanzar una excepción NumerosNoValidosException cuando la lista de entrada es nula")
    public void testGetSumaCienPrimerosNumerosConListaNula() {
        List<Integer> listaNula = null;
        assertThrows(NumerosNoValidosException.class, () -> numerosService.getSumaCienPrimerosNumeros(listaNula));
    }

    @Test
    @DisplayName("Debe lanzar una excepción NumerosNoValidosException cuando la lista de entrada está vacía")
    public void testGetSumaCienPrimerosNumerosConListaVacia() {
        List<Integer> listaVacia = List.of();
        assertThrows(NumerosNoValidosException.class, () -> numerosService.getSumaCienPrimerosNumeros(listaVacia));
    }

    @Test
    @DisplayName("Debe lanzar una excepción NumerosNoValidosException cuando la lista de entrada tiene menos de 100 elementos")
    public void testGetSumaCienPrimerosNumerosConListaConMenosDeCienElementos() {
        List<Integer> listaConMenosDeCienElementos = numeros.subList(0, 99);
        assertThrows(NumerosNoValidosException.class, () -> numerosService.getSumaCienPrimerosNumeros(listaConMenosDeCienElementos));
    }

    @Test
    @DisplayName("Debe lanzar una excepción NumerosNoValidosException cuando la lista de entrada tiene más de 100 elementos")
    public void testGetSumaCienPrimerosNumerosConListaConMasDeCienElementos() {
        List<Integer> listaConMasDeCienElementos = numeros;
        listaConMasDeCienElementos.add(101);
        assertThrows(NumerosNoValidosException.class, () -> numerosService.getSumaCienPrimerosNumeros(listaConMasDeCienElementos));
    }
}
