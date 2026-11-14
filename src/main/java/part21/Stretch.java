package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 5–9 (the line sensor works the same way as the ultrasonic)
//
// SECTION C — Stretch. Do Stretch A, then Stretch B. The README says what each one should print.
// Stretch B also adds a LineSensor and two methods to your Rover class.
//
// There is no main method here yet. Typing it is part of the stretch.

@MBotLab(world = "parking")
public class Stretch {
    public static void main(String[] args) {
        Rover ada = new Rover("Ada");
        /* MY GUESS
        it will print Ada
        // I didn't know the Rover rule.
         */
        System.out.println(ada);
        /* MY GUESS
        it will be printed out true
         */
        System.out.println(ada.somethingAhead(500));
        /* MY GUESS
        It will be printed out false
         */
        System.out.println(ada.somethingAhead(5));


        ada.driveToTape();
        System.out.println("Found the tape");
        ada.forward(30);
        System.out.println(ada + " is parked");
    }

}

