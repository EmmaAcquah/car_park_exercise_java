import java.util.ArrayList;

public class CarPark {

    private int[] parkingSlots;

    public CarPark(int capacity) {
        this.parkingSlots = new int[capacity];
    }

    // Getters & Setters
    public int[] getParkingSlots() {
        return parkingSlots;
    }

    // Setter not being used - remove
//    public void setParkingSlots(int[] parkingSlots) {
//        this.parkingSlots = parkingSlots;
//    }

    public ArrayList<Integer> checkAvailableParkingSlots() {

        ArrayList<Integer> availableParkingSlots = new ArrayList<>();

        for (int i = 0; i < parkingSlots.length; i++) {
            if (parkingSlots[i] == 0) {
                availableParkingSlots.add(i + 1);
            }
        }
        return availableParkingSlots;
    }

    public int parkCar() {

        int parkingSlotNumber = 0;


        for (int i = 0; i < parkingSlots.length; i++) {
            if (parkingSlots[i] == 0) {
                parkingSlotNumber = i + 1;
                parkingSlots[i] = parkingSlotNumber;
                return parkingSlotNumber;
            }
        }

        return parkingSlotNumber;
    }

    public void freeParkingSlot(int parkingSlotNumber) {
        int indexNumber = parkingSlotNumber - 1;
        parkingSlots[indexNumber] = 0;
    }

}
