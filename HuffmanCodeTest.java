import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Testing suite for HuffmanCode.java
 * @author Kendra Lamb
 */
public class HuffmanCodeTest {
    private HuffmanCode huffCode = new HuffmanCode(INPUT_STRING);
    private static final String INPUT_STRING = "hello world";
    private StringOfBits ENCODED_HELLO_WORLD_STRING = new StringOfBits("1111110000001110110001110000101");

    private Map<Character, StringOfBits> getTestCodeMap() {
        HashMap<Character, StringOfBits> codeMap = new HashMap<>();
        codeMap.put('H', new StringOfBits("1111"));
        codeMap.put('E', new StringOfBits("1110"));
        codeMap.put(' ', new StringOfBits("1101"));
        codeMap.put('R', new StringOfBits("1100"));
        codeMap.put('D', new StringOfBits("101"));
        codeMap.put('W', new StringOfBits("100"));
        codeMap.put('O', new StringOfBits("01"));
        codeMap.put('L', new StringOfBits("00"));
        return codeMap;
    }

    @Test
    public void encodeTest() {
        StringOfBits encodedString = huffCode.encode(INPUT_STRING);
        assertEquals(ENCODED_HELLO_WORLD_STRING, encodedString);
    }

    @Test
    public void decodeTest() {
        String decodedString = huffCode.decode(ENCODED_HELLO_WORLD_STRING);
        assertEquals(INPUT_STRING, decodedString);
        assertEquals(INPUT_STRING.length(), decodedString.length());
    }

    @Test
    public void getCodeTest() {
        Map<Character, StringOfBits> codeMap = getTestCodeMap();
        assertEquals(codeMap, huffCode.getCode());
    }

}
