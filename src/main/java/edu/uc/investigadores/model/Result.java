/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.model;

/**
 *
 * @author vsaquicela
 */
public class Result {

    private int id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }
    private double observado;

    /**
     * Get the value of observado
     *
     * @return the value of observado
     */
    public double getObservado() {
        return observado;
    }

    /**
     * Set the value of observado
     *
     * @param observado new value of observado
     */
    public void setObservado(double observado) {
        this.observado = observado;
    }
    private double predecido;

    /**
     * Get the value of predecido
     *
     * @return the value of predecido
     */
    public double getPredecido() {
        return predecido;
    }

    /**
     * Set the value of predecido
     *
     * @param predecido new value of predecido
     */
    public void setPredecido(double predecido) {
        this.predecido = predecido;
    }

    public Result(int id, double observado, double predecido, boolean virtual) {
        this.id = id;
        this.observado = observado;
        this.predecido = predecido;
        this.virtual = virtual;
    }
    private boolean virtual = false;

    /**
     * Get the value of virtual
     *
     * @return the value of virtual
     */
    public boolean isVirtual() {
        return virtual;
    }

    /**
     * Set the value of virtual
     *
     * @param virtual new value of virtual
     */
    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    @Override
    public String toString() {
        return  id + "," + observado + "," + predecido +"\n";

        //return "Result{" + "id=" + id + ", observado=" + observado + ", predecido=" + predecido + ", virtual=" + virtual + "}\n";
    }
}
