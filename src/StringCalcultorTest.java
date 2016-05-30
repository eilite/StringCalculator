import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalcultorTest {
	StringCalculator sc = new StringCalculator();

	@Test
	public void blankStringReturnsZero(){
		assertEquals(sc.add(""), 0);
	}
	
	@Test
	public void oneLengthStringReturnsSum(){
		assertEquals(sc.add("1"), 1);
	}
	
	@Test
	public void twoLengthStringReturnsSum(){
		assertEquals(sc.add("1,2"), 3);
	}

	@Test
	public void unlimitedLenghtStringReturnsSum(){
		assertEquals(sc.add("1,2,3,4,5"),1+2+3+4+5);
	}
	
	@Test
	public void stringWithOtherSeparatorThanComma(){
		assertEquals(sc.add("1\n2"),3);
	}

	@Test
	public void stringWithDelimiterInBeggining(){
		assertEquals(sc.add("//;\n1;2"), 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void stringWithNegativeNumbers(){
		sc.add("1,-1");
	}
}
