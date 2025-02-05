import java.util.HashMap;
import java.util.PriorityQueue;

public class CarParkPriorityQueue {

//    private PriorityQueue<Integer> availableParkingSlots;
    private PriorityQueue<Integer> availableParkingSlots;
    private int capacity;
    private HashMap<Integer, String> parkedCars;

    public CarParkPriorityQueue(int capacity) {
        this.availableParkingSlots = new PriorityQueue<>(capacity);
        this.capacity = capacity;
        this.parkedCars = new HashMap<>();

        for (int i = 1; i <= capacity; i++) {
            availableParkingSlots.add(i);
        }
    }

    public PriorityQueue<Integer> checkAvailableParkingSlots() {
        return availableParkingSlots;
    }

    public Integer parkCar(String licensePlateNumber) throws Exception {
        if (availableParkingSlots.isEmpty()) {
            throw new Exception("No available parking slots. Car not parked.");
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

}
