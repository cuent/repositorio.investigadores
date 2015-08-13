package edu.uc.investigadores.dm.main;



import edu.uc.investigadores.filters.NormalizeVhsg;
import edu.uc.investigadores.model.Algorithm;
import edu.uc.investigadores.model.AllVariable;
import edu.uc.investigadores.model.Configuration;
import edu.uc.investigadores.model.Experiment;
import edu.uc.investigadores.model.ExperimentType;
import edu.uc.investigadores.model.NeuralNetwork;
import edu.uc.investigadores.model.OneVariable;
import edu.uc.investigadores.model.Parameter;
import edu.uc.investigadores.model.SVR;
import java.util.Map;


/**
 * Hello world!
 *
 */
public class TestMain {

    public static void main(String[] args) {
        TestMain test = new TestMain();
//       test.testSVR();
       test.testNN();
       // test.test_SVR_NN();
//        Experiment ex = test.test_SVR_NN();
//        Map r= ex.tableResult();
//        Iterator i= r.keySet().iterator();
//        while (i.hasNext()){
//            String c= (String) i.next();
//            System.out.println("Experiment: "+ c);
//            System.out.println(r.get(c));                    
//        }
        
    }

    public void testSVR() {
        Experiment ex = new Experiment("Predicción de Precipitación");
        ex.setUser("root");
        ex.setPassword("soloyose");
        ex.setQueryTrain("SELECT  v2,v4,v5,v7,v8,v9,v11,v12,v14,v16,v17,v20,v23,v27,v34,v39,v57,v59,v66,precipitacion FROM cta.originales where year(mes_dia_anio)<=1990 order by mes_dia_anio");
        ex.setQueryTest("SELECT  v2,v4,v5,v7,v8,v9,v11,v12,v14,v16,v17,v20,v23,v27,v34,v39,v57,v59,v66,precipitacion FROM cta.originales where year(mes_dia_anio)>1990 order by mes_dia_anio");
        ex.setQueryPrediction("SELECT  v2,v4,v5,v7,v8,v9,v11,v12,v14,v16,v17,v20,v23,v27,v34,v39,v57,v59,v66,precipitacion FROM cta.originales where year(mes_dia_anio)>1990 order by mes_dia_anio");
        ex.setVariablePredecir("precipitacion");
        ex.setNumColumnsOneVariable(12);
        ex.setNumeroPredicciones(0);
        ExperimentType et = new AllVariable();
        ex.setExperimentType(et);
        et.setExperiment(ex);
        Algorithm algorithm = new SVR("Support Vector Regression");
        ex.addAlgorithm(algorithm);
        Configuration c = new Configuration("uno");
        algorithm.addConfiguration(c);
        c.addParameter(new Parameter("-C", "1.0"));
        c.addParameter(new Parameter("-N", "0"));
        c.addParameter(new Parameter("-I", "weka.classifiers.functions.supportVector.RegSMOImproved"));
        c.addParameter(new Parameter("-L", "0.001"));
        c.addParameter(new Parameter("-W", "1"));
        c.addParameter(new Parameter("-P", "1.0E-12"));
        c.addParameter(new Parameter("-T", "0.0010"));
        c.addParameter(new Parameter("-V", ""));
        c.addParameter(new Parameter("-K", "weka.classifiers.functions.supportVector.RBFKernel"));
        c.addParameter(new Parameter("-C", "250007"));
        c.addParameter(new Parameter("-E", "1.0"));
ex.addFilter(new NormalizeVhsg());
        //execute the experiment
        ex.executeExperiment();
        System.out.println(ex.toString());
    }

