package engine;

import compute.Compute;
import compute.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine implements Compute {
    public ComputeEngine() {
        super();
    }

    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        return t.execute();
    }

    public static void main(String[] args){
        if(System.getSecurityManager()==null)
            System.setSecurityManager(new SecurityManager());

        String name = "Compute";
        Compute engine = new ComputeEngine();
        try {
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine,0);
            Registry registry1 = LocateRegistry.createRegistry(1099);
            // TODO: 7/23/20 find out why there are problems when using getRegistry()
            //  and start a service using rmiregistry
            //Registry registry = LocateRegistry.getRegistry();
            registry1.rebind(name,stub);
            System.out.println("Compute Engine bound");
        } catch (RemoteException e) {
            System.out.println("Compute Engine Exception");
            e.printStackTrace();
        }
    }
}

