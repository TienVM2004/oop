public class BubbleSort implements SortAlgorithm{

    @Override
    public void sort(NumList numList){
        double[] arr = numList.getNumList();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }


}
