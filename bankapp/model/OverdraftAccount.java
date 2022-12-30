package gr.aueb.cf.ch12.bankapp.model;

/**
 * An account that gives the holder the possibility
 * to withdraw any amount, regardless of the
 * account's balance.
 */
public class OverdraftAccount {
    private int id;
    private String iban;
    private String firstname;
    private String lastname;
    private String ssn;
    private double balance;

    public OverdraftAccount() {}

    public OverdraftAccount(int id, String iban, String firstname, String lastname, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.firstname = firstname;
        this.lastname = lastname;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
            //e.printStackTrace();
            throw e;
        }
    }

    /**
     *  Withdraw certain amount from the account's balance,
     *  regardless of the balance.
     * @param amount    the amount to be withdrawn
     * @param ssn       the account's ssn.
     * @throws Exception
     *          if the ssn is not valid.
     */
    public void withdrawOverdraft(double amount, String ssn) throws Exception {
        try {
            if (!isSsnValid(ssn)) throw new Exception("Ssn not valid exception");
            balance -= amount;
        }catch (Exception e) {
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
        return "(" + id + ", " + iban + ", " + firstname + ", "
                + lastname + ", " + ssn + ", " + balance + ")";
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
