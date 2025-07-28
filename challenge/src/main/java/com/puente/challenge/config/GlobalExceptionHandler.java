package com.puente.challenge.config;

import com.puente.challenge.exception.EmailAlreadyInUseException;
import com.puente.challenge.model.RoleEnum;
import com.puente.challenge.model.SymbolsEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleEnumConversionError(MethodArgumentTypeMismatchException e) {
        if (e.getRequiredType() == SymbolsEnum.class) {
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("error", "Invalid symbol: " + e.getValue());
            body.put("allowedValues", Arrays.stream(SymbolsEnum.values())
                    .map(Enum::name)
                    .toList());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

        if (e.getRequiredType() == RoleEnum.class) {
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("error", "Invalid symbol: " + e.getValue());
            body.put("allowedValues", Arrays.stream(RoleEnum.values())
                    .map(Enum::name)
                    .toList());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", "Invalid parameter"));
    }

    @ExceptionHandler(EmailAlreadyInUseException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExists(EmailAlreadyInUseException e) {
        Map<String, String> body = new LinkedHashMap<>();
        body.put("error-message", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNoSuchElementException(NoSuchElementException e) {
        Map<String, String> body = new LinkedHashMap<>();
        body.put("error-message", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
