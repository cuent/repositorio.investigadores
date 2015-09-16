/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.configuration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuent
 */
public class Row {

    private final List<Column> columns;

    public Row() {
        columns = new ArrayList<>();
    }

    /**
     * Get the value of columns
     *
     * @return the value of columns
     */
    public List<Column> getColumns() {
        return columns;
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    @Override
    public String toString() {
        StringBuilder stringColunms = new StringBuilder();
        for (Column column : columns) {
            stringColunms.append(column);
        }
        return "Row{" + "columns=" + stringColunms + '}';
    }

}
