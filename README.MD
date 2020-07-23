This a tutorial about how to use java remote method invocation. You can find complete  
tutorial at https://docs.oracle.com/javase/tutorial/rmi/.



run the server with this command:
 java -cp /home/saeid/src:/home/saeid/classes/compute.jar
  -Djava.rmi.server.codebase=http://127.0.0.1:8887/compute.jar
  -Djava.security.policy=/home/saeid/RMI/client.policy
   client.ComputePi localhost 
   
run the client whit this command:
java -cp /home/jones/src:/home/jones/public_html/classes/compute.jar
   -Djava.rmi.server.codebase=http://127.0.0.1:8887/classes/
   -Djava.security.policy=client.policy
    client.ComputePi localhost 45
