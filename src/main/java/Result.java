public class Result {
    private double amount;
    private String conversion;

    public Result(double amount, String conversion){
        this.amount = amount;
        this.conversion = conversion;
    }

    public double getAmount() {
        return amount;
    }

    public String getConversion() {
        return conversion;
    }

    @Override
    public String toString(){
        return conversion + " --> " + amount ;
    }

}
