/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.platform;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuent
 */
public class Statistics {

    private List<Property> properties;

    public Statistics() {
        properties = new ArrayList<>();
    }

    /**
     * Get the value of properties
     *
     * @return the value of properties
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * Set the value of properties
     *
     * @param properties new value of properties
     */
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }
}
