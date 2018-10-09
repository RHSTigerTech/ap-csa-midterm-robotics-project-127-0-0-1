// Import hummingbird library
import edu.cmu.ri.createlab.hummingbird.HummingbirdRobot;
import org.json.JSONException;

import java.io.IOException;

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
    //takes a degree from 0 to 360 as input
    public void rotate(int degrees) {
        if(degrees >= 0 && degrees <= 360){
            hBird.setMotorVelocity(2,(int)((degrees*(255.0/360.0))));
            hBird.setMotorVelocity(2,-(int)((degrees*(255.0/360.0))));
        } else {
            System.err.println("Can only accept values between 0 and 360.");
        }
    }

    // this method will set motor velocities to 0.
    public void stop() {
        hBird.setMotorVelocity(1,0);
        hBird.setMotorVelocity(2,0);
    }

    // this method will make the eye leds turn on and off
    public void blinkEyes() throws InterruptedException{
        for(int i = 1; i < 5; i++) {
            hBird.setLED(i,0);
        }
        for(int i = 1; i < 3; i++) {
            hBird.setFullColorLED(i,0,0,0);
        }
        Thread.sleep(500);
        for(int i = 1; i < 5; i++) {
            hBird.setLED(i,255);
        }
        for(int i = 1; i < 3; i++) {
            hBird.setFullColorLED(i,255,0,0);
        }
    }
    //turns on all 6 eyes
    public void turnOnEyes(){
        for(int i = 1; i < 5; i++) {
            hBird.setLED(i,255);
        }
        for(int i = 1; i < 3; i++) {
            hBird.setFullColorLED(i,255,0,0);
        }
    }
    //this method detects light value and increases or decreases brightness
    //of leds based on the sensor value
    public void detectLight(){
        int s = 255 - hBird.getSensorValue(1);
        for(int i = 1; i < 5; i++) {
            hBird.setLED(i,s);
        }
        for(int i = 1; i < 3; i++) {
            hBird.setFullColorLED(i,s,0,0);
        }
    }

    // this method takes a string as input and says it
    public void say(String myStr) {
        hBird.speak(myStr);
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
                if(hBird.getSensorValue(2) >= 200 && hBird.getSensorValue(1) <= 200){
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
    public void disconnect() {
        this.hBird.disconnect();
    }

}
