package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–5
//
// Part 23 — inheritance: your own robot class, built on top of MBot2.
//
// SECTION A — FOLLOW ALONG: type the Scout class from the guide.
//    Step 1 changes the class line below: that is the one line you DO change.
//    Leave the "package part23;" line and the "import mbot.*;" line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

public class Scout extends MBot2 {
    // Store the scout's name.
    private String name;
    // Store the scanner used to check surrounding distances.
    private Scanner scanner;
    // Create a constructor that receives the scout's name.
    public Scout(String name) {
        // Call the constructor of the parent class.
        super();
        // Save the scout's name.
        this.name = name;
        // Create a scanner connected to this scout.
        this.scanner = new Scanner(this);
    }
    // Create a method to drive until an obstacle is close.
    public int driveUntilBlocked() {
        // Create a counter to count the number of moves.
        int moves = 0;
        // Keep moving while the obstacle is more than 25 cm away.
        while (readUltrasonic() > 25) {
            // Move the scout forward by 5 cm.
            straight(5);
            // Increase the move counter by one.
            moves++;
        }
        // Return the total number of moves.
        return moves;
    }
    // Create a method to find the direction with the most space.
    public int openestIndex() {
        // Scan the surroundings and store the distances in an array.
        double[] d = scanner.scan();
        // Start by assuming the first distance is the largest.
        int best = 0;
        // Check every remaining distance in the array.
        for (int i = 1; i < d.length; i++) {
            // Check if the current distance is larger than the best one.
            if (d[i] > d[best]) {
                // Save the index of the larger distance.
                best = i;
            }
        }
        // Return the index of the largest distance.
        return best;
    }
    // Create a method to turn toward the most open direction.
    public void turnTowardOpenSide() {
        // Find the index of the most open direction.
        int i = openestIndex();
        // Check if the angle of that direction is positive.
        if (Scanner.ANGLES[i] > 0) {
            // Turn the scout 90 degrees to the left.
            turnLeft(90);
            // Run this if the angle is zero or negative.
        } else {
            // Turn the scout 90 degrees to the right.
            turnRight(90);
        }
    }
    // Create a method to describe the scout.
    public String toString() {
        // Return the scout's name followed by "the scout".
        return name + " the scout";
    }
}
