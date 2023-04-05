package es.nmc.matematicas.api.v1.controller;

import es.nmc.matematicas.exception.NumerosNoValidosException;
import es.nmc.matematicas.service.NumerosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/numeros")
public class NumerosController {

    private final NumerosService numerosService;

    @PostMapping("/sumaCienPrimeros")
    public ResponseEntity<Map<String, Object>> getSumaCienPrimerosNumeros(@RequestBody @Valid List<Integer> numbers, BindingResult bindingResult) throws NumerosNoValidosException {
        Map<String, Object> respuesta = new HashMap<>();
        int suma = numerosService.getSumaCienPrimerosNumeros(numbers);
        respuesta.put("resultado", suma);
        respuesta.put("ok", true);
        respuesta.put("estado", HttpStatus.OK.value());

        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }
}
