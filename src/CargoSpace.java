import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class CargoSpace
{

    private final int placeForULD = 5;

    private Deque<ULD> space;

    public Deque<ULD> GetSpace() {
        return space;
    }

    public boolean SetSpace(Deque<ULD> space) {
        if (space.size()<=placeForULD){
            this.space = space;
            return true;
        }
        else return false;

    }

    public boolean PutULDInCargoSpace(ULD uld){
        if(space.size()<=placeForULD){
            this.space.add(uld);
            return true;
        }
        else return false;
    }

    public ULD GetULDFromCargoSpace(){
        if(space.size()!=0)
        {
            return space.pop();
        }
        else return null;
    }



    private position cargoposition;

    public position GetCargoposition() {
        return cargoposition;
    }

    public void SetCargoposition(position cargoposition) {
        this.cargoposition = cargoposition;
    }

    enum position
    {
        LEFT,
        RIGHT
    }


}
