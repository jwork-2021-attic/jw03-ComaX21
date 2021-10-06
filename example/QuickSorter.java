package example;

public class QuickSorter implements Sorter{

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
        quickSort(0, a.length - 1);
    }

    private void quickSort(int begin, int end){
        int base = a[begin];
        int pos = begin;
        for (int i = begin + 1; i < end + 1; i++) {
            if(a[i] < base){
                swap(pos, i);
                ++pos;
            }
        }
        if(begin < pos - 1)
            quickSort(begin, pos - 1);
        if(pos + 1 < end)
            quickSort(pos + 1, end);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}