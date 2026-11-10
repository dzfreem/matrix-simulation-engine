package com.engine;

import com.engine.matrix.Matrix;
import com.engine.vector.Vector3;
import com.engine.solver.LinearSystemSolver;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Day 5 Verification ---");

        // System to solve:
        //  2x -  y + 0z =  2
        // -1x + 2y -  z = -1
        //  0x -  y + 2z =  4

        double[][] coefficients = {
            { 2.0, -1.0,  0.0},
            {-1.0,  2.0, -1.0},
            { 0.0, -1.0,  2.0}
        };
        Matrix A = new Matrix(coefficients);
        Vector3 B = new Vector3(2.0, -1.0, 4.0);

        System.out.println("Coefficient Matrix A:");
        A.print();
        System.out.printf("\nConstants Vector B: [ %.2f, %.2f, %.2f ]\n", B.x, B.y, B.z);

        // Solve the system Ax = B
        Vector3 solution = LinearSystemSolver.solveSystem3x3(A, B);

        System.out.println("\nSystem Solved Successfully!");
        System.out.printf("Solution Vector x: [ X=%.2f, Y=%.2f, Z=%.2f ] (Expected: X=2.00, Y= 2.00, Z=3.00)\n", 
            solution.x, solution.y, solution.z);
    }
}