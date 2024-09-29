import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class MediatorClassTest {

	@Test
	public void testToStringList() {

       		NumStreamImplementation numStream = new NumStreamImplementation();
        
     		List<Integer> testList = List.of(0, 1, 2, 3);
      		numStream.setIntegerList(testList);  

        	List<String> output = toStringList(numStream);

        	List<String> expectedOutput = List.of("0", "1" , "2", "3");

        	assertEquals(expectedOutput, output);
    }
	
	private List<String> toStringList(NumStream stream){
		ArrayList<Integer> integers = (ArrayList<Integer>) stream.getIntegers();
		ArrayList<String> strings = new ArrayList<String>();
		for (Integer integer : integers) {
			strings.add(String.valueOf(integer));
		}
		return strings;

	}
}
