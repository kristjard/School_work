package hello;
import java.util.Scanner;

public class GetInput {

    public static String getInput() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your name");

        String name = myObj.nextLine();

        return name;
    }
}


