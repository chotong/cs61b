import java.io.BufferedReader;
import java.io.IOException;

public class NBody {
    public static double readRadius(String file) {
        In in = new In(file);
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();
        return secondItemInFile;
    }

    public static Body[] readBodies(String file) {
        In in = new In(file);
        int n = in.readInt();
        double radius = in.readDouble();
        Body[] bodies = new Body[n];
        int i = 0;
        for (i = 0; i < n; i++) {
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mass = in.readDouble();
            String name = in.readString();
            bodies[i] = new Body(xPos, yPos, xVel, yVel, mass, name);
        }
        return bodies;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] bodies = readBodies(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-readRadius(args[2]), readRadius(args[2]));
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Body i : bodies) {
            i.draw();
        }
        StdDraw.show();
    }
    

}