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
        private String name;
        private Chassis base;
        private Ultrasonic eyes;
        private LineSensor floor;

        public Rover(String name) {
            this.name = name;
            this.base = new Chassis();
            this.eyes = new Ultrasonic(base);
            this.floor = new LineSensor(base);
        }

        public void followLine(int steps) {
            boolean lineWasLeft = false;

            for (int i = 0; i < steps; i++) {
                int s = floor.status();

                if (s == 4 || s == 8 || s == 12) {
                    base.turnLeft(4);
                    lineWasLeft = true;

                } else if (s == 1 || s == 2 || s == 3) {
                    base.turnRight(4);
                    lineWasLeft = false;

                } else if (s == 0) {
                    if (lineWasLeft) {
                        base.turnLeft(4);
                    } else {
                        base.turnRight(4);
                    }

                } else {
                    base.straight(1);
                }
            }
        }
    }

