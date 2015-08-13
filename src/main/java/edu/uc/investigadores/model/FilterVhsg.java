/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.model;

import weka.core.Instances;

/**
 *
 * @author vsaquicela
 */
abstract public class FilterVhsg {
    abstract public Instances execute (Instances data);
}
