package com.engine;

import com.engine.matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Day 3 Verification ---");

        // Initialize a standard 3x3 matrix
        double[][] data = {
            {2.0, -1.0,  0.0},
            {-1.0, 2.0, -1.0},
            {0.0, -1.0,  2.0}
        };
        Matrix matrix = new Matrix(data);

        System.out.println("Target Matrix:");
        matrix.print();

        // Calculate determinant
        double det = matrix.determinant();
        System.out.printf("\nCalculated Determinant: %.2f (Expected: 4.00)\n", det);
    }
}