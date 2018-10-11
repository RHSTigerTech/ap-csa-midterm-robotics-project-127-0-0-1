
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
        String name = UI.tPromptString(lang, "What's your name?");
        name = name.toUpperCase().charAt(0) + name.substring(1, name.length());

        // say hi in the chat
        System.out.println();
        UI.tprintln(lang, "Hello, " + name + "!");
        UI.tprintln(lang, "I am speaking in the language that you selected!");
        if (!lang.equals("en")) {
            UI.tprintln(lang, "It may take a split second for each line to appear, as the robot has to translate.");
        }
        System.out.println();

        // ask for something to do
        int selection = 0;
        while (selection != 6) {
            UI.tprintln(lang, "What do you want me to do?");
            UI.tprintln(lang, "1. Sing a song in your language");
            UI.tprintln(lang, "2. Find a good hiding spot");
            UI.tprintln(lang, "3. You give me something to say");
            UI.tprintln(lang, "4. Donut mode");
            UI.tprintln(lang, "5. Adjust eyes to the light");
            UI.tprintln(lang, "6. Stop Robot");

            // get the user's selection
            selection = UI.tSelectionInt(lang, 6);

            // take action on their selection
            System.out.println();
            if (selection == 1) {
                // sing song
                UI.tprintln(lang, "Happy Birthday to You.\n" +
                        "Happy Birthday to You.\n" +
                        "Happy Birthday Dear " + name +
                        "\nHappy Birthday to You, cha, cha, cha.");
                robot.say(Translator.translate("en", lang, "Happy Birthday to You.\n" +
                        "Happy Birthday to You.\n" +
                        "Happy Birthday Dear " + name +
                        "\nHappy Birthday to You, cha, cha, cha."));
                Thread.sleep(10000);

            } else if (selection == 2) {
                // find hiding spot
                robot.findHidingPlace();
                // blink eyes for 3 seconds
                for (int i = 1; i <= 3; i++) {
                    robot.blinkEyes();
                }

            } else if (selection == 3) {
                // give something for robot to say
                UI.tprintln(lang, "Okay, what do you want me to say? ");
                String sayThis = giveMeThe.nextLine();
                if (!lang.equals("en"))
                    robot.say(Translator.translate("en", lang, sayThis));
                else
                    robot.say(sayThis);
                Thread.sleep(3000);

            } else if (selection == 4) {
                // Rotate around in circles
                robot.rotate();
                UI.tprintln(lang, "Spinning for 8 seconds!");
                robot.say("WEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
                Thread.sleep(8000);
                robot.stop();
                robot.say("Wow, I am dizzy.");
                Thread.sleep(3000);

            } else if (selection == 5) {
                // Adjusts LEDs to the light
                for (int i = 1; i <= 100; i++) {
                    robot.detectLight();
                    Thread.sleep(100);
                }
            }
        }

    }
}
