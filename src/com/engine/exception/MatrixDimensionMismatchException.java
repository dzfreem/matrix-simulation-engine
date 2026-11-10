package com.engine.exception;

public class MatrixDimensionMismatchException extends RuntimeException {
    public MatrixDimensionMismatchException(String message) {
        super(message);
    }
}