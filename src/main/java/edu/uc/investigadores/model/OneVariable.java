/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.model;

import edu.uc.investigadores.sources.Connector;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author vsaquicela
 */
public class OneVariable extends ExperimentType {
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

  
    
    public Instances createDataSet(int num, Instances data, String variablePrediction) {
        //This method creates the dataset using only the predict variable
        Attribute attPrediction = data.attribute(variablePrediction);
        List<Attribute> atts = new ArrayList();
        // Set up attributes
        for (int i = 1; i <= num; i++) { //creation of num attributes
            atts.add(new Attribute("att" + i));
        }
        atts.add(new Attribute("prediction"));
        Instances result = new Instances("OneVariable", (ArrayList<Attribute>) atts, 0);
        int pos = 0;
        while (data.numInstances() - pos >= num + 1) {
            Instance i1 = new DenseInstance(num + 1);
            int count = 0;
            for (int i = pos; i < pos + num + 1; i++) {
                Instance ins = data.get(i);
                i1.setValue(atts.get(count), ins.value(attPrediction));
                count++;
            }
            result.add(i1);
            pos++;
        }
        return result;
    }

    @Override
    void dataExtract() {
        try {
            Connector c = new Connector();
            Instances trainTemp = c.query(this.getExperiment().getQueryTrain(), this.getExperiment().getUser(), this.getExperiment().getPassword());
            Instances testTemp = c.query(this.getExperiment().getQueryTest(), this.getExperiment().getUser(), this.getExperiment().getPassword());
            train = this.createDataSet(this.getExperiment().getNumColumnsOneVariable(), trainTemp, this.getExperiment().getVariablePredecir());
            test = this.createDataSet(this.getExperiment().getNumColumnsOneVariable(), testTemp, this.getExperiment().getVariablePredecir());
            for (FilterVhsg f : this.getExperiment().getFilters()) {
                this.setTrain(f.execute(this.getTrain()));
                this.setTest(f.execute(this.getTest()));
            }
        } catch (Exception ex) {
            Logger.getLogger(OneVariable.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
