public class SortUtil {

    public static <T> void sort (Precedente<T>[] array){
        bubbleSort(array);
    }

    private static <T>  void bubbleSort(Precedente<T>[] array) {
        for(int i = 0; i < array.length; i++){
            for(int j = i; j < array.length; j++){
                if(array[i].precedeA((T) array[j]) >= 0){
                    Precedente<T> element = array[i];
                    array[i] = array[j];
                    array[j] = element;
                }
            }
        }
    }
}
