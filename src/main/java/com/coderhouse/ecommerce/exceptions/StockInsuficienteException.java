package com.coderhouse.ecommerce.exceptions;

public class StockInsuficienteException extends RuntimeException{
    public StockInsuficienteException() {
        super("No hay suficiente stock para este producto.");
    }
}
