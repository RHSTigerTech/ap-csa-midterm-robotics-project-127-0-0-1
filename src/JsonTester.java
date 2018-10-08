
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import java.util.Scanner;

public class JsonTester {
    public static void main(String [] args) throws IOException, JSONException {

        Scanner scan = new Scanner(System.in);

        System.out.print("Start lang: ");
        String startlang = scan.nextLine();

        System.out.print("Destination lang: ");
        String destlang = scan.nextLine();

        System.out.print("String: ");
        String txt = scan.nextLine();


        String url = "http://translate.googleapis.com/translate_a/single?client=gtx&sl="+startlang+"&tl="+destlang+"&dt=t&q="+txt;
        JSONObject output = Translator.readJsonFromUrl(url);
        System.out.println(output);

    }
}
