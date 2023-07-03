public class Wing {

    public Wing (){
        fan = new Fan();
    }
    private Fan fan;

    public Fan getFan() {
        return fan;
    }
    
    private POSITION position; 


    public POSITION getPosition() {
        return position;
    }


    public void setPosition(POSITION position) {
        this.position = position;
    }


    public enum POSITION
    {
        LEFT,
        RIGHT
    }



}
