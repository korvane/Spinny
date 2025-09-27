/*
 * Course: CSC 1020 - 131
 * Spinning 3D shapes
 * TestSuite
 * Name: Korvan Nameni
 * Last Updated: 9/27/25
 */
package src;

import javafx.geometry.Point3D;

/**
 * Stores the Vertices and Edges of each shape as parameters for ShapeMaker
 */
public class Dimensions {
    private static final int CX = 200;
    private static final int CY = 200;
    private static final int CZ = 0;
    private static final int SIZE = 30;

    //CUBE
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

    //TETRAHEDRON
    private static final Point3D[] TETRAHEDRON_VERTICES = new Point3D[] {
            new Point3D(CX + SIZE, CY + SIZE, CZ + SIZE),
            new Point3D(CX + SIZE, CY - SIZE, CZ-SIZE),
            new Point3D(CX - SIZE, CY + SIZE, CZ - SIZE),
            new Point3D(CX - SIZE, CY - SIZE, CZ + SIZE)};

    private static final int[][] TETRAHEDRON_EDGES = new int[][] {
            {0, 1}, {0, 2}, {0, 3}, {1, 2},
            {1, 3}, {2, 3}};

    //PYRAMID
    private static final Point3D[] PYRAMID_VERTICES = new Point3D[] {
            new Point3D(CX - SIZE, CY - SIZE, CZ - SIZE),
            new Point3D(CX - SIZE, CY + SIZE, CZ - SIZE),
            new Point3D(CX + SIZE, CY + SIZE, CZ - SIZE),
            new Point3D(CX + SIZE, CY - SIZE, CZ - SIZE),
            new Point3D(CX, CY, CZ + SIZE)};
    private static final int[][] PYRAMID_EDGES = new int[][] {
            {0, 1}, {1, 2}, {2, 3}, {3, 0},
            {0, 4}, {1, 4}, {2, 4}, {3, 4}};

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