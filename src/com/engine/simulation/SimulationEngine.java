package com.engine.simulation;

import com.engine.matrix.Matrix;
import com.engine.vector.Vector3;

public class SimulationEngine {
    private final Vector3[] meshPoints;

    public SimulationEngine() {
        // Defines vertices of a simple unit cube in 3D coordinate space
        this.meshPoints = new Vector3[] {
            new Vector3(0,0,0), new Vector3(1,0,0), new Vector3(1,1,0), new Vector3(0,1,0),
            new Vector3(0,0,1), new Vector3(1,0,1), new Vector3(1,1,1), new Vector3(0,1,1)
        };
    }

    // Generates a 3D rotation transformation matrix along the Y axis
    public Matrix createYRotationMatrix(double degrees) {
        double rad = Math.toRadians(degrees);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        return new Matrix(new double[][] {
            { cos,  0f, sin },
            {  0f,  1f,  0f },
            {-sin,  0f, cos }
        });
    }

    public void runSimulationStep(double rotationDegrees) {
        Matrix transformation = createYRotationMatrix(rotationDegrees);
        System.out.println("\n--- SIMULATION STEP: Rotating Cube by " + rotationDegrees + "° ---");
        
        for (int i = 0; i < meshPoints.length; i++) {
            Matrix vectorMat = meshPoints[i].toMatrix();
            Matrix transformedMat = transformation.multiply(vectorMat);
            Vector3 finalPos = Vector3.fromMatrix(transformedMat);
            
            System.out.printf("Vertex %d transformed: (%5.2f, %5.2f, %5.2f)\n", i, finalPos.x, finalPos.y, finalPos.z);
        }
    }
}