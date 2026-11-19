package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 3–6
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and sends it round the box to the goal.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "obstacles")
public class ObstacleRun {
    public static void main(String[] args) {
        // Create a new Rover named Dash.
        Rover rover = new Rover("Dash");
        // Make the rover move toward its goal.
        rover.reachGoal();
        // Print a message when the rover finishes its movements.
        System.out.println(rover + " reached the goal");
    }
}
