/**
 * A HuffmanTree is a specialized BinaryTree used for developing and storing
 * a Huffman Code. Note that there is no empty tree constructor.
 * @author Kendra Lamb
 */
public class HuffmanTree
        extends BinaryTree<HuffmanTreeNodeValues>
        implements Comparable<HuffmanTree> {
    /**Maximum difference to accept two double values ae3dd33s equals.*/
    public static final double EPSILON = 0.0;

    /**
     * Constructor for leaf node.
     * @param data  an object
     *              containing the
     *              symbol, frequency,
     *              and code for this
     *              node.
     */
    public HuffmanTree(final HuffmanTreeNodeValues data) {
        super(data);
    }

    /**
     * Constructor for internal node.
     * @param data an object containing the
     *             symbol, code, and frequency
     *             for this node.
     * @param leftChild - the left child for this node
     * @param rightChild - the right child for this node
     */
    public HuffmanTree(final HuffmanTreeNodeValues data,
                       final HuffmanTree leftChild,
                       final HuffmanTree rightChild) {
        super(data, leftChild, rightChild);
    }

    /**
     * Parametrized constructor for leaf node.
     * @param symbol  the symbol stored in this node
     * @param frequency the code stored in this node
     * @param code the frequency stored in this node
     */
    public HuffmanTree(final Character symbol,
                       final Double frequency,
                       final StringOfBits code) {
        super(new HuffmanTreeNodeValues(symbol, frequency, code));
    }

    /**
     * Fully parametrized constructor.
     * @param symbol  the symbol stored in this node
     * @param frequency the code stored in this node
     * @param code the frequency stored in this node
     * @param leftChild  the left child for this node
     * @param rightChild the right child for this node
     */

    public HuffmanTree(final Character symbol,
                       final Double frequency,
                       final StringOfBits code,
                       final HuffmanTree leftChild,
                       final HuffmanTree rightChild) {
        super(new HuffmanTreeNodeValues(symbol, frequency, code), leftChild,
                rightChild);

    }

    /**
     * Frequency and children constructor; useful for internal
     * nodes. Sets symbol and code to null.
     * @param frequency the code stored in this node
     * @param leftChild  the left child for this node
     * @param rightChild the right child for this node
     */
    public HuffmanTree(final Double frequency,
                       final HuffmanTree leftChild,
                       final HuffmanTree rightChild) {
        this(null, frequency, null,
                leftChild, rightChild);
    }

    /**
     * Description copied from class: BinaryTree
     * Returns the left child of this tree.
     * Overrides getLeftChild in class
     * BinaryTree<HuffmanTreeNodeValues>
     * @return the left child; null if no such child
     */
    @Override
    public HuffmanTree getLeftChild() {
        return (HuffmanTree) super.getLeftChild();
    }

    /**
     * Description copied from class: BinaryTree
     * Returns the right child of this tree.
     * Overrides the right child; null if no such child
     * @return the right child; null if no such child
     */
    @Override
    public HuffmanTree getRightChild() {
        return (HuffmanTree) super.getRightChild();
    }

    /**
     * Retrieve the symbol stored in this root.
     * @return the symbol stored in this root
     */
    public Character getSymbol() {
        return super.getValue().getSymbol();
    }

    /**
     * Retrieve the code stored in this root.
     * @return the code stored in this root
     */
    public StringOfBits getCode() {
        return super.getValue().getCode();
    }

    /**
     * Retrieve the frequency stored in this root.
     * @return the frequency stored in this root
     */
    public Double getFrequency() {
        return super.getValue().getFrequency();
    }

    /**
     * Store the given parameter as the
     * symbol of this tree root.
     * @param symbol the new symbol
     *               for this root
     */
    public void setSymbol(final Character symbol) {
        super.getValue().setSymbol(symbol);
    }

    /**
     * Store the given parameter as the code
     * of this tree root.
     * @param code the new code for this root
     */
    public void setCode(final StringOfBits code) {
        super.getValue().setCode(code);
    }

    /**
     * Store the given parameter as the
     * frequency of this tree root.
     * @param frequency  the new frequency for this root
     */
    public void setFrequency(final Double frequency) {
        super.getValue().setFrequency(frequency);
    }

    /**
     * Equals predicate considers the symbol
     * and frequency only.
     * Overrides equals in class
     * BinaryTree<HuffmanTreeNodeValues>
     * @param o the object to check for
     *          equality
     * @return true if both the symbol and
     * the frequency agree; false otherwise
     * @ #see hashCode()
     */
    @Override
    public boolean equals(final Object o) {
        if (o instanceof HuffmanTree) {
            HuffmanTreeNodeValues values = ((HuffmanTree) o).getValue();
            return values.getSymbol().equals(this.getSymbol()) && values
                    .getFrequency().equals(this.getFrequency());
        } else {
            return false;
        }
    }

    /**
     * Returns a hash code value for
     * the object. Supported for the
     * benefit of hashtables.
     * Overrides hashCode in class
     * BinaryTree<HuffmanTreeNodeValues>
     * @return a hash code value for this object.
     * @ #see equals(Object o)
     */
    @Override
    public int hashCode() {
        int myCode = 1;
        if (super.getValue() != null) {
            HuffmanTreeNodeValues values = super.getValue();
            if (values.getSymbol() != null) {
                myCode = values.getSymbol().hashCode();
            } else {
                myCode += 2;
            }
            if (values.getFrequency() != null) {
                myCode = values.getFrequency().hashCode();
            } else {
                myCode += 2;
            }
            if (values.getCode() != null) {
                myCode = values.getCode().hashCode();
            } else {
                myCode += 2;
            }
        }

        if (super.getLeftChild() != null) {
            myCode = super.getLeftChild().hashCode();
        } else {
            myCode += 2;
        }

        if (super.getRightChild() != null) {
            myCode = super.getRightChild().hashCode();
        } else {
            myCode += 2;
        }

        return myCode;
    }

    /**
     *Compares this HuffmanTree with the parameter
     * for order. Returns a negative integer, zero,
     * or a positive integer as this object is less
     * than, equal to, or greater than the specified
     * object. Comparison considers frequency only;
     * null is considered to be lower than any other
     * frequency value.
     *
     * @param o  the object to be compared
     * @return a negative integer, zero,
     *         or a positive integer as this
     *         object is less than, equal to,
     *         or greater than the specified object
     */
    @Override
    public int compareTo(final HuffmanTree o) {
        double compareFrequency = o.getFrequency();
        double thisFrequency = this.getFrequency();
        if (compareFrequency > thisFrequency) {
            return 1;
        } else if (compareFrequency == thisFrequency) {
            return 0;
        } else {
            return -1;
        }
    }


}
