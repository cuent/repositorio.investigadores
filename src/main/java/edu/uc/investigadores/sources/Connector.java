/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.sources;

import weka.core.Instances;
import weka.experiment.InstanceQuery;

/**
 *
 * @author vsaquicela
 */
public class Connector {

    public Connector() {
    }
    
    public Instances query(String consulta, String user, String password) throws Exception {
        InstanceQuery query = new InstanceQuery();
        query.setUsername(user);
        query.setPassword(password);
        query.setQuery(consulta);
        // You can declare that your data set is sparse
        // query.setSparseData(true);
        Instances data = query.retrieveInstances();
        return data;
    }
}
