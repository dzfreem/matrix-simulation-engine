package com.engine.vector;

import com.engine.matrix.Matrix;

public class Vector3 {
    public double x, y, z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Converts this spatial vector into a 3x1 single-column Matrix for linear transformations
    public Matrix toMatrix() {
        return new Matrix(new double[][]{{x}, {y}, {z}});
    }

    // Reconstructs a Vector3 object from a transformed 3x1 Matrix object
    public static Vector3 fromMatrix(Matrix m) {
        if (m.getRows() != 3 || m.getCols() != 1) {
            throw new IllegalArgumentException("Matrix must be 3x1 to convert back to Vector3.");
        }
        return new Vector3(m.get(0, 0), m.get(1, 0), m.get(2, 0));
    }

    // TODO: Write clean methods for dotProduct() and crossProduct() down here
}