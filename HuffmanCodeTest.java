import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Testing suite for HuffmanCode.java
 * @author Kendra Lamb
 */
public class HuffmanCodeTest {
    private HuffmanCode huffCode = new HuffmanCode(INPUT_STRING);
    private static final String INPUT_STRING = "hello world";
    private StringOfBits ENCODED_HELLO_WORLD_STRING = new StringOfBits("011" +
                                        "1001001001000101001000010110011000");
    private final Map<Character, StringOfBits> expectedCode =
            getTestCodeEncodedMap();

    /**
     * Creates a HashMap of Characters and their frequencies.
     * @return codeMap
     */
    private HashMap<Character, Double> getTestCodeFrequencyMap(){
        HashMap<Character, Double> codeMap = new HashMap<>();
        codeMap.put('H', 1.0);
        codeMap.put('E', 1.0);
        codeMap.put('L', 3.0);
        codeMap.put('O', 2.0);
        codeMap.put(' ', 1.0);
        codeMap.put('R', 1.0);
        codeMap.put('D', 1.0);
        codeMap.put('W', 1.0);
        return codeMap;
    }

    /**
     * Creates a HashMap Of Characters and their Codes.
     * @return codeMap
     */
    private HashMap<Character, StringOfBits> getTestCodeEncodedMap() {
        HashMap<Character, StringOfBits> codeMap = new HashMap<>();
        codeMap.put('H', new StringOfBits("011"));
        codeMap.put('E', new StringOfBits("1001"));
        codeMap.put(' ', new StringOfBits("1010"));
        codeMap.put('R', new StringOfBits("1011"));
        codeMap.put('D', new StringOfBits("1000"));
        codeMap.put('W', new StringOfBits("010"));
        codeMap.put('O', new StringOfBits("000"));
        codeMap.put('L', new StringOfBits("001"));
        return codeMap;
    }
    @Test
    public void huffmanCodeSeedTest(){
        HuffmanCode huffCode = new HuffmanCode(INPUT_STRING);
        Map<Character, StringOfBits> code = huffCode.getCode();
        assertEquals(expectedCode.toString(), code.toString());
    }

    @Test
    public void huffmanCodeFrequencyTableTest(){
        HashMap<Character, Double> freqTable = getTestCodeFrequencyMap();
        HuffmanCode huffCode = new HuffmanCode(freqTable);
        Map<Character, StringOfBits> code = huffCode.getCode();
        assertEquals(expectedCode.toString(), code.toString());
    }

    @Test
    public void huffmanCodeTableCodeTest(){
        HashMap<Character, StringOfBits> codeTable = getTestCodeEncodedMap();
        HuffmanCode huffCode = new HuffmanCode(codeTable);
        assertEquals(expectedCode.toString(), huffCode.getCode().toString());
    }

    @Test
    public void encodeTest() {
        StringOfBits encodedString = huffCode.encode(INPUT_STRING);
        assertEquals(ENCODED_HELLO_WORLD_STRING.toString(),
                encodedString.toString());
    }

    @Test
    public void decodeTest() {
        String decodedString = huffCode.decode(ENCODED_HELLO_WORLD_STRING);
        assertTrue(INPUT_STRING.equalsIgnoreCase(decodedString));
        assertEquals(INPUT_STRING.length(), decodedString.length());
    }

    @Test
    public void getCodeTest() {
        Map<Character, StringOfBits> codeMap = getTestCodeEncodedMap();
        assertEquals(codeMap.toString(), huffCode.getCode().toString());
    }

}
