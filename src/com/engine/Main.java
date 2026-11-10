package com.engine;

import com.engine.matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Day 1 Verification ---");
        
        // Initialize a 2x2 matrix manually for testing
        double[][] sampleData = {
            {1.0, 2.0},
            {3.0, 4.0}
        };
        Matrix matrix = new Matrix(sampleData);
        
        System.out.println("Original Matrix:");
        matrix.print();
        
        // Multiply by a scalar value of 2.5
        Matrix scaledMatrix = matrix.multiply(2.5);
        
        System.out.println("\nScaled Matrix (Scaled by 2.5):");
        scaledMatrix.print();
    }
}