package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 3, 5 and 6
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Scout and sends it through the junctions to the goal.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "junctions")
public class Explore {
    public static void main(String[] args) {
        // Create a new Scout named Pathfinder.
        Scout scout = new Scout("Pathfinder");
        // Repeat the movement process for three legs.
        for (int leg = 1; leg <= 3; leg++) {
            // Drive until an obstacle is close and count the moves.
            int moves = scout.driveUntilBlocked();
            // Print the leg number and the number of moves.
            System.out.println("Leg " + leg + ": " + moves + " moves");
            // Check if the scout has not finished the third leg.
            if (leg < 3) {
                // Turn toward the direction with the most open space.
                scout.turnTowardOpenSide();
            }
        }
        // Print a message saying the scout reached the goal.
        System.out.println(scout + " reached the goal");
    }
}
