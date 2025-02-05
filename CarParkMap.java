import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarParkMap {
    // Test storing car information
//    private Map<Integer, String> parkingSlots; // parkingSlotNo, Car Registration - ?

    private Map<Integer, Boolean> parkingSlots;
    private int capacity;

    public CarParkMap(int capacity) {
        this.capacity = capacity;
        parkingSlots = new HashMap<>();

        // Populate the parkingSlots HashMap - with false (available) values
        for (int i = 1; i <= capacity; i++) {
            parkingSlots.put(i, false);
        }
    }

    public Map<Integer, Boolean> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(Map<Integer, Boolean> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Integer> checkAvailableParkingSlots() {
        ArrayList<Integer> availableParkingSlots = new ArrayList<>();
        for (int parkingSlot : parkingSlots.keySet()) {
            if (!parkingSlots.get(parkingSlot)) {
                availableParkingSlots.add(parkingSlot);
            }
        }
        return availableParkingSlots;
    }

    public Integer parkCar() {
        for (int parkingSlot : parkingSlots.keySet()) {
            if (!parkingSlots.get(parkingSlot)) {
                parkingSlots.put(parkingSlot, true);
                return parkingSlot;
            }
        }
        return null;
    }

    public void freeParkingSlot(Integer parkingSlotNo) {
            parkingSlots.put(parkingSlotNo, false);
    }

}
