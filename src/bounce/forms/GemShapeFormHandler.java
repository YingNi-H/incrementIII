package bounce.forms;

import bounce.GemShape;
import bounce.NestingShape;
import bounce.OvalShape;
import bounce.ShapeModel;
import bounce.forms.ColourFormElement;
import bounce.forms.ShapeFormElement;
import bounce.forms.util.Form;
import bounce.forms.util.FormHandler;

import java.awt.*;

public class GemShapeFormHandler implements FormHandler {
    private ShapeModel model;
    private NestingShape parentOfNewShape;

    public GemShapeFormHandler(ShapeModel model,
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
        String text = form.getFieldValue(String.class, ShapeFormElement.TEXT);
        Color colour = (Color) form
                .getFieldValue(Color.class, ColourFormElement.COLOUR);

        GemShape newShape = new GemShape(x, y,
                deltaX, deltaY, width, height, text, colour);
        model.add(newShape, parentOfNewShape);
    }


}
