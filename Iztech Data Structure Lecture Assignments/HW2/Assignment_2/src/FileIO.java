import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {

    public static void readReservations() {
        try (BufferedReader br = new BufferedReader(new FileReader("reservations.txt"))) {
            String line;
            br.readLine(); // skipping the first line
            while ((line = br.readLine()) != null) {
                
                String[] reservationData = line.split(",");
                int reservationId = Integer.parseInt(reservationData[0].trim());
                String customerName = reservationData[1].trim();
                String roomType = reservationData[2].trim();
                ReservationClass reservation = new ReservationClass(reservationId, customerName, roomType);
                switch (roomType) {
                    case "Single":
                        ReservationSystem.singleRoomWaitingLine.enqueue(reservation);
                        break;
                    case "Double":
                        ReservationSystem.doubleRoomWaitingLine.enqueue(reservation);
                        break;
                    case "Suite":
                        ReservationSystem.suiteRoomWaitingLine.enqueue(reservation);
                        break;
                    case "Deluxe":
                        ReservationSystem.deluxeRoomWaitingLine.enqueue(reservation);
                        break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

