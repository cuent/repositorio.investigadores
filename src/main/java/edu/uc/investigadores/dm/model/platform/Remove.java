/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.model.platform;

import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instances;

/**
 *
 * @author cuent
 */
public class Remove extends Weka implements Filter {

    private weka.filters.unsupervised.attribute.Remove remove;
    private Instances originalData;
    private Instances newData;

    public Remove() {
        remove = new weka.filters.unsupervised.attribute.Remove();
    }

    @Override
    public void build() {
        try {
            originalData = this.getData().getInstances();
            remove.setOptions(this.getConfiguration().getOptions());
            remove.setInputFormat(originalData);

            newData = weka.filters.Filter.useFilter(originalData, remove);
        } catch (Exception ex) {
            Logger.getLogger(Remove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Instances getOutPutFormat() {
        return newData;
    }

}
