public class CoinFactory {

    public static Coin getCoin(Coins coin,double value){

        return switch (coin) {
            case ILS -> new ILS(value);
            case USD -> new USD(value);
            case EUR -> new EUR(value);
        };

    }
}
