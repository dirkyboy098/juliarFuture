package com.juliar.gui;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;


/**
 * Created by AndreiM on 6/7/2017.
 */
public class JuliarPackageCheckbox<S,T> implements Callback<TableColumn<S, T>, TableCell<S, T>> {
    @Override public TableCell<S, T> call(TableColumn<S, T> p) {
        return new CheckBoxTableCell<>();
    }
}
