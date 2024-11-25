public class RoomClass {
    
    private int roomNumber;
    private String roomType;
    private boolean availability;

    public RoomClass(int roomNumber, String roomType, boolean availability) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availability = availability;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String toString() {
        return "Room Number: " + roomNumber + ", Room Type: " + roomType + ", Availability: " + availability;
    }
}

