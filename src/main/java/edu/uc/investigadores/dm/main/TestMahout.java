/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.main;

import edu.uc.investigadores.dm.model.configuration.Algorithm;
import edu.uc.investigadores.dm.model.configuration.Configuration;
import edu.uc.investigadores.dm.model.configuration.Parameter;
import edu.uc.investigadores.dm.model.experiment.Experiment;
import edu.uc.investigadores.dm.platform.Platform;
import edu.uc.investigadores.dm.platform.filters.Filter;
import edu.uc.investigadores.dm.platform.filters.mahout.Seq2Sparse;
import edu.uc.investigadores.dm.platform.filters.mahout.SeqDirectory;
import edu.uc.investigadores.dm.platform.filters.mahout.SeqDumper;
import edu.uc.investigadores.dm.platform.mahout.KMeans;
import org.apache.mahout.common.distance.CosineDistanceMeasure;
import org.apache.mahout.text.PrefixAdditionFilter;

/**
 *
 * @author cuent
 */
public class TestMahout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestMahout t = new TestMahout();
        t.test1();
    }

    public void test1() {
        Platform p = new edu.uc.investigadores.dm.platform.mahout.KMeans();
        Algorithm a = new edu.uc.investigadores.dm.model.configuration.KMeans(p);

        Configuration c = new Configuration();
        c.addParameter(new  Parameter("-i", "mahout_base/sparse/tfidf-vectors"));
        c.addParameter(new  Parameter("-o", "mahout_base/kmeans"));
        c.addParameter(new  Parameter("-c", "mahout_base/kmeans/seed"));
        c.addParameter(new  Parameter("-dm", CosineDistanceMeasure.class.getName()));
        c.addParameter(new  Parameter("-x", "100"));
        c.addParameter(new  Parameter("-k", "2000"));
        c.addParameter(new  Parameter("-xm", "sequential"));
        c.addParameter(new  Parameter("--clustering", "-ow"));
        c.setHadoopConfiguration(new org.apache.hadoop.conf.Configuration());
        a.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-i", "mahout_base/original"));
        c.addParameter(new Parameter("-o", "mahout_base/output"));
        c.addParameter(new Parameter("-c", "UTF-8"));
        c.addParameter(new Parameter("-filter", PrefixAdditionFilter.class.getName()));//"edu.uc.investigadores.dm.platform.filters.mahout.AlternatePrefixFilter"));
        c.setHadoopConfiguration(new org.apache.hadoop.conf.Configuration());

        Filter seqdirectory = new SeqDirectory();
        ((SeqDirectory) seqdirectory).setConfiguration(c);
        ((SeqDirectory) seqdirectory).build();

        c = new Configuration();
        c.addParameter(new Parameter("-i", "mahout_base/output"));
        c.addParameter(new Parameter("-o", "mahout_base/sparse"));
        c.addParameter(new Parameter("-x", "60"));
        c.addParameter(new Parameter("-n", "2"));
        c.addParameter(new Parameter("-ng", "1"));
        c.addParameter(new Parameter("-nv", "-ow"));
        c.setHadoopConfiguration(new org.apache.hadoop.conf.Configuration());

        Filter seq2sparse = new Seq2Sparse();
        ((Seq2Sparse) seq2sparse).setConfiguration(c);
        ((Seq2Sparse) seq2sparse).build();

        Experiment e = new Experiment();
        e.addAlgorithm(a);
        e.execute();
    }

}
