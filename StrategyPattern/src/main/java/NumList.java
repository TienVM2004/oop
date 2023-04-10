public class NumList {
    private SortAlgorithm sortAlgo;
    private double[] listOfNums;

    public int add(double num){
        if(listOfNums == null) {
            listOfNums = new double[]{num};
            return 1;
        }
        else{
            double[] newList = new double[listOfNums.length + 1];
            for(int i = 0; i < listOfNums.length; i ++){
                newList[i] = listOfNums[i];
            }
            newList[listOfNums.length] = num;
            listOfNums = newList;
        }
        return listOfNums.length;
    }
    public double[] getNumList(){
        return listOfNums;
    }
    public void setBubbleSort(){
        sortAlgo = new BubbleSort();
    }
    public void setQuickSort(){
        sortAlgo = new QuickSort();
    }
    public void setOrder() throws Exception {
        if(listOfNums.length == 0) throw new Exception("lmao");
        sortAlgo.sort(this);
    }
    public double[] getList(){
        return listOfNums;
    }
}
