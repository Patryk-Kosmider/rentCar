package pl.pjatk;

public enum CarType {

    PREMIUM(2.5), STANDARD(1.5), ECONOMY(1);

    private double priceRatio;

    CarType(double priceRatio){
        this.priceRatio = priceRatio;
    }

    public double getPriceRatio(){
        return priceRatio;
    }
}
