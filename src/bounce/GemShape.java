package bounce;

import java.awt.*;

public class GemShape extends Shape{
    private Color color;

    protected boolean isfilled;


    public GemShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color color){
        super(x, y, deltaX, deltaY, width, height, text);
        this.color = color;

    }

    @Override
    public void doPaint(Painter painter) {
        Color initial = painter.getColor();
        painter.setColor(color);
        if(width >= 40 ) {
            int[] xPoints = new int[]{x, x + 20, x + width - 20, x + width, x + width - 20, x + 20};
            int[] yPoints = new int[]{y + height / 2, y, y, y + height / 2, y + height, y + height};
            int nPoints = 6;
            if(isfilled) {
                painter.fillPolygon(xPoints, yPoints, nPoints);

            }else{
                painter.drawPolygon(xPoints, yPoints, nPoints);
            }

        }else {
            if(isfilled) {
                painter.fillRect(x,y,width,height);

            }else{
                painter.drawRect(x, y, width, height);
            }
        }
        painter.setColor(initial);

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
