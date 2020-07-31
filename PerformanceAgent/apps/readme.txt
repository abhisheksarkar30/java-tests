To test the project:----

--------------------------For realtime addition of agent to an active java process--------------------------
1. Start the test.jar using below command:-
	java -jar test.jar
	
2. Attach the agent to the test.jar jvm process using below command:-
	java -jar LaunchAgent.jar test.jar
	
--------------------------For addition of agent at startup of a java process--------------------------
1. Sart the target application using below comand:-
	java -javaagent:/full/path/to/agent.jar -jar test.jar