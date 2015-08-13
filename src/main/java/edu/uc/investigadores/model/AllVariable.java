/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.model;

import edu.uc.investigadores.sources.Connector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vsaquicela
 */
public class AllVariable extends ExperimentType {

    @Override
    void dataExtract() {
        try {
            Connector c = new Connector();
            this.setTrain(c.query(this.getExperiment().getQueryTrain(), this.getExperiment().getUser(), this.getExperiment().getPassword()));
            this.setTest(c.query(this.getExperiment().getQueryTest(), this.getExperiment().getUser(), this.getExperiment().getPassword()));
            this.setPrediction(c.query(this.getExperiment().getQueryPrediction(), this.getExperiment().getUser(), this.getExperiment().getPassword()));
            for (FilterVhsg f : this.getExperiment().getFilters()) {
                this.setTrain(f.execute(this.getTrain()));
                this.setTest(f.execute(this.getTest()));
            }
        } catch (Exception ex) {
            Logger.getLogger(AllVariable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
