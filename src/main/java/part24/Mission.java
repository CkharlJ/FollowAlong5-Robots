package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 2, 5 and 7
//
// SECTION A — FOLLOW ALONG: type the mission method and the main method from the guide.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "wall-ahead")
public class Mission {
    // Create a method that runs a mission using an MBot2.
    public static void mission(MBot2 bot) {
        // Print a message showing the start of the mission.
        System.out.println("Mission start: " + bot);
        // Run the selected robot's mission.
        bot.run();
        // Print a message showing the end of the mission.
        System.out.println("Mission done: " + bot);
    }
    // This is where the program starts running.
    public static void main(String[] args) {
        // Create a variable to choose which robot to use.
        int pick = 3;
        // Declare a variable that can store an MBot2 object.
        MBot2 bot;
        // Check if the selected robot is number 1.
        if (pick == 1) {
            // Create a new CarefulBot.
            bot = new CarefulBot();
            // Check if the selected robot is number 2.
        } else if (pick == 2) {
            // Create a new FlashyBot.
            bot = new FlashyBot();
            // Run this if the selected number is not 1 or 2.
        } else {
            // Create a regular MBot2.
            bot = new MBot2();
        }
        // Call the mission method using the selected robot.
        mission(bot);
    }
}

