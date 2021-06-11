import java.io.Serializable;

public class EUR extends Coin implements Serializable {

    final private double value = 4.28;


    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public double Calculate(double amount) {

        return amount / getValue();
    }
}

