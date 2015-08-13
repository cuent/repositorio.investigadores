/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vsaquicela
 */
public class Experiment {

    public Experiment(String name) {
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
    private int idExperiment;

    /**
     * Get the value of idExperiment
     *
     * @return the value of idExperiment
     */
    public int getIdExperiment() {
        return idExperiment;
    }

    /**
     * Set the value of idExperiment
     *
     * @param idExperiment new value of idExperiment
     */
    public void setIdExperiment(int idExperiment) {
        this.idExperiment = idExperiment;
    }
    private List<Algorithm> algorithms = new ArrayList();

    /**
     * Get the value of algorithms
     *
     * @return the value of algorithms
     */
    public List<Algorithm> getAlgorithms() {
        return algorithms;
    }

    /**
     * Set the value of algorithms
     *
     * @param algorithms new value of algorithms
     */
    public void setAlgorithms(List<Algorithm> algorithms) {
        this.algorithms = algorithms;
    }
    private ExperimentType experimentType;

    /**
     * Get the value of esperimentType
     *
     * @return the value of esperimentType
     */
    public ExperimentType getExperimentType() {
        return experimentType;
    }

    /**
     * Set the value of esperimentType
     *
     * @param esperimentType new value of esperimentType
     */
    public void setExperimentType(ExperimentType experimentType) {
        this.experimentType = experimentType;
    }
    private String queryTrain;

    /**
     * Get the value of query
     *
     * @return the value of query
     */
    public String getQueryTrain() {
        return queryTrain;
    }

    /**
     * Set the value of query
     *
     * @param query new value of query
     */
    public void setQueryTrain(String queryTrain) {
        this.queryTrain = queryTrain;
    }
    private String variablePredecir;

    /**
     * Get the value of variablePredecir
     *
     * @return the value of variablePredecir
     */
    public String getVariablePredecir() {
        return variablePredecir;
    }

    /**
     * Set the value of variablePredecir
     *
     * @param variablePredecir new value of variablePredecir
     */
    public void setVariablePredecir(String variablePredecir) {
        this.variablePredecir = variablePredecir;
    }
    private String queryTest;

    /**
     * Get the value of queryTest
     *
     * @return the value of queryTest
     */
    public String getQueryTest() {
        return queryTest;
    }

    /**
     * Set the value of queryTest
     *
     * @param queryTest new value of queryTest
     */
    public void setQueryTest(String queryTest) {
        this.queryTest = queryTest;
    }
    private int numColumnsOneVariable = 0;

    /**
     * Get the value of numColumnsOneVariable
     *
     * @return the value of numColumnsOneVariable
     */
    public int getNumColumnsOneVariable() {
        return numColumnsOneVariable;
    }

    /**
     * Set the value of numColumnsOneVariable
     *
     * @param numColumnsOneVariable new value of numColumnsOneVariable
     */
    public void setNumColumnsOneVariable(int numColumnsOneVariable) {
        this.numColumnsOneVariable = numColumnsOneVariable;
    }
    private int numeroPredicciones;

    /**
     * Get the value of numeroPredicciones
     *
     * @return the value of numeroPredicciones
     */
    public int getNumeroPredicciones() {
        return numeroPredicciones;
    }

    /**
     * Set the value of numeroPredicciones
     *
     * @param numeroPredicciones new value of numeroPredicciones
     */
    public void setNumeroPredicciones(int numeroPredicciones) {
        this.numeroPredicciones = numeroPredicciones;
    }
    private String user;

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public String getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(String user) {
        this.user = user;
    }
    private String password;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public void addAlgorithm(Algorithm a) {
        algorithms.add(a);
        a.setExperiment(this);
    }

    public void executeExperiment() {
        //extract data from database
        this.experimentType.dataExtract();
        for (Algorithm a : algorithms) {
            a.executeAll();
        }
    }

    @Override
    public String toString() {
        String aux = "";
        for (Algorithm a : algorithms) {
            aux = aux + a.toString();
        }
        return "Experiment{" + "name=" + name + ", idExperiment=" + idExperiment + ", esperimentType=" + experimentType + ", queryTrain=" + queryTrain + ", variablePredecir=" + variablePredecir + ", queryTest=" + queryTest + ", numColumnsOneVariable=" + numColumnsOneVariable + ", numeroPredicciones=" + numeroPredicciones + ", user=" + user + ", password=" + password + ", \n algorithms=" + aux + '}';
    }

    public Map tableResult() {
        //this method retrieve a  result list of all experiment.
        Map results = new HashMap();
        for (Algorithm a : algorithms) {
            for (Configuration c : a.getConfigurations()) {
                List algConfResult = new ArrayList();
                for (Result r : c.getResults()) {
                    algConfResult.add(r);
                }
                results.put(a.getName()+"_"+c.getName(), algConfResult);
            }
        }
        return results;
    }
    
    
        private List<FilterVhsg> filters= new ArrayList<FilterVhsg>();

    /**
     * Get the value of filters
     *
     * @return the value of filters
     */
    public List<FilterVhsg> getFilters() {
        return filters;
    }

    /**
     * Set the value of filters
     *
     * @param filters new value of filters
     */
    public void setFilters(List<FilterVhsg> filters) {
        this.filters = filters;
    }
    public void addFilter(FilterVhsg f){
        filters.add(f);
    }
        private String queryPrediction;

    /**
     * Get the value of queryPrediction
     *
     * @return the value of queryPrediction
     */
    public String getQueryPrediction() {
        return queryPrediction;
    }

    /**
     * Set the value of queryPrediction
     *
     * @param queryPrediction new value of queryPrediction
     */
    public void setQueryPrediction(String queryPrediction) {
        this.queryPrediction = queryPrediction;
    }

}
