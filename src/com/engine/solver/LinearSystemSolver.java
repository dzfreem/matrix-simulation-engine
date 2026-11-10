package com.engine.solver;

import com.engine.matrix.Matrix;
import com.engine.vector.Vector3;

public class LinearSystemSolver {
    // Solves the linear equation system Ax = B
    public static Vector3 solveSystem3x3(Matrix A, Vector3 B) {
        if (A.getRows() != 3 || A.getCols() != 3) {
            throw new IllegalArgumentException("Solver is specialized for 3x3 systems.");
        }

        // 1. Calculate the inverse of the coefficient Matrix A
        Matrix inverseA = A.inverse();
        // 2. Transform the constants Vector3 B into a 3x1 column matrix
        Matrix matrixB = B.toMatrix();
        // 3. Perform the matrix multiplication: x = A^-1 * B
        Matrix resultMatrix = inverseA.multiply(matrixB);
        // 4. Reconstruct and return the resulting coordinates as a Vector3
        
        return Vector3.fromMatrix(resultMatrix);
    }
}