// Import hummingbird library
import edu.cmu.ri.createlab.hummingbird.HummingbirdRobot;

public class Robot extends HummingbirdRobot {

    // create instance of hummingbirdrobot so we can control it within the class
    private HummingbirdRobot hBird = new HummingbirdRobot();

    // Instance Variables go here


    // Methods go here


    // this method will disconnect from the hummingbird and quit the program
    public void disconnect() {
        this.hBird.disconnect();
    }

}
