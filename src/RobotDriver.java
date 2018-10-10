
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

        // turn on the eyes
        robot.turnOnEyes();

        // ask the user for their language
        String lang = UI.askForLanguage();

        // ask user for their name
        String name = UI.tPromptString(lang,"What's your name?");

        // say hi in the chat
        System.out.println();
        UI.tprintln(lang,"Hello, " + name + "!");
        UI.tprintln(lang,"I am speaking in the language that you selected!");
        if (!lang.equals("en")) {
            UI.tprintln(lang,"It may take a split second for each line to appear, as the robot has to translate.");
        }
        System.out.println();

        // ask for a mission
        UI.tprintln(lang,"What do you want me to do?");
        UI.tprintln(lang,"1. Sing a song in your language");
        UI.tprintln(lang,"2. Find a good hiding spot");
        UI.tprintln(lang,"3. You give me something to say");

        // get the user's selection
        int selection = UI.tSelectionInt(lang, 3);

        // take action on their selection
        System.out.println();
        if (selection == 1) {
            // sing song
            UI.tprintln(lang, "Happy Birthday to You, cha, cha, cha.\n" +
                    "Happy Birthday to You, cha, cha, cha.\n" +
                    "Happy Birthday Dear " + name +
                    "\nHappy Birthday to You, cha, cha, cha.");
            robot.say(Translator.translate("en",lang,"Happy Birthday to You, cha, cha, cha.\n" +
                    "Happy Birthday to You, cha, cha, cha.\n" +
                    "Happy Birthday Dear " + name +
                    "\nHappy Birthday to You, cha, cha, cha."));
        } else if (selection == 2) {
            // find hiding spot
        } else if (selection == 3) {
            // give something for robot to say
            UI.tprintln(lang,"Okay, what do you want me to say? ");
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
