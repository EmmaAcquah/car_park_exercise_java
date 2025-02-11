import java.util.HashMap;
import java.util.PriorityQueue;

public class CarParkPriorityQueue {

    private PriorityQueue<Integer> availableParkingSlots;
    private int capacity;
    private HashMap<Integer, String> parkedCars;
    private HashMap<String, Integer> reservedParkingSlots;

    public CarParkPriorityQueue(int capacity) {
        this.availableParkingSlots = new PriorityQueue<>(capacity);
        this.capacity = capacity;
        this.parkedCars = new HashMap<>();
        this.reservedParkingSlots = new HashMap<>();

        for (int i = 1; i <= capacity; i++) {
            availableParkingSlots.add(i);
        }
    }

    public HashMap<Integer, String> getParkedCars() {
        return parkedCars;
    }

    public PriorityQueue<Integer> checkAvailableParkingSlots() /*throws Exception*/ {
        if (availableParkingSlots.isEmpty()) {
            System.out.println("No available parking slots.");
//            throw new Exception("No available parking slots.");
            return null;
        }
        return availableParkingSlots;
    }

    public Integer parkCar(String licensePlateNumber) /*throws Exception*/ {
        if (availableParkingSlots.isEmpty()) {
            System.out.println("No available parking slots.");
//            throw new Exception("No available parking slots.");
            return null;
        } else if (reservedParkingSlots.containsKey(licensePlateNumber)) {
            Integer parkingSlotNumber = reservedParkingSlots.get(licensePlateNumber);

            parkedCars.put(parkingSlotNumber, licensePlateNumber);
            reservedParkingSlots.remove(licensePlateNumber);
            return parkingSlotNumber;
        }
            Integer parkingSlotNumber = availableParkingSlots.poll();
            parkedCars.put(parkingSlotNumber, licensePlateNumber);
            return parkingSlotNumber;
    }

    public void freeParkingSlot(Integer parkingSlotNumber, String licensePlateNumber) /*throws Exception*/ {
        if (parkingSlotNumber > capacity || parkingSlotNumber <= 0) {
            System.out.println("Invalid parking slot number. Parking slot not freed.");
//            throw new Exception("Invalid parking slot number.");
        } else if (!parkedCars.get(parkingSlotNumber).equals(licensePlateNumber)) {
            System.out.println("Invalid license plate number. Parking slot not freed.");
//            throw new Exception("Invalid license plate number.");
        } else {
            availableParkingSlots.add(parkingSlotNumber);
            parkedCars.remove(parkingSlotNumber);
            System.out.println("Parking slot freed.");
        }
    }

    public Integer reserveParkingSlot(String licensePlateNumber) /*throws Exception*/ {
        if (availableParkingSlots.isEmpty()) {
            System.out.println("No available parking slots.");
//            throw new Exception("No available parking slots.");
            return null;
        }

        Integer nearestParkingSlot = availableParkingSlots.poll();
        reservedParkingSlots.put(licensePlateNumber, nearestParkingSlot);
        return nearestParkingSlot;
    }

    public void displayCarParkGrid() {
        int gridWidth = (int) Math.ceil((double) Math.sqrt(capacity));
        int gridHeight = (int) Math.ceil((double) capacity / gridWidth);

        int parkingSlotCounter = 1;

        for (int i = 1; i <= gridHeight; i++) {
            StringBuilder rowString = new StringBuilder(" | ");

            for (int j = 1; j <= gridWidth; j++) {
                if (parkingSlotCounter <= capacity) {
                    if (!reservedParkingSlots.containsValue(parkingSlotCounter) && !parkedCars.containsKey(parkingSlotCounter) ) { // Available if not in either reservedSlots or parkedCars HashMaps
                        rowString.append(parkingSlotCounter);
                        rowString.append(" | "); // prints weird sometimes - fix
                        parkingSlotCounter++;
                    } else {
                        rowString.append("X"); // print X instead of the slotNumber, change to print R for reserved
                        rowString.append(" | ");
                        parkingSlotCounter++;
                    }
                }
            }
            System.out.println(rowString.toString());
        }
    }

}
