public class Smartphone {

    public Smartphone(){

        this.wallet = new Wallet();

    }

    private Wallet wallet;

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    } 
    
}
