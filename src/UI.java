import org.json.JSONException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
  
    // identical to println() but instead translates the input
    public static void tprintln(String lang, String text) throws JSONException, IOException {
        if (lang.equals("en")) {
            System.out.println(text);
        } else {
            System.out.println(Translator.translate("en", lang, text));
        }
    }

    // identical to print() but instead translates the input
    public static void tprint(String lang, String text) throws JSONException, IOException {
        if (lang.equals("en")) {
            System.out.print(text);
        } else {
            System.out.print(Translator.translate("en", lang, text));
        }
    }

    // this method prints out all the available languages and asks the user to select one
    public static String askForLanguage() {
        Scanner giveMeThe = new Scanner(System.in);
        String lang;
        System.out.println("What language do you want the robot to speak?");
        for (String language : Translator.getLanguages()) {
            System.out.println(Translator.getLanguageCode(language) + " - " + language + " (" + Translator.getLanguageInLang(language) + ")");
        }
        do {
            System.out.print("Please enter the 2 character language code: ");
            lang = giveMeThe.nextLine();
        } while (Translator.getLanguageName(lang).equals("Language not found"));
        return lang;
    }

    // this method will prompt for input and then return that input from the user
    // it translates the prompt to the user's language
    public static String tPromptString(String lang, String prompt) throws JSONException, IOException {
        Scanner giveMeThe = new Scanner(System.in);
        if (!lang.equals("en"))
            tprint(lang, prompt);
        else
            System.out.print(prompt);
        return giveMeThe.nextLine();
    }

    // this method prompts the user to make a selection between 1 and max
    // translates prompt to users' language
    public static int tSelectionInt(String lang, int max) throws JSONException, IOException {
        Scanner giveMeThe = new Scanner(System.in);
        int selection = 0;
        do {
            if (!lang.equals("en"))
                tprint(lang, "Please make a selection: ");
            else
                System.out.print("Please make a selection: ");
            try {
                selection = giveMeThe.nextInt();
            } catch (InputMismatchException e) {
                giveMeThe.nextLine();
            }
        } while (selection < 1 || selection > max);
        return selection;
    }
  
}
