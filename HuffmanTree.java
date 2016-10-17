import java.util.Spliterator;
import java.util.function.Consumer;

public class HuffmanTree
        extends BinaryTree<HuffmanTreeNodeValues>
        implements Comparable<HuffmanTree> {
    /**Maximum difference to accept two double values as equals.*/
    public static final double EPSILON = 0.0;

    /**  an object containing the symbol,
     * frequency, and code for this node. */
    private HuffmanTreeNodeValues data;

    /** Left Child node.*/
    private HuffmanTree leftChild;

    /** Right Child Node. */
    private HuffmanTree rightChild;

    /** Symbole stored in node. */
    private Character symbol;

    /** Frequency of node's symbol.*/
    private Double frequency;

    /** Code for the symbol,
     * based on the frequency
     * compared to other frequencies.*/
    private StringOfBits code;

    /**
     * Constructor for leaf node.
     * @param data  an object
     *              containing the
     *              symbol, frequency,
     *              and code for this
     *              nod.
     */
    public HuffmanTree(final HuffmanTreeNodeValues data) {

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

    }

    /**
     * Parameterized constructor for leaf node.
     * @param symbol  the symbol stored in this node
     * @param frequency the code stored in this node
     * @param code the frequency stored in this node
     */
    public HuffmanTree(final Character symbol,
                       final Double frequency,
                       final StringOfBits code) {

    }

    /**
     * Fully parameterized constructor.
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
        return this.leftChild;
    }

    /**
     * Description copied from class: BinaryTree
     * Returns the right child of this tree.
     * Overrides the right child; null if no such child
     * @return the right child; null if no such child
     */
    @Override
    public HuffmanTree getRightChild() {
        return this.rightChild;
    }

    /**
     * Retrieve the symbol stored in this root.
     * @return the symbol stored in this root
     */
    public Character getSymbol() {
        return this.symbol;
    }

    /**
     * Retrieve the code stored in this root
     * @return the code stored in this root
     */
    public StringOfBits getCode() {
        return this.code;
    }

    /**
     * Retrieve the frequency stored in this root.
     * @return the frequency stored in this root
     */
    public Double getFrequency() {
        return this.frequency;
    }

    /**
     * Store the given parameter as the
     * symbol of this tree root.
     * @param symbol the new symbol
     *               for this root
     */
    public void setSymbol(final Character symbol) {
        this.symbol = symbol;
    }

    /**
     * Store the given parameter as the code
     * of this tree root.
     * @param code the new code for this root
     */
    public void setCode(StringOfBits code) {
        this.code = code;
    }

    /**
     * Store the given parameter as the
     * frequency of this tree root.
     * @param frequency  the new frequency for this root
     */
    public void setFrequency(Double frequency) {
        this.frequency = frequency;
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
     */
    @Override
    public boolean equals(Object o) {
        return false;
    }

    /**
     * Returns a hash code value for
     * the object. Supported for the
     * benefit of hashtables.
     * Overrides hashCode in class
     * BinaryTree<HuffmanTreeNodeValues>
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return 0;
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
     * @param ht  the object to be compared
     * @return a negative integer, zero,
     * 		or a positive integer as this
     * 		object is less than, equal to,
     * 		or greater than the specified object
     */
    @Override
    public int compareTo(HuffmanTree ht)  {
        return 0;
    }

    @Override
    public void forEach(Consumer<? super BinaryTree<HuffmanTreeNodeValues>> action) {

    }

    @Override
    public Spliterator<BinaryTree<HuffmanTreeNodeValues>> spliterator() {
        return null;
    }
}
