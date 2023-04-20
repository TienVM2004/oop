import java.awt.*;

public class Picture extends Graphic {
    private String fileName;
    private Dimension extent;
    private Point position;
    private Picture picture;


    Picture(String name, Dimension ext, Point point) {
        fileName = name;
        extent = ext;
        position = point;
    }
    public void draw (Point position) {

    }
    public String getFileName(){
        return fileName;
    }
    public Dimension getExtent(){
        return extent;
    }
    public Point getPosition(){
        return position;
    }
    public void handleMouse (Event mouseEvent){

    }
    public void store(){

    }
    public void load(){

    }
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Picture)) {
            return false;
        }
        Picture other = (Picture) obj;
        if(other.getExtent().equals(this.extent) && other.getPosition().equals(this.position) && other.getFileName().equals(this.fileName)) return true;
        else return false;
    }

}
