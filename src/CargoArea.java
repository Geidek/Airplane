import java.util.ArrayDeque;
import java.util.Deque;

public class CargoArea {

    public CargoArea()
    {
        cargoSpaceLeft = new CargoSpace();
        cargoSpaceLeft.SetCargoposition(CargoSpace.position.LEFT);
        cargoSpaceRight = new CargoSpace();
        cargoSpaceRight.SetCargoposition(CargoSpace.position.RIGHT);
        
    }

    private int capacity = 10;
    //ToDo: Methode erstellen zum befüllen
    private Deque<ULD> baggage = new ArrayDeque<ULD>(capacity);


    public void setLocation(locations location) {
        this.location = location;
    }

    private locations location;
    
    public locations getLocation() {
        return location;
    }

    private CargoSpace cargoSpaceLeft;
    private CargoSpace cargoSpaceRight;


    public enum locations {
        FRONT,
        AFT
    }


}

