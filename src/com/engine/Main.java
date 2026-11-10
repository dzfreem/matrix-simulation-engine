package com.engine;

import com.engine.simulation.SimulationEngine;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     3D COORDINATE SPACE SIMULATION INITIATED    ");
        System.out.println("==================================================");

        SimulationEngine engine = new SimulationEngine();

        // Simulate a timeline stepping by 45 degrees each frame
        for (double degrees = 0.0; degrees <= 135.0; degrees += 45.0) {
            engine.runSimulationStep(degrees);
            try {
                Thread.sleep(300); // Small delay to mimic a dynamic frame cycle rate
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("\nSimulation timeline complete.");
    }
}
