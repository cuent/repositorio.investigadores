/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.platform.weka;

import edu.uc.investigadores.dm.platform.Property;
import edu.uc.investigadores.dm.platform.Statistics;
import edu.uc.investigadores.dm.platform.weka.Weka;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instance;
import weka.core.Instances;

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

            Instances data = this.getData().getInstances();
            int num;
            for (int i = 0; i < data.numInstances(); i++) {
                Instance instance = data.get(i);
                num = em.clusterInstance(instance);
                System.out.println(i + "\t" + instance + "\t" + num);
            }

            Statistics statistics = new Statistics();
            //statistics.addProperty(new Property("MinLogLikelihoodImprovementCV", em.getMinLogLikelihoodImprovementCV()));
            statistics.addProperty(new Property("MinLogLikelihoodImprovementIterating", em.getMinLogLikelihoodImprovementIterating()));
            //statistics.addProperty(new Property("MinStdDev", em.getMinStdDev()));
            this.setStatistics(statistics);
        } catch (Exception ex) {
            Logger.getLogger(EM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return em.toString();
    }

}
