/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.main;

import edu.uc.investigadores.dm.model.configuration.Algorithm;
import edu.uc.investigadores.dm.model.configuration.Configuration;
import edu.uc.investigadores.dm.model.configuration.Parameter;
import edu.uc.investigadores.dm.model.experiment.Data;
import edu.uc.investigadores.dm.model.experiment.Experiment;
import edu.uc.investigadores.dm.platform.Filter;
import edu.uc.investigadores.dm.platform.Platform;
import edu.uc.investigadores.dm.platform.SimpleKMeans;
import edu.uc.investigadores.dm.platform.EM;
import edu.uc.investigadores.dm.platform.HierarchicalClusterer;
import edu.uc.investigadores.dm.platform.filters.NumericToNominal;
import edu.uc.investigadores.dm.platform.filters.Remove;
import edu.uc.investigadores.dm.platform.filters.StringToNominal;
import edu.uc.investigadores.dm.platform.filters.StringToWordVector;

/**
 *
 * @author cuent
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Test t = new Test();
        t.experimentK();
        //t.experiment4();
    }

    public void experimentTest() {
        Platform p = new SimpleKMeans();

        Algorithm a = new edu.uc.investigadores.dm.model.configuration.KMeans(p);
        Configuration c = new Configuration();
        c.addParameter(new Parameter("-N", "2"));
        c.addParameter(new Parameter("-A", "weka.core.EuclideanDistance -R first-last"));
        c.addParameter(new Parameter("-I", "500"));
        c.addParameter(new Parameter("-num-slots", "1"));
        c.addParameter(new Parameter("-S", "10"));
        a.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "3"));
        a.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-R", "1"));

        Data data = new Data();

        Filter ntNominal = new NumericToNominal();

        ((NumericToNominal) ntNominal).setConfiguration(c);
        ((NumericToNominal) ntNominal).setData(data);
        ((NumericToNominal) ntNominal).build();
        data.setInstances(((NumericToNominal) ntNominal).getOutPutFormat());

        Experiment e = new Experiment();
        e.setData(data);
        e.addAlgorithm(a);
        e.execute();

        System.out.println(e.toString());
    }

    public void experiment0() {
        Platform p = new SimpleKMeans();
        Algorithm kmeans = new edu.uc.investigadores.dm.model.configuration.KMeans(p);

        Platform pEM = new EM();
        Algorithm em = new edu.uc.investigadores.dm.model.configuration.EM(pEM);

        Platform pHierarchicalClusterer = new HierarchicalClusterer();
        Algorithm hierarchicalClusterer = new edu.uc.investigadores.dm.model.configuration.HierarchicalClusterer(pHierarchicalClusterer);

        Configuration c = new Configuration();
//        c.addParameter(new Parameter("-N", "2"));
//        c.addParameter(new Parameter("-A", "weka.core.EuclideanDistance -R first-last"));
//        c.addParameter(new Parameter("-I", "500"));
//        c.addParameter(new Parameter("-num-slots", "1"));
//        c.addParameter(new Parameter("-S", "10"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "3"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "7"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "11"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "15"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "19"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "24"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "26"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "36"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "46"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "56"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "66"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "76"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "86"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "3000"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "6000"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "9000"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "12000"));
//        kmeans.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "500"));
        kmeans.addConfiguration(c);

//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "50000"));
//        kmeans.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "90000"));
//        kmeans.addConfiguration(c);
        c = new Configuration();
        c.addParameter(new Parameter("-N", "-1"));
        em.addConfiguration(c);

//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "12000"));
//        em.addConfiguration(c);
//
//        c = new Configuration();
//        c.addParameter(new Parameter("-N", "20000"));
//        em.addConfiguration(c);
        c = new Configuration();
        c.addParameter(new Parameter("-N", "50000"));
        hierarchicalClusterer.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "90000"));
        hierarchicalClusterer.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "180000"));
        hierarchicalClusterer.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-R", "1,2"));

        Data data = new Data();
        data.testLoad("src/main/java/edu/uc/investigadores/dm/data/data_join_keywords.arff");

        Filter remove = new Remove();

        ((Remove) remove).setConfiguration(c);
        ((Remove) remove).setData(data);
        ((Remove) remove).build();
        data.setInstances(((Remove) remove).getOutPutFormat());

        Experiment e = new Experiment();
        e.setData(data);
        e.addAlgorithm(kmeans);
        //e.addAlgorithm(em);
        //e.addAlgorithm(hierarchicalClusterer);
        e.execute();

        System.out.println(e.toString());
    }

    public void experiment1() {
        Platform pSKM = new SimpleKMeans();
        Algorithm kmeans = new edu.uc.investigadores.dm.model.configuration.KMeans(pSKM);

        Platform pEM = new EM();
        Algorithm em = new edu.uc.investigadores.dm.model.configuration.EM(pEM);

        Configuration c = new Configuration();
        c.addParameter(new Parameter("-N", "2"));
        kmeans.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "3"));
        kmeans.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "-1"));
        em.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "2"));
        em.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-R", "2"));

        Data data = new Data();
        data.testLoad("src/main/java/edu/uc/investigadores/dm/data/muestra.arff");

        Filter stringToNominal = new StringToNominal();

        ((StringToNominal) stringToNominal).setConfiguration(c);
        ((StringToNominal) stringToNominal).setData(data);
        ((StringToNominal) stringToNominal).build();
        data.setInstances(((StringToNominal) stringToNominal).getOutPutFormat());

        Experiment e = new Experiment();
        e.setData(data);
        e.addAlgorithm(kmeans);
        e.addAlgorithm(em);
        e.execute();

        System.out.println(e.toString());
    }

    public void experiment2() {
        Platform pSKM = new SimpleKMeans();
        Algorithm kmeans = new edu.uc.investigadores.dm.model.configuration.KMeans(pSKM);

        Platform pEM = new EM();
        Algorithm em = new edu.uc.investigadores.dm.model.configuration.EM(pEM);

        Configuration c = new Configuration();
        c.addParameter(new Parameter("-N", "2"));
        kmeans.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "3"));
        kmeans.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "-1"));
        em.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "2"));
        em.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-R", "2"));

        Data data = new Data();
        data.testLoad("src/main/java/edu/uc/investigadores/dm/data/muestra.arff");

        Filter stringToNominal = new StringToNominal();

        ((StringToNominal) stringToNominal).setConfiguration(c);
        ((StringToNominal) stringToNominal).setData(data);
        ((StringToNominal) stringToNominal).build();
        data.setInstances(((StringToNominal) stringToNominal).getOutPutFormat());

        c = new Configuration();
        c.addParameter(new Parameter("-R", "1"));

        Filter remove = new Remove();

        ((Remove) remove).setConfiguration(c);
        ((Remove) remove).setData(data);
        ((Remove) remove).build();
        data.setInstances(((Remove) remove).getOutPutFormat());

        Experiment e = new Experiment();
        e.setData(data);
        e.addAlgorithm(kmeans);
        e.addAlgorithm(em);
        e.execute();

        System.out.println(e.toString());
    }

    public void experiment3() {
        Platform pSKM = new SimpleKMeans();
        Algorithm kmeans = new edu.uc.investigadores.dm.model.configuration.KMeans(pSKM);

        Platform pEM = new EM();
        Algorithm em = new edu.uc.investigadores.dm.model.configuration.EM(pEM);

        Configuration c = new Configuration();
        c.addParameter(new Parameter("-N", "2"));
        kmeans.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "3"));
        kmeans.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "-1"));
        em.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "2"));
        em.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-R", "2"));
        c.addParameter(new Parameter("-prune-rate", "-1.0"));
        c.addParameter(new Parameter("-stemmer", "weka.core.stemmers.NullStemmer"));
        c.addParameter(new Parameter("-tokenizer", "weka.core.tokenizers.WordTokenizer -delimiters ,"));

        Data data = new Data();
        data.testLoad("src/main/java/edu/uc/investigadores/dm/data/muestra.arff");

        Filter stringToWordVector = new StringToWordVector();

        ((StringToWordVector) stringToWordVector).setConfiguration(c);
        ((StringToWordVector) stringToWordVector).setData(data);
        ((StringToWordVector) stringToWordVector).build();
        data.setInstances(((StringToWordVector) stringToWordVector).getOutPutFormat());

        c = new Configuration();
        c.addParameter(new Parameter("-R", "1"));

        Filter remove = new Remove();

        ((Remove) remove).setConfiguration(c);
        ((Remove) remove).setData(data);
        ((Remove) remove).build();
        data.setInstances(((Remove) remove).getOutPutFormat());

        Experiment e = new Experiment();
        e.setData(data);
        e.addAlgorithm(kmeans);
        e.addAlgorithm(em);
        e.execute();

        System.out.println(e.toString());
    }

    public void experiment4() {
        Platform pSKM = new SimpleKMeans();
        Algorithm kmeans = new edu.uc.investigadores.dm.model.configuration.KMeans(pSKM);

        Platform pEM = new EM();
        Algorithm em = new edu.uc.investigadores.dm.model.configuration.EM(pEM);

        Configuration c = new Configuration();
        c.addParameter(new Parameter("-N", "2"));
        kmeans.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "3"));
        kmeans.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "-1"));
        em.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-N", "2"));
        em.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-R", "2"));
        c.addParameter(new Parameter("-prune-rate", "-1.0"));
        c.addParameter(new Parameter("-stemmer", "weka.core.stemmers.NullStemmer"));
        c.addParameter(new Parameter("-tokenizer", "weka.core.tokenizers.WordTokenizer -delimiters ,"));

        Data data = new Data();
        data.testLoad("src/main/java/edu/uc/investigadores/dm/data/muestra.arff");

        Filter stringToWordVector = new StringToWordVector();

        ((StringToWordVector) stringToWordVector).setConfiguration(c);
        ((StringToWordVector) stringToWordVector).setData(data);
        ((StringToWordVector) stringToWordVector).build();
        data.setInstances(((StringToWordVector) stringToWordVector).getOutPutFormat());

        Experiment e = new Experiment();
        e.setData(data);
        e.addAlgorithm(kmeans);
        e.addAlgorithm(em);
        e.execute();

        System.out.println(e.toString());
    }

    public void experimentK() {
        Platform pSKM = new SimpleKMeans();
        Algorithm kmeans = new edu.uc.investigadores.dm.model.configuration.KMeans(pSKM);

        Configuration c = new Configuration();
        c.addParameter(new Parameter("-N", "2000"));
        kmeans.addConfiguration(c);

        c = new Configuration();
        c.addParameter(new Parameter("-R", "2"));
        c.addParameter(new Parameter("-prune-rate", "-1.0"));
        c.addParameter(new Parameter("-stemmer", "weka.core.stemmers.NullStemmer"));
        c.addParameter(new Parameter("-tokenizer", "weka.core.tokenizers.WordTokenizer -delimiters ,"));
        c.addParameter(new Parameter("-W", "1000000"));

        Data data = new Data();
        data.testLoad("src/main/java/edu/uc/investigadores/dm/data/datos.arff");

        Filter stringToWordVector = new StringToWordVector();

        ((StringToWordVector) stringToWordVector).setConfiguration(c);
        ((StringToWordVector) stringToWordVector).setData(data);
        ((StringToWordVector) stringToWordVector).build();
        data.setInstances(((StringToWordVector )stringToWordVector).getOutPutFormat());

        c = new Configuration();
        c.addParameter(new Parameter("-R", "1,2"));

        Filter remove = new Remove();

        ((Remove) remove).setConfiguration(c);
        ((Remove) remove).setData(data);
        ((Remove) remove).build();
        data.setInstances(((Remove) remove).getOutPutFormat());

        Experiment e = new Experiment();
        e.setData(data);
        e.addAlgorithm(kmeans);
        e.execute();

        System.out.println(e.toString());
    }

}
