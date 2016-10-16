import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Testing suite for HuffmanTree.java
 * @author Kendra Lamb
 */
public class HuffmanTreeTest {
    private final Character NEW_SYMBOL = 'A';
    private final Double NEW_FREQUENCY = 3.0;
    private final StringOfBits NEW_CODE = new StringOfBits("000");

    private HuffmanTree getHLeafNode() {
        return new HuffmanTree('H', 1.0, new StringOfBits("1111"));
    }

    private HuffmanTree getELeafNode() {
        return new HuffmanTree('E', 1.0, new StringOfBits("1110"));
    }

    private HuffmanTree getLLeafNode() {
        return new HuffmanTree('L', 3.0, new StringOfBits("00"));
    }
    private HuffmanTreeNodeValues getSumFrequencyDataNode() {
        return new HuffmanTreeNodeValues(null, 2.0, null);
    }
    private HuffmanTree getSubTree() {
        return new HuffmanTree(getSumFrequencyDataNode(),
                                getHLeafNode(), getELeafNode());
    }

    @Test
    public void leftNodeTest() {
        HuffmanTree hleaf = getHLeafNode();
        assertEquals(0, hleaf.height());
        assertFalse(hleaf.isEmpty());
        assertNotNull(hleaf.getValue());
        assertNull(hleaf.getLeftChild());
        assertNull(hleaf.getRightChild());
    }

    @Test
    public void subTreeTest() {
        HuffmanTree subTree = getSubTree();
        assertEquals(2, subTree.height());
        assertEquals(2, subTree.numberOfNodes());
        assertEquals(getHLeafNode(), subTree.getLeftChild());
        assertEquals(getELeafNode(), subTree.getRightChild());
    }

    @Test
    public void subTreeRightChildTest() {
        HuffmanTree subTree = getSubTree();
        HuffmanTree subTreeRightChild = subTree.getRightChild();
        HuffmanTree rightChild = getELeafNode();
        assertEquals(getELeafNode(), subTree.getRightChild());
        Character subTreeSymbol = subTreeRightChild.getSymbol();
        Character symbol = rightChild.getSymbol();
        assertEquals(symbol, subTreeSymbol);
        StringOfBits subTreeCode = subTreeRightChild.getCode();
        StringOfBits code = rightChild.getCode();
        assertEquals(code, subTreeCode);
        Double subTreeFrequency = subTreeRightChild.getFrequency();
        Double frequency = rightChild.getFrequency();
        assertEquals(frequency, subTreeFrequency);
    }

    @Test
    public void subTreeLeftChildTest() {
        HuffmanTree subTree = getSubTree();
        HuffmanTree subTreeLeftChild = subTree.getLeftChild();
        HuffmanTree leftChild = getHLeafNode();
        assertEquals(getHLeafNode(), subTree.getLeftChild());
        Character subTreeSymbol = subTreeLeftChild.getSymbol();
        Character symbol = leftChild.getSymbol();
        assertEquals(symbol, subTreeSymbol);
        StringOfBits subTreeCode = subTreeLeftChild.getCode();
        StringOfBits code = leftChild.getCode();
        assertEquals(code, subTreeCode);
        Double subTreeFrequency = subTreeLeftChild.getFrequency();
        Double frequency = leftChild.getFrequency();
        assertEquals(frequency, subTreeFrequency);
    }

    @Test
    public void modifyLeftChildTest() {
        HuffmanTree subTree = getSubTree();
        HuffmanTree subTreeLeftChild = subTree.getLeftChild();
        subTreeLeftChild.setCode(NEW_CODE);
        subTreeLeftChild.setFrequency(NEW_FREQUENCY);
        subTreeLeftChild.setSymbol(NEW_SYMBOL);
        assertEquals(NEW_CODE, subTreeLeftChild.getCode());
        assertEquals(NEW_FREQUENCY, subTreeLeftChild.getFrequency());
        assertEquals(NEW_SYMBOL, subTreeLeftChild.getSymbol());
    }

    @Test
    public void modifyLRighttChildTest() {
        HuffmanTree subTree = getSubTree();
        HuffmanTree subTreeRightChild = subTree.getRightChild();
        subTreeRightChild.setCode(NEW_CODE);
        subTreeRightChild.setFrequency(NEW_FREQUENCY);
        subTreeRightChild.setSymbol(NEW_SYMBOL);
        assertEquals(NEW_CODE, subTreeRightChild.getCode());
        assertEquals(NEW_FREQUENCY, subTreeRightChild.getFrequency());
        assertEquals(NEW_SYMBOL, subTreeRightChild.getSymbol());
    }

    @Test
    public void equalsNullTest() {
        HuffmanTree huffTree = getSubTree();
        assertFalse(huffTree.equals(null));
    }

    @Test
    public void equalsLeafTest() {
        HuffmanTree leaf = getHLeafNode();
        assertTrue(leaf.equals(leaf));
        HuffmanTree leaf2 = getHLeafNode();
        assertTrue(leaf.equals(leaf2));
        assertTrue(leaf2.equals(leaf));
        assertFalse(leaf.equals(null));
        HuffmanTree eleaf = getELeafNode();
        assertFalse(leaf.equals(eleaf));
        assertFalse(eleaf.equals(leaf));
    }

    @Test
    public void hashCodeTest() {
        HuffmanTree hleaf = getHLeafNode();
        HuffmanTree hleaf2 = getHLeafNode();
        assertTrue(hleaf.equals(hleaf2));
        assertEquals(hleaf.hashCode(), hleaf2.hashCode());
        HuffmanTree eleaf = getELeafNode();
        HuffmanTree eleaf2 = getELeafNode();
        assertTrue(eleaf.equals(eleaf2));
        assertEquals(eleaf.hashCode(), eleaf2.hashCode());
    }

    @Test
    public void compareToTest() {
        HuffmanTree hleaf = getHLeafNode();
        HuffmanTree hleaf2 = getHLeafNode();
        assertTrue(hleaf.equals(hleaf2));
        assertEquals(0, hleaf.compareTo(hleaf2));
        assertEquals(0, hleaf2.compareTo(hleaf));
        HuffmanTree eleaf = getELeafNode();
        HuffmanTree eleaf2 = getELeafNode();
        assertTrue(eleaf.equals(eleaf2));
        assertEquals(0, eleaf.compareTo(eleaf2));
        assertEquals(0, eleaf2.compareTo(eleaf));
        HuffmanTree lLeaf = getLLeafNode();
        assertEquals(-1, hleaf.compareTo(lLeaf));
        assertEquals(1, lLeaf.compareTo(hleaf));
        assertEquals(-1, eleaf.compareTo(lLeaf));
        assertEquals(1, lLeaf.compareTo(eleaf));
        assertEquals(0, eleaf.compareTo(hleaf));
        assertEquals(0, hleaf.compareTo(eleaf));
    }
}
