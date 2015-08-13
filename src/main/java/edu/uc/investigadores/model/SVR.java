/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uc.investigadores.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.NumericPrediction;
import weka.classifiers.functions.SMOreg;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Option;

/**
 *
 * @author vsaquicela
 */
public class SVR extends Algorithm {

    public SVR(String name) {
        super(name);
    }

    private SMOreg svr = new SMOreg();

    @Override
    List<Result> execute(String options) {
        List<Result> results = new ArrayList<Result>();
        try {
            Instances data = this.getExperiment().getExperimentType().getTrain();
            Instances dataTest = this.getExperiment().getExperimentType().getTest();;
            if (this.getExperiment().getNumeroPredicciones() == 0) { //Only required build the regression
                data.setClassIndex(data.numAttributes() - 1);
                svr.setOptions(weka.core.Utils.splitOptions(options));
                svr.buildClassifier(data);
                //Model test using other data
                dataTest.setClassIndex(dataTest.numAttributes() - 1);
//                for (int i = 0; i < dataTest.numInstances(); i++) {
//                    Instance t = dataTest.instance(i);
//                    double pred = svr.classifyInstance(t);
//                    double actual = t.value(dataTest.numAttributes() - 1);
//                    results.add(new Result(i, actual, pred, false));
//                }
                System.out.println(svr.toString());
                System.out.println(data.toSummaryString());

                //Model evaluation
                Evaluation eval = new Evaluation(dataTest);
                eval.evaluateModel(svr, dataTest);

                System.out.println(eval.toSummaryString("\nResults\n======\n", true));
                
                int i=0;
                for (Object o : eval.predictions()) {
                    NumericPrediction np = (NumericPrediction) o;
                    //System.out.println(np.actual() + "," + np.predicted());
                    results.add(new Result(i, np.actual(), np.predicted(), false));
                    i++;
                }             

            } else { //estimate numeroPredicciones over the model
                //Prepare data using total prediction.
                int totalInstancesOriginal = data.numInstances();
                for (int i = 1; i <= this.getExperiment().getNumeroPredicciones(); i++) {
                    data.setClassIndex(data.numAttributes() - 1);
                    svr.setOptions(weka.core.Utils.splitOptions(options));
                    svr.buildClassifier(data);
                    //create a instance to evaluate with the model
                    Instance ins = new DenseInstance(data.numAttributes());
                    int pos = data.numInstances() - 1;
                    Instance ins1 = data.get(pos);
                    int count = 1;
                    for (int j = 0; j < data.numAttributes() - 1; j++) {
                        ins.setValue(data.attribute(count - 1), ins1.value(data.attribute(count)));
                        count++;
                    }
                    double pred = svr.classifyInstance(ins);
                    ins.setValue(data.attribute(count - 1), pred);
                    data.add(ins);
                }
                data.setClassIndex(data.numAttributes() - 1);
                for (int i = 0; i < data.numInstances(); i++) {
                    Instance t = data.instance(i);
                    double pred = svr.classifyInstance(t);
                    double actual = t.value(data.numAttributes() - 1);
                    if (totalInstancesOriginal <= i) {
                        results.add(new Result(i, actual, pred, true));
                    } else {
                        results.add(new Result(i, actual, pred, false));
                    }
                }
                System.out.println(svr.toString());
                System.out.println(data.toSummaryString());

                //Model evaluation
                Evaluation eval = new Evaluation(data);
                eval.evaluateModel(svr, data);
                System.out.println(eval.toSummaryString("\nResults\n======\n", true));
            }
        } catch (Exception ex) {
            Logger.getLogger(OneVariable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}
