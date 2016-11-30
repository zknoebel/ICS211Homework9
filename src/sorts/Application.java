package sorts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Application {
	public static void main(String[] args)throws java.io.IOException{
		BufferedReader br0 = new BufferedReader(new FileReader("src//txtFiles//A10-1000-words.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader("src//txtFiles//A10-5000-words.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("src//txtFiles//A10-10000-words.txt"));

		ArraySort sorter = new ArraySort();
		CompareStrings comp = new CompareStrings();
		
		String[] file0 = new String[1000];
		String[] file1 = new String[5000];
		String[] file2 = new String[10000];
		
		for(int i = 0; i < 1000; i ++){
			file0[i] = br0.readLine();
		}
		
			for(int i = 0; i < 5000; i ++){
			file1[i] = br1.readLine();
		}

			for(int i = 0; i < 10000; i ++){
			file2[i] = br2.readLine();
		}
			
		
			sorter.heapSort(file0, comp);
			for(int i = 0; i < 1000; i ++){
				System.out.println(file0[i]);
			}
			System.out.println("");
			System.out.println("Time: " + sorter.getSortTime() + " nano seconds");
			System.out.println("Comparisons: " + sorter.getCompareCount());
			System.out.println("Swaps: " + sorter.getSwapCount());
			System.out.println("");


			sorter.heapSort(file1, comp);

			sorter.heapSort(file2, comp);

		br0.close();
		br1.close();
		br2.close();
	}
}
