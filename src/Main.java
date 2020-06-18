public class Main {

    public static void main(String[] args) {
        // Create 2 new robot objects
        Robot r1 = new Robot();
        Robot r2 = new Robot();
        // Set 2 payloads
        Robot.placePayLoad(10, 8, 'B');
        Robot.placePayLoad(22, 4, 'C');
        Robot.print2D();
        // Call print method
        r1.print();
        r2.print();
        // Move both robots
        r1.moveTo(23, 24);
        r1.print();
        r2.moveTo(15, 3);
        r2.print();
        // r1 pickup/drop off
        r1.pickup(10, 8);
        r1.dropOff(20, 20);
        r1.print();
        Robot.print2D();
        // r2 pickup/drop off
        r2.pickup(22, 4);
        r2.dropOff(0, 0);
        r2.print();
        Robot.print2D();
    }
}
