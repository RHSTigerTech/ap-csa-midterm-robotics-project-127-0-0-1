
import org.json.JSONException;

import java.io.IOException;
import java.util.Scanner;

public class RobotDriver {
    public static void main(String[] args) throws InterruptedException, JSONException, IOException {

        // create instance of Scanner
        Scanner giveMeThe = new Scanner(System.in);

        // create instance of Robot
        //Robot robot = new Robot();

        // ask the user for their language
        String lang = "no";
        System.out.println("What language do you want the robot to speak?");
        for (String language : Translator.getLanguages()) {
            System.out.println(Translator.getLanguageCode(language) + " - " + language + " (" + Translator.getLanguageInLang(language) + ")");
        }
        do {
            System.out.print("Please enter the 2 character language code: ");
            lang = giveMeThe.nextLine();
        } while (Translator.getLanguageName(lang).equals("Language not found"));

        // ask user for their name
        Translator.tprint(lang,"What's your name? ");
        String name = giveMeThe.nextLine();

        // say hi in the chat
        System.out.println();
        Translator.tprintln(lang,"Hello, " + name + "!");
        Translator.tprintln(lang,"I am speaking in the language that you selected!");



    }
}
