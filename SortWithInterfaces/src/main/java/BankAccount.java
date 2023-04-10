public class BankAccount {
    protected int numWithdraws;
    protected double balance;
    BankAccount(double initialBalance, int draws){
        balance = initialBalance;
        numWithdraws = draws;
    }
    public double getBalance(){
        return balance;
    }
    public int getNumWithdraws(){
        return numWithdraws;
    }
    public void deposit(double amount){
        balance += amount;

    }
    public void withdraw(double amount){};
    public void endMonth(){};
    public boolean equals(Object obj) {
        // standard equals() technique 1
        if (obj == this) return true;

        // standard equals() technique 2
        // (null will be false)
        if (!(obj instanceof BankAccount)) return false;
        //Piece other = (Piece) obj;
        else{
            return this.getBalance() == ((BankAccount) obj).getBalance() && this.getNumWithdraws() == ((BankAccount) obj).getNumWithdraws();

        }

    }
}
