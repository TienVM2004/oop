public class TransactionCountDescending implements MyComparator{
    @Override
    public boolean less(BankAccount a1, BankAccount a2) {
        return a1.getNumWithdraws() <= a2.getNumWithdraws();
    }
}
