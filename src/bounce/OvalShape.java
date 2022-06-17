package bounce;


import java.awt.*;

public class OvalShape extends Shape {
    protected Color colour;

    public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color colour){
        super(x, y, deltaX, deltaY, width, height, text);
        this.colour = colour;

    }

    @Override
    public void doPaint(Painter painter) {
        Color defaultColor = painter.getColor();
        painter.setColor(colour);
        painter.fillOval(x, y, width, height);
        painter.setColor(defaultColor);

    }


}
