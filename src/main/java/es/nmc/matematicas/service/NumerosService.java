package es.nmc.matematicas.service;

import es.nmc.matematicas.exception.NumerosNoValidosException;

import java.util.List;

public interface NumerosService {
    public int getSumaCienPrimerosNumeros(List<Integer> numbers) throws NumerosNoValidosException;
}
