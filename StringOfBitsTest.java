/**
 * Created by Kendra's Laptop on 10/12/2016.
 */

import org.junit.Test;

import javax.print.DocFlavor;

import static org.junit.Assert.*;


/**
 * Tests for StringOfBits
 * @author Kendra Lamb
 */
public class StringOfBitsTest {
	private CharSequence HELLO_WORLD = "hello world";
	private String HELLO_WORLD_BIT_STRING = "10010000110010101101100"
											+ "0110110001101111001"
											+ "0000001010111011011"
											+ "1101110010011011000"
											+ "110010000100001";

	private int helloWorldLength = HELLO_WORLD_BIT_STRING.length();

	private StringOfBits emptyStringOfBits(){
		return new StringOfBits();
	}

	private StringOfBits helloWorldStringOfBits(){
		return new StringOfBits(HELLO_WORLD);
	}
	@Test
	public void emptyStringTest(){
		assertEquals(0, emptyStringOfBits().length());
	}

	@Test
	public void bitStringTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertNotEquals(0, sb.length());
		assertEquals(HELLO_WORLD_BIT_STRING, sb.getBinaryString());
		assertEquals(helloWorldLength,
				sb.getBinaryString().length());
	}

	@Test
	public void cloneConstructorTest(){
		StringOfBits clone = new StringOfBits(helloWorldStringOfBits());
		assertEquals(clone, helloWorldStringOfBits());
	}

	@Test
	public void emptyStringOfBitsAppendCharTest(){
		StringOfBits sb = helloWorldStringOfBits();
		char c =  '1';
		assertEquals(0, sb.length());
		sb.append(c);
		assertEquals(1, sb.length());
		assertEquals(String.valueOf(c), sb.getBinaryString());
	}

	@Test
	public void stringOfBitsAppendCharTest(){
		StringOfBits sb = helloWorldStringOfBits();
		char c = '1';
		sb.append(c);
		assertEquals(helloWorldLength  + 1, sb.getBinaryString().length());
		assertEquals(HELLO_WORLD_BIT_STRING + String.valueOf(c),
				sb.getBinaryString());
	}

	@Test
	public void emptyStringOfBitsMultipleAppendCharValueTest(){
		StringOfBits sb = emptyStringOfBits();
		char one =  '1';
		char zero = '0';
		sb.append(zero);
		sb.append(zero);
		assertEquals(2, sb.length());
		assertEquals(String.valueOf(zero) + String.valueOf(one),
				sb.getBinaryString());
	}

	@Test
	public void stringOfBitsMultipleAppendCharValueTest(){
		StringOfBits sb = helloWorldStringOfBits();
		char one =  '1';
		char zero = '0';
		sb.append(zero);
		sb.append(zero);
		assertEquals(helloWorldLength + 2, sb.length());
		assertEquals(HELLO_WORLD + String.valueOf(zero)
				+ String.valueOf(one), sb.getBinaryString());
	}

	@Test
	public void emptyStringOfBitsAppendBooleanValueZeroTest(){
		StringOfBits sb = emptyStringOfBits();
		sb.append(false);
		assertEquals(1, sb.length());
		assertEquals(String.valueOf(0), sb.getBinaryString());
	}

	@Test
	public void emptyStringOfBitsAppendBooleanValueOneTest(){
		StringOfBits sb = emptyStringOfBits();
		sb.append(true);
		assertEquals(1, sb.length());
		assertEquals(String.valueOf(1), sb.getBinaryString());
	}

	@Test
	public void stringOfBitsAppendBooleanValueZeroTest(){
		StringOfBits sb = helloWorldStringOfBits();
		sb.append(false);
		assertEquals(helloWorldLength + 1, sb.length());
		assertEquals(HELLO_WORLD + String.valueOf(0), sb.getBinaryString());
	}

	@Test
	public void stringOfBitsAppendBooleanValueOneTest(){
		StringOfBits sb = helloWorldStringOfBits();
		sb.append(true);
		assertEquals(helloWorldLength + 1, sb.length());
		assertEquals(HELLO_WORLD + String.valueOf(1), sb.getBinaryString());
	}

	@Test
	public void emptyStringOfBitsMultipleAppendBooleanValueTest(){
		StringOfBits sb = emptyStringOfBits();
		sb.append(false);
		sb.append(true);
		assertEquals(2, sb.length());
		assertEquals(String.valueOf(0) + String.valueOf(1),
				sb.getBinaryString());
	}

	@Test
	public void stringOfBitsMultipleAppendBooleanValueTest(){
		StringOfBits sb = helloWorldStringOfBits();
		sb.append(false);
		sb.append(true);
		assertEquals(helloWorldLength + 2, sb.length());
		assertEquals(HELLO_WORLD + String.valueOf(0)
				+ String.valueOf(1), sb.getBinaryString());
	}

	@Test
	public void emptyStringOfBitsAppendIntValueZeroTest(){
		StringOfBits sb = emptyStringOfBits();
		sb.append(0);
		assertEquals(1, sb.length());
		assertEquals(String.valueOf(0), sb.getBinaryString());
	}

	@Test
	public void emptyStringOfBitsAppendIntValueOneTest(){
		StringOfBits sb = emptyStringOfBits();
		sb.append(1);
		assertEquals(1, sb.length());
		assertEquals(String.valueOf(1), sb.getBinaryString());
	}

	@Test
	public void stringOfBitsAppendIntValueZeroTest(){
		StringOfBits sb = helloWorldStringOfBits();
		sb.append(0);
		assertEquals(helloWorldLength + 1, sb.length());
		assertEquals(HELLO_WORLD + String.valueOf(0),sb.getBinaryString());
	}

	@Test
	public void stringOfBitsAppendIntValueValueOneTest(){
		StringOfBits sb = helloWorldStringOfBits();
		sb.append(1);
		assertEquals(helloWorldLength + 1, sb.length());
		assertEquals(HELLO_WORLD + String.valueOf(1), sb.getBinaryString());
	}

	@Test
	public void emptyStringOfBitsMultipleAppendIntValueTest(){
		StringOfBits sb = emptyStringOfBits();
		sb.append(0);
		sb.append(1);
		assertEquals(2, sb.length());
		assertEquals(String.valueOf(0) + String.valueOf(1),
				sb.getBinaryString());
	}

	@Test
	public void stringOfBitsMultipleAppendIntValueTest(){
		StringOfBits sb = helloWorldStringOfBits();
		sb.append(0);
		sb.append(1);
		assertEquals(helloWorldLength + 2, sb.length());
		assertEquals(HELLO_WORLD + String.valueOf(0)
				+ String.valueOf(1), sb.getBinaryString());
	}


	@Test
	public void emptyStringOfBitsAppendCharSequenceValueZeroTest(){
		StringOfBits sb = emptyStringOfBits();
		CharSequence cs = "0";
		sb.append(cs);
		assertEquals(1, sb.length());
		assertEquals(String.valueOf(cs), sb.getBinaryString());
	}

	@Test
	public void emptyStringOfBitsAppendCharSequenceValueOneTest(){
		StringOfBits sb = emptyStringOfBits();
		CharSequence cs = "1";
		sb.append(cs);
		assertEquals(1, sb.length());
		assertEquals(String.valueOf(cs), sb.getBinaryString());
	}

	@Test
	public void stringOfBitsAppendCharSequenceValueZeroTest(){
		StringOfBits sb = helloWorldStringOfBits();
		CharSequence cs = "0";
		sb.append(cs);
		assertEquals(helloWorldLength + 1, sb.length());
		assertEquals(HELLO_WORLD + String.valueOf(cs), sb.getBinaryString());
	}

	@Test
	public void stringOfBitsAppendCharSequenceValueOneTest(){
		StringOfBits sb = helloWorldStringOfBits();
		CharSequence cs = "0";
		sb.append(cs);
		assertEquals(helloWorldLength + 1, sb.length());
		assertEquals(HELLO_WORLD + String.valueOf(cs), sb.getBinaryString());
	}

	@Test
	public void emptyStringOfBitsMultipleAppendCharSequenceTest(){
		StringOfBits sb = emptyStringOfBits();
		CharSequence cs = "0";
		sb.append(cs);
		assertEquals(2, sb.length());
		assertEquals(String.valueOf(cs), sb.getBinaryString());
	}

	@Test
	public void stringOfBitsMultipleAppendCharSequenceTest(){
		StringOfBits sb = helloWorldStringOfBits();
		CharSequence cs = "01";
		sb.append(cs);
		assertEquals(helloWorldLength + 2, sb.length());
		assertEquals(HELLO_WORLD + String.valueOf(cs), sb.getBinaryString());
	}

	@Test
	public void emptyStringOfBitsAppendStringOfBitsTest(){
		StringOfBits sb = emptyStringOfBits();
		StringOfBits appendStringOfBits = new StringOfBits("01");
		sb.append(appendStringOfBits);
		assertEquals(appendStringOfBits.length(), sb.length());
		assertEquals("01", sb.getBinaryString());
	}

	@Test
	public void stringOfBitsAppendStringOfBitsTest(){
		StringOfBits sb = helloWorldStringOfBits();
		StringOfBits appendHelloWorldStringOfBits = new StringOfBits("01");
		sb.append(appendHelloWorldStringOfBits);
		assertEquals(helloWorldLength + sb.length(), sb.length());
		assertEquals(HELLO_WORLD + "01", sb.getBinaryString());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsCharAtTest(){
		StringOfBits sb = emptyStringOfBits();
		sb.charAt(10);
	}

	@Test
	public void testCharAtTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertEquals('1', sb.charAt(0));
		assertEquals('0', sb.charAt(1));
		assertEquals('0', sb.charAt(10));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsIntAtTest(){
		StringOfBits sb = emptyStringOfBits();
		sb.intAt(10);
	}

	@Test
	public void testIntAtTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertEquals(1, sb.intAt(0));
		assertEquals(0, sb.intAt(1));
		assertEquals(0, sb.intAt(10));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsIBooleanAtTest(){
		StringOfBits sb = emptyStringOfBits();
		sb.booleanAt(10);
	}

	@Test
	public void testooleanAtTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertTrue(sb.booleanAt(0));
		assertFalse(sb.booleanAt(1));
		assertFalse(sb.booleanAt(10));
	}

	@Test
	public void setFirstBitEmptyStringOfBitsCharTestTest(){
		StringOfBits sb = emptyStringOfBits();
		assertEquals(0, sb.length());
		sb.setBitAt(0, '1');
		assertEquals(1, sb.length());
		assertEquals('1', sb.charAt(0));
	}

	@Test
	public void setArbitraryEmptyStringOfBitsBitCharTest(){
		StringOfBits sb = emptyStringOfBits();
		assertEquals(0, sb.length());
		sb.setBitAt(10, '1');
		assertEquals(10, sb.length());
		assertEquals('1', sb.charAt(10));
	}

	@Test
	public void setFirstBitStringOfBitsCharTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertEquals(helloWorldLength, sb.length());
		sb.setBitAt(0, '0');
		assertEquals(helloWorldLength, sb.length());
		assertEquals('0', sb.charAt(0));
	}

	@Test
	public void setArbitraryStringOfBitsBitCharTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertEquals(helloWorldLength, sb.length());
		sb.setBitAt(10, '1');
		assertEquals(helloWorldLength, sb.length());
		assertEquals('1', sb.charAt(10));
	}

	@Test
	public void setFirstBitEmptyStringOfBitsIntTest(){
		StringOfBits sb = emptyStringOfBits();
		assertEquals(0, sb.length());
		sb.setBitAt(0, 1);
		assertEquals(1, sb.length());
		assertEquals(1, sb.intAt(0));
	}

	@Test
	public void setArbitraryEmptyStringOfBitsBitIntTest(){
		StringOfBits sb = emptyStringOfBits();
		assertEquals(0, sb.length());
		sb.setBitAt(10, 1);
		assertEquals(10, sb.length());
		assertEquals(1, sb.intAt(10));
	}

	@Test
	public void setFirstBitStringOfBitsIntTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertEquals(helloWorldLength, sb.length());
		sb.setBitAt(0, 0);
		assertEquals(helloWorldLength, sb.length());
		assertEquals(0, sb.intAt(0));
	}

	@Test
	public void setArbitraryStringOfBitsBitIntTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertEquals(helloWorldLength, sb.length());
		sb.setBitAt(10, 1);
		assertEquals(helloWorldLength, sb.length());
		assertEquals(1, sb.intAt(10));
	}

	@Test
	public void setFirstBitEmptyStringOfBitsIBooleanOneTest(){
		StringOfBits sb = emptyStringOfBits();
		assertEquals(0, sb.length());
		sb.setBitAt(0, true);
		assertEquals(1, sb.length());
		assertTrue(sb.booleanAt(0));
	}

	@Test
	public void setArbitraryEmptyStringOfBitsBitBooleanOneTest(){
		StringOfBits sb = emptyStringOfBits();
		assertEquals(0, sb.length());
		sb.setBitAt(10, true);
		assertEquals(10, sb.length());
		assertTrue(sb.booleanAt(10));
	}

	@Test
	public void setFirstBitStringOfBitsBooleanOneTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertEquals(helloWorldLength, sb.length());
		sb.setBitAt(2, true);
		assertEquals(helloWorldLength, sb.length());
		assertTrue(sb.booleanAt(2));
	}

	@Test
	public void setArbitraryStringOfBitsBitBooleanOneTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertEquals(helloWorldLength, sb.length());
		sb.setBitAt(10, true);
		assertEquals(helloWorldLength, sb.length());
		assertTrue(sb.booleanAt(10));
	}

	@Test
	public void setFirstBitEmptyStringOfBitsIBooleanZeroTest(){
		StringOfBits sb = emptyStringOfBits();
		assertEquals(0, sb.length());
		sb.setBitAt(0, false);
		assertEquals(1, sb.length());
		assertFalse(sb.booleanAt(0));
	}

	@Test
	public void setArbitraryEmptyStringOfBitsBitBooleanZeroTest(){
		StringOfBits sb = emptyStringOfBits();
		assertEquals(0, sb.length());
		sb.setBitAt(10, false);
		assertEquals(10, sb.length());
		assertFalse(sb.booleanAt(10));
	}

	@Test
	public void setFirstBitStringOfBitsBooleanOZeroTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertEquals(helloWorldLength, sb.length());
		sb.setBitAt(0, false);
		assertEquals(helloWorldLength, sb.length());
		assertFalse(sb.booleanAt(0));
	}

	@Test
	public void setArbitraryStringOfBitsBitBooleanZeroTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertEquals(helloWorldLength, sb.length());
		sb.setBitAt(9, false);
		assertEquals(helloWorldLength, sb.length());
		assertFalse(sb.booleanAt(9));
	}

	@Test
	public void toStringTest(){
		StringOfBits sb = helloWorldStringOfBits();
		assertEquals(HELLO_WORLD, sb.toString());
	}
}
