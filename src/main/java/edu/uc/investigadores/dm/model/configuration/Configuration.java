/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.configuration;

import edu.uc.investigadores.dm.platform.Property;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuent
 */
public class Configuration {

    private List<Parameter> parameters;
    private Result result;
    private org.apache.hadoop.conf.Configuration configuration;

    public Configuration() {
        parameters = new ArrayList<>();
    }

    /**
     * Load a configuration of hadoop.
     *
     * @param configuration
     */
    public Configuration(org.apache.hadoop.conf.Configuration configuration) {
        parameters = new ArrayList<>();
        this.configuration = configuration;
    }

    /**
     * Get the configuration of hadoop
     *
     * @return
     */
    public org.apache.hadoop.conf.Configuration getHadoopConfiguration() {
        return configuration;
    }

    /**
     * Set the hadoop configuration
     *
     * @param conf
     */
    public void setHadoopConfiguration(org.apache.hadoop.conf.Configuration conf) {
        configuration = conf;
    }

    /**
     * Get the value of result
     *
     * @return the value of result
     */
    public Result getResult() {
        return result;
    }

    /**
     * Set the value of result
     *
     * @param result new value of result
     */
    public void setResult(Result result) {
        this.result = result;
    }

    public void addParameter(Parameter parameter) {
        parameters.add(parameter);
    }

    public String[] getOptions() {
        String[] options = new String[parameters.size() * 2];
        int i = 0;
        for (Parameter parameter : parameters) {
            options[i] = parameter.getClave();
            options[i + 1] = parameter.getValor();

            i += 2;
        }
        return options;
    }

    @Override
    public String toString() {
        StringBuilder parametersString = new StringBuilder();
        for (Parameter parameter : parameters) {
            parametersString.append(parameter.toString());
        }
        return "==>Configuration=" + parametersString + "\n\t";//+ "\n\t==>Result\n" + resultString;
    }
}
