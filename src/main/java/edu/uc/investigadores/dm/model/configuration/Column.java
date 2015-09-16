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
public class Column {

    private Object field;

    public Column(Object field) {
        this.field = field;
    }

    /**
     * Get the value of field
     *
     * @return the value of field
     */
    public Object getField() {
        return field;
    }

    /**
     * Set the value of field
     *
     * @param field new value of field
     */
    public void setField(Object field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Column{" + "field=" + field + '}';
    }

}
