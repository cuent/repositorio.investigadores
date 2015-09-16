/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.configuration;

import edu.uc.investigadores.dm.model.platform.Property;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuent
 */
public class Configuration {

    private List<Parameter> parameters;
    private Result result;

    public Configuration() {
        parameters = new ArrayList<>();
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
//        StringBuilder resultString = new StringBuilder();
//        for (int i = 0; i < result.getTable().getRows().size(); i++) {
//            resultString.append("\t\t+--------------+\n");
//            for (Column column : result.getTable().getRows().get(i).getColumns()) {
//
//                resultString.append("\t\t|");
//                resultString.append(((Property) column.getField()).getKey());
//                resultString.append("  |\n");
//                resultString.append("\t\t+--------------+\n");
//                resultString.append("\t\t|");
//                resultString.append(((Property) column.getField()).getValue());
//                resultString.append("\t       |\n");
//                resultString.append("\t\t+--------------+\n");
//            }
//        }

        return "==>Configuration=" + parametersString + "\n\t";//+ "\n\t==>Result\n" + resultString;
    }
}
