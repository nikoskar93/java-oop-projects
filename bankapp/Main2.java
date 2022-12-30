package gr.aueb.cf.ch12.bankapp;

import gr.aueb.cf.ch12.bankapp.model2.Account;
import gr.aueb.cf.ch12.bankapp.model2.Holder;
import gr.aueb.cf.ch12.bankapp.model2.JointAccount;
import gr.aueb.cf.ch12.bankapp.model2.OverdraftAccount;

public class Main2 {

    public static void main(String[] args) {
        Account alice = new Account(new Holder(1L, "Alice", "W.", "R1234"), "GR12345", 400);
        OverdraftAccount alice2 = new OverdraftAccount(alice);
        Holder bob = new Holder(2L, "Bob", "W.", "R5678");
        JointAccount joint = new JointAccount(alice, bob);
        OverdraftAccount jointOverdraft = new OverdraftAccount(joint.getAccount());

        try {
            joint.getAccount().deposit(300);
            System.out.println(joint.getAccountState());
            joint.withdraw(300, "R5678");
            System.out.println(joint.getAccountState());
            alice2.withdrawOverdraft(500, "R1234");
            System.out.println(alice.getAccountBalance());
            joint.getAccount().deposit(500);
            System.out.println(alice.getAccountState());
            System.out.println(joint.getAccountState());
            jointOverdraft.withdrawOverdraft(500, "R1234");
            System.out.println(joint.getAccountState());
            alice.withdraw(500, "R1234");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
