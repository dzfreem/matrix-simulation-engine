# Linear Algebra & Spatial Simulation Engine

A robust, dependency-free Java 3D coordinate transformation and linear systems simulation engine built completely from scratch using object-oriented principles. This utility implements modular linear algebra operations, algorithmic matrix optimizations, and coordinate systems transforms to process multi-dimensional calculations live via an interactive CLI command dashboard.

## 🛠️ System Architecture

The engine follows clean architectural isolation principles to decouple core mathematical entities from the evaluation and simulation execution layers:

```text
[Main Console Entry] ───> [SimulationEngine] ───> [LinearSystemSolver]
                                │                        │
                                ▼                        ▼
                       [Vector3 / Vector2] ───────> [Matrix]
```

### Core Components
* **`Matrix.java`**: Encapsulates a row-major 2D array grid storing coordinate elements. Implements dot-product multiplication, transpositions, and inverse workflows.
* **`Vector3.java`**: Models spatial coordinates (x, y, z). Integrates with the `Matrix` class by converting into 3 × 1 column vectors to handle linear mappings natively.
* **`LinearSystemSolver.java`**: A quantitative evaluation utility designed to isolate structural parameters and solve systems of equations (Ax = B).
* **`SimulationEngine.java`**: Simulates a 3D graphics rendering pipeline by iteratively rotating multi-dimensional vertex meshes across space using real-time trigonometric rotation matrices.

---

## 📊 Algorithmic Matrix Metrics

| Operation | Implementation Algorithm | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- |
| **Addition / Scaling** | Element-by-element iterative map | \(O(M \times N)\) | \(O(M \times N)\) |
| **Multiplication** | Triple-loop index dot product | \(O(M \times P \times N)\) | \(O(M \times P)\) |
| **Determinant** | Gaussian Elimination (Row Reduction) | O(N³) | O(N²) |
| **Matrix Inversion** | Gauss-Jordan Elimination with Pivoting | O(N³) | O(N²) |

### Technical Highlights
* **Complexity Optimization**: The determinant and inversion subroutines prioritize O(N³) Gaussian Elimination over the naive O(N!) cofactor expansion model, ensuring structural stability for large input dimensions.
* **Numerical Safeguards**: Built-in floating-point error safety traps ensure that comparisons against theoretical zero track within a tight tolerance parameter (ε = 10⁻⁹), safely intercepting singular matrix exceptions before causing division-by-zero crashes.
* **Robust Input Sanitization**: Utilizes space-separated regular expression parsing (`\\s+`) to process user values dynamically via the command console while enforcing runtime boundary matching.

---

## 🚀 Compilation & Local Execution

Since this engine is entirely dependency-free and written natively in standard Java, it compiles easily on local workstations or cloud environments (like GitHub Codespaces).

```bash
# 1. Compile the source tree into localized target binaries
javac -d bin src/com/engine/Main.java src/com/engine/*/*.java

# 2. Execute the engine control panel main class
java -cp bin com.engine.Main
```

### Live Interface Demonstration
```text
==================================================
   LINEAR ALGEBRA & SPATIAL ENGINE DASHBOARD v1.0 
==================================================

--- MAIN CONTROL PANEL ---
1) Compute Matrix Multiplication (A x B)
2) Calculate Determinant & Inverse of a Matrix
3) Solve Linear Equation System (Ax = B)
4) Run 3D Mesh Rotation Simulation Frame
5) Exit Application

Select an option (1-5): 4

Enter rotation increment step in degrees (e.g., 45): 90

--- FRAME: Rotating Coordinate Mesh by 90.0° ---
Vertex 0 positions: Initial(X=0.0, Y=0.0, Z=0.0) -> Transformed(X= 0.00, Y= 0.00, Z= 0.00)
Vertex 1 positions: Initial(X=1.0, Y=0.0, Z=0.0) -> Transformed(X= 0.00, Y= 0.00, Z=-1.00)
Vertex 2 positions: Initial(X=1.0, Y=1.0, Z=0.0) -> Transformed(X= 0.00, Y= 1.00, Z=-1.00)
```

## 📦 Instant Executable Launch

Skip compilation and run the pre-packaged executable binary file instantly:

```bash
java -jar LinearAlgebraEngine.jar
```
