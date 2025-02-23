
// Strategy Pattern
import java.util.Arrays;

interface SortingStrategy{
    void sort(int[] input);
}

class QuickSortStrategy implements SortingStrategy{
    public void sort(int[] input){
         System.out.println("QuickSort algorithm used.");
         Arrays.sort(input);
    }
}

class BubbleSortStrategy implements SortingStrategy{
    public void sort(int[] input){
        System.out.println("BubbleSort algorithm used.");
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
    }
}

class Sorter{
    
    SortingStrategy sortingStrategy;
    Sorter(SortingStrategy strategy){
        this.sortingStrategy=strategy;
    }
    
    public void setstrategy(SortingStrategy strategy){
        this.sortingStrategy=strategy;
    }
    
    public void executeSort(int[] input){
        this.sortingStrategy.sort(input);
    }
}

public class Main
{
	public static void main(String[] args) {
	    QuickSortStrategy quickSortStrategy = new QuickSortStrategy();
	    Sorter sorter = new Sorter(quickSortStrategy);
	    int[] input = {1,0,90,13,4,56};
	    
	    sorter.executeSort(input);
	    
	    BubbleSortStrategy bubbleSortStrategy = new BubbleSortStrategy();
	    sorter.setstrategy(bubbleSortStrategy);
	    
	    sorter.executeSort(input);
	    
	    System.out.println("sorted input: ");
	    for(int i=0;i<input.length;i++){
	        System.out.print(input[i]+", ");
	    }
	    

	}
}

// more examples like vehicle drive strategy, etc
