//QUESTION #2:

//Write a Java method that takes an array of "sets" of String objects,
//and determines whether _all_ sets in the array are equivalent.

//Each "set" in the input array is represented as an array of String objects, in 
//no particular order, and possibly containing duplicates. Nevertheless, when
//determining whether two of these "sets" are equivalent, you should disregard
//order and duplicates. For example, the sets represented by these arrays are
//all equivalent:

//{"a", "b"}
//{"b", "a"}
//{"a", "b", "a"}

//The signature for your method should be:

//public static boolean allStringSetsIdentical(String[ ][ ] sets)

//Examples of the method in operation:

//allStringSetsIdentical(new String[][] {{"a","b"},{"b","b","a"},{"b","a"}})
//returns true

//allStringSetsIdentical(new String[][] {{"a","b"},{"a"},{"b"}}) returns false
import java.util.*;

class Solution{
	public boolean allStringSetsIdentical(String [][] sets){
		int i;
		if(sets==null || sets.length==1 || sets.length==0){
			return true;
		}
		
		Set<String> base = new HashSet<String>();
		for(String str: sets[0]){
			base.add(str);
		}
		for(i=1;i<sets.length;i++){
			Set<String> indvSet = new HashSet<String>();
			for(String str: sets[i]){
				indvSet.add(str);
			}
			if(!base.equals(indvSet)){
				return false;
			}
		}
		
		/*for(i=1;i<inputList.size();i++){
			if(!inputList.get(0).equals(inputList.get(i))){
				return false;
			}
		}*/
			
		return true;
	} 
}
public class stringcheck {

	public static void main(String[] args) {
		int i, pass=0,fail=0;
		Solution sol = new Solution();
		String [][][] input = {
                null,
                {},
                {{}},
                {{"a"}},
                { {}, {} },
                { {}, {"a"} },
                { {"a", "b"}, {"b", "b", "a"}, {"b", "a"} },
                { {"a", "b"}, {"a"}, {"b"}},
                { {"a"}, {"b"}, {"c"} }
		};
        boolean[] result={
                true,
                true,
                true,
                true,
                true,
                false,
                true,
                false,
                false
        };

		System.out.println("Executing test cases..");
		for(i=0;i<input.length;i++){
			boolean status;
			status = sol.allStringSetsIdentical(input[i]);
			if(status==result[i]){
				System.out.println("Test - " + (i+1)+ " : passed");
				pass++;
			}else{
				System.out.println("Test - " + (i+1)+ " : failed");
				fail++;
			}
		}
		System.out.println();
		System.out.println("Summary of test results");
		System.out.println("Total Test Cases : " + (pass+fail));
		System.out.println("Total Failed Test Cases : " + (fail));
		System.out.println("Total Passed Cases : " + (pass));
		

	}

}
