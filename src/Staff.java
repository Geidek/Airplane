import java.util.concurrent.ThreadLocalRandom;

public class Staff extends Human {

    public Staff(){
        super();
        this.personnelNumber = ThreadLocalRandom.current().nextInt(10000, 100000);
        idCard = new IDCard();



    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }

    private IDCard idCard;

    public int getPersonnelNumber() {
        return personnelNumber;
    }

    private final int personnelNumber;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;

}
