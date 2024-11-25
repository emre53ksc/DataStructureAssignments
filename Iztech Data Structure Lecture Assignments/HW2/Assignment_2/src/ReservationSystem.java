import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {

    public static QueueClass<ReservationClass> singleRoomWaitingLine;
    public static QueueClass<ReservationClass> doubleRoomWaitingLine;
    public static QueueClass<ReservationClass> suiteRoomWaitingLine;
    public static QueueClass<ReservationClass> deluxeRoomWaitingLine;

    public static StackClass<RoomClass> singleRoomPile;
    public static StackClass<RoomClass> doubleRoomPile;
    public static StackClass<RoomClass> suiteRoomPile;
    public static StackClass<RoomClass> deluxeRoomPile;

    public static ListClass<RoomClass> unavailableRooms;
    public static ListClass<RoomClass> availableRooms;


    private static void processReservations(QueueClass<ReservationClass> reservations, StackClass<RoomClass> rooms) {
        
        int reservationCount = reservations.size();

        for (int i = 0; i < reservationCount; i++) {
            ReservationClass reservation = reservations.dequeue();
            if (!rooms.isEmpty() && rooms.peek().isAvailability()) {
                RoomClass room = rooms.pop();
                room.setAvailability(false);
                unavailableRooms.add(room);
                System.out.println("Room " + room.getRoomNumber() + " booked for " + reservation.getCustomerName());
            } else {
                reservations.enqueue(reservation);
            }
        }
    }
        

private static void makeOddNumberedRoomsAvailable(ListClass<RoomClass> unavailableRooms) {
    List<RoomClass> roomsToRemove = new ArrayList<>();
    for (int i = unavailableRooms.getLength(); i > 0; i--) {
        RoomClass room = unavailableRooms.getEntry(i);
        if (room.getRoomNumber() % 2!= 0) {
            switch (room.getRoomType()) {
                case "Single":
                    singleRoomPile.push(room);
                    break;
                case "Double":
                    doubleRoomPile.push(room);
                    break;
                case "Suite":
                    suiteRoomPile.push(room);
                    break;
                case "Deluxe":
                    deluxeRoomPile.push(room);
                    break;
                default:
                    break;
            }
            room.setAvailability(true);
            availableRooms.add(room);
            roomsToRemove.add(room);
        }
    }
    // Remove the rooms from the unavailableRooms list after the for loop completes
    for (RoomClass room : roomsToRemove) {
        unavailableRooms.remove(room);
    }
}
    


    public static void main(String[] args) {
        
        singleRoomPile = new StackClass<>(5);
        doubleRoomPile = new StackClass<>(5);
        suiteRoomPile = new StackClass<>(5);
        deluxeRoomPile = new StackClass<>(5);

        singleRoomWaitingLine = new QueueClass<>();
        doubleRoomWaitingLine = new QueueClass<>();
        suiteRoomWaitingLine = new QueueClass<>();
        deluxeRoomWaitingLine = new QueueClass<>();

        unavailableRooms = new ListClass<>();
        availableRooms = new ListClass<>();


        RoomClass room1 = new RoomClass(1, "Single", true);
        RoomClass room2 = new RoomClass(2, "Single", true);
        RoomClass room3 = new RoomClass(3, "Single", true);
        RoomClass room4 = new RoomClass(4, "Single", true);
        RoomClass room5 = new RoomClass(5, "Single", true);

        RoomClass room6 = new RoomClass(6, "Double", true);
        RoomClass room7 = new RoomClass(7, "Double", true);
        RoomClass room8 = new RoomClass(8, "Double", true);
        RoomClass room9 = new RoomClass(9, "Double", true);
        RoomClass room10 = new RoomClass(10, "Double", true);

        RoomClass room11 = new RoomClass(11, "Suite", true);
        RoomClass room12 = new RoomClass(12, "Suite", true);
        RoomClass room13 = new RoomClass(13, "Suite", true);
        RoomClass room14 = new RoomClass(14, "Suite", true);
        RoomClass room15 = new RoomClass(15, "Suite", true);

        RoomClass room16 = new RoomClass(16, "Deluxe", true);
        RoomClass room17 = new RoomClass(17, "Deluxe", true);
        RoomClass room18 = new RoomClass(18, "Deluxe", true);
        RoomClass room19 = new RoomClass(19, "Deluxe", true);
        RoomClass room20 = new RoomClass(20, "Deluxe", true);

        singleRoomPile.push(room5);
        singleRoomPile.push(room4);
        singleRoomPile.push(room3);
        singleRoomPile.push(room2);
        singleRoomPile.push(room1);

        doubleRoomPile.push(room10);
        doubleRoomPile.push(room9);
        doubleRoomPile.push(room8);
        doubleRoomPile.push(room7);
        doubleRoomPile.push(room6);

        suiteRoomPile.push(room15);
        suiteRoomPile.push(room14);
        suiteRoomPile.push(room13);
        suiteRoomPile.push(room12);
        suiteRoomPile.push(room11);

        deluxeRoomPile.push(room20);
        deluxeRoomPile.push(room19);
        deluxeRoomPile.push(room18);
        deluxeRoomPile.push(room17);
        deluxeRoomPile.push(room16);

        availableRooms.add(room1);
        availableRooms.add(room2);
        availableRooms.add(room3);
        availableRooms.add(room4);
        availableRooms.add(room5);
        availableRooms.add(room6);
        availableRooms.add(room7);
        availableRooms.add(room8);
        availableRooms.add(room9);
        availableRooms.add(room10);
        availableRooms.add(room11);
        availableRooms.add(room12);
        availableRooms.add(room13);
        availableRooms.add(room14);
        availableRooms.add(room15);
        availableRooms.add(room16);
        availableRooms.add(room17);
        availableRooms.add(room18);
        availableRooms.add(room19);
        availableRooms.add(room20);



        singleRoomPile.display();
        System.out.println();
        
        doubleRoomPile.display();
        System.out.println();
        
        suiteRoomPile.display();
        System.out.println();
        
        deluxeRoomPile.display();



        System.out.println("reading reservations");
        FileIO.readReservations();


        processReservations(singleRoomWaitingLine, singleRoomPile);
        processReservations(doubleRoomWaitingLine, doubleRoomPile);
        processReservations(suiteRoomWaitingLine, suiteRoomPile);
        processReservations(deluxeRoomWaitingLine, deluxeRoomPile);

        singleRoomWaitingLine.displayItems();
        System.out.println();
        
        doubleRoomWaitingLine.displayItems();
        System.out.println();
        
        suiteRoomWaitingLine.displayItems();
        System.out.println();
        
        deluxeRoomWaitingLine.displayItems();



        System.out.println("all booked odd numbered rooms avaliable now");
        makeOddNumberedRoomsAvailable(unavailableRooms);




        singleRoomWaitingLine.displayItems();
        System.out.println();
        
        doubleRoomWaitingLine.displayItems();
        System.out.println();
        
        suiteRoomWaitingLine.displayItems();
        System.out.println();
        
        deluxeRoomWaitingLine.displayItems();




        
        processReservations(singleRoomWaitingLine, singleRoomPile);
        processReservations(doubleRoomWaitingLine, doubleRoomPile);
        processReservations(suiteRoomWaitingLine, suiteRoomPile);
        processReservations(deluxeRoomWaitingLine, deluxeRoomPile);
    
    }
}

