import java.io.Serializable;

public class EUR extends Coin implements Serializable {

    private double value = 0.0;

    public EUR(double value){
        this.value = value;
    }


    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public double Calculate(double amount) {

        return amount * getValue();
    }
}

