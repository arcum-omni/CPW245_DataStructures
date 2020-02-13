import java.awt.*;

public class ColorRectangle extends Rectangle{

    private Color color;
    
    public ColorRectangle( int x, int y, int width, int height, Color color ) {
        super( x, y, width, height );
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
}