package gr.aueb.cf.ch12.bankapp.model2;

public class Account {
    private Holder holder;
    private String iban;
    private double balance;

    public Account() {}

    public Account(Holder holder, String iban, double balance) {
        this.holder = holder;
        this.iban = iban;
        this.balance = balance;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *  Deposits a zero or positive amount of money to account's balance.
     * @param amount    the amount of money to be deposited.
     * @throws Exception  if the amount is negative.
     */
    public void deposit(double amount) throws Exception {
        try {
            if (amount>=0) {
                balance += amount;
            } else throw new Exception("Negative amount exception");
        }catch(Exception e) {
            //e.printStackTrace();
            throw e;
        }
    }

    /**
     *  Withdraws a certain amount of money from account's balance.
     * @param amount    The amount to be withdrawn.
     * @throws Exception  if the amount is greater than the account's balance
     *                    or ssn is not valid.
     */
    public void withdraw(double amount, String ssn) throws Exception {
        try {
            if (!isSsnValid(ssn)) throw new Exception("Ssn not valid exception");
            if (amount <= balance) {
                balance -= amount;
            } else throw new Exception("Insufficient balance exception");
        } catch(Exception e) {
            //e.printStackTrace();
            throw e;
        }
    }

    /**
     *  Returns the account's balance.
     * @return the account's balance.
     */
    public double getAccountBalance() {
        return getBalance();
    }

    public String getAccountState() {
        return "(" + holder.getId() + ", " + iban + ", " + holder.getFirstname() + ", "
                + holder.getLastname() + ", " + holder.getSsn() + ", " + balance + ")";
    }

    private boolean isSsnValid(String ssn) {
        return holder.getSsn().equals(ssn);
    }
}
