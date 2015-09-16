/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.platform;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cuent
 */
public class EM extends Weka {

    private final weka.clusterers.EM em;

    public EM() {
        em = new weka.clusterers.EM();
    }

    @Override
    public void build() {
        try {
            System.out.println("BUILDING EM...");
            em.setOptions(super.getConfiguration().getOptions());
            em.buildClusterer(this.getData().getInstances());

            Statistics statistics = new Statistics();
            statistics.addProperty(new Property("MinLogLikelihoodImprovementCV", em.getMinLogLikelihoodImprovementCV()));
            statistics.addProperty(new Property("MinLogLikelihoodImprovementIterating", em.getMinLogLikelihoodImprovementIterating()));
            statistics.addProperty(new Property("MinStdDev", em.getMinStdDev()));
            this.setStatistics(statistics);
        } catch (Exception ex) {
            Logger.getLogger(EM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
