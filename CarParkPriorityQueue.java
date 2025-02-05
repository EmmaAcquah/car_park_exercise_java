import java.util.PriorityQueue;

public class CarParkPriorityQueue {

    private PriorityQueue<Integer> availableParkingSlots;

    public CarParkPriorityQueue(int capacity) {
        this.availableParkingSlots = new PriorityQueue<>(capacity);
        for (int i = 1; i <= capacity; i++) {
            availableParkingSlots.add(i);
        }
    }

    public PriorityQueue<Integer> checkAvailableParkingSlots() {
        return availableParkingSlots;
    }

    public Integer parkCar() throws Exception {
        return availableParkingSlots.poll();
    }

    public void freeParkingSlot(Integer parkingSlotNumber) {
        availableParkingSlots.add(parkingSlotNumber);
    }

}
