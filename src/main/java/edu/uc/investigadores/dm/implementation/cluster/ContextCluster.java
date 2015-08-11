/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.implementation.cluster;

import edu.uc.investigadores.dm.exceptions.BuildClusterException;
import edu.uc.investigadores.dm.exceptions.ReadDataFileException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cuent
 */
public class ContextCluster {

    private final AbstractCluster _cluster;
    private final String filename;

    public ContextCluster(String filename, AbstractCluster _cluster) {
        this.filename = filename;
        this._cluster = _cluster;
    }

    public void buildCluster() {
        try {
            if (_cluster instanceof KMeans) {
                _cluster.readDataFile(filename);
                _cluster.buildCluster();
            }
        } catch (ReadDataFileException | BuildClusterException ex) {
            Logger.getLogger(ContextCluster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printInstances() {
        if (_cluster instanceof KMeans) {
            _cluster.getInstances();
        }
    }
}
