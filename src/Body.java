public class Body {

    public Body(){
        cockpit = new Cockpit();
        cabin = new Cabin();
        cargoArea01 = new CargoArea();
        cargoArea01.setLocation(CargoArea.locations.FRONT);
        cargoArea02 = new CargoArea();
        cargoArea02.setLocation(CargoArea.locations.AFT);
    }

    private Cockpit cockpit;

    public Cockpit getCockpit() {
        return cockpit;
    }
    
    public Cabin getCabin() {
        return cabin;
    }

    private Cabin cabin;
    private CargoArea cargoArea01;
    private CargoArea cargoArea02;
}