    public void testNN() {
        Experiment ex = new Experiment("Predicción de Precipitación");
        ex.setUser("root");
        ex.setPassword("soloyose");
        ex.setQueryTrain("SELECT  v2,v4,v5,v7,v8,v9,v11,v12,v14,v16,v17,v20,v23,v27,v34,v39,v57,v59,v66,precipitacion FROM cta.originales where year(mes_dia_anio)<=1980 order by mes_dia_anio");
        ex.setQueryTest("SELECT  v2,v4,v5,v7,v8,v9,v11,v12,v14,v16,v17,v20,v23,v27,v34,v39,v57,v59,v66,precipitacion FROM cta.originales where year(mes_dia_anio)>1980 and year(mes_dia_anio)<=1990  order by mes_dia_anio");
        ex.setQueryPrediction("SELECT  v2,v4,v5,v7,v8,v9,v11,v12,v14,v16,v17,v20,v23,v27,v34,v39,v57,v59,v66,precipitacion FROM cta.originales where year(mes_dia_anio)>1990 order by mes_dia_anio");
        ex.setVariablePredecir("precipitacion");
        ex.setNumColumnsOneVariable(12);
        ex.setNumeroPredicciones(0);
        ExperimentType et = new AllVariable();
        ex.setExperimentType(et);
        et.setExperiment(ex);
        Algorithm algorithm = new NeuralNetwork("Neural Network");
        ex.addAlgorithm(algorithm);
        Configuration c = new Configuration("uno");
        algorithm.addConfiguration(c);
        c.addParameter(new Parameter("-L", "0.3"));
        c.addParameter(new Parameter("-M", "0.2"));
        c.addParameter(new Parameter("-N", "5000"));
        c.addParameter(new Parameter("-V", "0"));
        c.addParameter(new Parameter("-S", "0"));
        c.addParameter(new Parameter("-E", "20"));
        c.addParameter(new Parameter("-H", "10"));    
        //ex.addFilter(new NormalizeVhsg());
        //execute the experiment
        ex.executeExperiment();
        System.out.println(ex.toString());
        Map m =ex.tableResult();
        System.out.println(m);
    }
    
    public Experiment test_SVR_NN(){
       Experiment ex = new Experiment("Predicción de Precipitación");
        ex.setUser("root");
        ex.setPassword("soloyose");
        ex.setQueryTrain("SELECT  v2,v4,v5,v7,v8,v9,v11,v12,v14,v16,v17,v20,v23,v27,v34,v39,v57,v59,v66,precipitacion FROM cta.originales order by mes_dia_anio");
        ex.setQueryTest("SELECT  v2,v4,v5,v7,v8,v9,v11,v12,v14,v16,v17,v20,v23,v27,v34,v39,v57,v59,v66,precipitacion FROM cta.originales order by mes_dia_anio");
        ex.setQueryPrediction("SELECT  v2,v4,v5,v7,v8,v9,v11,v12,v14,v16,v17,v20,v23,v27,v34,v39,v57,v59,v66,precipitacion FROM cta.originales order by mes_dia_anio");

        ex.setVariablePredecir("precipitacion");
        ex.setNumColumnsOneVariable(12);
        ex.setNumeroPredicciones(10);
        ExperimentType et = new OneVariable();
        ex.setExperimentType(et);
        et.setExperiment(ex);
        Algorithm algorithm = new SVR("Support Vector Regression");
        ex.addAlgorithm(algorithm);
        Configuration c = new Configuration("uno");
        algorithm.addConfiguration(c);
        c.addParameter(new Parameter("-C", "1.0"));
        c.addParameter(new Parameter("-N", "0"));
        c.addParameter(new Parameter("-I", "weka.classifiers.functions.supportVector.RegSMOImproved"));
        c.addParameter(new Parameter("-L", "0.001"));
        c.addParameter(new Parameter("-W", "1"));
        c.addParameter(new Parameter("-P", "1.0E-12"));
        c.addParameter(new Parameter("-T", "0.0010"));
        c.addParameter(new Parameter("-V", ""));
        c.addParameter(new Parameter("-K", "weka.classifiers.functions.supportVector.RBFKernel"));
        c.addParameter(new Parameter("-C", "250007"));
        c.addParameter(new Parameter("-E", "1.0"));

        Algorithm algorithm2 = new NeuralNetwork("Neural Network");
        ex.addAlgorithm(algorithm2);
        Configuration c2 = new Configuration("dos");
        algorithm2.addConfiguration(c2);
        c2.addParameter(new Parameter("-L", "0.3"));
        c2.addParameter(new Parameter("-M", "0.2"));
        c2.addParameter(new Parameter("-N", "500"));
        c2.addParameter(new Parameter("-V", "0"));
        c2.addParameter(new Parameter("-S", "0"));
        c2.addParameter(new Parameter("-E", "20"));
        c2.addParameter(new Parameter("-H", "a")); 
        
        
        //execute the experiment
        ex.executeExperiment();
        System.out.println(ex.toString());
        return ex;
    }
}
