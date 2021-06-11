import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {
        boolean stay =true;
        System.out.println("Welcome to currency converter");
        ArrayList<Result> results = new ArrayList<>();
        while (stay){


            String answer;
            String[] options = {"Dollars to Shekels", "Shekels to Dollars" ,"Shekels to Euros"};
            Scanner myObj = new Scanner(System.in);

            do {
                System.out.println("Please choose an option (1/3):");
                System.out.println("1. "+ options[0]);
                System.out.println("2. "+ options[1]);
                System.out.println("3. "+ options[2]);
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
            results.add(new Result(myCoin.Calculate(amount),options[option-1]));

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

        System.out.println("Thanks for using our currency converter.");
        for(Result r : results){
            System.out.println(r);
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
