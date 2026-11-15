package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 7–9 (the line sensor's numbers, and followLine)
//
// SECTION C — Stretch. Do Stretch A, then Stretch B. The README says what each one should print.
// Stretch B adds a new class, Lapper, at the bottom of this file.
//
// There is no main method here yet. Typing it is part of the stretch.

@MBotLab(world = "line-track")
public class Stretch {
    public static void main(String[] args) {
        int[] readings = {6, 12, 3, 0};
        for (int s : readings) {
            if (s == 4 || s == 8 || s == 12) {
                /* MY GUESS
                It will be printed out 6: straight
                 */
                System.out.println(s + ": turn left");
            } else if (s == 1 || s == 2 || s == 3) {
                /* MY GUESS
                It will be printed out 12: turn left
                 */
                System.out.println(s + ": turn right");
            } else if (s == 0) {
                /* MY GUESS
                it will be printed 3: right
                 */
                System.out.println(s + ": lost it");
            } else {
                /* MY GUESS
                0: lost it
                 */
                System.out.println(s + ": straight");
            }
        }

        Lapper lapper = new Lapper(new Rover("Loop"));
        lapper.laps(2);
    }
}

class Lapper {
    private Rover rover;
    private int done;
    public Lapper(Rover rover) {
        this.rover = rover;
        this.done = 0;
    }

    public void laps(int n) {
        for (int i = 0; i < n; i++) {
            rover.followLine(725);
            done++;
            System.out.println("Lap " + done + " done");
        }
    }
}

/*
STRETCH B3:
Lapper takes a Rover as a parameter I think  the caller can
choose which Rover to use and decide its name.
That could make Lapper more flexible and reusable.
*/
