// Import hummingbird library
import edu.cmu.ri.createlab.hummingbird.HummingbirdRobot;

public class Robot {

    // Instance Variables
    private HummingbirdRobot hBird;

    // Constructor to create instance of hummingbirdrobot
    public Robot() {
        hBird = new HummingbirdRobot();
    }


    // this method will set motor velocities to go in a forward moving direction
    public void goForward(){
        hBird.setMotorVelocity(1,255);
        hBird.setMotorVelocity(2,-255);
    }

    // this method will set motor velocities to 0.
    public void stop(){
        hBird.setMotorVelocity(1,0);
        hBird.setMotorVelocity(2,0);
    }

    // this method will disconnect from the hummingbird and quit the program
    public void disconnect() {
        this.hBird.disconnect();
    }

}
