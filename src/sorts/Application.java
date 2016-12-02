package sorts;

import java.io.BufferedReader;
import java.io.FileReader;

public class Application {
  public static void main(String[] args) throws java.io.IOException {
    String[] file0 = new String[1000];
    String[] file1 = new String[5000];
    String[] file2 = new String[10000];


    heapSortPrint(file0, file1, file2);
    mergeSortPrint(file0, file1, file2);
    quickSortPrint(file0, file1, file2);

  }


  public static void heapSortPrint(String[] file0, String[] file1, String[] file2) throws java.io.IOException {
    ArraySort<String> sorter = new ArraySort<>();
    CompareStrings comp = new CompareStrings();

    setArrays(file0, file1, file2);

    sorter.heapSort(file0, comp);
    printResults("Heap Sort", sorter, file0);

    sorter.heapSort(file1, comp);
    printResults("Heap Sort", sorter, file1);

    sorter.heapSort(file2, comp);
    printResults("Heap Sort", sorter, file2);

  }

  public static void quickSortPrint(String[] file0, String[] file1, String[] file2) throws java.io.IOException {
    ArraySort<String> sorter = new ArraySort<>();
    CompareStrings comp = new CompareStrings();
    
     setArrays(file0, file1, file2);
   
    sorter.quickSort(file0, comp);
    printResults("Quick Sort", sorter, file0);

    sorter.quickSort(file1, comp);
    printResults("Quick Sort", sorter, file1);

    sorter.quickSort(file2, comp);
    printResults("Quick Sort", sorter, file2);


  }

  public static void mergeSortPrint(String[] file0, String[] file1, String[] file2) throws java.io.IOException {
    ArraySort<String> sorter = new ArraySort<>();
    CompareStrings comp = new CompareStrings();
    
        setArrays(file0, file1, file2);

    sorter.mergeSort(file0, comp);
    printResults("Merge Sort", sorter, file0);

    sorter.mergeSort(file1, comp);
    printResults("Merge Sort", sorter, file1);

    sorter.mergeSort(file2, comp);
    printResults("Merge Sort", sorter, file2);


  }

  public static <E> void printResults(String sortName, ArraySort<E> sorter, E[] array){
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
    System.out.println("");
    System.out.println(sortName);
    System.out.println("Time: " + sorter.getSortTime() + " nano seconds");
    System.out.println("Comparisons: " + sorter.getCompareCount());
    System.out.println("Swaps: " + sorter.getSwapCount());
    System.out.println("");


  }

  public static <E> void setArrays(E[] array0, E[] array1, E[] array2)throws java.io.IOException{
    BufferedReader br0 = new BufferedReader(new FileReader("src//txtFiles//A10-1000-words.txt"));
    BufferedReader br1 = new BufferedReader(new FileReader("src//txtFiles//A10-5000-words.txt"));
    BufferedReader br2 = new BufferedReader(new FileReader("src//txtFiles//A10-10000-words.txt"));

    for (int i = 0; i < 1000; i++) {
      array0[i] = (E)br0.readLine();
    }

    for (int i = 0; i < 5000; i++) {
      array1[i] = (E)br1.readLine();
    }

    for (int i = 0; i < 10000; i++) {
      array2[i] = (E)br2.readLine();
    }

    br0.close();
    br1.close();
    br2.close();


  }
}
