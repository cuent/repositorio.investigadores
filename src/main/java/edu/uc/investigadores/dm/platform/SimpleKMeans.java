/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.dm.platform;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cuent
 */
public class SimpleKMeans extends Weka {

    private final weka.clusterers.SimpleKMeans kmeans;

    public SimpleKMeans() {
        kmeans = new weka.clusterers.SimpleKMeans();
    }

    @Override
    public void build() {
        try {
            System.out.println("BUILDING KMEANS...");
            kmeans.setOptions(super.getConfiguration().getOptions());
            kmeans.setPreserveInstancesOrder(true);
            kmeans.buildClusterer(this.getData().getInstances());

            Statistics statistics = new Statistics();
            statistics.addProperty(new Property("SquaredError", kmeans.getSquaredError()));
            this.setStatistics(statistics);

            System.out.println(getAssignments());
        } catch (Exception ex) {
            Logger.getLogger(SimpleKMeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StringBuilder getAssignments() {
        StringBuilder resultado = new StringBuilder().append("Cluster,Assignments\n");

        try {
            int[] clusters = kmeans.getAssignments();
            HashMap<Integer, Set<String>> clustersAssignments = new HashMap<>();
            String word;
            for (int i = 0; i < clusters.length; i++) {
                String[] line = this.getData().getInstances().get(i).toString().replace("{", "").replace("}", "").split(",");
                if (line.length >= 1) {
                    for (String line1 : line) {
                        String[] indexAttributeWord = line1.split(" ");
                        if (indexAttributeWord[1].equals("1")) {
                            word = this.getData().getInstances().attribute(Integer.parseInt(indexAttributeWord[0])).toString();
                            word = word.substring(word.indexOf("@attribute ") + 11, word.lastIndexOf(" numeric"));
                            if (clustersAssignments.containsKey(clusters[i])) {
                                clustersAssignments.get(clusters[i]).add(word);
                            } else {
                                Set<String> indexWord = new HashSet<>();
                                clustersAssignments.put(clusters[i], indexWord);
                                indexWord.add(word);
                            }
                        }
                    }
                }
            }
            Iterator it = clustersAssignments.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Set<String>> pair = (Map.Entry<Integer, Set<String>>) it.next();
                resultado.append(pair.getKey()).append(",").append("\"");
                Set<String> wordsString = pair.getValue();

                for (String wordAux : wordsString) {
                    if (wordAux.startsWith("'") && wordAux.endsWith("'")) {
                        resultado.append(wordAux.substring(1, wordAux.length() - 1));
                    } else {
                        resultado.append(wordAux);
                    }
                    resultado.append(",");
                }
                resultado.append("\"\n");
            }
        } catch (Exception ex) {
            Logger.getLogger(SimpleKMeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "SimpleKMeans{" + "kmeans=" + kmeans + '}';
    }
}
