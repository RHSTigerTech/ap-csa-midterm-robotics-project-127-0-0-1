
import org.json.JSONException;
import java.io.IOException;

import java.util.Scanner;

public class JsonTester {
    public static void main(String [] args) throws IOException, JSONException {

        Scanner scan = new Scanner(System.in);

        System.out.print("Start lang: ");
        String src = scan.nextLine();

        System.out.print("Destination lang: ");
        String dest = scan.nextLine();

        System.out.print("String: ");
        String txt = scan.nextLine();

        System.out.println(Translator.translate(src, dest, txt));

    }
}
