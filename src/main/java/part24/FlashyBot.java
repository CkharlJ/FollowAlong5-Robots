package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4 and 6
//
// SECTION A — FOLLOW ALONG: type the FlashyBot class from the guide.
//    Leave the package, import and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

public class FlashyBot extends MBot2 {
    // Create a constructor for FlashyBot.
    public FlashyBot() {

        // Call the constructor of the parent class.
        super();
    }

    // Override the turnLeft method from MBot2.
    @Override
    public void turnLeft(double degrees) {

        // Print a message showing the left turn.
        System.out.println("Flash! Turning left " + degrees);

        // Turn on LED 1 with a blue color.
        turnLedOn(1, 0, 0, 255);

        // Call the original turnLeft method from MBot2.
        super.turnLeft(degrees);

        // Turn off LED 1 after turning.
        turnLedOff(1);
    }

    // Override the turnRight method from MBot2.
    @Override
    public void turnRight(double degrees) {

        // Print a message showing the right turn.
        System.out.println("Flash! Turning right " + degrees);

        // Turn on LED 1 with a green color.
        turnLedOn(1, 0, 255, 0);

        // Call the original turnRight method from MBot2.
        super.turnRight(degrees);

        // Turn off LED 1 after turning.
        turnLedOff(1);
    }

}