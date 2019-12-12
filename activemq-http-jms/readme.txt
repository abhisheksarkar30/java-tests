Replace the below line in apache-activemq-x.xx.x\conf\activemq.xml:

<transportConnector name="openwire" uri="tcp://0.0.0.0:61616?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>

with the given line below:

<transportConnector name="http" uri="http://0.0.0.0:61616?maximumConnections=1000&amp;wireFormat.maxFrameSize=104857600"/>

Restart ActiveMQ