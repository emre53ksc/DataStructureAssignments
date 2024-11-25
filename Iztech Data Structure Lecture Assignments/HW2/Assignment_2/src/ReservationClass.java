public class ReservationClass {
    
    private int reservationID;
    private String customerName;
    private String roomType;

    // Constructor
    public ReservationClass(int reservationID, String customerName, String roomType) {
        this.reservationID = reservationID;
        this.customerName = customerName;
        this.roomType = roomType;
    }

    // Getter and Setter methods
    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    
    @Override
    public String toString() {
        return "reservationClass{" +
                "reservationID=" + reservationID +
                ", customerName='" + customerName + '\'' +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}

