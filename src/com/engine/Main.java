package com.engine;

import com.engine.matrix.Matrix;
import com.engine.vector.Vector3;
import com.engine.solver.LinearSystemSolver;
import com.engine.simulation.SimulationEngine;
import com.engine.exception.MatrixDimensionMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimulationEngine simulationEngine = new SimulationEngine();
        boolean running = true;

        System.out.println("==================================================");
        System.out.println("   LINEAR ALGEBRA & SPATIAL ENGINE DASHBOARD v1.0 ");
        System.out.println("==================================================");

        while (running) {
            System.out.println("\n--- MAIN CONTROL PANEL ---");
            System.out.println("1) Compute Matrix Multiplication (A x B)");
            System.out.println("2) Calculate Determinant & Inverse of a Matrix");
            System.out.println("3) Solve Linear Equation System (Ax = B)");
            System.out.println("4) Run 3D Mesh Rotation Simulation Frame");
            System.out.println("5) Exit Application");
            System.out.print("Select an option (1-5): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    runMultiplicationDemo();
                    break;
                case "2":
                    runInverseDemo(scanner);
                    break;
                case "3":
                    runSystemSolverDemo();
                    break;
                case "4":
                    runSimulationDemo(scanner);
                    break;
                case "5":
                    running = false;
                    System.out.println("\nShutting down engine core cleanly.");
                    break;
                default:
                    System.out.println("\n[ERROR] Invalid option. Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }

    private static void runMultiplicationDemo() {
        System.out.println("\n[EXEC] Multiplying a 2x3 Matrix by a 3x2 Matrix...");
        Matrix A = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix B = new Matrix(new double[][]{{7, 8}, {9, 1}, {2, 3}});
        
        System.out.println("Matrix A:"); A.print();
        System.out.println("Matrix B:"); B.print();
        
        Matrix result = A.multiply(B);
        System.out.println("Result (A x B):"); result.print();
    }

    private static void runInverseDemo(Scanner scanner) {
        System.out.println("\n[EXEC] Matrix Inversion Setup");
        System.out.println("Choose Matrix type: 1) Standard Invertible 2) Singular (Will fail)");
        System.out.print("Choice: ");
        String type = scanner.nextLine().trim();

        double[][] data = type.equals("2") 
            ? new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}} // Singular (det = 0)
            : new double[][]{{2, -1, 0}, {-1, 2, -1}, {0, -1, 2}}; // Invertible

        Matrix M = new Matrix(data);
        System.out.println("Target Matrix:"); M.print();
        System.out.printf("Determinant: %.2f\n", M.determinant());

        try {
            Matrix inverse = M.inverse();
            System.out.println("Computed Inverse Matrix:"); inverse.print();
        } catch (ArithmeticException e) {
            System.out.println("\n[SAFEGUARD TRIPPED] Exception caught successfully: " + e.getMessage());
        }
    }

    private static void runSystemSolverDemo() {
        System.out.println("\n[EXEC] Solving Linear System: Ax = B");
        Matrix A = new Matrix(new double[][]{{2, -1, 0}, {-1, 2, -1}, {0, -1, 2}});
        Vector3 B = new Vector3(2.0, -1.0, 4.0);
        
        System.out.println("Coefficients Matrix A:"); A.print();
        System.out.printf("Constants Vector B: [X=%.1f, Y=%.1f, Z=%.1f]\n", B.x, B.y, B.z);
        
        Vector3 solution = LinearSystemSolver.solveSystem3x3(A, B);
        System.out.printf("Isolated Solution Vector x: [X=%.2f, Y=%.2f, Z=%.2f]\n", solution.x, solution.y, solution.z);
    }

    private static void runSimulationDemo(Scanner scanner) {
        System.out.print("\nEnter rotation increment step in degrees (e.g., 45): ");
        try {
            double degrees = Double.parseDouble(scanner.nextLine().trim());
            SimulationEngine engine = new SimulationEngine();
            engine.runSimulationStep(degrees);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Invalid numeric input string.");
        }
    }
}