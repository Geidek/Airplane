import java.util.LinkedList;
import java.util.List;

public class Cabin {




    public Cabin(){
        businessClass = new LinkedList<Row>();
        for (int i = 0; i<8; i++)
            businessClass.add(new Row(BookingClass.BUSINESS, i+1));
    }

    private List<Row> businessClass;


}


