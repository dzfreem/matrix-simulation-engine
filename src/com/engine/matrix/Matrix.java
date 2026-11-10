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
            // 1. Dimension Validation Check
            if (this.cols != other.rows) {
                throw new MatrixDimensionMismatchException(
                    "Cannot multiply matrices: Inner dimensions must match. " + 
                    "Matrix A columns (" + this.cols + ") must equal Matrix B rows (" + other.rows + ")."
                );
        }

        // 2. Initialize the resulting matrix structure (M x P)
        Matrix result = new Matrix(this.rows, other.cols);

        // 3. The Triple-Loop Algorithmic Core
        for (int i = 0; i < this.rows; i++) { // Iterates through rows of A
            for (int j = 0; j < other.cols; j++) { // Iterates through columns of B
                double dotProductSum = 0.0;
                
                for (int k = 0; k < this.cols; k++) { // Tracks the inner matching index
                    dotProductSum += this.data[i][k] * other.data[k][j];
                }
                
                // Assign the final computed sum to the target cell
                result.set(i, j, dotProductSum);
            }
        }

        return result;
    }

    // DAY 3: Implement Gaussian Elimination to find the determinant
    public double determinant() {
        if (rows != cols) {
            throw new IllegalStateException("Determinant requires a square matrix.");
        }
        
        int n = this.rows;
        // Clone the internal data array to preserve the original matrix values (Encapsulation)
        double[][] mat = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(this.data[i], 0, mat[i], 0, n);
        }

        double det = 1.0;
        double EPSILON = 1e-9;

        // Loop through each column to eliminate values below the diagonal.
        for (int i = 0; i < n; i++) {
            // Find a non-zero pivot element if the current one is zero.
            if (Math.abs(mat[i][i]) < EPSILON) {
                int pivotRow = -1;
                for (int r = i + 1; r < n; r++) {
                    if (Math.abs(mat[r][i]) > EPSILON) {
                        if (Math.abs(mat[r][i]) > EPSILON) {
                            pivotRow = r;
                            break;
                        }
                    }
                }

                // If no non-zero element is found below, the matrix is singular (det = 0)
                if (pivotRow == -1) {
                    return 0.0;
                }

                // Swap rows
                double[] temp = mat[i];
                mat[i] = mat[pivotRow];
                mat[pivotRow] = temp;

                // Rule 1: Swapping rows flips the sign of the determinant
                det *= -1.0;
            }

            for (int r = i + 1; r < n; r++) {
                double factor = mat[r][i] / mat[i][i];
                for (int c = i; c < n; c++) {
                    mat[r][c] -= factor * mat[i][c];
                }
            }

            // Rule 2: Multiply the current diagonal element into our running project.
            det *= mat[i][i];
        }
        return det;
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