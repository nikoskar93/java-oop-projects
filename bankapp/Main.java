package gr.aueb.cf.ch12.bankapp;

import gr.aueb.cf.ch12.bankapp.model.JointAccount;
import gr.aueb.cf.ch12.bankapp.model.OverdraftAccount;

public class Main {

    public static void main(String[] args) {
        OverdraftAccount aliceOd = new OverdraftAccount(1, "GR12345", "Alice", "W.", "R123", 300);
        JointAccount aliceBob = new JointAccount(2, "GR98765", "Alice", "W.", "Bob", "W.", "R987", 800);

        try {
            aliceOd.deposit(100);
            System.out.println("Successful deposit");

            aliceOd.withdrawOverdraft(500, "R123");
            System.out.println("Successful withdrawal");

            System.out.println(aliceBob.getAccountState());

            aliceOd.withdrawOverdraft(100, "R987");
            System.out.println("Successful withdrawal");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
