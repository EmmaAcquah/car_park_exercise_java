import java.util.HashMap;
import java.util.PriorityQueue;

public class CarParkPriorityQueue {

    private int capacity;
    private PriorityQueue<Integer> availableParkingSlots;
    private HashMap<Integer, String> parkedCars;
    private HashMap<String, Integer> reservedParkingSlots;

    public CarParkPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.availableParkingSlots = new PriorityQueue<>(capacity);
        this.parkedCars = new HashMap<>();
        this.reservedParkingSlots = new HashMap<>();

        for (int i = 1; i <= capacity; i++) {
            availableParkingSlots.add(i);
        }
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
        int gridWidth = (int) Math.ceil(Math.sqrt(capacity));
        int gridHeight = (int) Math.ceil((double) capacity / gridWidth);

        int parkingSlotCounter = 1;

        for (int row = 1; row <= gridHeight; row++) {
            StringBuilder rowString = new StringBuilder(" | ");

            for (int col = 1; col <= gridWidth; col++) {
                if (parkingSlotCounter <= capacity) {
                    if(reservedParkingSlots .containsValue(parkingSlotCounter)) {
                        rowString.append("R");
                    } else if (parkedCars.containsKey(parkingSlotCounter)) {
                        rowString.append("X");
                    } else {
                        rowString.append(parkingSlotCounter);
                    }
                    rowString.append(" | ");
                    parkingSlotCounter++;
                }
            }
            System.out.println(rowString);
        }
    }

}
