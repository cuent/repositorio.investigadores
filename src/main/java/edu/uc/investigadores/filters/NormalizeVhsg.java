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
import weka.filters.unsupervised.attribute.Normalize;

/**
 *
 * @author vsaquicela
 */
public class NormalizeVhsg extends FilterVhsg{

    public NormalizeVhsg() {
    }

    public NormalizeVhsg(String scale,String translation) {
        this.scale=scale;
        this.translation=translation;
    }
    private boolean IgnoreClass=true;

    /**
     * Get the value of IgnoreClass
     *
     * @return the value of IgnoreClass
     */
    public boolean isIgnoreClass() {
        return IgnoreClass;
    }

    /**
     * Set the value of IgnoreClass
     *
     * @param IgnoreClass new value of IgnoreClass
     */
    public void setIgnoreClass(boolean IgnoreClass) {
        this.IgnoreClass = IgnoreClass;
    }

    private String scale = "1.0";

    /**
     * Get the value of scale
     *
     * @return the value of scale
     */
    public String getScale() {
        return scale;
    }

    /**
     * Set the value of scale
     *
     * @param scale new value of scale
     */
    public void setScale(String scale) {
        this.scale = scale;
    }
    private String translation = "0.0";

    /**
     * Get the value of translation
     *
     * @return the value of translation
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * Set the value of translation
     *
     * @param translation new value of translation
     */
    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public Instances execute(Instances data) {
try {
            String[] options = new String[3];
            options[0] = "-S "+ scale;
            options[1] = "-T "+ translation;
            options[2]= "-unset-class-temporarily";
            Normalize d = new Normalize();            
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
