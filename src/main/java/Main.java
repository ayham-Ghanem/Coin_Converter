import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {
        boolean stay =true;
        System.out.println("Welcome to currency converter");
        while (stay){


            String answer;
            Scanner myObj = new Scanner(System.in);

            do {
                System.out.println("Please choose an option (1/3):");
                System.out.println("1. Dollars to Shekels");
                System.out.println("2. Shekels to Dollars");
                System.out.println("3. Shekels to Euros");
                answer = myObj.nextLine();

            }
            while (!answer.equalsIgnoreCase("1") && !answer.equalsIgnoreCase("2") && !answer.equalsIgnoreCase("3"));
            int option = Integer.parseInt(answer);
            CoinFactory myCoinFac = new CoinFactory();
            Coin myCoin = myCoinFac.getCoin(Coins.values()[option-1]);


            do {
                System.out.println("Please enter an amount to convert ");
                answer = myObj.nextLine();
            }
            while (!isNumeric(answer));

            double amount = Double.parseDouble(answer);
            System.out.println(myCoin.Calculate(amount));
























            String answer2 = null;
            Scanner myObj1 = new Scanner(System.in);

            do{
                System.out.println("Do you want to proceed? Y/N");
                answer2 = myObj1.nextLine();

            }
            while (!answer2.equalsIgnoreCase("y") && !answer2.equalsIgnoreCase("N"));

            if (answer2.equalsIgnoreCase("n")){
                stay = false;
            }

            //open file
            //show result




        }


    }



public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}

}
