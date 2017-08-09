package com.juliar.gui;

import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 * Created by AndreiM on 5/20/2017.
 */
class Shapes {
    private Shapes(){

    }
    static Polygon btnSquare() {
        Polygon square = new Polygon();
        square.getPoints().addAll(0.0, 0.0,
                0.0, 21.0,
                21.0, 21.0,
                21.0, 0.0);
        square.setFill(javafx.scene.paint.Color.WHITE);
        return square;
    }
    static Polygon btnTriangle() {
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(0.0, 0.0,
                0.0, 21.0,
                15.0, 10.5);
        triangle.setFill(Color.WHITE);
        return triangle;
    }
    static Circle tabCircle(){
        Circle c = new Circle(0, 0, 3);
        c.setFill(Color.rgb(131,207,23));
        c.getStyleClass().add("graphic");
        return c;
    }
}
