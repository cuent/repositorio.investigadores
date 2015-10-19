/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.experiment;

import edu.uc.investigadores.dm.model.configuration.Algorithm;
import edu.uc.investigadores.dm.model.configuration.Column;
import edu.uc.investigadores.dm.model.configuration.Configuration;
import edu.uc.investigadores.dm.platform.Property;
import edu.uc.investigadores.dm.model.configuration.Result;
import edu.uc.investigadores.dm.model.configuration.Row;
import edu.uc.investigadores.dm.model.configuration.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuent
 */
public class Experiment {

    private Data data;
    private List<Algorithm> algorithms;

    public Experiment() {
        algorithms = new ArrayList<>();
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void addAlgorithm(Algorithm algorithm) {
        algorithms.add(algorithm);
    }

    public void execute() {
        for (Algorithm algorithm : algorithms) {
            List<Configuration> configuration = algorithm.getConfigurations();
            Result result = new Result();
            Table table = new Table();
            for (Configuration configuration1 : configuration) {
                algorithm.getPlatform().setData(this.getData());
                algorithm.getPlatform().setConfiguration(configuration1);
                algorithm.getPlatform().build();
                List<Property> properties = algorithm.getPlatform().getStatistics().getProperties();

                Row row = new Row();

                configuration1.setResult(result);
                result.setTable(table);
                table.addRow(row);

                for (Property property : properties) {
                    row.addColumn(new Column(property));
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Experiment\n" + "Data:\n" + data + "\n" + algorithms + '}';
    }
}
