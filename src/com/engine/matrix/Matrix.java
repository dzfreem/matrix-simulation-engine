package com.engine.matrix;

import com.engine.exception.MatrixDimensionMismatchException;

public class Matrix {
    private final double[][] data;
    private final int rows;
    private final int cols;

    // Initializes an M x N matrix with zeros
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    // Initializes a matrix with a pre-existing 2D array
    public Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
    
    public double get(int r, int c) { return data[r][c]; }
    public void set(int r, int c, double val) { data[r][c] = val; }

    // DAY 1: Implement basic linear scaling
    public Matrix multiply(double scalar) {
        // Create a new matrix of the exact same dimensions to preserve encapsulation
        Matrix result = new Matrix(this.rows, this.cols);
        
        // Loop through each row
        for (int i = 0; i < this.rows; i++) {
            // Loop through each column in that row
            for (int j = 0; j < this.cols; j++) {
                // Read the original value, scale it, and set it in the result matrix
                double scaledValue = this.data[i][j] * scalar;
                result.set(i, j, scaledValue);
            }
        }
        
        return result;
    }       
    // DAY 2: Implement dot-product matrix multiplication
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new MatrixDimensionMismatchException("Dimensions mismatch: " + this.cols + " cols != " + other.rows + " rows.");
        }
        Matrix result = new Matrix(this.rows, other.cols);
        // TODO: Compute matrix multiplication (Row x Column dot products)
        return result;
    }

    // DAY 3: Implement Gaussian Elimination to find the determinant
    public double determinant() {
        if (rows != cols) {
            throw new IllegalStateException("Determinant requires a square matrix.");
        }
        // TODO: Return the determinant using row reduction O(n^3)
        return 0.0;
    }

    // DAY 4: Implement Inverse calculation
    public Matrix inverse() {
        if (rows != cols) {
            throw new IllegalStateException("Matrix must be square to invert.");
        }
        double det = determinant();
        if (Math.abs(det) < 1e-9) {
            throw new ArithmeticException("Matrix is singular and cannot be inverted.");
        }
        Matrix result = new Matrix(rows, cols);
        // TODO: Calculate and return the inverse mrix
        return result;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            System.out.print("[ ");
            for (int j = 0; j < cols; j++) {
                System.out.printf("%6.2f ", data[i][j]);
            }
            System.out.println("]");
        }
    }
}