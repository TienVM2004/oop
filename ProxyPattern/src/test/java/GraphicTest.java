import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GraphicTest {
    Dimension extent = new Dimension(4,4);
    Point point = new Point(2,2);
    PictureProxy pictureProxy = new PictureProxy("lmao", extent, point);
    @Test
    public void Test1() {
        assertEquals(pictureProxy.getExtent(), new Dimension(4,4));
        assertEquals(pictureProxy.getPosition(), new Point(2,2));
        assertTrue(pictureProxy.getPicture().equals(new Picture("lmao",new Dimension(4,4),new Point(2,2))));
    }

}