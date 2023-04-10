public class BubbleSort {
    public void sort(BankAccount[] account, MyComparator compare){
        int n = account.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (compare.less(account[j],account[j+1])) {
                    BankAccount temp = account[j];
                    account[j] = account[j + 1];
                    account[j + 1] = temp;
                }
    }
}
