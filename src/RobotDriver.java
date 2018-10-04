
public class RobotDriver {
    public static void main(String[] args) throws InterruptedException {

        // create instance of Robot
        Robot robot = new Robot();

        // test motors
        robot.goForward();
        Thread.sleep(5000);
        robot.stop();

    }
}
