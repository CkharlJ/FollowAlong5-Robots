package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 2–8
//
// Part 21 — composition: a Rover HAS-A Chassis and HAS-AN Ultrasonic.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part21;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
//
// SECTION C — STRETCH B adds a LineSensor and two methods to this class.

public class Rover {
    // Create a variable to store the rover's name.
    private String name;
    // Create a variable to control the rover's movement.
    private Chassis base;
    // Create a variable for the ultrasonic sensor.
    private Ultrasonic eyes;
    // Create a variable for the line sensor.
    private LineSensor floor;
    // Create a constructor that receives the rover's name.
    public Rover(String name) {
        // Save the name of the rover.
        this.name = name;
        // Create a new chassis for the rover.
        this.base = new Chassis();
        // Create an ultrasonic sensor connected to the chassis.
        this.eyes = new Ultrasonic(base);
        // Create a line sensor connected to the chassis.
        this.floor = new LineSensor(base);
    }
    // Create a method that describes the rover.
    public String toString() {
        return name + " the rover";
    }
    // Return the rover's name with the words "the rover".
    public boolean somethingAhead(double cm) {
        return eyes.distance() < cm;
    }
    // Create a method to check for objects ahead.
    public void driveUntilBlocked() {
        // Keep moving while no object is closer than 20 cm.
        while (!somethingAhead(20)) {
            // Move the rover forward by 5 cm.
            base.straight(5);
        }
    }
    // Create a method to drive until the rover sees tape.
    public void driveToTape() {
        // Keep moving while the sensor does not detect tape.
        while (!floor.seesTape()) {
            // Move the rover forward by 2 cm.
            base.straight(2);
        }
    }
    // Create a method to move the rover forward.
    public void forward(double cm) {
        base.straight(cm);
    }
}

