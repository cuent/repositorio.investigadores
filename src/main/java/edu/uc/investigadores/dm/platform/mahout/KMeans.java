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
import org.apache.mahout.clustering.kmeans.KMeansDriver;

/**
 *
 * @author cuent
 */
public class KMeans extends Mahout {

    @Override
    public void build() {
        try {
            Tool tool = new KMeansDriver();
            if (this.getConfiguration() == null) {
                ToolRunner.run(tool, this.getConfiguration().getOptions());
            } else {
                ToolRunner.run(this.getConfiguration().getHadoopConfiguration(), tool,
                        this.getConfiguration().getOptions());
            }
            //Buscar una forma para obtener estadisticas
            Statistics statistics = new Statistics();
            statistics.addProperty(new Property("SquaredError", "NA"));
            this.setStatistics(statistics);
        } catch (Exception ex) {
            Logger.getLogger(KMeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
