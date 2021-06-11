import java.io.Serializable;

public class USD extends Coin implements Serializable {

    final private double value = 3.52;

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public double Calculate(double amount) {

        return amount / getValue()  ;
    }
}
