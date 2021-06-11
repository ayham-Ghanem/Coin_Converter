import java.io.Serializable;

public class ILS extends Coin implements Serializable {

    final private double value = 0.28;


    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public double Calculate(double amount) {

        return amount/ getValue()   ;
    }
}
