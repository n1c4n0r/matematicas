package es.nmc.matematicas.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
@Slf4j
@RestControllerAdvice
public class NumerosControllerAdvice {

    public static final String ERROR = "error";
    public static final String DETALLES = "detalles";
    public static final String ESTADO = "estado";

    public static final String OK = "ok";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put(ERROR, "Error de validación");
        errorResponse.put(DETALLES, bindingResult.getAllErrors()
                .stream()
                .map(error -> error instanceof FieldError ?
                        Map.of("field", ((FieldError) error).getField(), "message", error.getDefaultMessage())
                        : Map.of("message", error.getDefaultMessage()))
                .collect(Collectors.toList()));
        errorResponse.put(OK, false);
        errorResponse.put(ESTADO, HttpStatus.BAD_REQUEST.value());

        log.error("Error de validación", ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumerosNoValidosException.class)
    public ResponseEntity<Object> handleNumerosNoValidosException(NumerosNoValidosException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put(ERROR, "Números no válidos");
        errorResponse.put(DETALLES, ex.getMessage());
        errorResponse.put(OK, false);
        errorResponse.put(ESTADO, HttpStatus.BAD_REQUEST.value());

        log.error("Números no válidos", ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put(ERROR, "Bad Request");
        errorResponse.put(DETALLES, ex.getMessage());
        errorResponse.put(OK, false);
        errorResponse.put(ESTADO, HttpStatus.BAD_REQUEST.value());

        log.error("Bad Request", ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

