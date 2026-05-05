import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String args[]) throws Exception {

        try {
            LocateRegistry.createRegistry(5000);
        } catch (Exception e) {
            // Registry already exists, continue
        }

        StringConcatImpl obj = new StringConcatImpl();
        Naming.rebind("rmi://localhost:5000/concat", obj);

        System.out.println("Server ready...");
    }
}