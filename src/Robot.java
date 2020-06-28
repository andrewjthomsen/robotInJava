import java.util.Arrays;

public class Robot {
    // 3 private data members: x variable, y variable, and payload variable

    private int x;
    private int y;
    private char payload;
    // Declaring grid class variable
    private static final int XSIZE = 25;
    private static final int YSIZE = 25;
    private static final char[][] grid = new char[XSIZE][YSIZE];

    // constructor for Robot class to house public content
    // No parameters needed for default constructor
    public Robot() {
        x = 0;
        y = 0;
        payload = ' ';
        for (char[] arr : grid) {// enhanced for loop
            Arrays.fill(arr, ' ');
        }
    }

    public Robot(int x, int y, char payload) {
        // Must use this operator to identify the current object data members
        this.x = x;
        this.y = y;
        this.payload = payload;
    }

    // setter and getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getPayload() {
        return payload;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPayload(char payload) {
        this.payload = payload;
    }

    // function that prints out location of robot and load status
    public void print() {
        // Ternary conditional used to print the payload or empty if nothing in it.
        System.out.println("Location: (" + x + "," + y + ") " +
                "Load: " + (payload != ' ' ? payload : "Empty"));
    }

    // Function for picking up load
    public boolean pickup(int lx, int ly) {
        // Examines current location of robot and if at location of pickup
        if (x != lx || y != ly) {
            System.out.println("Not at location: (" + lx + "," + ly + ")");
            return false;
        }
        // If load is at location or not
        if (grid[lx][ly] == ' ') {
            System.out.println("No load at this location.");
            return false;
        }
        // If payload is empty then pickup load
        if (payload != ' ') {
            return false;
        }
        payload = grid[lx][ly];
        grid[lx][ly] = ' ';
        return true;
    }

    public boolean dropOff(int lx, int ly) {
        // Return false if robot not at drop off location
        if (x != lx || y != ly) {
            System.out.println("Not at location: (" + lx + "," + ly + ")");
            return false;
        }
        // return false if robot has no payload to drop off
        if (payload == ' ') {
            return false;
        }
        grid[lx][ly] = payload;
        payload = ' ';
        return true;
    }

    public void moveRight() {
        // Checks if the grid boundary has been reached
        if (x == XSIZE - 1) {
            System.out.println("Right boundary reached.");
        } else {
            x++;
        }
    }

    public void moveLeft() {
        // Checks if the grid boundary has been reached
        if (x == 0) {
            System.out.println("Left boundary reached.");
        } else {
            x--;
        }
    }

    public void moveUp() {
        // Checks if the grid boundary has been reached
        if (y == 0) {
            System.out.println("Top boundary reached.");
        } else {
            y--;
        }
    }

    public void moveDown() {
        // Checks if the grid boundary has been reached
        if (y == YSIZE - 1) {
            System.out.println("Bottom boundary reached.");
        } else {
            y++;
        }
    }

    public boolean moveTo(int lx, int ly) {
        if (lx < 0 || lx > XSIZE - 1 || ly < 0 || ly > YSIZE - 1) {
            return false;
        } else {
            // No matter what will give us the amount of moves it has to make
            // Regardless of whether its left or right
            while (Math.abs(x - lx) != 0) {
                // Handles both x coordinate movements
                if (x > lx) {
                    moveLeft();
                } else {
                    moveRight();
                }
            }
            while (Math.abs(y - ly) != 0) {
                //Handles both x coordinate movements
                if (y > ly) {
                    moveUp();
                } else {
                    moveDown();
                }
            }
        }
        return true;
    }

    // Place payloads at locations on map
    public static boolean placePayLoad(int lx, int ly, char payload) {
        // check for valid boundaries
        if (lx < 0 || lx > XSIZE - 1 || ly < 0 || ly > YSIZE - 1) {
            return false;
        } else {
            grid[lx][ly] = payload;

        }
        return true;
    }

    // Need to resolve this nonmember business
    public static void print2D() {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (int i = 0; i < XSIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < YSIZE; j++) {
                System.out.print(" " + grid[i][j] + " |");
            }
            // deleted grid parameter because has access to grid and no methods have grid as params
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }
    }
}
