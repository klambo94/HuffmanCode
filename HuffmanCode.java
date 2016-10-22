import java.util.HashMap;
import java.util.Map;

public class HuffmanCode {
    /** Seed String to create code for.*/
    private String seed;
    /** HashMap to hold character frequencies.*/
    private HashMap<Character, Double> table;
    /** Map to hold character codes. */
    private Map<Character, StringOfBits> hmap;

    /**
     * Creates a Huffman code for
     * a given seed string.
     * @param seed the string from which
     *             the code is generated
     */

    //This is the message body that will contain the statistics of the
    // messages you will send. Ex. if we were to send twitter messages the
    // seed would be a concatenation of all the twitter messages that would
    // hold the common used languages and characters.
    public HuffmanCode(final String seed) {

    }
    /**
     * Creates a Huffman code for a given
     * frequency table.
     * @param table the symbol frequency
     *              table from which the
     *              code is generated
     */
    public HuffmanCode(final HashMap<Character, Double> table) {

    }

    /**
     * Creates a Huffman code for a
     * given mapping of symbols to codes.
     * @param hmap the mapping from
     *              symbols to their encodings
     */
    public HuffmanCode(final Map<Character, StringOfBits> hmap) {

    }

    /**
     * Encodes a string using the Huffman code of this object.
     * @param inputString the string to be encoded
     * @return the compressed encoding of the parameter
     */
    public StringOfBits encode(final String inputString) {
        return new StringOfBits();
    }

    /**
     * Decodes a bit string (0s and 1s) using
     * the Huffman code of this object.
     * @param encodedString the string to be decoded
     * @return the decoded version of the parameter
     */
    public String decode(final StringOfBits encodedString) {
        return null;
    }

    /**
     * Returns the mapping of symbols to codes for this object.
     * @return this Huffman code as a map
     */
    public Map<Character, StringOfBits> getCode() {
        return hmap;
    }

    /**
     * Finds the frequency of each character of the input String.
     * Normalizes the string to upper case before finding frequency.
     * @param inputString String to find the frequency of
     * @return Map of Characters and frequency count in inputString
     */
    private HashMap<Character, Integer> findFrequency(String inputString) {
        inputString = inputString.toUpperCase();
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            Integer val = frequencyMap.get(c);
            if (val != null) {
                frequencyMap.put(c, val + 1);
            } else {
                frequencyMap.put(c, 1);
            }
        }
        return frequencyMap;
    }

    //Method for priority queus
    //Method for transfering priority queue
    //Method for creating single HuffmanNodeValue
    //Method for creating a sumTree
    //Method for creating whole tree
    //Method to create code based on tree made
}
