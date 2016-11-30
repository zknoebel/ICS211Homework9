package sorts;
import java.util.Random;

/*
 * @author Zachery Knoebel
 * 
 * Class Main is used to test the ArraySort class and to test the run times of the three sorting algorithm methods 
 * within the ArraySort class.
 */
public class Main {

  /*
   * Method main runs four different run time test methods. Three big O tests and one average time test
   */
  public static void main(String[] args) {

    Main tester = new Main();

    tester.bigOBubTest();
    tester.bigOInsTest();
    tester.bigOSelTest();
//    avgTest takes a couple minutes depending on how fast your computer is
//    tester.avgTest();

  }

  ArraySort<Integer> test = new ArraySort<Integer>();
  CompareNumbers comp = new CompareNumbers();
  int arrayLength = 5000;
  int numberOfTests = 1000;
  Random randomGeneration = new Random();

  /*
   * these variables are used to store the values of the number of comparisons, swaps and run times of the bubbleSort,
   * insertionSort and selectionSort methods
   */
  long avgBubComps = 0, avgBubSwaps = 0, avgBubTime = 0;
  long avgInsComps = 0, avgInsSwaps = 0, avgInsTime = 0;
  long avgSelComps = 0, avgSelSwaps = 0, avgSelTime = 0;

  Integer[] testArray;


  /*
   * builds an array of length arrLength that is filled with random numbers between -999 and 999
   */
  private void arrayBuild(int arrLength) {
    testArray = new Integer[arrLength];
    for (int j = 0; j < arrLength; j++) {
      testArray[j] = randomGeneration.nextInt(1000) * (int) Math.pow(-1, j);
    }

  }


  /*
   * runs the bubbleSort, insertionSort and selectionSort methods of class ArraySort numberOfTests times and then takes
   * the averages of the number of swaps, number of comparisons and run times for each method
   */
  private void avgTest() {

    for (int i = 0; i < numberOfTests; i++) {
      arrayBuild(arrayLength);
      test.bubbleSort(testArray, comp);
      avgBubComps += test.getCompareCount();
      avgBubSwaps += test.getSwapCount();
      avgBubTime += test.getSortTime();
    }
    for (int i = 0; i < 1000; i++) {
      arrayBuild(arrayLength);
      test.insertionSort(testArray, comp);
      avgInsComps += test.getCompareCount();
      avgInsSwaps += test.getSwapCount();
      avgInsTime += test.getSortTime();
    }
    for (int i = 0; i < 1000; i++) {
      arrayBuild(arrayLength);
      test.selectionSort(testArray, comp);
      avgSelComps += test.getCompareCount();
      avgSelSwaps += test.getSwapCount();
      avgSelTime += test.getSortTime();
    }

    System.out.println("Bubble Sort");
    System.out.println("Average number of comparisons: " + avgBubComps / numberOfTests);
    System.out.println("Average number of swaps: " + avgBubSwaps / numberOfTests);
    System.out.println("Average sort time: " + avgBubTime / numberOfTests + " nano Seconds");
    System.out.println("");
    System.out.println("Insertion Sort");
    System.out.println("Average number of comparisons: " + avgInsComps / numberOfTests);
    System.out.println("Average number of swaps: " + avgInsSwaps / numberOfTests);
    System.out.println("Average sort time: " + avgInsTime / numberOfTests + " nano Seconds");
    System.out.println("");
    System.out.println("Selection Sort");
    System.out.println("Average number of comparisons: " + avgSelComps / numberOfTests);
    System.out.println("Average number of swaps: " + avgSelSwaps / numberOfTests);
    System.out.println("Average sort time: " + avgSelTime / numberOfTests + " nano Seconds");
    System.out.println("");
  }


  /*
   * runs the bubbleSort method for arrays with random numbers between -999 and 999. Starts with an array of 10, next an
   * array of 100, then an array of 1000 and finally an array of 5000. This is used to show how the run time of the
   * bubble sort grows exponentially
   */
  private void bigOBubTest() {
    arrayBuild(10);
    test.bubbleSort(testArray, comp);
    test.printResults(testArray, "Bubble Sort");
    arrayBuild(100);
    test.bubbleSort(testArray, comp);
    test.printResults(testArray, "Bubble Sort");
    arrayBuild(1000);
    test.bubbleSort(testArray, comp);
    test.printResults(testArray, "Bubble Sort");
    arrayBuild(5000);
    test.bubbleSort(testArray, comp);
    test.printResults(testArray, "Bubble Sort");
  }


  /*
   * runs the insertionSort method for arrays with random numbers between -999 and 999. Starts with an array of 10, next
   * an array of 100, then an array of 1000 and finally an array of 5000. This is used to show how the run time of the
   * insertion sort grows exponentially
   */
  private void bigOInsTest() {
    arrayBuild(10);
    test.insertionSort(testArray, comp);
    test.printResults(testArray, "Insertion Sort");
    arrayBuild(100);
    test.insertionSort(testArray, comp);
    test.printResults(testArray, "Insertion Sort");
    arrayBuild(1000);
    test.insertionSort(testArray, comp);
    test.printResults(testArray, "Insertion Sort");
    arrayBuild(5000);
    test.insertionSort(testArray, comp);
    test.printResults(testArray, "Insertion Sort");
  }


  /*
   * runs the selectionSort method for arrays with random numbers between -999 and 999. Starts with an array of 10, next
   * an array of 100, then an array of 1000 and finally an array of 5000. This is used to show how the run time of the
   * selection sort grows exponentially
   */
  private void bigOSelTest() {
    arrayBuild(10);
    test.selectionSort(testArray, comp);
    test.printResults(testArray, "Selection Sort");
    arrayBuild(100);
    test.selectionSort(testArray, comp);
    test.printResults(testArray, "Selection Sort");
    arrayBuild(1000);
    test.selectionSort(testArray, comp);
    test.printResults(testArray, "Selection Sort");
    arrayBuild(5000);
    test.selectionSort(testArray, comp);
    test.printResults(testArray, "Selection Sort");
  }


  /*
   * used to create on object of Main so the methods other than main can be used
   */
  Main() {

  }
}
