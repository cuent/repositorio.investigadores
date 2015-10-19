/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.platform.filters;

import edu.uc.investigadores.dm.platform.Filter;
import edu.uc.investigadores.dm.platform.Weka;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instances;

/**
 *
 * @author cuent
 */
public class NumericToNominal extends Weka implements Filter {

    private weka.filters.unsupervised.attribute.NumericToNominal numericToNominal;
    private Instances originalData;
    private Instances newData;

    public NumericToNominal() {
        numericToNominal = new weka.filters.unsupervised.attribute.NumericToNominal();
    }

    @Override
    public void build() {
        try {
            originalData = this.getData().getInstances();
            numericToNominal.setOptions(this.getConfiguration().getOptions());
            numericToNominal.setInputFormat(originalData);

            newData = weka.filters.Filter.useFilter(originalData, numericToNominal);
        } catch (Exception ex) {
            Logger.getLogger(NumericToNominal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Instances getOutPutFormat() {
        return newData;
    }

}
