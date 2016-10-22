import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

/**
 * Testing suite for HuffmanTree.java
 * @author Kendra Lamb
 */
public class HuffmanTreeTest {
    private final Character NEW_SYMBOL = 'A';
    private final Double NEW_FREQUENCY = 3.0;
    private final StringOfBits NEW_CODE = new StringOfBits("000");

    private HuffmanTree getHLeafNode() {
        HuffmanTreeNodeValues data = new HuffmanTreeNodeValues('H', 1.0, new
                StringOfBits("1111"));
        return new HuffmanTree(data);
    }

    private HuffmanTree getELeafNode() {
        HuffmanTreeNodeValues data = new HuffmanTreeNodeValues('E', 1.0, new
                StringOfBits("1110"));
        return new HuffmanTree(data);
    }

    private HuffmanTree getLLeafNode() {
        HuffmanTreeNodeValues data = new HuffmanTreeNodeValues('L', 3.0, new
                StringOfBits("00"));
        return new HuffmanTree(data);
    }
    private HuffmanTree getSubTree() {
        return new HuffmanTree(2.0,
                                getHLeafNode(), getELeafNode());
    }

    @Test
    public void leafNodeTest() {
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
        HuffmanTree hLeafNode = getHLeafNode();
        HuffmanTree eLeafNode = getELeafNode();
        assertEquals(1, subTree.height());
        assertEquals(3, subTree.numberOfNodes());
    }

    @Test
    public void subTreeRightChildTest() {
        HuffmanTree subTree = getSubTree();
        HuffmanTree subTreeRightChild = subTree.getRightChild();
        HuffmanTree rightChild = getELeafNode();
        assertEquals(rightChild.getSymbol(), subTreeRightChild.getSymbol());
        assertEquals(rightChild.getFrequency(), subTreeRightChild
                .getFrequency());
        assertEquals(rightChild.getCode().toString(), subTreeRightChild
                .getCode().toString());
    }

    @Test
    public void subTreeLeftChildTest() {
        HuffmanTree subTree = getSubTree();
        HuffmanTree subTreeLeftChild = subTree.getLeftChild();
        HuffmanTree leftChild = getHLeafNode();
        assertEquals(leftChild.getSymbol(), subTreeLeftChild.getSymbol());
        assertEquals(leftChild.getFrequency(), subTreeLeftChild
                .getFrequency());
        assertEquals(leftChild.getCode().toString(), subTreeLeftChild
                .getCode().toString());
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
        assertTrue(leaf.getFrequency().equals(leaf.getFrequency()));
        assertTrue(leaf.getSymbol().equals(leaf.getSymbol()));
        HuffmanTree leaf2 = getHLeafNode();
        assertTrue(leaf.getSymbol().equals(leaf2.getSymbol()));
        assertTrue(leaf2.getSymbol().equals(leaf.getSymbol()));
        assertTrue(leaf.getFrequency().equals(leaf2.getFrequency()));
        assertTrue(leaf2.getFrequency().equals(leaf.getFrequency()));
        assertFalse(leaf.equals(null));
        HuffmanTree lLeaf = getLLeafNode();
        assertFalse(leaf.getFrequency().equals(lLeaf.getFrequency()));
        assertFalse(lLeaf.getFrequency().equals(leaf.getFrequency()));
        assertFalse(leaf.getSymbol().equals(lLeaf.getSymbol()));
        assertFalse(lLeaf.getSymbol().equals(leaf.getSymbol()));
    }

    @Test
    public void hashCodeTest() {
        HuffmanTree hleaf = getHLeafNode();
        assertEquals(hleaf.hashCode(), hleaf.hashCode());
        HuffmanTree eleaf = getELeafNode();
        assertEquals(eleaf.hashCode(), eleaf.hashCode());
        assertNotEquals(eleaf.hashCode(), hleaf.hashCode());
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
        assertEquals(1, hleaf.compareTo(lLeaf));
        assertEquals(-1, lLeaf.compareTo(hleaf));
        assertEquals(1, eleaf.compareTo(lLeaf));
        assertEquals(-1, lLeaf.compareTo(eleaf));
        assertEquals(0, eleaf.compareTo(hleaf));
        assertEquals(0, hleaf.compareTo(eleaf));
    }
}
