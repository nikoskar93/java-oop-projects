package gr.aueb.cf.ch12.bankapp.model2;

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

    public void withdrawOverdraft(double amount, String ssn) throws Exception {
        try {
            if (!isSsnValid(ssn)) throw new Exception("Ssn not valid exception");
            account.setBalance(account.getBalance() - amount);
        }catch (Exception e) {
            throw e;
        }
    }

    private boolean isSsnValid(String ssn) {
        return account.getHolder().getSsn().equals(ssn);
    }
}
