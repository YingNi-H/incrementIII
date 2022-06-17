package bounce;


public class BorderShape extends Shape {

    private Shape shape;


    public BorderShape( Shape shape,  String text) {
        this.x = shape.x - 2;
        this.y = shape.y - 2;
        this.width = shape.width + 4;
        this.height = shape.height + 4;
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

        x = shape.x - 2;
        y = shape.y - 2;
        this.width = shape.width + 4;
        this.height = shape.height + 4;
        deltaX = shape.deltaX;
        deltaY = shape.deltaY;

        super.move(width, height);
        shape.move(width, height);
        if(x <= 0 && shape.x <= 2){
            x = 0;
            shape.x = 2;
            deltaX = -deltaX;
            shape.deltaX = -shape.deltaX;

        }else if (x + this.width >= width && shape.x + this.width - 4 >= width - 2){
            x = width - this.width;
            shape.x = width - 2 - (this.width - 4);
            deltaX = -deltaX;
            shape.deltaX = -shape.deltaX;

        }if(y <= 0 && shape.y <= 2){
            y = 0;
            shape.y = 2;
            deltaY = -deltaY;
            shape.deltaY = -shape.deltaY;

        }else if (y + this.height >= height && shape.y + this.height - 4 >= height - 2){
            y = height - this.height;
            shape.y = height - 2 - (this.height - 4);
            deltaY = -deltaY;
            shape.deltaY = -shape.deltaY;
        }

    }


}
