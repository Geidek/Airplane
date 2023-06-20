import java.util.LinkedList;
import java.util.List;

public class Cabin {



    public Cabin(){
        rowList = new LinkedList<Row>();
        for (int i = 0; i<42; i++)
            rowList.add(new Row());
    }

    private List<Row> rowList;


}


