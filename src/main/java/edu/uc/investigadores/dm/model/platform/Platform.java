/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.platform;

import edu.uc.investigadores.dm.model.configuration.Configuration;
import edu.uc.investigadores.dm.model.experiment.Data;

/**
 *
 * @author cuent
 */
public abstract class Platform {

    private String namePlatform;
    private Data data;
    private Configuration configuration;
    private Statistics statistics;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public String getNamePlatform() {
        return namePlatform;
    }

    public void setNamePlatform(String namePlatform) {
        this.namePlatform = namePlatform;
    }

    public abstract void build();
}
