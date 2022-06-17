package bounce.forms;

import bounce.ImageRectangleShape;
import bounce.NestingShape;
import bounce.ShapeModel;
import bounce.bounceApp.Bounce;
import bounce.forms.util.Form;
import bounce.forms.util.FormHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/*
 * TODO Complete this class to more appropriately load and scale the image
 */
public class ImageShapeFormHandler implements FormHandler {
    private ShapeModel model;

    private NestingShape parentOfNewShape;

    private File imageFile;

    private int width;

    private int deltaX;

    private int deltaY;

    private Image scaledImage;

    private Form form;


    public ImageShapeFormHandler(ShapeModel model, NestingShape parent) {
        this.model = model;
        parentOfNewShape = parent;
        this.imageFile = imageFile;
        this.width = width;


    }



    private SwingWorker<Image, Void> worker = new SwingWorker<Image, Void>() {
        @Override
        protected Image doInBackground() throws Exception {


            // Load the original image (ImageIO.read() is a blocking call).
            BufferedImage fullImage = null;
            try {
                fullImage = ImageIO.read(imageFile);
            } catch (IOException e) {
                System.out.println("Error loading image.");
            }

            int fullImageWidth = fullImage.getWidth();
            int fullImageHeight = fullImage.getHeight();

            BufferedImage scaledImage = fullImage;

            // Scale the image if necessary.


            if (fullImageWidth > width) {
                double scaleFactor = (double) width / (double) fullImageWidth;
                int height = (int) ((double) fullImageHeight * scaleFactor);

                scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = scaledImage.createGraphics();

                // Method drawImage() scales an already loaded image. The
                // ImageObserver argument is null because we don't need to monitor
                // the scaling operation.
                g.drawImage(fullImage, 0, 0, width, height, null);


            }
            return scaledImage;
        }

        @Override
        protected void done() {
            try{
                scaledImage = get();


            }catch (InterruptedException ignore) {}
            catch (java.util.concurrent.ExecutionException e) {
                String why = null;
                Throwable cause = e.getCause();
                if (cause != null) {
                    why = cause.getMessage();
                } else {
                    why = e.getMessage();
                }
                System.err.println("Error retrieving file: " + why);
            }
            // Create the new Shape and add it to the model.

            ImageRectangleShape imageShape = new ImageRectangleShape(deltaX, deltaY, scaledImage);
            model.add(imageShape, parentOfNewShape);
        }

    };
    @Override
    public void processForm(Form form) {


        long startTime = System.currentTimeMillis();
        // Read field values from the form.
        imageFile = (File) form.getFieldValue(File.class, ImageFormElement.IMAGE);
        width = form.getFieldValue(Integer.class, ShapeFormElement.WIDTH);
        deltaX = form.getFieldValue(Integer.class, ShapeFormElement.DELTA_X);
        deltaY = form.getFieldValue(Integer.class, ShapeFormElement.DELTA_Y);

        worker.execute();



        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Image loading ans scaling took " + elapsedTime + "ms.");
    }




}
