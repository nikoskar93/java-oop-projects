package gr.aueb.cf.ch12.bankapp.model2;

/**
 * An account that gives the holder the possibility
 * to withdraw any amount, regardless of the
 * account's balance.
 */
public class OverdraftAccount {
    private Account account;

    public OverdraftAccount() {}

    public OverdraftAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
            account.setBalance(account.getBalance() - amount);
        }catch (Exception e) {
            throw e;
        }
    }

    /**
     *  Check if the ssn is valid.
     * @param ssn the given ssn
     * @return true, if the given ssn matches the account's ssn,
     *          false otherwise
     */
    private boolean isSsnValid(String ssn) {
        return account.getHolder().getSsn().equals(ssn);
    }
}
