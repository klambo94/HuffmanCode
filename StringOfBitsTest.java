import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


/**
 * Tests for StringOfBits
 * @author Kendra Lamb
 */
public class StringOfBitsTest {
    private final CharSequence HELLO_WORLD = "hello world";
    private final String HELLO_WORLD_BIT_STRING =
            "01101000011001010110110001101100011011110010000001110111011011"
                                                + "11011100100110110001100100";

    private final int HELLO_WORLD_BIT_STRING_LENGTH =
            HELLO_WORLD_BIT_STRING.length();

    private final CharSequence HELLO = "hello";
    private final String HELLO_BIT_STRING =
            "0110100001100101011011000110110001101111";
    private final int HELLO_BIT_STRING_LENGTH = HELLO_BIT_STRING.length();

    private StringOfBits emptyStringOfBits() {
        return new StringOfBits();
    }

    private StringOfBits helloWorldStringOfBits() {
        return new StringOfBits(HELLO_WORLD);
    }
    @Test
    public void emptyStringTest() {
        assertEquals(0, emptyStringOfBits().length());
    }

    @Test
    public void bitStringTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD_BIT_STRING, sb.getBitString());
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH,
                sb.getBitString().length());
    }

    @Test
    public void cloneConstructorTest() {
        StringOfBits clone = new StringOfBits(helloWorldStringOfBits());
        assertEquals(clone.toString(), helloWorldStringOfBits().toString());
    }

    @Test
    public void emptyStringOfBitsAppendCharTest() {
        StringOfBits sb = emptyStringOfBits();
        char c =  '1';
        assertEquals(0, sb.length());
        sb.append(c);
        assertEquals(1, sb.length());
        assertEquals(String.valueOf(c), sb.getBitString());
        System.out.println(sb.getBitString());
    }

    @Test
    public void stringOfBitsAppendCharTest() {
        StringOfBits sb = helloWorldStringOfBits();
        char c = '1';
        sb.append(c);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 1, sb.getBitString().length());
        assertEquals(HELLO_WORLD_BIT_STRING + String.valueOf(c),
                sb.getBitString());
    }

    @Test
    public void emptyStringOfBitsMultipleAppendCharValueTest() {
        StringOfBits sb = emptyStringOfBits();
        char one =  '1';
        char zero = '0';
        sb.append(zero);
        sb.append(one);
        assertEquals(2, sb.length());
        assertEquals(String.valueOf(zero) + String.valueOf(one),
                sb.getBitString());
    }

    @Test
    public void stringOfBitsMultipleAppendCharValueTest() {
        StringOfBits sb = helloWorldStringOfBits();
        char one =  '1';
        char zero = '0';
        sb.append(zero);
        sb.append(one);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 2, sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING + String.valueOf(zero)
                + String.valueOf(one), sb.getBitString());
    }

    @Test
    public void emptyStringOfBitsAppendBooleanValueZeroTest() {
        StringOfBits sb = emptyStringOfBits();
        sb.append(false);
        assertEquals(1, sb.length());
        assertEquals(String.valueOf(0), sb.getBitString());
    }

    @Test
    public void emptyStringOfBitsAppendBooleanValueOneTest() {
        StringOfBits sb = emptyStringOfBits();
        sb.append(true);
        assertEquals(1, sb.length());
        assertEquals(String.valueOf(1), sb.getBitString());
    }

    @Test
    public void stringOfBitsAppendBooleanValueZeroTest() {
        StringOfBits sb = helloWorldStringOfBits();
        sb.append(false);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 1, sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING + String.valueOf(0),
                sb.getBitString());
    }

    @Test
    public void stringOfBitsAppendBooleanValueOneTest() {
        StringOfBits sb = helloWorldStringOfBits();
        sb.append(true);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 1, sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING + String.valueOf(1),
                sb.getBitString());
    }

    @Test
    public void emptyStringOfBitsMultipleAppendBooleanValueTest() {
        StringOfBits sb = emptyStringOfBits();
        sb.append(false);
        sb.append(true);
        assertEquals(2, sb.length());
        assertEquals(String.valueOf(0) + String.valueOf(1),
                sb.getBitString());
    }

    @Test
    public void stringOfBitsMultipleAppendBooleanValueTest() {
        StringOfBits sb = helloWorldStringOfBits();
        sb.append(false);
        sb.append(true);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 2, sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING + String.valueOf(0)
                + String.valueOf(1), sb.getBitString());
    }

    @Test
    public void emptyStringOfBitsAppendIntValueZeroTest() {
        StringOfBits sb = emptyStringOfBits();
        sb.append(0);
        assertEquals(1, sb.length());
        assertEquals(String.valueOf(0), sb.getBitString());
    }

    @Test
    public void emptyStringOfBitsAppendIntValueOneTest() {
        StringOfBits sb = emptyStringOfBits();
        sb.append(1);
        assertEquals(1, sb.length());
        assertEquals(String.valueOf(1), sb.getBitString());
    }

    @Test
    public void stringOfBitsAppendIntValueZeroTest() {
        StringOfBits sb = helloWorldStringOfBits();
        sb.append(0);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 1, sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING
                + String.valueOf(0), sb.getBitString());
    }

    @Test
    public void stringOfBitsAppendIntValueValueOneTest() {
        StringOfBits sb = helloWorldStringOfBits();
        sb.append(1);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 1, sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING
                + String.valueOf(1), sb.getBitString());
    }

    @Test
    public void emptyStringOfBitsMultipleAppendIntValueTest() {
        StringOfBits sb = emptyStringOfBits();
        sb.append(0);
        sb.append(1);
        assertEquals(2, sb.length());
        assertEquals(String.valueOf(0) + String.valueOf(1),
                sb.getBitString());
    }

    @Test
    public void stringOfBitsMultipleAppendIntValueTest() {
        StringOfBits sb = helloWorldStringOfBits();
        sb.append(0);
        sb.append(1);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 2, sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING + String.valueOf(0)
                + String.valueOf(1), sb.getBitString());
    }


    @Test
    public void emptyStringOfBitsAppendCharSequenceValueZeroTest() {
        StringOfBits sb = emptyStringOfBits();
        CharSequence cs = "0";
        sb.append(cs);
        assertEquals(1, sb.length());
        assertEquals(String.valueOf(cs), sb.getBitString());
    }

    @Test
    public void emptyStringOfBitsAppendCharSequenceValueOneTest() {
        StringOfBits sb = emptyStringOfBits();
        CharSequence cs = "1";
        sb.append(cs);
        assertEquals(1, sb.length());
        assertEquals(String.valueOf(cs), sb.getBitString());
    }

    @Test
    public void stringOfBitsAppendCharSequenceValueZeroTest() {
        StringOfBits sb = helloWorldStringOfBits();
        CharSequence cs = "0";
        sb.append(cs);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 1, sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING + String.valueOf(cs),
                sb.getBitString());
    }

    @Test
    public void stringOfBitsAppendCharSequenceValueOneTest() {
        StringOfBits sb = helloWorldStringOfBits();
        CharSequence cs = "0";
        sb.append(cs);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 1, sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING + String.valueOf(cs),
                sb.getBitString());
    }

    @Test
    public void emptyStringOfBitsMultipleAppendCharSequenceTest() {
        StringOfBits sb = emptyStringOfBits();
        CharSequence cs = "0";
        sb.append(cs);
        assertEquals(1, sb.length());
        assertEquals(String.valueOf(cs), sb.getBitString());
    }

    @Test
    public void stringOfBitsMultipleAppendCharSequenceTest() {
        StringOfBits sb = helloWorldStringOfBits();
        CharSequence cs = "01";
        sb.append(cs);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 2, sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING  + String.valueOf(cs),
                sb.getBitString());
    }

    @Test
    public void emptyStringOfBitsAppendStringOfBitsTest() {
        StringOfBits sb = emptyStringOfBits();
        StringOfBits appendStringOfBits = new StringOfBits(HELLO);
        sb.append(appendStringOfBits);
        assertEquals(HELLO_BIT_STRING_LENGTH, sb.length());
        assertEquals(HELLO_BIT_STRING,
                sb.getBitString());
    }

    @Test
    public void stringOfBitsAppendStringOfBitsTest() {
        StringOfBits sb = helloWorldStringOfBits();
        StringOfBits appendHelloWorldStringOfBits = new StringOfBits(HELLO);
        sb.append(appendHelloWorldStringOfBits);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + HELLO_BIT_STRING_LENGTH,
                sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING + HELLO_BIT_STRING,
                sb.getBitString());
    }

    @Test
    public void emptyStringOfBitsMultipleAppendStringOfBitsTest() {
        StringOfBits sb = emptyStringOfBits();
        StringOfBits appendStringOfBits = new StringOfBits(HELLO);
        sb.append(appendStringOfBits);
        sb.append(appendStringOfBits);
        assertEquals(HELLO_BIT_STRING_LENGTH * 2, sb.length());
        assertEquals(HELLO_BIT_STRING + HELLO_BIT_STRING,
                sb.getBitString());
    }

    @Test
    public void stringOfBitsMultipleAppendStringOfBitsTest() {
        StringOfBits sb = helloWorldStringOfBits();
        StringOfBits appendHelloWorldStringOfBits = new StringOfBits(HELLO);
        sb.append(appendHelloWorldStringOfBits);
        sb.append(appendHelloWorldStringOfBits);
        assertEquals((HELLO_WORLD_BIT_STRING_LENGTH + HELLO_BIT_STRING_LENGTH
                * 2), sb.length());
        assertEquals(HELLO_WORLD_BIT_STRING + HELLO_BIT_STRING
                + HELLO_BIT_STRING, sb.getBitString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsCharAtTest() {
        StringOfBits sb = emptyStringOfBits();
        sb.charAt(10);
    }

    @Test
    public void testCharAtTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals('0', sb.charAt(0));
        assertEquals('1', sb.charAt(1));
        assertEquals('1', sb.charAt(10));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsIntAtTest() {
        StringOfBits sb = emptyStringOfBits();
        sb.intAt(10);
    }

    @Test
    public void testIntAtTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(0, sb.intAt(0));
        assertEquals(1, sb.intAt(1));
        assertEquals(1, sb.intAt(10));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsIBooleanAtTest() {
        StringOfBits sb = emptyStringOfBits();
        sb.booleanAt(10);
    }

    @Test
    public void testooleanAtTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertFalse(sb.booleanAt(0));
        assertTrue(sb.booleanAt(1));
        assertTrue(sb.booleanAt(10));
    }

    @Test
    public void setFirstBitEmptyStringOfBitsCharTestTest() {
        StringOfBits sb = emptyStringOfBits();
        assertEquals(0, sb.length());
        sb.setBitAt(0, '1');
        assertEquals(1, sb.length());
        assertEquals('1', sb.charAt(0));
    }

    @Test
    public void setArbitraryEmptyStringOfBitsBitCharTest() {
        StringOfBits sb = emptyStringOfBits();
        assertEquals(0, sb.length());
        sb.setBitAt(10, '1');
        assertEquals('1', sb.charAt(10));
        assertEquals(11, sb.length());
    }

    @Test
    public void setFirstBitStringOfBitsCharTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        sb.setBitAt(0, '1');
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        assertEquals('1', sb.charAt(0));
    }

    @Test
    public void setArbitraryStringOfBitsBitCharTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        sb.setBitAt(90, '1');
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 3, sb.length());
        assertEquals('1', sb.charAt(10));
    }

    @Test
    public void setIndexGreaterThanStringOfBitsCharTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        sb.setBitAt(10, '1');
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        assertEquals('1', sb.charAt(10));
    }

    @Test
    public void setFirstBitEmptyStringOfBitsIntTest() {
        StringOfBits sb = emptyStringOfBits();
        assertEquals(0, sb.length());
        sb.setBitAt(0, 1);
        assertEquals(1, sb.length());
        assertEquals(1, sb.intAt(0));
    }

    @Test
    public void setArbitraryEmptyStringOfBitsBitIntTest() {
        StringOfBits sb = emptyStringOfBits();
        assertEquals(0, sb.length());
        sb.setBitAt(10, 1);
        assertEquals(11, sb.length());
        assertEquals(1, sb.intAt(10));
    }

    @Test
    public void setFirstBitStringOfBitsIntTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        sb.setBitAt(0, 0);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        assertEquals(0, sb.intAt(0));
    }

    @Test
    public void setArbitraryStringOfBitsBitIntTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        sb.setBitAt(10, 1);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        assertEquals(1, sb.intAt(10));
    }

    @Test
    public void setLargerIndexStringOfBitsBitCharTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        sb.setBitAt(90, 1);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH + 3, sb.length());
        assertEquals('1', sb.charAt(10));
    }

    @Test
    public void setFirstBitEmptyStringOfBitsIBooleanOneTest() {
        StringOfBits sb = emptyStringOfBits();
        assertEquals(0, sb.length());
        sb.setBitAt(0, true);
        assertEquals(1, sb.length());
        assertTrue(sb.booleanAt(0));
    }

    @Test
    public void setArbitraryEmptyStringOfBitsBitBooleanOneTest() {
        StringOfBits sb = emptyStringOfBits();
        assertEquals(0, sb.length());
        sb.setBitAt(10, true);
        assertEquals(11, sb.length());
        assertTrue(sb.booleanAt(10));
    }

    @Test
    public void setFirstBitStringOfBitsBooleanOneTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        sb.setBitAt(2, true);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        assertTrue(sb.booleanAt(2));
    }

    @Test
    public void setArbitraryStringOfBitsBitBooleanOneTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        sb.setBitAt(10, true);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        assertTrue(sb.booleanAt(10));
    }

    @Test
    public void setFirstBitEmptyStringOfBitsIBooleanZeroTest() {
        StringOfBits sb = emptyStringOfBits();
        assertEquals(0, sb.length());
        sb.setBitAt(0, false);
        assertEquals(1, sb.length());
        assertFalse(sb.booleanAt(0));
    }

    @Test
    public void setArbitraryEmptyStringOfBitsBitBooleanZeroTest() {
        StringOfBits sb = emptyStringOfBits();
        assertEquals(0, sb.length());
        sb.setBitAt(10, false);
        assertEquals(11, sb.length());
        assertFalse(sb.booleanAt(10));
    }

    @Test
    public void setFirstBitStringOfBitsBooleanOZeroTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        sb.setBitAt(0, false);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        assertFalse(sb.booleanAt(0));
    }

    @Test
    public void setArbitraryStringOfBitsBitBooleanZeroTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        sb.setBitAt(9, false);
        assertEquals(HELLO_WORLD_BIT_STRING_LENGTH, sb.length());
        assertFalse(sb.booleanAt(9));
    }

    @Test
    public void toStringTest() {
        StringOfBits sb = helloWorldStringOfBits();
        assertEquals(HELLO_WORLD, sb.toString());
    }
}
