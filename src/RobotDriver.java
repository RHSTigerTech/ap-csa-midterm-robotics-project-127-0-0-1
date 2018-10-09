
import java.util.Scanner;

public class RobotDriver {
    public static void main(String[] args) throws InterruptedException {

        // create instance of Scanner
        Scanner giveMeThe = new Scanner(System.in);

        // create instance of Robot
        Robot robot = new Robot();

        // ask the user for their name
        //System.out.print("Hey what's your name? ");
       // String name = giveMeThe.nextLine();

        // say hi in the chat
        System.out.println();
        //System.out.println("Hello, " + name + "!");
        robot.turnOnEyes();
        Thread.sleep(10000);
        robot.blinkEyes();
        Thread.sleep(10000);
        robot.disconnect();
        // test motors
        /*
        robot.go(100);
        Thread.sleep(25000);
        robot.rotate(90);
        robot.go(100);
        Thread.sleep(25000);
        robot.stop();
        */
    }
}
