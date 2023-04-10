import java.awt.*;

public class PictureProxy extends Graphic {
    private String fileName;
    private Dimension extent;
    private Point position;
    private Picture picture;

    public void draw(Point position){

    }

    @Override
    public Dimension getExtent() {
        return extent;
    }

    @Override
    public Point getPosition() {
        return position;
    }
    public void handleMouse (Event mouseEvent){

    }
    public void store(){

    }
    public void load(){

    }
    protected Picture getPicture(){
        picture = new Picture();
        return picture;
    }
}
