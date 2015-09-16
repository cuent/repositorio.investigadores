/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.platform;

import java.util.logging.Level;
import java.util.logging.Logger;
import weka.clusterers.ClusterEvaluation;
import weka.core.Capabilities;

/**
 *
 * @author cuent
 */
public class SimpleKMeans extends Weka {

    private final weka.clusterers.SimpleKMeans kmeans;

    public SimpleKMeans() {
        kmeans = new weka.clusterers.SimpleKMeans();
    }

    @Override
    public void build() {
        try {
            System.out.println("BUILDING KMEANS...");
            kmeans.setOptions(super.getConfiguration().getOptions());
            kmeans.buildClusterer(this.getData().getInstances());

            Statistics statistics = new Statistics();
            statistics.addProperty(new Property("SquaredError", kmeans.getSquaredError()));
            this.setStatistics(statistics);
        } catch (Exception ex) {
            Logger.getLogger(SimpleKMeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Override
//    public String toString() {
//        return "SimpleKMeans{" + "kmeans=" + kmeans + '}';
//    }
}
