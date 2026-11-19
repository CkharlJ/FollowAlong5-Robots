package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–3 and 6
//
// Part 24 — overriding: your robot keeps a method's name, but changes what it does.
//
// SECTION A — FOLLOW ALONG: type the CarefulBot class from the guide.
//    Leave the "package part24;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

public class CarefulBot extends MBot2 {
    // Create a constructor for CarefulBot.
    public CarefulBot() {

        // Call the constructor of the parent class.
        super();
    }

    // Override the straight method from MBot2.
    @Override
    public void straight(double cm) {

        // Check if there is enough space to move safely.
        if (readUltrasonic() > cm + 20) {

            // Call the original straight method from MBot2.
            super.straight(cm);

            // Run this if an obstacle is too close.
        } else {

            // Turn on LED 1 with a red color.
            turnLedOn(1, 255, 0, 0);

            // Print a message explaining why the robot cannot move.
            System.out.println("CarefulBot: not driving " + cm + " cm, too close");
        }
    }

    // Override the run method from MBot2.
    @Override
    public void run() {

        // Repeat the movement attempt five times.
        for (int i = 0; i < 5; i++) {

            // Try to move the robot forward by 40 cm.
            straight(40);
        }
    }
}