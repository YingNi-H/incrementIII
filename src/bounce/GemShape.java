package bounce;

import java.awt.*;

public class GemShape extends Shape{
    private Color color;


    public GemShape(int x, int y, int deltaX, int deltaY, int width, int height, String text, Color color){
        super(x, y, deltaX, deltaY, width, height, text);
        this.color = color;

    }

    @Override
    public void doPaint(Painter painter) {
        if(width >= 40 ) {
            Color initial = painter.getColor();
            painter.setColor(color);
            int[] xPoints = new int[]{x, x + 20, x + width - 20, x + width, x + width - 20, x + 20};
            int[] yPoints = new int[]{y + height / 2, y, y, y + height / 2, y + height, y + height};
            int nPoints = 6;
            painter.fillPolygon(xPoints, yPoints, nPoints);
            painter.setColor(initial);



        }else {
            Color initial = painter.getColor();
            painter.setColor(color);
            painter.fillRect(x,y,width,height);
            painter.setColor(initial);


        }

    }


}
