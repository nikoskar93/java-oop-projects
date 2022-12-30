package gr.aueb.cf.ch12.bankapp.model2;

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

    public String getAccountState() {
        return "(" + account.getHolder().getId() + ", " + account.getHolder().getFirstname() + ", " + account.getHolder().getLastname() + ", " + account.getHolder().getSsn()+ ", " + holder2.getId() + ", " + holder2.getFirstname() + ", "
                + holder2.getLastname() + ", " + holder2.getSsn() + ", " + account.getIban() + ", " + account.getAccountBalance() + ")";
    }

    private boolean isSsnValid(String ssn) {
        return account.getHolder().getSsn().equals(ssn) || holder2.getSsn().equals(ssn);
    }
}
