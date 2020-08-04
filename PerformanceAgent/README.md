# Performance Agent

## Introduction 

This tool is very much beneficial for automated logging of JVM processes without code change.</br>
It is basically a java agent designed for analysing performance of java processes.

## Configuration
Put proper configuration in config.properties file. A unique part of the complete cannonical name of each class to be logged, can be given there, comma-separated.

## Prerequisites
JAVA 7+

## Usage

From within apps directory, please follow:- </br>
### Hotlinking

For realtime addition of agent to an active java process:
1. Start the test.jar(test application to log) using below command:- </br>
	***java -jar test.jar***
	
2. Attach the agent to the test.jar jvm process using below command:- </br>
	***java -jar LaunchAgent.jar test.jar*** </br>
P.S: Here test.jar can be replaced by any unqiue part of the target jvm process shown by **jps -ml**
	
### Attaching at Startup

For addition of agent at startup of a java process
1. Sart the target application itself using below comand:- </br>
	***java -javaagent:/full/path/to/agent.jar -jar test.jar*** </br>
  
## Notes to follow

1. If while hotlinking, failed to initialize/attach the agent, refer to target application logs.
2. If agent fails to attach/initialize, either rename the agent to retry with same jvm PID, or else restart the target app and then retry to attach.
3. config.properties file to be kept at location from where the java app is executed for addition at startup.
4. Please add '-XX:-UseSplitVerifier' when executing target app, if agent initialization fails due to following error: </br>
  Caused by: java.lang.VerifyError </br>
at sun.instrument.InstrumentationImpl.retransformClasses0(Native Method) </br>
at sun.instrument.InstrumentationImpl.retransformClasses(InstrumentationImpl.java:144) </br>
