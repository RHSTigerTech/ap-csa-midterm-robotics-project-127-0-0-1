// Import hummingbird library
import edu.cmu.ri.createlab.hummingbird.HummingbirdRobot;
import org.json.JSONException;

import java.io.IOException;

public class Robot extends HummingbirdRobot {

    // Constructor to create instance of hummingbirdrobot
    public Robot() {
        super();
    }


    // this method will set motor velocities to go in a forward moving direction
    // takes a percent -100-100 as input
    public void go(int percent) {
        if (percent >= -100 && percent <= 100) {
            this.setMotorVelocity(1,(int)(255.0/100.0) * percent);
            this.setMotorVelocity(2,(int)(255.0/100.0) * percent);
        } else {
            System.err.println("Can only accept values between -100 and 100.");
        }
    }
    
    // rotate around by specified degrees
    //takes a degree from 0 to 360 as input
    public void rotate(int degrees) {
        if(degrees >= 0 && degrees <= 360){
            this.setMotorVelocity(2,(int)((degrees*(255.0/360.0))));
            this.setMotorVelocity(2,-(int)((degrees*(255.0/360.0))));
        } else {
            System.err.println("Can only accept values between 0 and 360.");
        }
    }

    // this method will set motor velocities to 0.
    public void stop() {
        this.setMotorVelocity(1,0);
        this.setMotorVelocity(2,0);
    }

    // this method will stop the robot if it detects something from a specified distance
    // TODO: implement input for lambda functions to be called
    public void detectDistance(int distance, int tolerance) throws InterruptedException
    {
        int lowerLimit = 0;
        if (distance - tolerance >= 0)
            lowerLimit = distance - tolerance;

        // tolerance range for distance values
        for (int i = lowerLimit; i <= distance + tolerance; i++) {
            if (this.getSensorValue(3) == distance) {
                // action after detecting something in the distance

                this.blinkEyes();
            }
        }
    }

    // this method will make the eye leds turn on and off
    public void blinkEyes() throws InterruptedException{
        for(int i = 1; i < 5; i++) {
            this.setLED(i,0);
        }
        for(int i = 1; i < 3; i++) {
            this.setFullColorLED(i,0,0,0);
        }
        Thread.sleep(500);
        for(int i = 1; i < 5; i++) {
            this.setLED(i,255);
        }
        for(int i = 1; i < 3; i++) {
            this.setFullColorLED(i,255,0,0);
        }
    }
    //turns on all 6 eyes
    public void turnOnEyes(){
        for(int i = 1; i < 5; i++) {
            this.setLED(i,255);
        }
        for(int i = 1; i < 3; i++) {
            this.setFullColorLED(i,255,0,0);
        }
    }


    //this method detects light value and increases or decreases brightness
    //of leds based on the sensor value
    public void detectLight(){
        int s = 255 - this.getSensorValue(1);
        for(int i = 1; i < 5; i++) {
            this.setLED(i,s);
        }
        for(int i = 1; i < 3; i++) {
            this.setFullColorLED(i,s,0,0);
        }
    }

    // this method takes a string as input and says it
    public void say(String myStr) {
        this.speak(myStr);
    }
    public String translate(String endLang, String str) throws IOException, JSONException {
        return Translator.translate("en",endLang,str);
    }
    //Repeatedly goes forward for a while and then turns 30 degrees until it hits a wall and it is dark enough
    public void findHidingPlace(){
        boolean spotFound = false;
        while(spotFound == false){
            go(100);
            for(int i = 0; i < 5000; i++) {
                if(this.getSensorValue(2) >= 200 && this.getSensorValue(1) <= 200){
                    stop();
                    rotate(150);
                    spotFound = true;
                    break;
                }
            }
            rotate(30);
        }
    }

    // this method will disconnect from the hummingbird and quit the program
    //public void disconnect() {
    //    this.hBird.disconnect();
    //}

}
