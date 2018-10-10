import java.util.Scanner;

public class RobotTester {
    public static void main(String[] args) throws InterruptedException {

        // create instance of Scanner
        Scanner giveMeThe = new Scanner(System.in);

        // create instance of Robot
        Robot robot = new Robot();

        // testing

        for (int i = 1; i <= 100; i++)
        {
            robot.detectLight();
            Thread.sleep(100);

        }



    }
}
