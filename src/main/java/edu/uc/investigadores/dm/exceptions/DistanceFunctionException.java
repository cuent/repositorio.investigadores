/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.exceptions;

/**
 *
 * @author cuent
 */
public class DistanceFunctionException extends Exception{

    public DistanceFunctionException(String message) {
        super("Problem with distance function, exception if instances cannot be processed");
    }
    
}
