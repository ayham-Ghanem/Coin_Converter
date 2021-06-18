import java.io.Serializable;

public class USD extends Coin implements Serializable {

     private double value = 0.0;

     public USD(double value){
        this.value = value;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public double Calculate(double amount) {

        return amount / getValue()  ;
    }
}
