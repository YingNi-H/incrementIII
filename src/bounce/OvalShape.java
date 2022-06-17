package bounce;


import java.awt.*;

public class OvalShape extends Shape {
    protected Color colour;

    protected boolean isfilled;

    public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color colour){
        super(x, y, deltaX, deltaY, width, height, text);
        this.colour = colour;

    }



    @Override
    public void doPaint(Painter painter) {

        Color origin = painter.getColor();
        painter.setColor(colour);

        if(isfilled) {
            painter.fillOval(x, y, width, height);

        }else{
            painter.drawOval(x, y, width, height);
        }

        painter.setColor(origin);

    }



    public void move(int width, int height) {

        int originalSpeedX = deltaX;
        int originalSpeedY = deltaY;
        super.move(width, height);

        if(originalSpeedX != deltaX ){
            isfilled = true;
        } else if(originalSpeedY != deltaY ){
            isfilled = false;
        }

    }


}
