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
public class Configuration {

    public Configuration() {
    }

    public Configuration(String name) {
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
    private int idConfiguration;

    /**
     * Get the value of idConfiguration
     *
     * @return the value of idConfiguration
     */
    public int getIdConfiguration() {
        return idConfiguration;
    }

    /**
     * Set the value of idConfiguration
     *
     * @param idConfiguration new value of idConfiguration
     */
    public void setIdConfiguration(int idConfiguration) {
        this.idConfiguration = idConfiguration;
    }
    private List<Parameter> parameters= new ArrayList<Parameter>();

    /**
     * Get the value of parameters
     *
     * @return the value of parameters
     */
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * Set the value of parameters
     *
     * @param parameters new value of parameters
     */
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
    private List<Result> results= new ArrayList<Result>();

    /**
     * Get the value of results
     *
     * @return the value of results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * Set the value of results
     *
     * @param results new value of results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }
    private Algorithm algorithm;

    /**
     * Get the value of algorithm
     *
     * @return the value of algorithm
     */
    public Algorithm getAlgorithm() {
        return algorithm;
    }

    /**
     * Set the value of algorithm
     *
     * @param algorithm new value of algorithm
     */
    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
    public void addParameter (Parameter p){
        parameters.add(p);
        
    }

    @Override
    public String toString() {
        String aux="";
        for (Parameter p:parameters){
            aux=aux+p.toString();
        }
        String result="";
        for (Result r: results){
            result=result+r.toString();
        }
        return "Configuration{" + "name=" + name + ", idConfiguration=" + idConfiguration + ", \n parameters=" + aux + ", \n results=" + result + '}';
    }
    
}
