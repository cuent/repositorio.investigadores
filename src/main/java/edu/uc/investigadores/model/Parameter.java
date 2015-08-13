/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.model;

/**
 *
 * @author vsaquicela
 */
public class Parameter {

    public Parameter() {
    }

    public Parameter(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    private int idParameter;

    /**
     * Get the value of idParameter
     *
     * @return the value of idParameter
     */
    public int getIdParameter() {
        return idParameter;
    }

    /**
     * Set the value of idParameter
     *
     * @param idParameter new value of idParameter
     */
    public void setIdParameter(int idParameter) {
        this.idParameter = idParameter;
    }
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    private String value;

    /**
     * Get the value of value
     *
     * @return the value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * Set the value of value
     *
     * @param value new value of value
     */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Parameter{" + "idParameter=" + idParameter + ", name=" + name + ", value=" + value + "}\n";
    }

}
