/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.implementation.cluster;

import edu.uc.investigadores.dm.exceptions.BuildClusterException;
import edu.uc.investigadores.dm.exceptions.ReadDataFileException;
import java.util.HashMap;

/**
 *
 * @author cuent
 */
public abstract class AbstractCluster {

    private final String nameCluster;

    public AbstractCluster(String nameCluster) {
        this.nameCluster = nameCluster;
    }

    /**
     * Returns the name of the cluster applied.
     *
     * @return String
     */
    public String getNameCluster() {
        return nameCluster;
    }

    /**
     * Read a dataset to apply an algorithm.
     *
     * @param filename
     * @throws ReadDataFileException if the file can not be read.
     */
    public abstract void readDataFile(String filename) throws ReadDataFileException;

    /**
     * Generates a clusterer. Has to initialize all fields of the clusterer that
     * are not being set via options.
     *
     * @throws BuildClusterException if the clusterer has not been generated
     * successfully
     */
    public abstract void buildCluster() throws BuildClusterException;

    /**
     * Return a Hash Map with instances of the cluster.
     *
     * @return HashMap<num_instancia, cluster>
     */
    public abstract HashMap<Integer, Integer> getInstances();

}
