package com.engine;

import com.engine.matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Day 4 Verification ---");

        double[][] data = {
            {2.0, -1.0, 0.0},
            {-1.0, 2.0, -1.0},
            {0.0, -1.0, 2.0}
        };
        Matrix A = new Matrix(data);

        System.out.println("Original Matrix A:");
        A.print();

        // Compute Inverse
        Matrix A_inverse = A.inverse();
        System.out.println("\nComputed Inverse Matrix A^-1:");
        A_inverse.print();

        // Identity Verification check
        System.out.println("\nVerification: A x A^-1 (Should equal Identity Matrix):");
        Matrix identityVerification = A.multiply(A_inverse);
        identityVerification.print();
    }
}