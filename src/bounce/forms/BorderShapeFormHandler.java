package bounce.forms;

import bounce.*;
import bounce.forms.ColourFormElement;
import bounce.forms.ShapeFormElement;
import bounce.RectangleShape;
import bounce.Shape;
import bounce.BorderShape;
import bounce.forms.util.Form;
import bounce.forms.util.FormHandler;


import java.awt.*;


public class BorderShapeFormHandler implements FormHandler {
    private ShapeModel model;
    private NestingShape parentOfNewShape;

    public BorderShapeFormHandler(ShapeModel model,
                                  NestingShape parent) {
        this.model = model;
        parentOfNewShape = parent;
    }

    @Override
    public void processForm(Form form) {
        int x = 0;
        int y = 0;
        int deltaX = form.getFieldValue(Integer.class, ShapeFormElement.DELTA_X);
        int deltaY = form.getFieldValue(Integer.class, ShapeFormElement.DELTA_Y);
        int width = form.getFieldValue(Integer.class, ShapeFormElement.WIDTH);
        int height = form.getFieldValue(Integer.class, ShapeFormElement.HEIGHT);

        Shape shape = new RectangleShape(x, y,
                deltaX, deltaY, width, height);

        BorderShape newShape = new BorderShape(shape, null  );
        model.add(newShape, parentOfNewShape);
    }


}
