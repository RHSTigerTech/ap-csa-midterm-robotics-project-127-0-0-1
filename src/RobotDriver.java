
import org.json.JSONException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RobotDriver {
    public static void main(String[] args) throws InterruptedException, JSONException, IOException {

        // create instance of Scanner
        Scanner giveMeThe = new Scanner(System.in);

        // create instance of Robot
        Robot robot = new Robot();

        // ask the user for their language
        String lang;
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
        if (!lang.equals("en")) {
            Translator.tprintln(lang,"It may take a split second for each line to appear, as the robot has to translate.");
        }
        System.out.println();

        // ask for a mission
        Translator.tprintln(lang,"What do you want me to do?");
        Translator.tprintln(lang,"1. Sing a song in your language");
        Translator.tprintln(lang,"2. Find a good hiding spot");
        Translator.tprintln(lang,"3. You give me something to say");

        // get the user's selection
        int selection = 0;
        do {
            Translator.tprint(lang, "Please make a selection: ");
            try {
                selection = giveMeThe.nextInt();
            } catch (InputMismatchException e) {
                giveMeThe.nextLine();
            }
        } while (selection < 1 || selection > 3);

        // take action on their selection
        System.out.println();
        if (selection == 1) {
            // sing song
        } else if (selection == 2) {
            // find hiding spot
        } else if (selection == 3) {
            // give something for robot to say
            Translator.tprintln(lang,"Okay, what do you want me to say? ");
            String sayThis = giveMeThe.nextLine();
            sayThis = giveMeThe.nextLine();
            if (!lang.equals("en"))
                robot.say(Translator.translate("en", lang, sayThis));
            else
                robot.say(sayThis);
            Thread.sleep(3000);
        }



    }
}
