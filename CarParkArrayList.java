import java.util.ArrayList;

public class CarParkArrayList {

    private ArrayList<Integer> parkingSlots;

    public CarParkArrayList(int capacity) {
        this.parkingSlots = new ArrayList<>(capacity); // Set the capacity of the underlying array?

        for (int i = 0; i < capacity; i++) {
            this.parkingSlots.add(0);
        }
    }

    // Getters & Setters
    public ArrayList<Integer> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(ArrayList<Integer> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public ArrayList<Integer> checkAvailableParkingSlots() {

        ArrayList<Integer> availableParkingSlots = new ArrayList<>(parkingSlots.size());

        for (int i = 0; i < parkingSlots.size(); i++) {
            if (parkingSlots.get(i) == 0) {
                availableParkingSlots.add(i + 1);
            }
        }
        return availableParkingSlots;
    }

    public Integer parkCar() {
        Integer parkingSlotNumber = null;

        for (int i = 0; i < parkingSlots.size(); i++) {
            if (parkingSlots.get(i) == 0) {
                parkingSlotNumber = i + 1;
                parkingSlots.set(i, parkingSlotNumber);
                return parkingSlotNumber;
            }
        }
        return parkingSlotNumber;
    }

    public void freeParkingSlot(Integer parkingSlotNumber) {
        parkingSlots.set(parkingSlotNumber - 1, 0);
    }
}
