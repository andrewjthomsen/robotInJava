public class Robot {
    // 3 private data members: x variable, y variable, and payload variable

    private int x;
    private int y;
    private char payload;

    // constructor for Robot class to house public content
    // No parameters needed for default constructor
    public Robot() {
        x = 0;
        y = 0;
        payload = ' ';
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
        System.out.println("Location: (" + x + "," + y + ") Load: " + payload);
    }
    // Function for picking up load
}
