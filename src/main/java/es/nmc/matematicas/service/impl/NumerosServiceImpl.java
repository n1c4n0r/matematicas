package es.nmc.matematicas.service.impl;

import es.nmc.matematicas.api.v1.controller.validator.NumerosValidator;
import es.nmc.matematicas.exception.NumerosNoValidosException;
import es.nmc.matematicas.service.NumerosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NumerosServiceImpl implements NumerosService {
    @Override
    public int getSumaCienPrimerosNumeros(List<Integer> numeros) throws NumerosNoValidosException {
        NumerosValidator.validar(numeros);
        return numeros.stream().mapToInt(Integer::intValue).sum();
    }
}
