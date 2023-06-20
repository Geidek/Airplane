public class CargoArea {

    public CargoArea()
    {
        cargoSpaceLeft = new CargoSpace();
        cargoSpaceLeft.SetCargoposition(CargoSpace.position.LEFT);
        cargoSpaceRight = new CargoSpace();
        cargoSpaceRight.SetCargoposition(CargoSpace.position.RIGHT);
    }


    public void setLocation(locations location) {
        this.location = location;
    }

    private locations location;
    private CargoSpace cargoSpaceLeft;
    private CargoSpace cargoSpaceRight;


    public enum locations {
        FRONT,
        AFT
    }


}

