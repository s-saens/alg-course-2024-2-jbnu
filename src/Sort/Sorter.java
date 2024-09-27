public class Sorter {
    
    public <T extends Comparable<T>> void sort(Iterable<T> c)
    {
        ArrayList<T> arr = new ArrayList<T>(c);
        sort(arr);
    }

    protected <T extends Comparable<T>> void _sort(ArrayList<T> arr) {}
}