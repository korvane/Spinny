import javafx.geometry.Point3D;
import javafx.scene.shape.Line;

public class Tetrahedron {
    private double x;
    private double y;
    private double z;
    private double speedx;
    private double speedy;
    private double speedz;
    private Point3D[] vertices;
    private int[][] edges;
    private Line[] linez;

    //cube parameters
    private double cx;
    private double cy;
    private double cz;
    private double size;

    private double dx;
    private double dy;
    private double dz;

    public Tetrahedron(int size) {
        speedx = .01;
        speedy = .01;
        speedz = .01;
        cx = 200;
        cy = 200;
        cz = 0;
        this.size = size;
        vertices = new Point3D[]{
                new Point3D(cx+size, cy+size, cz + size),
                new Point3D(cx + size, cy - size, cz-size),
                new Point3D(cx - size, cy + size, cz - size),
                new Point3D(cx - size, cy - size, cz + size)};



        edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2},
                {1, 3}, {2, 3}};


        linez = new Line[edges.length];
        for (int i = 0; i < linez.length; i++) {
            linez[i] = new Line();
        }

    }

    public void run(double dt) {
        changePyramid('x', dt);
        changePyramid('y', dt);
        changePyramid('z', dt);
        drawLines();
    }

    //set location
    public void setLocation(int cx, int cy) {
        this.cx = cx;
        this.cy = cy;
    }
    public void setSpeed(double spd){
        speedx = spd;
        speedy = spd;
        speedz = spd;
    }

    private void drawLines() {
        for (int i = 0; i < edges.length; i++) {
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

    private void changePyramid(char axis, double dt) {
        //z axis
        switch (axis) {
            case 'z':
                double angle1 = dt * speedz;
                for (int i = 0; i < vertices.length; i++) {
                    dx = vertices[i].getX() - cx;
                    dy = vertices[i].getY() - cy;
                    x = dx * cos(angle1) - dy * sin(angle1);
                    y = dx * sin(angle1) + dy * cos(angle1);
                    vertices[i] = new Point3D(x + cx, y + cy, vertices[i].getZ());
                    dx = x;
                    dy = y;
                }
            case 'y':
                //y axis
                double angle2 = dt * speedy;
                for (int i = 0; i < vertices.length; i++) {
                    dx = vertices[i].getX() - cx;
                    dz = vertices[i].getZ() - cz;
                    x = dx * cos(angle2) - dz * sin(angle2);
                    z = dx * sin(angle2) + dz * cos(angle2);
                    vertices[i] = new Point3D(x + cx, vertices[i].getY(), z + cz);
                    dx = x;
                    dz = z;
                }
            case 'x':
                //x axis
                double angle3 = dt * speedx;
                for (int i = 0; i < vertices.length; i++) {
                    dz = vertices[i].getZ() - cz;
                    dy = vertices[i].getY() - cy;
                    z = dz * cos(angle3) - dy * sin(angle3);
                    y = dz * sin(angle3) + dy * cos(angle3);
                    vertices[i] = new Point3D(vertices[i].getX(), y + cy, z + cz);
                    dz = z;
                    dy = y;
                }
        }
    }

    public Line[] getLinez() {
        return linez;
    }

    private double sin(double x) {
        return Math.sin(x);
    }

    private double cos(double x) {
        return Math.cos(x);
    }
}