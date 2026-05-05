import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws Exception {
        StringConcat obj = (StringConcat) Naming.lookup("rmi://localhost:5000/concat");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String a = sc.nextLine();

        System.out.print("Enter second string: ");
        String b = sc.nextLine();

        System.out.println("Result: " + obj.concat(a, b));
    }
}