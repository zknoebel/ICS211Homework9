package sorts;
import java.util.Comparator;

/*
 * @author Zachery Knoebel
 * 
 * used to create a comparator object that takes in Integers as the parameters
 */
public class CompareStrings implements Comparator<String> {

  public int compare(String a, String b) {

    return a.compareTo(b);
  }
}
