/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.configuration;

import edu.uc.investigadores.dm.model.platform.Platform;

/**
 *
 * @author cuent
 */
public class KMeans extends Clustering {

    public KMeans( Platform platform) {
        super(platform);
        this.setNameAlgorithm("KMeans");
    }

}
