package src;

import javafx.geometry.Point3D;
import javafx.scene.shape.Line;

public class ShapeMaker {
    private final Point3D[] vertices;
    private final int[][] edges;
    private final Line[] linez;

    //cube start positions
    private double cx;
    private double cy;
    private final double cz;
    private double speed;
    public ShapeMaker(String shape){
        speed = .001;
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
    public void run(double dt){
//        changeCube('x',dt);
//        changeCube('y',dt);
//        changeCube('z',dt);
        //
        changeCube(dt);
        drawLines();
    }
    //set location
    public void setLocation(int cx, int cy){
        this.cx = cx;
        this.cy = cy;
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }

    private void drawLines(){
        for(int i = 0; i  < edges.length; i++){
            int startIdx = edges[i][0];
            int endIdx   = edges[i][1];
            Point3D p1 = vertices[startIdx];
            Point3D p2 = vertices[endIdx];
            linez[i].setStartX(p1.getX());
            linez[i].setStartY(p1.getY());
            linez[i].setEndX(p2.getX());
            linez[i].setEndY(p2.getY());
        }
    }
    public double getSpeed(){
        return speed;
    }

    private void changeCube(double dt){
        double angle = dt * speed;

        for (int i = 0; i < vertices.length; i++) {
            double x,y,z;
            double dx,dy,dz;
            dx = vertices[i].getX() - cx;
            dy = vertices[i].getY() - cy;
            dz = vertices[i].getZ() - cz;
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
