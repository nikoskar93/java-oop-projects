package gr.aueb.cf.ch12.bankapp.model;

/**
 * An account that can have two holders
 *
 * @author nikoskar93
 */
public class JointAccount {
    private int id;
    private String iban;
    private String firstname1;
    private String lastname1;
    private String firstname2;
    private String lastname2;
    private String ssn;
    private double balance;

    public JointAccount() {}

    public JointAccount(int id, String iban, String firstname1, String lastname1, String firstname2, String lastname2, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.firstname1 = firstname1;
        this.lastname1 = lastname1;
        this.firstname2 = firstname2;
        this.lastname2 = lastname2;
        this.ssn = ssn;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFirstname1() {
        return firstname1;
    }

    public void setFirstname1(String firstname1) {
        this.firstname1 = firstname1;
    }

    public String getLastname1() {
        return lastname1;
    }

    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    public String getFirstname2() {
        return firstname2;
    }

    public void setFirstname2(String firstname2) {
        this.firstname2 = firstname2;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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
            throw e;
        }
    }

    /**
     *  Withdraws a certain amount of money from account's balance.
     *
     * @param amount    The amount to be withdrawn.
     * @param ssn       The account's ssn.
     * @throws Exception
     *          if the amount is greater than the account's balance
     *          or ssn is not valid.
     */
    public void withdraw(double amount, String ssn) throws Exception {
        try {
            if (!isSsnValid(ssn)) throw new Exception("Ssn not valid exception");
            if (amount <= balance) {
                balance -= amount;
            } else throw new Exception("Insufficient balance exception");
        } catch(Exception e) {
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

    /**
     *  Prints the account information as a string.
     * @return the account info.
     */
    public String getAccountState() {
        return "(" + id + ", " + iban + ", " + firstname1 + ", "
                + lastname1 + ", " + firstname2 + ", "
                + lastname2 + ", " + ssn + ", " + balance + ")";
    }

    /**
     *  Check if the ssn is valid.
     * @param ssn the given ssn
     * @return true, if the given ssn matches the account's ssn,
     *          false otherwise
     */
    private boolean isSsnValid(String ssn) {
        return this.ssn.equals(ssn);
    }
}
