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
            this.setMotorVelocity(1,-(int)(255.0/100.0) * percent);
            this.setMotorVelocity(2,-(int)(255.0/100.0) * -percent);
        } else {
            System.err.println("Can only accept values between -100 and 100.");
        }
    }
    
    // rotate around by specified degrees
    //takes a degree from 0 to 360 as input
    public void rotate() {
        this.setMotorVelocity(1,255);
        this.setMotorVelocity(2,255);
    }

    // this method will set motor velocities to 0.
    public void stop() {
        this.setMotorVelocity(1,0);
        this.setMotorVelocity(2,0);
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
        int s = 255 - 3* this.getSensorValue(1);
        if (s < 30)
            s = 30;
        // System.out.println(this.getSensorValue(1));
        for(int i = 1; i < 5; i++) {
            this.setLED(i, s);
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
    //Repeatedly goes forward for a while and then turns 30 degrees until it is dark enough
    public void findHidingPlace(){
        boolean spotFound = false;
        while(spotFound == false){
            go(100);
            for(int i = 0; i < 5000; i++) {
                if(this.getSensorValue(1) <= 30){
                    stop();
                    rotate();
                    spotFound = true;
                    break;
                }
            }
            rotate();
        }
        stop();
    }

    // this method will disconnect from the hummingbird and quit the program
    //public void disconnect() {
    //    this.hBird.disconnect();
    //}

}
