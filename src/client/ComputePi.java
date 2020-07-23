package client;

import compute.Compute;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputePi {
    public static void main(String[] args){
        if(System.getSecurityManager()==null)
            System.setSecurityManager(new SecurityManager());

        String name = "Compute";
        try {
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute compute = (Compute) registry.lookup(name);
            Pi task = new Pi(Integer.parseInt(args[1]));
            BigDecimal pi = compute.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
            System.out.println("Compute Pi exception");
            e.printStackTrace();
        }
    }
}
