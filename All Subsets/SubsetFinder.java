import java.util.ArrayList;
import java.util.List;

public class SubsetFinder {
	
	public static int c=0; 		// c is the counter
	
	public static void  main(String[] args)
	{
		System.out.println("{ }");
		
		//the array that you need to find the subset of
		int a[] = {1,2,3};
		List<List<Integer>> listNum = new ArrayList<>();
		for( int i = 0; i < a.length; i++ ){
			List<Integer> ln =  new ArrayList<>();
			listNum.add(ln);
			ln.add( a[i] );	
		}		
		System.out.println(" Number of Subsets = " + ++c );
	}	
}