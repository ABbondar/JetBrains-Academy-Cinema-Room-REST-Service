public class SavingsAccount extends BankAccount {
    protected double interestRate;

    public SavingsAccount(String number, Long balance, double interestRate) {
        super(number, balance);
        this.interestRate = interestRate;
    }
}
