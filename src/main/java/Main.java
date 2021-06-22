import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
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
            double coinValue = GetCoinValues(option);
            Coin myCoin = CoinFactory.getCoin(Coins.values()[option-1],coinValue);




            do {
                System.out.println("Please enter an amount to convert ");
                answer = myObj.nextLine();
            }
            while (!isNumeric(answer));

            double amount = Double.parseDouble(answer);
            results.add(new Result(myCoin.Calculate(amount),options[option-1]));

            System.out.println(myCoin.Calculate(amount));


            String answer2;
            Scanner myObj1 = new Scanner(System.in);



            do{
                System.out.println("Do you want to proceed? Y/N");
                answer2 = myObj1.nextLine();

            }
            while (!answer2.equalsIgnoreCase("y") && !answer2.equalsIgnoreCase("N"));

            if (answer2.equalsIgnoreCase("n")){
                stay = false;
            }


        }
        fileWrite(results);
        System.out.println("Thanks for using our currency converter.");


        fileOpen();
    }



public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}




public static double GetCoinValues(int option) {
    try {
        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();

        URL url = new URL("http://api.exchangeratesapi.io/v1/latest?access_key=89fc343f2e24d03fe1451b2882cf7994&symbols=USD,ILS&format=1");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while((line = reader.readLine()) != null){
            responseContent.append(line);
        }
        reader.close();
        //responseContent be like:  {  "success":true,  "timestamp":1623937744,  "base":"EUR",  "date":"2021-06-17",  "rates":{    "USD":1.193538,    "ILS":3.898227  }}
        String response = responseContent.toString();
        // 1.193538,    "ILS"
        String[] respArr = response.split(":");
        String shekels = respArr[7];// --> 3.898227  }}
        shekels =shekels.replace("}","").strip();
        String dollars = respArr[6];
        dollars = dollars.replace("ILS","");
        dollars = dollars.replace(",","");
        dollars = dollars.replace("\"","").strip();
        double shekelsValue = Double.parseDouble(shekels);
        double dollarsValue = Double.parseDouble(dollars);
        switch (option){
            case 1,2 :
            return shekelsValue/dollarsValue;
            case 3:
                return shekelsValue;
        }



    }catch (IOException e){
        e.printStackTrace();
        System.out.println("Could not get rate from API using default rate...");
    }
    return 0.0;
}

public static void fileWrite(ArrayList<Result> result){
    try {
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("output.txt"));
        for(Result r : result){
            bw.write(r+"\n");
        }
        bw.close();


    }catch (Exception e){
        e.getStackTrace();
        System.out.println("Something went wrong.... please try again");

    }



}

public static void fileOpen() {


        try {
            String path = "output.txt";
            File file = new File(path);
            if (file.exists()){

                Process pro = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+path);
                pro.waitFor();

            }else {
                System.out.println("file does not exist");

            }

        }
        catch (Exception e){
            System.out.println("Something went wrong please try again");;
        }

}

}
