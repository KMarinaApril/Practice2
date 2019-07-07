package com.company;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        List<Banks> listOfBanks = banksList();
        List<Credit> listOfCredits = creditList();
        Integer input = inputCreditSum();
        Integer salary = inputSalary();
        acceptCredit(input, salary, listOfCredits,listOfBanks);


    }


    public static Integer inputCreditSum() {
        Scanner in = new Scanner(System.in);
        String input = null;
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = null;

        do {
            System.out.println("Input a credit sum that you would like to get: ");
            input = in.nextLine();
            matcher = pattern.matcher(input);
        } while (!matcher.matches());


        return Integer.parseInt(input);

    }

    public static Integer inputSalary() {
        Scanner in = new Scanner(System.in);
        String input = null;
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = null;

        do {
            System.out.println("Input your salary: ");
            input = in.nextLine();
            matcher = pattern.matcher(input);
        } while (!matcher.matches());
        return Integer.parseInt(input);
    }

    public static List<Banks> banksList() {
        List<Banks> listOfBanks = new ArrayList<Banks>();
        Collections.addAll(listOfBanks,
                new Banks("Bank1", "113, Odintsova Str., Minsk", "Ph. (017) 213-13-13"),
                new Banks("Bank2", "11, Filatova Str., Minsk", "Ph. (017) 211-11-11"),
                new Banks("Bank3", "5, Lobanka Str., Minsk", "Ph. (017) 210-10-10"));
        return listOfBanks;
    }

    public static List<Credit> creditList() {
        List<Credit> listOfCredits = new ArrayList<Credit>();
        Collections.addAll(listOfCredits,
                new Credit("Credit1", "Bank1", 10000, 490, 15.30, true, false, 60),
                new Credit("Credit2", "Bank1", 1000, 42, 10.3, false, false, 60),
                new Credit("Credit3", "Bank1", 5000, 273, 19.3, true, false, 60),
                new Credit("Credit4", "Bank2", 4000, 345, 17.3, true, false, 36)
        );
        return listOfCredits;
    }

    public static void acceptCredit(Integer input, Integer salary, List<Credit> listOfCredits, List<Banks> banksList) {
        Credit clientCredit = new Credit();
        clientCredit.setMaxSum(input);
        clientCredit.setMinReturn(salary);

        if (listOfCredits.stream().anyMatch(credit -> input <= credit.getMaxSum() && (salary >= credit.getMinReturn()))) {

            listOfCredits.stream()
                    .filter(credit -> input <= credit.getMaxSum())
                    .filter(credit -> salary >= credit.getMinReturn())
                    .forEach(credit -> credit.printShortCreditInfo());

            creditDetails(input, salary, listOfCredits, banksList);
        }

        if (listOfCredits.stream()
                .noneMatch(credit -> input <= credit.getMaxSum()) || listOfCredits.stream().noneMatch(credit -> salary >= credit.getMinReturn())) {
            System.out.println("Try change the input value (credit amount) to find at least one available credit.");

        }

    }

    public static void creditDetails(Integer input, Integer salary, List<Credit> listOfCredits, List<Banks> banksList) {
        Scanner in = new Scanner(System.in);
        String choise = null;
        Pattern pattern = Pattern.compile("^[YyNn]+$");
        Matcher matcher = null;

        do {
            System.out.println("Would you like to take a look at credit more deeper? Y /N");
            choise = in.nextLine();
            matcher = pattern.matcher(choise);
        } while (!matcher.matches());


        if (choise.matches("y") || choise.matches("Y")) {
            reviewSelectedCredit(input, salary, listOfCredits, banksList);
        }else
            System.out.println("End.");

    }



    public static void reviewSelectedCredit(Integer input, Integer salary, List<Credit> listOfCredits, List<Banks> banksList) {

        Scanner newIn = new Scanner(System.in);
        String selectedCredit = null;
        Pattern creditPattern = Pattern.compile("^[a-zA-Z500-9]+$");
        Matcher creditMatcher = null;
        do {
            System.out.println("Enter creditName to take a look at details.");
            selectedCredit = newIn.nextLine();
            creditMatcher = creditPattern.matcher(selectedCredit);
        } while (!creditMatcher.matches());


        for (Credit credits : listOfCredits) {
            if (!credits.getCreditName().equalsIgnoreCase(selectedCredit)) {
                continue;
            }
            if (credits.getCreditName().equalsIgnoreCase(selectedCredit)) {
                System.out.println("You've selected the following credit. Contact to Bank specialist using contacts below:");
                credits.printFullCreditInfo();
                for (Banks bank : banksList)
                    if (bank.getBankName().equalsIgnoreCase(credits.getBankName()))
                        bank.printBankInfo();
                    break;
            }
        }

//        String cred=selectedCredit;
//        listOfCredits.stream()
//                .filter(cr->cr.getCreditName().equalsIgnoreCase(cred))
//                .forEach(cr-> cr.printFullCreditInfo());




    }
}
