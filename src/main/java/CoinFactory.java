public class CoinFactory {

    public static Coin getCoin(Coins coin){

        switch (coin){

            case ILS:
                return new ILS();
            case USD:
                return new USD();
            case EUR:
                return new EUR();

        }

        return null;
    }
}
