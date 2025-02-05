import java.util.PriorityQueue;

public class CarParkPriorityQueue {

    private PriorityQueue<Integer> availableParkingSlots;
    private int capacity;
    private HashMap<Integer, String> parkedCars;

    public CarParkPriorityQueue(int capacity) {
        this.availableParkingSlots = new PriorityQueue<>(capacity);
        this.capacity = capacity;
//        this.parkedCars = new HashMap<>(capacity); // does that init work?
        this.parkedCars = new HashMap<>(); // does that init work?

        for (int i = 1; i <= capacity; i++) {
            availableParkingSlots.add(i);
        }
    }

    public PriorityQueue<Integer> checkAvailableParkingSlots() {
        return availableParkingSlots;
    }

    public Integer parkCar() throws Exception {
        if (availableParkingSlots.isEmpty()) {
            throw new Exception("No available parking slots. Car not parked.");
        } else {
            return availableParkingSlots.poll();
        }
    }

    public void freeParkingSlot(Integer parkingSlotNumber) throws Exception {
        if (parkingSlotNumber > capacity || parkingSlotNumber <= 0) {
            throw new Exception("Invalid parking slot number.");
        } else {
            availableParkingSlots.add(parkingSlotNumber);
        }
    }

}
