import java.util.Scanner;

public class RobotTester {
    public static void main(String[] args) throws InterruptedException {

        // create instance of Scanner
        Scanner giveMeThe = new Scanner(System.in);

        // create instance of Robot
        Robot robot = new Robot();

        // ask the user for their name
        //System.out.print("Hey what's your name? ");
        // String name = giveMeThe.nextLine();

        // say hi in the chat
        //robot.go(100);
        //Thread.sleep(5000);
        robot.rotate(90);
        Thread.sleep(5000);
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
