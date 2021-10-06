package example;

public class SelectSorter implements Sorter{

    private int[] a;

    private String plan = "";

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    

    @Override
    public void sort() {
        selectSort(0, a.length - 1);
    }

    private void selectSort(int begin, int end){
        for(int i = 0; i < a.length; ++i){
            int min_index = i;
            for(int j = i + 1; j < a.length; ++j){
                if(a[j] < a[min_index]){
                    min_index = j;
                }
            }
            swap(i, min_index);
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}
