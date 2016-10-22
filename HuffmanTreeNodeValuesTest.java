import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
/**
 * Testing sutie for HuffmanTreeNodeValues
 * @author Kendra Lamb
 */
public class HuffmanTreeNodeValuesTest {

    private Character NEW_SYMBOL = 'H';
    private StringOfBits NEW_CODE = new StringOfBits("111");
    private Double NEW_FREQUENCY = 1.0;
    private StringOfBits A_CODE = new StringOfBits("101");
    /**
     * Generic empty Node for Testing
     * @return HuffmanTreeNodeValues
     * A node with null values
     */
    private HuffmanTreeNodeValues emptyHuffmanTreeNode() {
        return new HuffmanTreeNodeValues();
    }

    /**
     * Node for testing that holds Character A,
     * it's frequency, and the code for that character.
     * @return HuffmanTreeNodeValues A node with
     *      Character A, Frequency of 2, code of 101
     */
    private HuffmanTreeNodeValues huffmanTreeNode() {
        return new HuffmanTreeNodeValues('A', 2.0, A_CODE);
    }

    @Test
    public void getNullSymbolTest() {
        HuffmanTreeNodeValues huffCode = emptyHuffmanTreeNode();
        assertNull(huffCode.getSymbol());
    }

    @Test
    public void getSymbolTest() {
        HuffmanTreeNodeValues huffCode = huffmanTreeNode();
        assertEquals(String.valueOf('A'), String.valueOf(huffCode.getSymbol()));
    }

    @Test
    public void getNullCodeTest() {
        HuffmanTreeNodeValues huffCode = emptyHuffmanTreeNode();
        assertNull(huffCode.getCode());
    }

    @Test
    public void getCodeTest() {
        HuffmanTreeNodeValues huffCode = huffmanTreeNode();
        assertEquals(A_CODE, huffCode.getCode());
    }

    @Test
    public void getNullFrequencyTest() {
        HuffmanTreeNodeValues huffCode = emptyHuffmanTreeNode();
        assertNull(huffCode.getFrequency());
    }

    @Test
    public void getFrequencyTest() {
        HuffmanTreeNodeValues huffCode = huffmanTreeNode();
        assertEquals((Double) 2.0, huffCode.getFrequency());
    }

    @Test
    public void setNullSymbolTest() {
        HuffmanTreeNodeValues huffCode = emptyHuffmanTreeNode();
        huffCode.setSymbol(NEW_SYMBOL);
        assertEquals(String.valueOf(NEW_SYMBOL), String.valueOf(huffCode.getSymbol()));
    }

    @Test
    public void setSymbolTest() {
        HuffmanTreeNodeValues huffCode = huffmanTreeNode();
        huffCode.setSymbol(NEW_SYMBOL);
        assertEquals(String.valueOf(NEW_SYMBOL), String.valueOf(huffCode.getSymbol()));
    }

    @Test
    public void setNullCodeTest() {
        HuffmanTreeNodeValues huffCode = emptyHuffmanTreeNode();
        huffCode.setCode(NEW_CODE);
        assertEquals(String.valueOf(NEW_CODE), String.valueOf(huffCode.getCode()));
    }

    @Test
    public void setCodeTest() {
        HuffmanTreeNodeValues huffCode = huffmanTreeNode();
        huffCode.setCode(NEW_CODE);
        assertEquals(String.valueOf(NEW_CODE), String.valueOf(huffCode.getCode()));
    }

    @Test
    public void setNullFrequencyTest() {
        HuffmanTreeNodeValues huffCode = emptyHuffmanTreeNode();
        huffCode.setFrequency(NEW_FREQUENCY);
        assertEquals(NEW_FREQUENCY, huffCode.getFrequency());
    }

    @Test
    public void setFrequencyTest() {
        HuffmanTreeNodeValues huffCode = huffmanTreeNode();
        huffCode.setFrequency(NEW_FREQUENCY);
        assertEquals(NEW_FREQUENCY, huffCode.getFrequency());
    }

}
