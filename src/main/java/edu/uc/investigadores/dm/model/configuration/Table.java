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
public class Table {

    private final List<Row> rows;

    public Table() {
        rows = new ArrayList<>();
    }

    /**
     * Get the value of rows
     *
     * @return the value of rows
     */
    public List<Row> getRows() {
        return rows;
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    @Override
    public String toString() {
        StringBuilder stringRows = new StringBuilder();
        for (Row row : rows) {
            stringRows.append(row);
        }
        return "Table{" + "rows=" + stringRows + '}';
    }
}
