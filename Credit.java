package com.company;


import java.util.Comparator;

public class Credit {
    private String creditName;
    private String bankName;
    private Integer maxSum;
    private Integer minReturn;
    private double prRate;
    private boolean prepayment;
    private boolean increaseInLending;
    private Integer term;



    public Credit(String creditName, String bankName, Integer maxSum, Integer minReturn, double prRate, boolean prepayment, boolean increaseInLending, Integer term) {
        this.creditName = creditName;
        this.bankName = bankName;
        this.maxSum = maxSum;
        this.minReturn = minReturn;
        this.prRate = prRate;
        this.prepayment = prepayment;
        this.increaseInLending = increaseInLending;
        this.term = term;
    }

    public Credit() {
    }


    public void printFullCreditInfo() {
        System.out.println("creditName\t| bankName\t| maxSum\t| minReturn\t| prRate\t| prepayment\t| increaseInLending\t| term\t| ");
        System.out.println(creditName +"\t| " + bankName + "\t| " +
                        maxSum +"\t| " + minReturn + "\t| " + prRate + "\t| " +
                        prepayment + "\t| " + increaseInLending + "\t| " + term + "\t| ");
    }

    public void printShortCreditInfo() {
        System.out.println("creditName\t| bankName\t| maxSum\t| prRate\t| term\t| ");
        System.out.println(creditName +"\t| " + bankName + "\t| " +
                maxSum +"\t| " + prRate + "\t| " + term + "\t| ");

    }

    public boolean acceptableCredit (Integer maxSum) {
        boolean accepted = false;
        if (maxSum <=this.maxSum)
            accepted=true;
        else accepted=false;
        return accepted;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getMaxSum() {
        return maxSum;
    }

    public void setMaxSum(Integer maxSum) {
        this.maxSum = maxSum;
    }

    public int getMinReturn() {
        return minReturn;
    }

    public void setMinReturn(Integer minReturn) {
        this.minReturn = minReturn;
    }

    public double getPrRate() {
        return prRate;
    }

    public void setPrRate(double prRate) {
        this.prRate = prRate;
    }

    public boolean isPrepayment() {
        return prepayment;
    }

    public void setPrepayment(boolean prepayment) {
        this.prepayment = prepayment;
    }

    public boolean isIncreaseInLending() {
        return increaseInLending;
    }

    public void setIncreaseInLending(boolean increaseInLending) {
        this.increaseInLending = increaseInLending;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }


}

class CreditComparator implements Comparator<Credit> {

    public int compare(Credit a, Credit b){

        return a.getCreditName().toUpperCase().compareTo(b.getCreditName().toUpperCase());
    }
}
