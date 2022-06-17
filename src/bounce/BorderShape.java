package bounce;


public class BorderShape extends Shape {

    private Shape shape;


    public BorderShape( Shape shape,  String text) {
        this.x = shape.x - 15;
        this.y = shape.y - 15;
        this.width = shape.width + 30;
        this.height = shape.height + 30;
        this.deltaX = shape.deltaX;
        this.deltaY = shape.deltaY;
        this.shape = shape;
        this.text = text;

    }


    @Override
    public void doPaint(Painter painter) {
        painter.drawRect(x, y, width, height);
        shape.paint(painter);

    }

    @Override
    public void move(int width, int height) {

        x = shape.x - 15;
        y = shape.y - 15;
        this.width = shape.width + 30;
        this.height = shape.height + 30;
        deltaX = shape.deltaX;
        deltaY = shape.deltaY;

        super.move(width, height);
        shape.move(width, height);
        if(x <= 0 && shape.x <= 15){
            x = 0;
            shape.x = 15;
            deltaX = -deltaX;
            shape.deltaX = -shape.deltaX;

        }else if (x + this.width >= width && shape.x + this.width - 30 >= width - 30){
            x = width - this.width;
            shape.x = width - 15 - (this.width - 30);
            deltaX = -deltaX;
            shape.deltaX = -shape.deltaX;

        }if(y <= 0 && shape.y <= 15){
            y = 0;
            shape.y = 15;
            deltaY = -deltaY;
            shape.deltaY = -shape.deltaY;

        }else if (y + this.height >= height && shape.y + this.height - 30 >= height - 15){
            y = height - this.height;
            shape.y = height - 15 - (this.height - 30);
            deltaY = -deltaY;
            shape.deltaY = -shape.deltaY;
        }

    }


}
