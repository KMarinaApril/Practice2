package com.company;



public class Banks {

    private String bankName;
    private String bankAddress;
    private String bankContacts;
    private Credit bankCredit;

    public Banks(String bankName, String bankAddress, String bankContacts) {
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.bankContacts = bankContacts;
    }

    public Banks() {
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankContacts() {
        return bankContacts;
    }

    public void setBankContacts(String bankContacts) {
        this.bankContacts = bankContacts;
    }

    public void printBankInfo() {
        System.out.println("bankName\t | bankAddress\t | bankContacts \t |");
        System.out.println(bankName +"\t| " + bankAddress + "\t| " +
                bankContacts);
    }


}

