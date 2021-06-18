import java.io.Serializable;

public class ILS extends Coin implements Serializable {

    private double value = 0.0;

    public ILS(double value){
        this.value = value;
    }
    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public double Calculate(double amount) {

        return amount* getValue()   ;
    }
}
