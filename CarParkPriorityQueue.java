import java.util.HashMap;
import java.util.PriorityQueue;

public class CarParkPriorityQueue {

//    private PriorityQueue<Integer> availableParkingSlots;
    private PriorityQueue<Integer> availableParkingSlots;
    private int capacity;
    private HashMap<Integer, String> parkedCars;
//    private HashMap<Integer, String> reservedParkingSlots;
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

    public PriorityQueue<Integer> checkAvailableParkingSlots() throws Exception{
        if (availableParkingSlots.isEmpty()) {
            throw new Exception("No available parking slots");
        } else {
            return availableParkingSlots;
        }
//        return availableParkingSlots;
    }

    public Integer parkCar(String licensePlateNumber) throws Exception {
        if (availableParkingSlots.isEmpty()) {
            throw new Exception("No available parking slots.");
//        } else if (reservedParkingSlots.containsValue(licensePlateNumber)) {
        } else if (reservedParkingSlots.containsKey(licensePlateNumber)) {
            Integer parkingSlotNumber = reservedParkingSlots.get(licensePlateNumber);
            parkedCars.put(parkingSlotNumber, licensePlateNumber);
            reservedParkingSlots.remove(licensePlateNumber);
            return parkingSlotNumber;
        } else {
            Integer parkingSlotNumber = availableParkingSlots.poll();
            parkedCars.put(parkingSlotNumber, licensePlateNumber);
            return parkingSlotNumber;
        }
    }

    public void freeParkingSlot(Integer parkingSlotNumber, String licensePlateNumber) throws Exception {
        if (parkingSlotNumber > capacity || parkingSlotNumber <= 0) {
            throw new Exception("Invalid parking slot number.");
        } else if (!parkedCars.get(parkingSlotNumber).equals(licensePlateNumber)) {
            throw new Exception("Invalid license plate number");
        } else {
            availableParkingSlots.add(parkingSlotNumber);
            parkedCars.remove(parkingSlotNumber);
        }
    }

    public Integer reserveParkingSlot(String licensePlateNumber) throws Exception {
        if (availableParkingSlots.isEmpty()) {
            throw new Exception("No available parking slots.");
        }

        Integer nearestParkingSlot = availableParkingSlots.poll();
//        reservedParkingSlots.put(nearestParkingSlot, licensePlateNumber);
        reservedParkingSlots.put(licensePlateNumber, nearestParkingSlot);

        return nearestParkingSlot;
    }

}
