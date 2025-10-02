/*
 * Course: CSC 1020 - 131
 * Spinning 3D shapes
 * TestSuite
 * Name: Korvan Nameni
 * Last Updated: 9/27/25
 */
package src;

import javafx.geometry.Point3D;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores the Vertices and Edges of each shape as parameters for ShapeMaker
 * MVC - Model
 */
public class Dimensions {
    private static final int CX = 275;
    private static final int CY = 350;
    private static final int CZ = 0;
    private static final int SIZE = 125;

    // call: int[][] edges = buildEdges(vertices);
    public static int[][] buildEdges(Point3D[] vertices) {
        int n = vertices.length;
        double minDist = Double.POSITIVE_INFINITY;

        // Step 1: find minimum non-zero distance
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double d = vertices[i].distance(vertices[j]);
                if (d > 1e-6 && d < minDist) minDist = d;
            }
        }

        // Step 2: connect vertices at that distance
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(vertices[i].distance(vertices[j]) - minDist) < 1e-6) {
                    edges.add(new int[]{i, j});
                }
            }
        }

        return edges.toArray(new int[edges.size()][]);
    }
    //cube
    private static final Point3D[] CUBE_VERTICES = new Point3D[] {
            new Point3D(CX - SIZE, CY - SIZE, CZ - SIZE),
            new Point3D(CX + SIZE, CY - SIZE, CZ - SIZE),
            new Point3D(CX + SIZE, CY + SIZE, CZ - SIZE),
            new Point3D(CX - SIZE, CY + SIZE, CZ - SIZE),
            new Point3D(CX - SIZE, CY - SIZE, CZ + SIZE),
            new Point3D(CX + SIZE, CY - SIZE, CZ + SIZE),
            new Point3D(CX + SIZE, CY + SIZE, CZ + SIZE),
            new Point3D(CX - SIZE, CY + SIZE, CZ + SIZE)};

    private static final int[][] CUBE_EDGES = new int[][] {
            {0, 1}, {1, 2}, {2, 3}, {3, 0},
            {4, 5}, {5, 6}, {6, 7}, {7, 4},
            {0, 4}, {1, 5}, {2, 6}, {3, 7}};

    //tetrahedron
    private static final Point3D[] TETRAHEDRON_VERTICES = new Point3D[] {
            new Point3D(CX + SIZE, CY + SIZE, CZ + SIZE),
            new Point3D(CX + SIZE, CY - SIZE, CZ-SIZE),
            new Point3D(CX - SIZE, CY + SIZE, CZ - SIZE),
            new Point3D(CX - SIZE, CY - SIZE, CZ + SIZE)};

    private static final int[][] TETRAHEDRON_EDGES = new int[][] {
            {0, 1}, {0, 2}, {0, 3}, {1, 2},
            {1, 3}, {2, 3}};

    //square pyramid
    private static final Point3D[] PYRAMID_VERTICES = new Point3D[] {
            new Point3D(CX - SIZE, CY - SIZE, CZ - SIZE/4.0),
            new Point3D(CX - SIZE, CY + SIZE, CZ - SIZE/4.0),
            new Point3D(CX + SIZE, CY + SIZE, CZ - SIZE/4.0),
            new Point3D(CX + SIZE, CY - SIZE, CZ - SIZE/4.0),
            new Point3D(CX, CY, CZ + SIZE*4/3.0)};
    private static final int[][] PYRAMID_EDGES = new int[][] {
            {0, 1}, {1, 2}, {2, 3}, {3, 0},
            {0, 4}, {1, 4}, {2, 4}, {3, 4}};

    // Octahedron
    private static final Point3D[] OCTAHEDRON_VERTICES = new Point3D[] {
            new Point3D(CX, CY - SIZE, CZ),   // top
            new Point3D(CX, CY + SIZE, CZ),   // bottom
            new Point3D(CX - SIZE, CY, CZ),   // left
            new Point3D(CX + SIZE, CY, CZ),   // right
            new Point3D(CX, CY, CZ - SIZE),   // front
            new Point3D(CX, CY, CZ + SIZE)    // back
    };

    private static final int[][] OCTAHEDRON_EDGES = new int[][] {
            {0,2}, {0,3}, {0,4}, {0,5},
            {1,2}, {1,3}, {1,4}, {1,5},
            {2,4}, {2,5}, {3,4}, {3,5}
    };

    // Rectangular Prism
    private static final Point3D[] PRISM_VERTICES = new Point3D[] {
            new Point3D(CX - SIZE*2, CY - SIZE, CZ - SIZE),
            new Point3D(CX + SIZE*2, CY - SIZE, CZ - SIZE),
            new Point3D(CX + SIZE*2, CY + SIZE, CZ - SIZE),
            new Point3D(CX - SIZE*2, CY + SIZE, CZ - SIZE),
            new Point3D(CX - SIZE*2, CY - SIZE, CZ + SIZE),
            new Point3D(CX + SIZE*2, CY - SIZE, CZ + SIZE),
            new Point3D(CX + SIZE*2, CY + SIZE, CZ + SIZE),
            new Point3D(CX - SIZE*2, CY + SIZE, CZ + SIZE)
    };

    private static final int[][] PRISM_EDGES = new int[][] {
            {0,1}, {1,2}, {2,3}, {3,0},
            {4,5}, {5,6}, {6,7}, {7,4},
            {0,4}, {1,5}, {2,6}, {3,7}
    };

    // Triangular Prism
    private static final Point3D[] TRI_PRISM_VERTICES = new Point3D[] {
            new Point3D(CX - SIZE, CY - SIZE, CZ - SIZE),
            new Point3D(CX + SIZE, CY - SIZE, CZ - SIZE),
            new Point3D(CX, CY + SIZE, CZ - SIZE),
            new Point3D(CX - SIZE, CY - SIZE, CZ + SIZE),
            new Point3D(CX + SIZE, CY - SIZE, CZ + SIZE),
            new Point3D(CX, CY + SIZE, CZ + SIZE)
    };

    private static final int[][] TRI_PRISM_EDGES = new int[][] {
            {0,1}, {1,2}, {2,0},    // bottom triangle
            {3,4}, {4,5}, {5,3},    // top triangle
            {0,3}, {1,4}, {2,5}     // vertical connectors
    };

    // Dodecahedron
    private static final double PHI = (1 + Math.sqrt(5)) / 2;
    private static final double INV_PHI = 1.0 / PHI;

    private static final Point3D[] DODECA_VERTICES = new Point3D[] {
            // (±1, ±1, ±1)
            new Point3D(CX + SIZE, CY + SIZE, CZ + SIZE),   // 0
            new Point3D(CX + SIZE, CY + SIZE, CZ - SIZE),   // 1
            new Point3D(CX + SIZE, CY - SIZE, CZ + SIZE),   // 2
            new Point3D(CX + SIZE, CY - SIZE, CZ - SIZE),   // 3
            new Point3D(CX - SIZE, CY + SIZE, CZ + SIZE),   // 4
            new Point3D(CX - SIZE, CY + SIZE, CZ - SIZE),   // 5
            new Point3D(CX - SIZE, CY - SIZE, CZ + SIZE),   // 6
            new Point3D(CX - SIZE, CY - SIZE, CZ - SIZE),   // 7

            // (0, ±1/φ, ±φ)
            new Point3D(CX, CY + SIZE * INV_PHI, CZ + SIZE * PHI),  // 8
            new Point3D(CX, CY + SIZE * INV_PHI, CZ - SIZE * PHI),  // 9
            new Point3D(CX, CY - SIZE * INV_PHI, CZ + SIZE * PHI),  // 10
            new Point3D(CX, CY - SIZE * INV_PHI, CZ - SIZE * PHI),  // 11

            // (±1/φ, ±φ, 0)
            new Point3D(CX + SIZE * INV_PHI, CY + SIZE * PHI, CZ),  // 12
            new Point3D(CX + SIZE * INV_PHI, CY - SIZE * PHI, CZ),  // 13
            new Point3D(CX - SIZE * INV_PHI, CY + SIZE * PHI, CZ),  // 14
            new Point3D(CX - SIZE * INV_PHI, CY - SIZE * PHI, CZ),  // 15

            // (±φ, 0, ±1/φ)
            new Point3D(CX + SIZE * PHI, CY, CZ + SIZE * INV_PHI),  // 16
            new Point3D(CX + SIZE * PHI, CY, CZ - SIZE * INV_PHI),  // 17
            new Point3D(CX - SIZE * PHI, CY, CZ + SIZE * INV_PHI),  // 18
            new Point3D(CX - SIZE * PHI, CY, CZ - SIZE * INV_PHI)   // 19
    };

    private static final int[][] DODECA_EDGES = new int[][] {
            {0, 8},  {0, 12}, {0, 16},
            {1, 9},  {1, 12}, {1, 17},
            {2, 10}, {2, 13}, {2, 16},
            {3, 11}, {3, 13}, {3, 17},
            {4, 8},  {4, 14}, {4, 18},
            {5, 9},  {5, 14}, {5, 19},
            {6, 10}, {6, 15}, {6, 18},
            {7, 11}, {7, 15}, {7, 19},
            {8, 10}, {9, 11},
            {12, 14}, {13, 15},
            {16, 17}, {18, 19}
    };

    // Icosahedron
    private static final Point3D[] ICOSAHEDRON_VERTICES = new Point3D[] {
            // (0, ±1, ±φ)
            new Point3D(CX, CY + SIZE, CZ + SIZE * PHI),   // 0
            new Point3D(CX, CY + SIZE, CZ - SIZE * PHI),   // 1
            new Point3D(CX, CY - SIZE, CZ + SIZE * PHI),   // 2
            new Point3D(CX, CY - SIZE, CZ - SIZE * PHI),   // 3

            // (±1, ±φ, 0)
            new Point3D(CX + SIZE, CY + SIZE * PHI, CZ),   // 4
            new Point3D(CX + SIZE, CY - SIZE * PHI, CZ),   // 5
            new Point3D(CX - SIZE, CY + SIZE * PHI, CZ),   // 6
            new Point3D(CX - SIZE, CY - SIZE * PHI, CZ),   // 7

            // (±φ, 0, ±1)
            new Point3D(CX + SIZE * PHI, CY, CZ + SIZE),   // 8
            new Point3D(CX + SIZE * PHI, CY, CZ - SIZE),   // 9
            new Point3D(CX - SIZE * PHI, CY, CZ + SIZE),   // 10
            new Point3D(CX - SIZE * PHI, CY, CZ - SIZE)    // 11
    };

    private static final int[][] ICOSAHEDRON_EDGES = new int[][] {
            {0, 2}, {0, 4}, {0, 6}, {0, 8}, {0, 10},
            {1, 3}, {1, 4}, {1, 6}, {1, 9}, {1, 11},
            {2, 5}, {2, 7}, {2, 8}, {2, 10},
            {3, 5}, {3, 7}, {3, 9}, {3, 11},
            {4, 6}, {4, 8}, {4, 9},
            {5, 7}, {5, 8}, {5, 9},
            {6, 10}, {6, 11},
            {7, 10}, {7, 11},
            {8, 9}, {10, 11}
    };

    // Hexagonal Prism
    private static final Point3D[] HEX_PRISM_VERTICES = new Point3D[] {
            // bottom hexagon (z - SIZE)
            new Point3D(CX - SIZE, CY, CZ - SIZE),
            new Point3D(CX - SIZE/2.0, CY + SIZE*Math.sqrt(3)/2.0, CZ - SIZE),
            new Point3D(CX + SIZE/2.0, CY + SIZE*Math.sqrt(3)/2.0, CZ - SIZE),
            new Point3D(CX + SIZE, CY, CZ - SIZE),
            new Point3D(CX + SIZE/2.0, CY - SIZE*Math.sqrt(3)/2.0, CZ - SIZE),
            new Point3D(CX - SIZE/2.0, CY - SIZE*Math.sqrt(3)/2.0, CZ - SIZE),

            // top hexagon (z + SIZE)
            new Point3D(CX - SIZE, CY, CZ + SIZE),
            new Point3D(CX - SIZE/2.0, CY + SIZE*Math.sqrt(3)/2.0, CZ + SIZE),
            new Point3D(CX + SIZE/2.0, CY + SIZE*Math.sqrt(3)/2.0, CZ + SIZE),
            new Point3D(CX + SIZE, CY, CZ + SIZE),
            new Point3D(CX + SIZE/2.0, CY - SIZE*Math.sqrt(3)/2.0, CZ + SIZE),
            new Point3D(CX - SIZE/2.0, CY - SIZE*Math.sqrt(3)/2.0, CZ + SIZE)
    };

    private static final int[][] HEX_PRISM_EDGES = new int[][] {
            {0,1},{1,2},{2,3},{3,4},{4,5},{5,0},     // bottom hex
            {6,7},{7,8},{8,9},{9,10},{10,11},{11,6}, // top hex
            {0,6},{1,7},{2,8},{3,9},{4,10},{5,11}    // verticals
    };

    private static final Point3D[] RECT_PYRAMID_VERTICES = new Point3D[] {
            new Point3D(CX - SIZE, CY - SIZE, CZ - SIZE),  // base square
            new Point3D(CX + SIZE, CY - SIZE, CZ - SIZE),
            new Point3D(CX + SIZE, CY + SIZE, CZ - SIZE),
            new Point3D(CX - SIZE, CY + SIZE, CZ - SIZE),
            new Point3D(CX, CY, CZ + SIZE*2)              // apex
    };

    private static final int[][] RECT_PYRAMID_EDGES = new int[][] {
            {0,1},{1,2},{2,3},{3,0},   // base
            {0,4},{1,4},{2,4},{3,4}    // sides
    };

    // Pentagonal Prism
    private static final Point3D[] PENTA_PRISM_VERTICES = new Point3D[] {
            // bottom pentagon (z - SIZE)
            new Point3D(CX, CY - SIZE, CZ - SIZE),
            new Point3D(CX + SIZE*Math.sin(72*Math.PI/180), CY - SIZE*Math.cos(72*Math.PI/180), CZ - SIZE),
            new Point3D(CX + SIZE*Math.sin(144*Math.PI/180), CY - SIZE*Math.cos(144*Math.PI/180), CZ - SIZE),
            new Point3D(CX - SIZE*Math.sin(144*Math.PI/180), CY - SIZE*Math.cos(144*Math.PI/180), CZ - SIZE),
            new Point3D(CX - SIZE*Math.sin(72*Math.PI/180), CY - SIZE*Math.cos(72*Math.PI/180), CZ - SIZE),

            // top pentagon (z + SIZE)
            new Point3D(CX, CY - SIZE, CZ + SIZE),
            new Point3D(CX + SIZE*Math.sin(72*Math.PI/180), CY - SIZE*Math.cos(72*Math.PI/180), CZ + SIZE),
            new Point3D(CX + SIZE*Math.sin(144*Math.PI/180), CY - SIZE*Math.cos(144*Math.PI/180), CZ + SIZE),
            new Point3D(CX - SIZE*Math.sin(144*Math.PI/180), CY - SIZE*Math.cos(144*Math.PI/180), CZ + SIZE),
            new Point3D(CX - SIZE*Math.sin(72*Math.PI/180), CY - SIZE*Math.cos(72*Math.PI/180), CZ + SIZE)
    };

    private static final int[][] PENTA_PRISM_EDGES = new int[][] {
            {0,1},{1,2},{2,3},{3,4},{4,0},   // bottom
            {5,6},{6,7},{7,8},{8,9},{9,5},   // top
            {0,5},{1,6},{2,7},{3,8},{4,9}    // verticals
    };

    //hexagonal pyramid
    private static final Point3D[] HEX_PYRAMID_VERTICES = new Point3D[7];
    static {
        double r = SIZE;
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i);
            double x = CX + r * Math.cos(angle);
            double y = CY + r * Math.sin(angle);
            HEX_PYRAMID_VERTICES[i] = new Point3D(x, y, CZ - SIZE/2.0);
        }
        HEX_PYRAMID_VERTICES[6] = new Point3D(CX, CY, CZ + SIZE*1.5); // apex
    }

    private static final int[][] HEX_PYRAMID_EDGES = new int[][] {
            {0,1},{1,2},{2,3},{3,4},{4,5},{5,0}, // base
            {0,6},{1,6},{2,6},{3,6},{4,6},{5,6}  // sides
    };

    //truncated tetrahedron
    private static final Point3D[] TRUNC_TETRA_VERTICES = new Point3D[] {
            new Point3D(CX + SIZE * 1.0, CY + SIZE * 1.0, CZ + SIZE * 0.333333),
            new Point3D(CX + SIZE * 1.0, CY + SIZE * 0.333333, CZ + SIZE * 1.0),
            new Point3D(CX + SIZE * 0.333333, CY + SIZE * 1.0, CZ + SIZE * 1.0),

            new Point3D(CX + SIZE * -1.0, CY + SIZE * -1.0, CZ + SIZE * 0.333333),
            new Point3D(CX + SIZE * -1.0, CY + SIZE * 0.333333, CZ + SIZE * -1.0),
            new Point3D(CX + SIZE * 0.333333, CY + SIZE * -1.0, CZ + SIZE * -1.0),

            new Point3D(CX + SIZE * -1.0, CY + SIZE * 1.0, CZ + SIZE * -0.333333),
            new Point3D(CX + SIZE * -1.0, CY + SIZE * 0.333333, CZ + SIZE * 1.0),
            new Point3D(CX + SIZE * 0.333333, CY + SIZE * 1.0, CZ + SIZE * -1.0),

            new Point3D(CX + SIZE * 1.0, CY + SIZE * -1.0, CZ + SIZE * -0.333333),
            new Point3D(CX + SIZE * 1.0, CY + SIZE * -0.333333, CZ + SIZE * -1.0),
            new Point3D(CX + SIZE * -0.333333, CY + SIZE * -1.0, CZ + SIZE * -1.0)
    };

    private static final int[][] TRUNC_TETRA_EDGES = new int[][] {
            {0,1},{0,2},{0,4},{1,2},{1,5},{2,8},
            {3,4},{3,5},{3,6},{4,6},{4,9},{5,6},
            {7,8},{7,9},{7,10},{8,10},{8,11},{9,10},{9,11},{10,11}
    };

    //Cuboctahedron

    private static final Point3D[] CUBOCT_VERTICES = new Point3D[] {
            new Point3D(CX + SIZE * -1.0, CY + SIZE * -1.0, CZ + SIZE * 0.0),
            new Point3D(CX + SIZE * -1.0, CY + SIZE * 1.0, CZ + SIZE * 0.0),
            new Point3D(CX + SIZE * 1.0, CY + SIZE * -1.0, CZ + SIZE * 0.0),
            new Point3D(CX + SIZE * 1.0, CY + SIZE * 1.0, CZ + SIZE * 0.0),

            new Point3D(CX + SIZE * -1.0, CY + SIZE * 0.0, CZ + SIZE * -1.0),
            new Point3D(CX + SIZE * -1.0, CY + SIZE * 0.0, CZ + SIZE * 1.0),
            new Point3D(CX + SIZE * 1.0, CY + SIZE * 0.0, CZ + SIZE * -1.0),
            new Point3D(CX + SIZE * 1.0, CY + SIZE * 0.0, CZ + SIZE * 1.0),

            new Point3D(CX + SIZE * 0.0, CY + SIZE * -1.0, CZ + SIZE * -1.0),
            new Point3D(CX + SIZE * 0.0, CY + SIZE * -1.0, CZ + SIZE * 1.0),
            new Point3D(CX + SIZE * 0.0, CY + SIZE * 1.0, CZ + SIZE * -1.0),
            new Point3D(CX + SIZE * 0.0, CY + SIZE * 1.0, CZ + SIZE * 1.0)
    };

    private static final int[][] CUBOCT_EDGES = buildEdges(CUBOCT_VERTICES);

    //truncated cube
    private static final Point3D[] TRUNC_CUBE_VERTICES = new Point3D[] {
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * -1.000000, CZ + SIZE * -0.414214),
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * -1.000000, CZ + SIZE * 0.414214),
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * -0.414214, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * -0.414214, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * 0.414214, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * 0.414214, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * 1.000000, CZ + SIZE * -0.414214),
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * 1.000000, CZ + SIZE * 0.414214),
            new Point3D(CX + SIZE * -0.414214, CY + SIZE * -1.000000, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * -0.414214, CY + SIZE * -1.000000, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * -0.414214, CY + SIZE * 1.000000, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * -0.414214, CY + SIZE * 1.000000, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * 0.414214, CY + SIZE * -1.000000, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * 0.414214, CY + SIZE * -1.000000, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * 0.414214, CY + SIZE * 1.000000, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * 0.414214, CY + SIZE * 1.000000, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * -1.000000, CZ + SIZE * -0.414214),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * -1.000000, CZ + SIZE * 0.414214),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * -0.414214, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * -0.414214, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * 0.414214, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * 0.414214, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * 1.000000, CZ + SIZE * -0.414214),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * 1.000000, CZ + SIZE * 0.414214)
    };

    private static final int[][] TRUNC_CUBE_EDGES = new int[][] {
            {0,1},{0,2},{0,8},{1,3},{1,9},{2,4},{2,8},{3,5},{3,9},{4,6},{4,10},{5,7},{5,11},{6,7},{6,10},{7,11},
            {8,12},{9,13},{10,14},{11,15},{12,16},{12,18},{13,17},{13,19},{14,20},{14,22},{15,21},{15,23},
            {16,17},{16,18},{17,19},{18,20},{19,21},{20,22},{21,23},{22,23}
    };

    //snub cube
    private static final Point3D[] SNUB_CUBE_VERTICES = new Point3D[] {
            new Point3D(CX + SIZE * -1.839286, CY + SIZE * -1.000000, CZ + SIZE * -0.543689),
            new Point3D(CX + SIZE * -1.839286, CY + SIZE * -0.543689, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * -1.839286, CY + SIZE * 0.543689, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * -1.839286, CY + SIZE * 1.000000, CZ + SIZE * 0.543689),
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * -1.839286, CZ + SIZE * 0.543689),
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * -0.543689, CZ + SIZE * -1.839286),
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * 0.543689, CZ + SIZE * 1.839286),
            new Point3D(CX + SIZE * -1.000000, CY + SIZE * 1.839286, CZ + SIZE * -0.543689),
            new Point3D(CX + SIZE * -0.543689, CY + SIZE * -1.839286, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * -0.543689, CY + SIZE * -1.000000, CZ + SIZE * 1.839286),
            new Point3D(CX + SIZE * -0.543689, CY + SIZE * 1.000000, CZ + SIZE * -1.839286),
            new Point3D(CX + SIZE * -0.543689, CY + SIZE * 1.839286, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * 0.543689, CY + SIZE * -1.839286, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * 0.543689, CY + SIZE * -1.000000, CZ + SIZE * -1.839286),
            new Point3D(CX + SIZE * 0.543689, CY + SIZE * 1.000000, CZ + SIZE * 1.839286),
            new Point3D(CX + SIZE * 0.543689, CY + SIZE * 1.839286, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * -1.839286, CZ + SIZE * -0.543689),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * -0.543689, CZ + SIZE * 1.839286),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * 0.543689, CZ + SIZE * -1.839286),
            new Point3D(CX + SIZE * 1.000000, CY + SIZE * 1.839286, CZ + SIZE * 0.543689),
            new Point3D(CX + SIZE * 1.839286, CY + SIZE * -1.000000, CZ + SIZE * 0.543689),
            new Point3D(CX + SIZE * 1.839286, CY + SIZE * -0.543689, CZ + SIZE * -1.000000),
            new Point3D(CX + SIZE * 1.839286, CY + SIZE * 0.543689, CZ + SIZE * 1.000000),
            new Point3D(CX + SIZE * 1.839286, CY + SIZE * 1.000000, CZ + SIZE * -0.543689)
    };

    private static final int[][] SNUB_CUBE_EDGES = new int[][] {
            {0,1},{0,2},{0,4},{0,5},{0,8},{1,3},{1,4},{1,6},{1,9},{2,3},{2,5},{2,7},{2,10},{3,6},{3,7},{3,11},
            {4,8},{4,9},{4,12},{5,8},{5,10},{5,13},{6,9},{6,11},{6,14},{7,10},{7,11},{7,15},{8,13},{8,16},
            {9,12},{9,17},{10,15},{10,18},{11,14},{11,19},{12,16},{12,17},{12,20},{13,16},{13,18},{13,21},
            {14,17},{14,19},{14,22},{15,18},{15,19},{15,23},{16,20},{16,21},{17,20},{17,22},{18,21},{18,23},
            {19,22},{19,23},{20,21},{20,22},{21,23},{22,23}
    };

    //truncated octahedron
    private static final Point3D[] TRUNCATED_OCTAHEDRON_VERTICES = new Point3D[] {
            new Point3D(CX + SIZE * -1.414214, CY + SIZE * -0.707107, CZ + SIZE * 0.000000),
            new Point3D(CX + SIZE * -1.414214, CY + SIZE * 0.000000, CZ + SIZE * -0.707107),
            new Point3D(CX + SIZE * -1.414214, CY + SIZE * 0.000000, CZ + SIZE * 0.707107),
            new Point3D(CX + SIZE * -1.414214, CY + SIZE * 0.707107, CZ + SIZE * 0.000000),
            new Point3D(CX + SIZE * -0.707107, CY + SIZE * -1.414214, CZ + SIZE * 0.000000),
            new Point3D(CX + SIZE * -0.707107, CY + SIZE * 0.000000, CZ + SIZE * -1.414214),
            new Point3D(CX + SIZE * -0.707107, CY + SIZE * 0.000000, CZ + SIZE * 1.414214),
            new Point3D(CX + SIZE * -0.707107, CY + SIZE * 1.414214, CZ + SIZE * 0.000000),
            new Point3D(CX + SIZE * 0.000000, CY + SIZE * -1.414214, CZ + SIZE * -0.707107),
            new Point3D(CX + SIZE * 0.000000, CY + SIZE * -1.414214, CZ + SIZE * 0.707107),
            new Point3D(CX + SIZE * 0.000000, CY + SIZE * -0.707107, CZ + SIZE * -1.414214),
            new Point3D(CX + SIZE * 0.000000, CY + SIZE * -0.707107, CZ + SIZE * 1.414214),
            new Point3D(CX + SIZE * 0.000000, CY + SIZE * 0.707107, CZ + SIZE * -1.414214),
            new Point3D(CX + SIZE * 0.000000, CY + SIZE * 0.707107, CZ + SIZE * 1.414214),
            new Point3D(CX + SIZE * 0.000000, CY + SIZE * 1.414214, CZ + SIZE * -0.707107),
            new Point3D(CX + SIZE * 0.000000, CY + SIZE * 1.414214, CZ + SIZE * 0.707107),
            new Point3D(CX + SIZE * 0.707107, CY + SIZE * -1.414214, CZ + SIZE * 0.000000),
            new Point3D(CX + SIZE * 0.707107, CY + SIZE * 0.000000, CZ + SIZE * -1.414214),
            new Point3D(CX + SIZE * 0.707107, CY + SIZE * 0.000000, CZ + SIZE * 1.414214),
            new Point3D(CX + SIZE * 0.707107, CY + SIZE * 1.414214, CZ + SIZE * 0.000000),
            new Point3D(CX + SIZE * 1.414214, CY + SIZE * -0.707107, CZ + SIZE * 0.000000),
            new Point3D(CX + SIZE * 1.414214, CY + SIZE * 0.000000, CZ + SIZE * -0.707107),
            new Point3D(CX + SIZE * 1.414214, CY + SIZE * 0.000000, CZ + SIZE * 0.707107),
            new Point3D(CX + SIZE * 1.414214, CY + SIZE * 0.707107, CZ + SIZE * 0.000000)
    };

    private static final int[][] TRUNCATED_OCTAHEDRON_EDGES = new int[][] {
            {0,1},{0,2},{0,4},{1,3},{1,5},{2,3},{2,6},{3,7},{4,8},{4,9},{5,10},{5,12},{6,11},{6,13},{7,14},{7,15},
            {8,10},{8,16},{9,11},{9,16},{10,17},{11,18},{12,14},{12,17},{13,15},{13,18},{14,19},{15,19},{16,20},
            {17,21},{18,22},{19,23},{20,21},{20,22},{21,23},{22,23}
    };

    //rhombic dodecahedron
    private static final Point3D[] RHOMBIC_DODECAHEDRON_VERTICES = new Point3D[] {
            // Cube corners
            new Point3D(CX + SIZE * -1.0, CY + SIZE * -1.0, CZ + SIZE * -1.0),
            new Point3D(CX + SIZE * -1.0, CY + SIZE * -1.0, CZ + SIZE * 1.0),
            new Point3D(CX + SIZE * -1.0, CY + SIZE * 1.0, CZ + SIZE * -1.0),
            new Point3D(CX + SIZE * -1.0, CY + SIZE * 1.0, CZ + SIZE * 1.0),
            new Point3D(CX + SIZE * 1.0, CY + SIZE * -1.0, CZ + SIZE * -1.0),
            new Point3D(CX + SIZE * 1.0, CY + SIZE * -1.0, CZ + SIZE * 1.0),
            new Point3D(CX + SIZE * 1.0, CY + SIZE * 1.0, CZ + SIZE * -1.0),
            new Point3D(CX + SIZE * 1.0, CY + SIZE * 1.0, CZ + SIZE * 1.0),
            // Face centers
            new Point3D(CX + SIZE * -2.0, CY + SIZE * 0.0, CZ + SIZE * 0.0),
            new Point3D(CX + SIZE * 2.0, CY + SIZE * 0.0, CZ + SIZE * 0.0),
            new Point3D(CX + SIZE * 0.0, CY + SIZE * -2.0, CZ + SIZE * 0.0),
            new Point3D(CX + SIZE * 0.0, CY + SIZE * 2.0, CZ + SIZE * 0.0),
            new Point3D(CX + SIZE * 0.0, CY + SIZE * 0.0, CZ + SIZE * -2.0),
            new Point3D(CX + SIZE * 0.0, CY + SIZE * 0.0, CZ + SIZE * 2.0)
    };

    private static final int[][] RHOMBIC_DODECAHEDRON_EDGES = new int[][] {
            {0,1},{0,2},{0,4},{0,8},{0,10},{0,12},
            {1,3},{1,5},{1,8},{1,10},{1,13},
            {2,3},{2,6},{2,8},{2,11},{2,12},
            {3,7},{3,9},{3,11},{3,13},
            {4,5},{4,6},{4,9},{4,10},{4,12},
            {5,7},{5,9},{5,13},
            {6,7},{6,11},{6,12},{6,9},
            {7,11},{7,13},
            {8,9},{8,10},{10,12},{11,13},{12,13}
    };
    /**
     * Edges getter for ShapeMaker.
     * @param shape Takes a string. Avoids the alternative of making a new getter per shape
     * @return Point3D array of vertices
     * @throws IllegalArgumentException Input valid shape
     */
    public static int[][] getEdges(String shape){
        return switch (shape) {
            case "tetrahedron" -> TETRAHEDRON_EDGES;
            case "cube" -> CUBE_EDGES;
            case "pyramid" -> PYRAMID_EDGES;
            case "octahedron" -> OCTAHEDRON_EDGES;
            case "rectangular prism" -> PRISM_EDGES;
            case "triangular prism" -> TRI_PRISM_EDGES;
            case "dodecahedron" -> DODECA_EDGES;
            case "icosahedron" -> ICOSAHEDRON_EDGES;
            case "hexagonal prism" -> HEX_PRISM_EDGES;
            case "rectangular pyramid" -> RECT_PYRAMID_EDGES;
            case "pentagonal prism" -> PENTA_PRISM_EDGES;
            case "hexagonal pyramid" -> HEX_PYRAMID_EDGES;
            case "truncated tetrahedron" -> TRUNC_TETRA_EDGES;
            case "cuboctahedron" -> CUBOCT_EDGES;
            case "truncated cube" -> TRUNC_CUBE_EDGES;
            case "snub cube" -> SNUB_CUBE_EDGES;
            case "truncated octahedron" -> TRUNCATED_OCTAHEDRON_EDGES;
            case "rhombic dodecahedron" -> RHOMBIC_DODECAHEDRON_EDGES;
            default -> throw new IllegalArgumentException("please give a valid shape.");
        };

    }


    /**
     * Vertices getter for ShapeMaker. Same deal as edges.
     * @param shape Takes a string. Avoids the alternative of making a new getter per shape
     * @return Point3D array of vertices
     *  @throws IllegalArgumentException Input valid shape
     */
    public static Point3D[] getVertices(String shape){
        return switch (shape) {
            case "tetrahedron" -> TETRAHEDRON_VERTICES;
            case "cube" -> CUBE_VERTICES;
            case "pyramid" -> PYRAMID_VERTICES;
            case "octahedron" -> OCTAHEDRON_VERTICES;
            case "rectangular prism" -> PRISM_VERTICES;
            case "triangular prism" -> TRI_PRISM_VERTICES;
            case "dodecahedron" -> DODECA_VERTICES;
            case "icosahedron" -> ICOSAHEDRON_VERTICES;
            case "hexagonal prism" -> HEX_PRISM_VERTICES;
            case "rectangular pyramid" -> RECT_PYRAMID_VERTICES;
            case "pentagonal prism" -> PENTA_PRISM_VERTICES;
            case "hexagonal pyramid" -> HEX_PYRAMID_VERTICES;
            case "truncated tetrahedron" -> TRUNC_TETRA_VERTICES;
            case "cuboctahedron" -> CUBOCT_VERTICES;
            case "truncated cube" -> TRUNC_CUBE_VERTICES;
            case "snub cube" -> SNUB_CUBE_VERTICES;
            case "truncated octahedron" -> TRUNCATED_OCTAHEDRON_VERTICES;
            case "rhombic dodecahedron" -> RHOMBIC_DODECAHEDRON_VERTICES;
            default -> throw new IllegalArgumentException("please give a valid shape.");
        };
    }

    /**
     * Get center X, Y, Z
     * @return center coordinates
     */
    public static int[] getStart(){
        return new int[] {CX, CY, CZ};
    }
}