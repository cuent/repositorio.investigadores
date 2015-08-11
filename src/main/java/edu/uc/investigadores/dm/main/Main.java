/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.main;

import edu.uc.investigadores.dm.implementation.cluster.AbstractCluster;
import edu.uc.investigadores.dm.implementation.cluster.ContextCluster;
import edu.uc.investigadores.dm.implementation.cluster.KMeans;

/**
 *
 * @author cuent
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String pathFile="src/main/java/edu/uc/investigadores/dm/data/datos1.arff";
        if (pathFile.trim().equals("")) {
            System.out.println(args.length);
        } else {
            AbstractCluster kmeans = new KMeans()
                    .setPreserveInstancesOrder(true);
            System.out.println("===== Usage: java " + kmeans.getNameCluster() + " =====");
            System.out.println("===== Loaded Dataset <fileData> " + pathFile + " =====");

            ContextCluster cc = new ContextCluster(pathFile, kmeans);

            System.out.println("===== Building cluster... =====");
            cc.buildCluster();

            System.out.println("===== Results of each instance =====");
            cc.printInstances();
        }
    }
    
}
