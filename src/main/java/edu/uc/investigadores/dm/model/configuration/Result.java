/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.configuration;

/**
 *
 * @author cuent
 */
public class Result {

    private Table table;

    /**
     * Get the value of table
     *
     * @return the value of table
     */
    public Table getTable() {
        return table;
    }

    /**
     * Set the value of table
     *
     * @param table new value of table
     */
    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "Result{" + "table=" + table + '}';
    }

}
