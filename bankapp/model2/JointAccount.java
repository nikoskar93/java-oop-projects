package gr.aueb.cf.ch12.bankapp.model2;

/**
 * An account that can have two holders
 *
 * @author nikoskar93
 */
public class JointAccount {
    private Account account;
    private Holder holder2;

    public JointAccount() {}

    public JointAccount(Account account, Holder holder2) {
        this.account = account;
        this.holder2 = holder2;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Holder getHolder2() {
        return holder2;
    }

    public void setHolder2(Holder holder2) {
        this.holder2 = holder2;
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
            if (amount <= account.getBalance()) {
                account.setBalance(account.getBalance() - amount);
            }
        }catch (Exception e) {
            throw e;
        }
    }

    /**
     *  Prints the account information as a string.
     * @return the account info.
     */
    public String getAccountState() {
        return "(" + account.getHolder().getId() + ", " + account.getHolder().getFirstname() + ", " + account.getHolder().getLastname() + ", " + account.getHolder().getSsn()+ ", " + holder2.getId() + ", " + holder2.getFirstname() + ", "
                + holder2.getLastname() + ", " + holder2.getSsn() + ", " + account.getIban() + ", " + account.getAccountBalance() + ")";
    }

    /**
     *  Check if the ssn is valid.
     * @param ssn the given ssn
     * @return true, if the given ssn matches the first
     *          or second account holder's ssn,
     *          false otherwise
     */
    private boolean isSsnValid(String ssn) {
        return account.getHolder().getSsn().equals(ssn) || holder2.getSsn().equals(ssn);
    }
}
