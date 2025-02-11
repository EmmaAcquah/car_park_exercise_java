
public class Main {

    public static void main(String[] args) /*throws Exception*/ {
        CarParkPriorityQueue carParkQueue = new CarParkPriorityQueue(5);
        testCarParkPriorityQueueNoExceptions();
    }

    private static void testCarParkPriorityQueueNoExceptions() /*throws Exception*/ {
        System.out.println("--- DEBUG START: CAR PARK PRIORITY QUEUE WITHOUT EXCEPTIONS ---");

        // Initialise the car park with 5 spaces
        CarParkPriorityQueue carPark = new CarParkPriorityQueue(5);

        System.out.println("DEBUG - Initial parking slots check: " + carPark.checkAvailableParkingSlots());
        System.out.println("DEBUG - Park the 1st car: " + carPark.parkCar("AB12 CDE"));
        carPark.displayCarParkGrid();
        System.out.println("DEBUG - Park another car (2nd): " + carPark.parkCar("AB24 CDE"));
        carPark.displayCarParkGrid();
        System.out.println("DEBUG - Park a 3rd car: " + carPark.parkCar("FG34 HIJ"));
        carPark.displayCarParkGrid();
        System.out.println("DEBUG - Reserve 4th slot: " + carPark.reserveParkingSlot("KL56 MNO"));
        carPark.displayCarParkGrid();
        System.out.println("DEBUG - Park a 5th car: " + carPark.parkCar("PQ78 RST"));
        System.out.println("DEBUG 1 - Check parking slots again after parking 5th car: " + carPark.checkAvailableParkingSlots());
        System.out.println("DEBUG - Park a 6th car: " + carPark.parkCar("PQ78 RST"));
        carPark.freeParkingSlot(1, "AB24 CDE"); // invalid details
        carPark.freeParkingSlot(1, "AB12 CDE"); // valid details
        carPark.displayCarParkGrid();
    }

    private static void testCarParkHashMap() {
        System.out.println("--- DEBUG START: CAR PARK MAP ---");

        // Initialise the car park with 5 spaces
        CarParkMap carPark = new CarParkMap(5);

        // Park vehicles - CHECK AVAILABLE PARKING SLOTS
        System.out.println("DEBUG - getParkingSlots() getter: " + carPark.getParkingSlots());
        System.out.println("DEBUG - capacity() getter: " + carPark.getCapacity());
        System.out.println("DEBUG - Initial parking slots check: " + carPark.checkAvailableParkingSlots()); // returns array [1, 2, 3, 4, 5]

        // Park Car
        System.out.println("DEBUG - Park the first car: " + carPark.parkCar());

        // Check available parking slots after adding a car
        System.out.println("DEBUG - Test getParkingSlots() getter: " + carPark.getParkingSlots());
        System.out.println("DEBUG - Check available parking slots: " + carPark.checkAvailableParkingSlots()); // returns array - [2, 3, 4, 5] if slot 1 is taken

        // Park another car
        System.out.println("DEBUG - Park another car: " + carPark.parkCar());

        // Check available parking slots again
        System.out.println("DEBUG - Check available parking slots again: " + carPark.checkAvailableParkingSlots());

        // Park a 3rd car
        System.out.println("DEBUG - Park a 3rd car: " + carPark.parkCar());
        System.out.println("DEBUG - Check parking slots again after parking 3rd car: " + carPark.checkAvailableParkingSlots());

        // Park a 4th car
        System.out.println("DEBUG - Park a 4th car: " + carPark.parkCar());
        System.out.println("DEBUG - Check parking slots again after parking 4th car: " + carPark.checkAvailableParkingSlots());

        // Park a 5th car
        System.out.println("DEBUG - Park a 5th car: " + carPark.parkCar());
        System.out.println("DEBUG - Check parking slots again after parking 5th car: " + carPark.checkAvailableParkingSlots()); // Returns an empty array if all parking slots are full: []

        // Try to park a car once all parking slots are taken
        System.out.println("DEBUG - Try to park more cars than the capacity: " + carPark.parkCar());
        System.out.println("DEBUG - Check parking slots again after attempting to park a 6th car: " + carPark.checkAvailableParkingSlots());

        // Test freeParkingSlot()
        carPark.freeParkingSlot(5); // error freeing car park spot - Index 4 out of bounds for length 0
        System.out.println("DEBUG - Check parking slots after freeing a parking slot: " + carPark.checkAvailableParkingSlots());

        System.out.println("--- DEBUG END: CAR PARK MAP ---");
    }
}
