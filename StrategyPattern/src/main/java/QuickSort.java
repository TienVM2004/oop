public class QuickSort implements SortAlgorithm{
    public int partition(double[] list, int low, int high) {
        double pivot = list[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {

            if (list[j] < pivot) {
                i++;

                // swap arr[i] và arr[j]
                double temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        double temp = list[i + 1];
        list[i + 1] = list[high];
        list[high] = temp;

        return i + 1;
    }

    public void QSort(double[] list, int low, int high){
        if (low < high) {
            int p = partition(list, low, high);
            QSort(list,low,p - 1);
            QSort(list, p + 1, high);
        }
    }
    @Override
    public void sort(NumList numList) {
        QSort(numList.getList(), 0, numList.getList().length-1);
    }

}
