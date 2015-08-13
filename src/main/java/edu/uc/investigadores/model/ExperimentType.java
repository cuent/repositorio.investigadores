/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.model;

import weka.core.Instances;

/**
 *
 * @author vsaquicela
 */
public abstract class ExperimentType {
    
    private String idExperimentType;

    /**
     * Get the value of idExperimentType
     *
     * @return the value of idExperimentType
     */
    public String getIdExperimentType() {
        return idExperimentType;
    }

    /**
     * Set the value of idExperimentType
     *
     * @param idExperimentType new value of idExperimentType
     */
    public void setIdExperimentType(String idExperimentType) {
        this.idExperimentType = idExperimentType;
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
 private Instances train;

    /**
     * Get the value of train
     *
     * @return the value of train
     */
    public Instances getTrain() {
        return train;
    }

    /**
     * Set the value of train
     *
     * @param train new value of train
     */
    public void setTrain(Instances train) {
        this.train = train;
    }
    private Instances test;

    /**
     * Get the value of test
     *
     * @return the value of test
     */
    public Instances getTest() {
        return test;
    }

    /**
     * Set the value of test
     *
     * @param test new value of test
     */
    public void setTest(Instances test) {
        this.test = test;
    }
    private Instances prediction;

    /**
     * Get the value of prediction
     *
     * @return the value of prediction
     */
    public Instances getPrediction() {
        return prediction;
    }

    /**
     * Set the value of prediction
     *
     * @param prediction new value of prediction
     */
    public void setPrediction(Instances prediction) {
        this.prediction = prediction;
    }

    @Override
    public String toString() {
        return "ExperimentType{" + "idExperimentType=" + idExperimentType + ", name=" + name + '}';
    }
    abstract void dataExtract();     
    
}
