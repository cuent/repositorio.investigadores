/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.platform.mahout;

import edu.uc.investigadores.dm.platform.Property;
import edu.uc.investigadores.dm.platform.Statistics;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.mahout.clustering.fuzzykmeans.FuzzyKMeansDriver;

/**
 *
 * @author cuent
 */
public class FuzzyKMeans extends Mahout {

    @Override
    public void build() {
        Tool tool = new FuzzyKMeansDriver();
        try {
            if (this.getConfiguration().getHadoopConfiguration() == null) {
                ToolRunner.run(tool, this.getConfiguration().getOptions());
            } else {
                ToolRunner.run(this.getConfiguration().getHadoopConfiguration(), tool, this.getConfiguration().getOptions());
            }
            //Buscar una forma para obtener estadisticas
            Statistics statistics = new Statistics();
            statistics.addProperty(new Property("SquaredError", "NA"));
            this.setStatistics(statistics);
        } catch (Exception ex) {
            Logger.getLogger(FuzzyKMeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
