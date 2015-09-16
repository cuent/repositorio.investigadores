/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.experiment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

/**
 *
 * @author cuent
 */
public class Data {

    private Instances instances;

    public Data() {
        ArrayList<Attribute> attributes = new ArrayList();
        Attribute attribute = new Attribute("keywords");

        attributes.add(attribute);
        instances = new Instances("test", attributes, 9);

        DenseInstance di = new DenseInstance(instances.numAttributes());
        di.setValue(attribute, 5);

        instances.add(di);
    }

    public Instances getInstances() {
        return instances;
    }

    public void setInstances(Instances instances) {
        this.instances = instances;
    }

    @Override
    public String toString() {
        return "instances=" + instances;
    }

    public void testLoad(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(filePath));
            Instances data = new Instances(reader);
            reader.close();
            
            setInstances(data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
