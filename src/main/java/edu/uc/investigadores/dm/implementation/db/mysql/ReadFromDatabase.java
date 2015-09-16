/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.implementation.db.mysql;

import weka.core.Instances;
import weka.experiment.InstanceQuery;

/**
 *
 * @author cuent
 */
public class ReadFromDatabase {

    private final InstanceQuery query;

    public ReadFromDatabase() throws Exception {
        query = new InstanceQuery();
    }

    public ReadFromDatabase(String username, String password, String query) throws Exception {
        this.query = new InstanceQuery();
        this.query.setUsername(username);
        this.query.setPassword(password);
        this.query.setQuery(query);
    }

    public ReadFromDatabase setUsername(String username) {
        query.setUsername(username);
        return this;
    }

    public ReadFromDatabase setPassword(String password) {
        query.setPassword(password);
        return this;
    }

    public ReadFromDatabase setQuery(String q) {
        query.setQuery(q);
        return this;
    }

    /**
     * Makes a database query using the query set through the -Q option to convert a table into a set of instances
     * @return Instances the instances contained in the result of the query
     * @throws Exception if an error occurs
     */
    public Instances getInstances() throws Exception {
        return query.retrieveInstances();
    }
}
