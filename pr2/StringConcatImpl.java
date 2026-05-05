import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringConcatImpl extends UnicastRemoteObject implements StringConcat {
    public StringConcatImpl() throws RemoteException {
        super();
    }

    public String concat(String a, String b) throws RemoteException {
        return a + b;
    }
}
