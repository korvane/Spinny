/*
 * Course: CSC 1020 - 131
 * Spinning 3D shapes
 * TestSuite
 * Name: Korvan Nameni
 * Last Updated: 9/27/25
 */
package src;

import javafx.geometry.Point3D;
import javafx.scene.shape.Line;

/**
 * Shape Drawer and updater
 */
public class ShapeMaker {
    private final Point3D[] vertices;
    private final int[][] edges;
    private final Line[] linez;

    //cube start positions
    private double cx;
    private double cy;
    private final double cz;
    private double speed;

    /**
     * ShapeMaker constructor
     * @param shape from spinnyController
     */
    public ShapeMaker(String shape){
        final double initSpeed = .001; //MSOE Checkstyle's redundancy is making me do this
        speed = initSpeed;
        int[] strt = Dimensions.getStart();
        cx = strt[0];
        cy = strt[1];
        cz = strt[2];
        vertices = Dimensions.getVertices(shape);
        edges = Dimensions.getEdges(shape);

        linez = new Line[edges.length];
        for(int i = 0; i < linez.length; i++){
            linez[i] = new Line();
        }
    }

    /**
     * update for the AnimationTimer in SpinnyController
     * @param dt Change in time
     */
    public void run(double dt){
        changeCube(dt);
        drawLines();
    }

    /**
     * set location of shapes
     * @param cx center x
     * @param cy center y
     */
    public void setLocation(int cx, int cy){
        this.cx = cx;
        this.cy = cy;
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }
    public double getSpeed(){
        return speed;
    }
    private void drawLines(){
        for(int i = 0; i < edges.length; i++){
            int startIdx = edges[i][0];
            int endIdx = edges[i][1];
            Point3D p1 = vertices[startIdx];
            Point3D p2 = vertices[endIdx];
            linez[i].setStartX(p1.getX());
            linez[i].setStartY(p1.getY());
            linez[i].setEndX(p2.getX());
            linez[i].setEndY(p2.getY());
        }
    }


    private void changeCube(double dt){
        double angle = dt * speed;

        for (int i = 0; i < vertices.length; i++) {
            double x;
            double y;
            double z;
            double dx;
            double dy;
            double dz;
            dx = vertices[i].getX() - cx;
            dy = vertices[i].getY() - cy;
            x = dx * cos(angle) - dy * sin(angle);
            y = dx * sin(angle) + dy * cos(angle);
            vertices[i] = new Point3D(x + cx, y + cy, vertices[i].getZ()); //around z axis
            dy = vertices[i].getY() - cy;
            dz = vertices[i].getZ() - cz;
            y = dz * sin(angle) + dy * cos(angle);
            z = dz * cos(angle) - dy * sin(angle);
            vertices[i] = new Point3D(vertices[i].getX(), y + cy, z + cz); // around x axis
            dz = vertices[i].getZ() - cz;
            dx = vertices[i].getX() - cx;
            z = dx * sin(angle) + dz * cos(angle);
            x = dx * cos(angle) - dz * sin(angle);
            vertices[i] = new Point3D(x + cx, vertices[i].getY(), z + cz); //around y axis
        }
    }

    public Line[] getLinez(){
        return linez;
    }
    private double sin(double x){
        return Math.sin(x);
    }
    private double cos(double x){
        return Math.cos(x);
    }

}
