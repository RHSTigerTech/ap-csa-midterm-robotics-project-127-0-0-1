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
    // takes a percent -100-100 as input
    public void go(int percent) {
        if (percent >= -100 && percent <= 100) {
            hBird.setMotorVelocity(1,(int)(255.0/100.0) * percent);
            hBird.setMotorVelocity(2,(int)(255.0/100.0) * percent);
        } else {
            System.err.println("Can only accept values between -100 and 100.");
        }
    }
    
    // rotate around by specified degrees
    public void rotate(int degrees) {
        // implement this during class with trial and error
        // best way to program duh
    }

    // this method will set motor velocities to 0.
    public void stop() {
        hBird.setMotorVelocity(1,0);
        hBird.setMotorVelocity(2,0);
    }

    // this method will make the eye leds turn on and off
    public void blinkEyes() {
        // to be implemented
    }

    // this method will disconnect from the hummingbird and quit the program
    public void disconnect() {
        this.hBird.disconnect();
    }

}
