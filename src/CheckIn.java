import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CheckIn {


    public CheckIn() {
        this.camera = new Camera();
        this.passportScanner = new PassportScanner();
        this.fingerprintScanner = new FingerprintScanner();
        this.conveyorBelt = new ConveyorBelt();
        this.storageAreaForEmptyULD = new StorageArea();
        this.storageAreaForFilledULD = new StorageArea();
        this.robot = new Robot();
    }

    public void StartCheckIn(){
        List<Passenger> passengers = ReadPassengerList();
        Queue<Passenger> tempQueue = new ConcurrentLinkedQueue<Passenger>();

        for(Passenger passenger : passengers){
            if(passenger.getBookingClass() == BookingClass.BUSINESS)
            {
                businessQueueForCheckIn.add(passenger);
            }
            else if (passenger.getBookingClass() == BookingClass.PREMIUM_ECONOMY)
            {
                economyQueueForCheckIn.add(passenger);
            }
            else if(passenger.getBookingClass() == BookingClass.ECONOMY)
            {
                tempQueue.add(passenger);
            }
        }
        economyQueueForCheckIn.addAll(tempQueue);


    }

    private Queue<Passenger> businessQueueForCheckIn = new ConcurrentLinkedQueue<Passenger>();
    private Queue<Passenger> economyQueueForCheckIn = new ConcurrentLinkedQueue<Passenger>();
    private Queue<Passenger> businessQueueForBoarding = new ConcurrentLinkedQueue<Passenger>();
    private Queue<Passenger> economyQueueForBoarding = new ConcurrentLinkedQueue<Passenger>();
    private Camera camera;


    private PassportScanner passportScanner;
    private FingerprintScanner fingerprintScanner;
    private ConveyorBelt conveyorBelt;
    private StorageArea storageAreaForEmptyULD;
    private StorageArea storageAreaForFilledULD;
    private Robot robot;



    private List<Passenger> ReadPassengerList() {

        List<Passenger> passengerList = new LinkedList<Passenger>();
        File getCSVFile = new File(System.getProperty("user.dir") + Configuration.INSTANCE.pathToData);
        try {
            Scanner scanner = new Scanner(getCSVFile);
            int i = 0;
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] fields = line.split(",");
                if (i == 0) {
                    i++;
                    continue;
                }

                Passenger passenger = new Passenger();
                passenger.setRole(fields[1]);
                passenger.setName(fields[2]);
                passenger.setGender(fields[3]);
                passenger.setDateOfBirth(fields[4]);
                passenger.setPassportId(fields[5]);
                passenger.setIris(fields[6]);
                passenger.setFingerprint(fields[7]);
                passenger.setBookingID(fields[8]);
                passenger.setFlight(fields[9]);
                passenger.setFrom(fields[10]);
                passenger.setTo(fields[11]);
                passenger.setDeparture(fields[12]);
                passenger.setArrival(fields[13]);
                if (fields[14].equalsIgnoreCase(BookingClass.BUSINESS.toString()))
                    passenger.setBookingClass(BookingClass.BUSINESS);
                else if (fields[14].equalsIgnoreCase(BookingClass.COCKPIT.toString()))
                    passenger.setBookingClass(BookingClass.COCKPIT);
                else if (fields[14].equalsIgnoreCase(BookingClass.PREMIUM_ECONOMY.toString()))
                    passenger.setBookingClass(BookingClass.PREMIUM_ECONOMY);
                else
                    passenger.setBookingClass(BookingClass.ECONOMY);
                passenger.setSeatAsString(fields[15]);
                passenger.setCountCheckedBaggage(Integer.parseInt(fields[16]));
                if (passenger.getCountCheckedBaggage() == 1) {
                    passenger.AddBaggage(new Baggage(Double.parseDouble(fields[17])));
                } else if (passenger.getCountCheckedBaggage() == 2) {
                    String[] baggages = fields[17].split(" ");
                    passenger.AddBaggage(new Baggage(Double.parseDouble(baggages[0])));
                    passenger.AddBaggage(new Baggage(Double.parseDouble(baggages[1])));
                } else {
                    String[] baggages = fields[17].split(" ");
                    passenger.AddBaggage(new Baggage(Double.parseDouble(baggages[0])));
                    passenger.AddBaggage(new Baggage(Double.parseDouble(baggages[1])));
                    passenger.AddBaggage(new Baggage(Double.parseDouble(baggages[2])));
                }
                if (fields[18].equalsIgnoreCase("no")) {
                    passenger.setWarrant(false);
                } else if (fields[18].equalsIgnoreCase("yes")) {
                    passenger.setWarrant(true);
                }
                passengerList.add(passenger);

            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return passengerList;

    }

}
