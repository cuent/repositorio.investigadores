/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.implementation.cluster;

import edu.uc.investigadores.dm.exceptions.BuildClusterException;
import edu.uc.investigadores.dm.exceptions.ReadDataFileException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.clusterers.SimpleKMeans;
import weka.core.DistanceFunction;
import weka.core.Instances;

/**
 *
 * @author cuent
 */
public class KMeans extends AbstractCluster {

    private BufferedReader inputReader = null;
    private final SimpleKMeans kmeans;

    public KMeans() {
        super("Simple K-Means");
        kmeans = new SimpleKMeans();
    }

    @Override
    public void readDataFile(String filename) throws ReadDataFileException {

        try {
            inputReader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + filename);
            Logger.getLogger(KMeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void buildCluster() throws BuildClusterException {
        try {
            BufferedReader datafile = inputReader;
            Instances data = new Instances(datafile);
            kmeans.buildClusterer(data);
        } catch (Exception ex) {
            Logger.getLogger(KMeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HashMap<Integer, Integer> getInstances() {
        HashMap<Integer, Integer> hashInstances = new HashMap();
        try {

            int[] assignments;
            assignments = kmeans.getAssignments();
            int i = 0;
            for (int clusterNum : assignments) {
                hashInstances.put(i, clusterNum);
                //Linea para comprobar
                System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
                i++;
            }
        } catch (Exception ex) {
            Logger.getLogger(KMeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashInstances;
    }

    /**
     * Gets the current settings of SimpleKMeans.
     *
     * @return String[] an array of strings.
     */
    public String[] getOptions() {
        return kmeans.getOptions();
    }

    /**
     * Sets whether standard deviations and nominal count Should be displayed in
     * the clustering output
     *
     * @param stdD - true if std. devs and counts should be displayed
     * @return KMeans
     */
    public KMeans setDisplayStdDevs(boolean stdD) {
        kmeans.setDisplayStdDevs(stdD);
        return this;
    }

    /**
     * sets the distance function to use for instance comparison.
     *
     * @param df - the new distance function to use
     * @return KMeans
     * @exception java.lang.Exception - if instances cannot be processed
     */
    public KMeans setDistanceFunction(DistanceFunction df) throws Exception {
        kmeans.setDistanceFunction(df);
        return this;
    }

    /**
     * Sets whether missing values are to be replaced
     *
     * @param r - true if missing values are to be replaced
     * @return KMeans
     */
    public KMeans setDontReplaceMissingValues(boolean r) {
        kmeans.setDontReplaceMissingValues(r);
        return this;
    }

    /**
     * set the maximum number of iterations to be executed
     *
     * @param n - the maximum number of iterations
     * @return KMeans
     * @exception java.lang.Exception - if maximum number of iteration is
     * smaller than 1
     */
    public KMeans setMaxIterations(int n) throws Exception {
        kmeans.setMaxIterations(n);
        return this;
    }

    /**
     * set the number of clusters to generate
     *
     * @param n - the number of clusters to generate
     * @return KMeans
     * @throws java.lang.Exception - if number of clusters is negative
     */
    public KMeans setNumClusters(int n) throws Exception {
        kmeans.setNumClusters(n);
        return this;
    }

    /**
     * Parses a given list of options. Valid options are:
     *
     * -N <num>
     * number of clusters. (default 2).
     *
     * -V Display std. deviations for centroids.
     *
     * -M Replace missing values with mean/mode.
     *
     * -S <num>
     * Random number seed. (default 10)
     *
     * -A <classname and options>
     * Distance function to be used for instance comparison (default
     * weka.core.EuclidianDistance)
     *
     * -I <num>
     * Maximum number of iterations.
     *
     * -O Preserve order of instances.
     *
     * @param options - the list of options as an array of strings
     * @return KMeans
     * @throws java.lang.Exception - if an option is not supported
     */
    public KMeans setOptions(java.lang.String[] options) throws Exception {
        kmeans.setOptions(options);
        return this;
    }

    /**
     * Sets whether order of instances must be preserved
     *
     * @param r - true if missing values are to be replaced
     * @return KMeans
     */
    public KMeans setPreserveInstancesOrder(boolean r) {
        kmeans.setPreserveInstancesOrder(r);
        return this;
    }
}
