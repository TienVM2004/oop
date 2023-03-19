import java.util.*;


/*
 Shape data for ShapeClient:
 "0 0  0 1  1 1  1 0"
 "10 10  10 11  11 11  11 10"
 "0.5 0.5  0.5 -10  1.5 0"
 "0.5 0.5  0.75 0.75  0.75 0.2"
*/

public class Shape {
    private Vector<Point> points = new Vector<>();
    private Point Heart = new Point(0,0);
    private double radius=0;

    public Shape(String s){
        Point temp;

        double x, y;
        String[] Coors = s.split("\\s+");

        for(int i=0;i<Coors.length-1;i+=2){
            x = Double.parseDouble(Coors[i]);
            y = Double.parseDouble(Coors[i+1]);
            temp = new Point(x,y);
            addPoint(temp);
        }
        Point temp2;
        x = Double.parseDouble(Coors[0]);
        y = Double.parseDouble(Coors[1]);
        temp2 = new Point(x,y);
        addNoRecalculate(temp2);
    }



    public void addNoRecalculate(Point a){
        points.add(a);
    }
    public void addPoint(Point a){
        double midX = 0,midY = 0;
        //add the point to the vector
        points.add(a);
        //calculating the heart of the circle
        for (Point point : points) {
            midX += point.getX();
            midY += point.getY();
        }
        midX /= points.size();
        midY /= points.size();

        //assigning the new heart of circle
        Heart = new Point(midX, midY);

        //finding the radius
        double temp;
        double min = 1000;
        for (Point point : points) {

            temp = Heart.distance(point);

            if (temp < min) {
                radius = temp;
                min = temp;
            }
            //System.out.println(point.getX()+" "+point.getY()+" heart "+Heart.getX()+" "+Heart.getY()+" "+temp+" "+radius);
        }
    }

    public Vector<Point> getPoints(){
        return points;
    }

    public double getRadius() {
        return radius;
    }
    public Point getHeart(){
        return Heart;
    }

    public boolean cross(Shape a, Shape b){
        double distance1;
        double distance2;
        boolean doCross = false;
        Vector<Point> pointA = a.getPoints();
        Point heartB = b.getHeart();
        double radiusB = b.getRadius();
        for(int i=0;i<pointA.size()-1;i++){
            distance1 = heartB.distance(pointA.get(i));
            distance2 = heartB.distance(pointA.get(i+1));
            if(( (distance1 < radiusB) && (distance2 > radiusB) ) || ( (distance1 > radiusB) && (distance2 < radiusB) )){
                doCross = true;
                break;
            }
        }
        return doCross;
    }

    public int encircle(Shape a, Shape b) {
        Shape bigger = a;
        Shape smaller = b;
        if(a.getRadius() > b.getRadius()){
            bigger = a;
            smaller = b;
        }
        else{
            bigger = b;
            smaller = a;
        }
        double dis = a.getHeart().distance(b.getHeart());
        if(dis < bigger.getRadius()) return 2;
        else if (dis < bigger.getRadius() + smaller.getRadius()) return 1;
        else return 0;
    }

}

