/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.filters;

import edu.uc.investigadores.model.FilterVhsg;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;

/**
 *
 * @author vsaquicela
 */
public class DiscretizeVhsg extends FilterVhsg {

    public DiscretizeVhsg() {
    }

    public DiscretizeVhsg(String bins, String desiredWeightOfInstancePerInterval, String attributeIndices) {
        this.bins = bins;
        this.desiredWeightOfInstancePerInterval = desiredWeightOfInstancePerInterval;
        this.attributeIndices = attributeIndices;

    }
    private String bins = "10";

    /**
     * Get the value of bins
     *
     * @return the value of bins
     */
    public String getBins() {
        return bins;
    }

    /**
     * Set the value of bins
     *
     * @param bins new value of bins
     */
    public void setBins(String bins) {
        this.bins = bins;
    }
    private String desiredWeightOfInstancePerInterval = "-1";

    /**
     * Get the value of desiredWeightOfInstancePerInterval
     *
     * @return the value of desiredWeightOfInstancePerInterval
     */
    public String getDesiredWeightOfInstancePerInterval() {
        return desiredWeightOfInstancePerInterval;
    }

    /**
     * Set the value of desiredWeightOfInstancePerInterval
     *
     * @param desiredWeightOfInstancePerInterval new value of
     * desiredWeightOfInstancePerInterval
     */
    public void setDesiredWeightOfInstancePerInterval(String desiredWeightOfInstancePerInterval) {
        this.desiredWeightOfInstancePerInterval = desiredWeightOfInstancePerInterval;
    }
    private String attributeIndices = "first-last";

    /**
     * Get the value of attributeIndices
     *
     * @return the value of attributeIndices
     */
    public String getAttributeIndices() {
        return attributeIndices;
    }

    /**
     * Set the value of attributeIndices
     *
     * @param attributeIndices new value of attributeIndices
     */
    public void setAttributeIndices(String attributeIndices) {
        this.attributeIndices = attributeIndices;
    }

    @Override
    public  Instances execute(Instances data) {
        try {
            String[] options = new String[3];
            options[0] = "-B"+ bins;
            options[1] = "-M"+ desiredWeightOfInstancePerInterval;
            options[2] = "-R"+ attributeIndices;
            Discretize d = new Discretize();
            d.setOptions(options);
            d.setInputFormat(data);
            Filter f;
            Instances newData = Filter.useFilter(data,d);
            return newData;
        } catch (Exception ex) {
            Logger.getLogger(DiscretizeVhsg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
