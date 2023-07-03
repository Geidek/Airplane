import java.util.LinkedList;
import java.util.List;

public class Cabin {




    public Cabin(){
        businessClass = new LinkedList<Row>();
        premiumEconomy = new LinkedList<Row>();
        economy = new LinkedList<Row>();

        for (int i = 1; i<=8; i++)
            businessClass.add(new Row(BookingClass.BUSINESS, i));
        
        for (int i = 12; i<=15; i++) {
            if (i == 13)
            continue;

            premiumEconomy.add(new Row(BookingClass.PREMIUM_ECONOMY,i));
        }
        for (int i = 16; i<=42; i++)
        {
            if (i == 17)
            continue;

            economy.add(new Row(BookingClass.ECONOMY, i));
        }
    }

    private List<Row> businessClass;
    private List<Row> premiumEconomy;
    private List<Row> economy;
    
    public List<Row> getBusinessClass() {
        return businessClass;
    }
    public List<Row> getPremiumEconomy() {
        return premiumEconomy;
    }
    public List<Row> getEconomy() {
        return economy;
    } 



}


