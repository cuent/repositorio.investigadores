/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vsaquicela
 */
public abstract class Algorithm {

    public Algorithm(String name) {
        this.name = name;
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
    private int idAlgorithm;

    /**
     * Get the value of idAlgorithm
     *
     * @return the value of idAlgorithm
     */
    public int getIdAlgorithm() {
        return idAlgorithm;
    }

    /**
     * Set the value of idAlgorithm
     *
     * @param idAlgorithm new value of idAlgorithm
     */
    public void setIdAlgorithm(int idAlgorithm) {
        this.idAlgorithm = idAlgorithm;
    }
    private List<Configuration> configurations = new ArrayList<Configuration>();

    /**
     * Get the value of configurations
     *
     * @return the value of configurations
     */
    public List<Configuration> getConfigurations() {
        return configurations;
    }

    /**
     * Set the value of configurations
     *
     * @param configurations new value of configurations
     */
    public void setConfigurations(List<Configuration> configurations) {
        this.configurations = configurations;
    }
    private Experiment experiment;

    /**
     * Get the value of experiment
     *
     * @return the value of experiment
     */
    public Experiment getExperiment() {
        return experiment;
    }

    /**
     * Set the value of experiment
     *
     * @param experiment new value of experiment
     */
    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public void executeAll() {
        //Execute the algorithm for each Configuration
        for (Configuration c : this.configurations) {
            String options = "";
            for (Parameter p : c.getParameters()) {
                options = options + p.getName() + " " + p.getValue() + " ";
            }            
            c.setResults(this.execute(options));
        }
    }
    public void addConfiguration(Configuration c){
        configurations.add(c);
        c.setAlgorithm(this);
    }

    @Override
    public String toString() {
        String aux="";
        for (Configuration c: configurations){
            aux=aux+c.toString();
        }
        return "Algorithm{" + "name=" + name + ", idAlgorithm=" + idAlgorithm + ", \n configurations=" + aux+ '}';
    }
    
     abstract  List<Result> execute(String options);
}
