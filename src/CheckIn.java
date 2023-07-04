import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;

public class CheckIn {


    public CheckIn() {
        this.camera = new Camera();
        this.passportScanner = new PassportScanner();
        this.fingerprintScanner = new FingerprintScanner();
        this.conveyorBelt = new ConveyorBelt();
        this.storageAreaForEmptyULD = new ConcurrentLinkedQueue<>();
        this.storageAreaForFilledULD = new ConcurrentLinkedQueue<>();
        AddEmptyULDsToStorageArea();
        this.robot = new Robot(storageAreaForEmptyULD, storageAreaForFilledULD, conveyorBelt);
        this.federalPoliceOfficer = new FederalPoliceOfficer();
    }

    public void QueuePassengers(Hashtable<Integer, Passenger> passengers) {
        Queue<Passenger> tempQueue = new ConcurrentLinkedQueue<>();

        for (int i = 1; i <= passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            if (passenger.getBookingClass() == BookingClass.BUSINESS) {
                businessQueueForCheckIn.add(passenger);
            } else if (passenger.getBookingClass() == BookingClass.PREMIUM_ECONOMY) {
                economyQueueForCheckIn.add(passenger);
            } else if (passenger.getBookingClass() == BookingClass.ECONOMY) {
                tempQueue.add(passenger);
            }

        }
        economyQueueForCheckIn.addAll(tempQueue);
    }



    private void AddPassengerToBoardingQueue(Passenger passenger, Queue<Passenger> boardingQueue) {
        passenger.getSmartphone().getWallet().AddDocumentToWallet(new BoardingPass("BoardingPass", passenger.getBookingID()));
        boardingQueue.add(passenger);
        passenger.AddBaggageToConveyorBelt(conveyorBelt);


    }

    private void DoCheckIn(Queue<Passenger> checkInQueue, Queue<Passenger> boardingQueue, Hashtable<Integer, Passenger> database) {


        int randomNumber = ThreadLocalRandom.current().nextInt(1, 4);
        Passenger passenger = checkInQueue.poll();

        if (passenger.isWarrant()) {
            passenger.setResult("arrested");
            federalPoliceOfficer.ArrestPassenger(passenger);

        } else {
            passenger.setResult("pass");
            if (randomNumber == 1 && camera.IrisScan(database, passenger)) {
                AddPassengerToBoardingQueue(passenger, boardingQueue);

            } else if (randomNumber == 2 && passportScanner.Scan(database, passenger)) {
                AddPassengerToBoardingQueue(passenger, boardingQueue);

            } else if (randomNumber == 3 && fingerprintScanner.Scan(database, passenger)) {
                AddPassengerToBoardingQueue(passenger, boardingQueue);
            }
        }
        recordTable.put(new Record(passenger.getBookingID(), passenger.getName(), passenger.getFlight(), passenger.getTo(), passenger.getCountCheckedBaggage(), passenger.getResult()), passenger);

    }

    public Hashtable<Record, Passenger> StartCheckIn(Hashtable<Integer, Passenger> database) {

        while (!businessQueueForCheckIn.isEmpty()) {
            DoCheckIn(businessQueueForCheckIn, businessQueueForBoarding, database);
        }

        while (!economyQueueForCheckIn.isEmpty()) {
            DoCheckIn(economyQueueForCheckIn, economyQueueForBoarding, database);
        }
        while(!conveyorBelt.isConveyorBeltEmpty()){
            robot.AddBaggageToULD();
        }

        return recordTable;

    }

    private ULD actualULD;

    public Queue<Staff> getStaffQueue() {
        return staffQueue;
    }

    public void setStaffQueue(Queue<Staff> staffQueue) {
        this.staffQueue = staffQueue;
    }

    private Queue<Staff> staffQueue = new ConcurrentLinkedQueue<>();
    private Queue<Passenger> businessQueueForCheckIn = new ConcurrentLinkedQueue<Passenger>();
    private Queue<Passenger> economyQueueForCheckIn = new ConcurrentLinkedQueue<Passenger>();
    private Queue<Passenger> businessQueueForBoarding = new ConcurrentLinkedQueue<Passenger>();
    private Queue<Passenger> economyQueueForBoarding = new ConcurrentLinkedQueue<Passenger>();

    public Hashtable<Record, Passenger> getRecordTable() {
        return recordTable;
    }

    public void setRecordTable(Hashtable<Record, Passenger> recordTable) {
        this.recordTable = recordTable;
    }

    private Hashtable<Record, Passenger> recordTable = new Hashtable<>();
    private Camera camera;

    public FederalPoliceOfficer getFederalPoliceOfficer() {
        return federalPoliceOfficer;
    }

    private final FederalPoliceOfficer federalPoliceOfficer;
    private PassportScanner passportScanner;
    private FingerprintScanner fingerprintScanner;
    private ConveyorBelt conveyorBelt;
    private Queue<ULD> storageAreaForEmptyULD;
    private Queue<ULD> storageAreaForFilledULD;
    private Robot robot;

    private void AddEmptyULDsToStorageArea(){
        for (int i = 1; i<=10; i++) {
            storageAreaForEmptyULD.add(new ULD());
        }
    }


    public Hashtable<Integer, Passenger> ReadPassengerList() {

        Hashtable<Integer, Passenger> passengerHashtable = new Hashtable<Integer, Passenger>();
        File getCSVFile = new File(System.getProperty("user.dir") + Configuration.INSTANCE.pathToData);
        try {
            Scanner scanner = new Scanner(getCSVFile);
            int i = 0;
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] fields = line.split(",");
                //skip first line
                if (i == 0) {
                    i++;
                    continue;
                }

                if (fields[1].equalsIgnoreCase("Captain") || fields[1].equalsIgnoreCase("FirstSeniorOfficer")) {
                    Staff staff = new Staff();
                    staff.setRole(fields[1]);
                    staff.setName(fields[2]);
                    staff.setFingerprint(fields[7]);
                    staff.setGender(Human.Gender.valueOf(fields[3]));
                    staff.setIris(fields[6]);
                    staff.setDateOfBirth(fields[4]);
                } else {


                    Passenger passenger = new Passenger();
                    passenger.setNumber(Integer.parseInt(fields[0]));
                    passenger.setRole(fields[1]);
                    passenger.setName(fields[2]);
                    passenger.setGender(Human.Gender.valueOf(fields[3]));
                    passenger.setDateOfBirth(fields[4]);
                    passenger.setPassport(new Passport("Passport", fields[5]));
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
                    passengerHashtable.put(passenger.getNumber(), passenger);
                }

            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return passengerHashtable;

    }

}
