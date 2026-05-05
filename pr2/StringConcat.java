import java.rmi.*;

public interface StringConcat extends Remote {
    String concat(String a, String b) throws RemoteException;
}