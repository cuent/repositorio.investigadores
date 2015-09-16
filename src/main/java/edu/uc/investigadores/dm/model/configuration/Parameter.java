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
public class Parameter {

    private String clave;
    private String valor;

    public Parameter(String clave, String valor) {
        this.clave = clave;
        this.valor = valor;
    }

    /**
     * Get the value of valor
     *
     * @return the value of valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * Set the value of valor
     *
     * @param valor new value of valor
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * Get the value of clave
     *
     * @return the value of clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Set the value of clave
     *
     * @param clave new value of clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Parameter{" + "clave=" + clave + ", valor=" + valor + '}';
    }
}
