/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.configuration;

import edu.uc.investigadores.dm.model.platform.Platform;
import edu.uc.investigadores.dm.model.platform.Property;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuent
 */
public abstract class Algorithm {

    private String nameAlgorithm;
    private String nameType;
    private List<Configuration> configurations;
    private Platform platform;

    public Algorithm(Platform platform) {
        this.platform = platform;
        configurations = new ArrayList<>();
    }

    public List<Configuration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<Configuration> configurations) {
        this.configurations = configurations;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public void addConfiguration(Configuration c) {
        configurations.add(c);
        this.getPlatform().setConfiguration(c);
    }

    public String getNameAlgorithm() {
        return nameAlgorithm;
    }

    public void setNameAlgorithm(String nameAlgorithm) {
        this.nameAlgorithm = nameAlgorithm;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Override
    public String toString() {
        List<Row> rows = this.configurations.get(0).getResult().getTable().getRows();
        StringBuilder stringResult;
        stringResult = header(rows.get(0));
        for (Row row : rows) {
            List<Column> columns = row.getColumns();
            for (Column column : columns) {
                String value = ((Property) column.getField()).getValue().toString();
                String key = ((Property) column.getField()).getKey();
                stringResult.append("|").append(value).append(space(value.length() + 2, key.length())).append("|");
            }
            stringResult.append("\n");
        }

        return "Algorithm: " + this.getNameAlgorithm() + "\n\t=>Platform:" + this.getPlatform().getNamePlatform() + "\n\t=>Type:" + this.getNameType() + "\n\t" + configurations + "\n\tResult=\n" + stringResult;
    }

    private StringBuilder header(Row row) {
        StringBuilder result = new StringBuilder();
        List<Column> columns = row.getColumns();
        for (Column column : columns) {
            String key = ((Property) column.getField()).getKey();
            line(key, result);
            result.append("|").append(key).append("|").append("\n");
            line(key, result);
        }
        return result;
    }

    private void line(String key, StringBuilder result) {

        for (int i = 0; i < key.length() + 2; i++) {
            if (i == 0) {
                result.append("+");
            } else if (i == (key.length() + 1)) {
                result.append("+\n");
            } else {
                result.append("-");
            }
        }
    }

    private String space(int sizeValue, int sizeKey) {
        String spaces = new String();
        int num;
        if (sizeKey >= sizeValue) {
            num = sizeKey - sizeValue;
        } else {
            num = sizeValue - sizeKey;
        }
        for (int i = 0; i < num + 2; i++) {
            spaces += " ";
        }
        return spaces;
    }
}
