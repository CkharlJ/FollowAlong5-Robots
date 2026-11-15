package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4–7 (overriding, and polymorphism)
//
// SECTION C — Stretch. Do Stretch A, then Stretch B. The README says what each one should print.
// Stretch B also changes CarefulBot.java, FlashyBot.java and Mission.java.
//
// There is no main method here yet. Typing it is part of the stretch.

@MBotLab(world = "open-room")
public class Stretch {
    public static void main(String[] args) {

        MBot2 a = new FlashyBot();
        Chassis c = a;

        a.straight(10);
        c.turnLeft(90);
        /* MY GUESS
        The line will be print true
         */

        /* MY GUESS
        c.turnLeft(90) will use FlashyBot's turnLeft().
          a.straight(10) will use FlashyBot's straight()
          if FlashyBot overrides it; otherwise it uses
          the inherited implementation.
         */
        System.out.println(a == c);

        System.out.println(a);
    }

}// With pick = 3 , the first line will be printed out a mbot 2 object.
// cause it does not use the toString overrides from
// * CarefulBot or FlashyBot.
