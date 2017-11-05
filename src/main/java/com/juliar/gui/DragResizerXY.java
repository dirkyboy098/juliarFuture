package com.juliar.gui;

import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

/**
 * {@link DragResizerXY} can be used to add mouse listeners to a {@link Region}
 * and make it resizable by the user by clicking and dragging the border in the
 * same way as a window.
 * <p>
 * Height and Width resizing is working (hopefully) properly
 *
 * <pre>
 * DragResizer.makeResizable(myAnchorPane);
 * </pre>
 *
 * @author Cannibalsticky (modified from the original DragResizer created by AndyTill) modified by Juliar Team
 *
 */
public class DragResizerXY {

    /**
     * The margin around the control that a user can click in to start resizing
     * the region.
     */
    private static final int RESIZE_MARGIN = 10;

    private final Region region;

    private double y;

    private double x;

    private boolean initMinHeight;

    private boolean initMinWidth;

    private boolean draggableZoneX;
    private boolean draggableZoneY;

    private boolean dragging;

    private DragResizerXY(Region aRegion) {
        region = aRegion;
    }

    public static void makeResizable(Region region) {
        final DragResizerXY resizer = new DragResizerXY(region);

        region.setOnMousePressed(resizer::mousePressed);
        region.setOnMouseDragged(resizer::mouseDragged);
        region.setOnMouseMoved(resizer::mouseOver);
        region.setOnMouseReleased(event -> resizer.mouseReleased());
    }

    private void mouseReleased() {
        dragging = false;
        region.setCursor(Cursor.DEFAULT);
    }

    private void mouseOver(MouseEvent event) {
        if (isInDraggableZone(event) || dragging) {
            if (draggableZoneY) {
                region.setCursor(Cursor.S_RESIZE);
            }

            if (draggableZoneX) {
                region.setCursor(Cursor.E_RESIZE);
            }

        } else {
            region.setCursor(Cursor.DEFAULT);
        }
    }


    //had to use 2 variables for the controll, tried without, had unexpected behaviour (going big was ok, going small nope.)
    private boolean isInDraggableZone(MouseEvent event) {
        draggableZoneY = (boolean)(event.getY() > (region.getHeight() - RESIZE_MARGIN));
        draggableZoneX = (boolean)(event.getX() > (region.getWidth() - RESIZE_MARGIN));
        return (draggableZoneY || draggableZoneX);
    }

    private void mouseDragged(MouseEvent event) {
        if (!dragging) {
            return;
        }

        if (draggableZoneY) {
            double mousey = event.getY();

            double newHeight = region.getMinHeight() + (mousey - y);

            region.setMinHeight(newHeight);

            y = mousey;
        }

        if (draggableZoneX) {
            double mousex = event.getX();

            double newWidth = region.getMinWidth() + (mousex - x);

            region.setMinWidth(newWidth);

            x = mousex;

        }

    }

    private void mousePressed(MouseEvent event) {

        // ignore clicks outside of the draggable margin
        if (!isInDraggableZone(event)) {
            return;
        }

        dragging = true;

        // make sure that the minimum height is set to the current height once,
        // setting a min height that is smaller than the current height will
        // have no effect
        if (!initMinHeight) {
            region.setMinHeight(region.getHeight());
            initMinHeight = true;
        }

        y = event.getY();

        if (!initMinWidth) {
            region.setMinWidth(region.getWidth());
            initMinWidth = true;
        }

        x = event.getX();
    }
}