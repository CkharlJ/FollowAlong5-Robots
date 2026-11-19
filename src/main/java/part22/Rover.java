package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–9
//
// Part 22 — behaviors: methods that use the sensors to decide what the robot does.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part22;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

public class Rover {
    // Store the rover's name.
    private String name;
    // Store the chassis used to move the rover.
    private Chassis base;
    // Store the ultrasonic sensor used to detect objects.
    private Ultrasonic eyes;
    // Store the line sensor used to detect lines.
    private LineSensor floor;
    // Remember if the line was last detected on the left.
    private boolean lineWasLeft;
    // Create a constructor that receives the rover's name.
    public Rover(String name) {
        // Save the rover's name.
        this.name = name;
        // Create a new chassis for the rover.
        this.base = new Chassis();
        // Create an ultrasonic sensor connected to the chassis.
        this.eyes = new Ultrasonic(base);
        // Create a line sensor connected to the chassis.
        this.floor = new LineSensor(base);
    }
    // Create a method that drives until an object is close.
    public int driveUntilBlocked(double cm) {
        // Create a counter to count how many moves are made.
        int moves = 0;
        // Keep moving while the object is farther than cm.
        while (eyes.distance() > cm) {
            // Move the rover forward by 5 cm.
            base.straight(5);
            // Increase the move counter by one.
            moves++;
        }
        // Return the total number of moves.
        return moves;
    }
    // Create a method to move around an obstacle on the left.
    public void goAroundLeft(double sideways) {
        // Turn the rover 90 degrees to the left.
        base.turnLeft(90);
        // Move forward by the given sideways distance.
        base.straight(sideways);
        // Turn the rover 90 degrees to the right.
        base.turnRight(90);
    }
    // Create a method to guide the rover toward its goal.
    public void reachGoal() {
        // Drive until an object is within 15 cm and count the moves.
        int first = driveUntilBlocked(15);
        // Print how many moves were made before the first obstacle.
        System.out.println("Blocked after " + first + " moves. Going round.");
        // Move around the obstacle using a 60 cm detour.
        goAroundLeft(60);
        // Drive until another object is within 15 cm.
        int second = driveUntilBlocked(15);
        // Print how many moves were made before the second obstacle.
        System.out.println("Blocked after " + second + " moves. That is the far wall.");
        // Turn the rover 90 degrees to the right.
        base.turnRight(90);
        // Move the rover forward by 50 cm.
        base.straight(50);
    }
    // Create a method to follow a line for a set number of steps.
    public void followLine(int steps) {
        // Repeat the line-following process for the given steps.
        for (int i = 0; i < steps; i++) {
            // Read the current status of the line sensor.
            int s = floor.status();
            // Check if the line is detected on the left.
            if (s == 4 || s == 8 || s == 12) {
                // Turn the rover slightly to the left.
                base.turnLeft(4);
                // Remember that the line was on the left.
                lineWasLeft = true;
                // Check if the line is detected on the right.
            } else if (s == 1 || s == 2 || s == 3) {
                // Turn the rover slightly to the right.
                base.turnRight(4);
                // Remember that the line was on the right.
                lineWasLeft = false;
                // Check if the line is no longer detected.
            } else if (s == 0) {
                // Check if the line was last seen on the left.
                if (lineWasLeft) {
                    // Turn left to try to find the line again.
                    base.turnLeft(4);
                    // Run this if the line was last seen on the right.
                } else {
                    // Turn right to try to find the line again.
                    base.turnRight(4);
                }
                // Run this if none of the previous conditions match.
            } else {
                // Move the rover forward by 1 cm.
                base.straight(1);
            }
        }
    }

    public String toString() {
        return name + " the rover";
    }
}
