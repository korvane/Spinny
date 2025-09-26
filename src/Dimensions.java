package src;

import javafx.geometry.Point3D;

public class Dimensions {
    private static final int cx = 200;
    private static final int cy = 200;
    private static final int cz = 0;
    private static final int size = 30;

    //CUBE
    private static final Point3D[] cubeVertices = new Point3D[]{
            new Point3D(cx - size, cy - size, cz - size),
            new Point3D(cx + size, cy - size, cz - size),
            new Point3D(cx + size, cy + size, cz - size),
            new Point3D(cx - size, cy + size, cz - size),
            new Point3D(cx - size, cy - size, cz + size),
            new Point3D(cx + size, cy - size, cz + size),
            new Point3D(cx + size, cy + size, cz + size),
            new Point3D(cx - size, cy + size, cz + size)};
    private static final int[][] cubeEdges = new int[][]{{0,1},{1,2},{2,3},{3,0},
            {4,5},{5,6},{6,7},{7,4},
            {0,4},{1,5},{2,6},{3,7}};

    //TETRAHEDRON
    private static final Point3D[] tetrahedronVertices = new Point3D[]{
            new Point3D(cx+size, cy+size, cz + size),
            new Point3D(cx + size, cy - size, cz-size),
            new Point3D(cx - size, cy + size, cz - size),
            new Point3D(cx - size, cy - size, cz + size)};

    private static final int[][] tetrahedronEdges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2},
            {1, 3}, {2, 3}};

    //PYRAMID
    private static final Point3D[] pyramidVertices = new Point3D[]{
            new Point3D(cx-size, cy-size, cz - size),
            new Point3D(cx - size, cy + size, cz-size),
            new Point3D(cx + size, cy - size, cz - size),
            new Point3D(cx + size, cy + size, cz - size),
            new Point3D(cx, cy, cz + size)};
    private static final int[][] pyramidEdges = new int[][]{{0, 4}, {0, 2}, {0, 1}, {3, 2},
            {3, 1}, {3, 4},{2,4},{1,4}};

    public static int[][] getEdges(String shape){
        return switch (shape) {
            case "tetrahedron" -> tetrahedronEdges;
            case "cube" -> cubeEdges;
            case "pyramid" -> pyramidEdges;
            default -> throw new IllegalArgumentException("please give a valid shape.");
        };

    }
    public static Point3D[] getVertices(String shape){
        return switch (shape) {
            case "tetrahedron" -> tetrahedronVertices;
            case "cube" -> cubeVertices;
            case "pyramid" -> pyramidVertices;
            default -> throw new IllegalArgumentException("please give a valid shape.");
        };
    }

    public static int[] getStart(){
        return new int[]{cx,cy,cz};
    }
}
