Repository Researches
==========================================================================================

It is a platform to execute experiments of data/text mining regardless the platform. The platform is under development, for now support clustering and the following algorithms:

  * WEKA
    - Kmeans
    - EM
    - Hierarchical Clusterer

  * Apache Mahout
    - Kmeans

Building the Source
--------------------

You could build using maven:

  mvn clean package
  
Or the code is been implemented in Netbeans IDE 8.0.2 (here just clone the code and execute).

Running the Examples
---------------------

There is some experiments built. For now you could execute some experiments under WEKA [1] or Apache Mahout [2]. 

[1] https://github.com/cuent/repositorio.investigadores/blob/master/src/main/java/edu/uc/investigadores/dm/main/Test.java
[2] https://github.com/cuent/repositorio.investigadores/blob/master/src/main/java/edu/uc/investigadores/dm/main/TestMahout.java
