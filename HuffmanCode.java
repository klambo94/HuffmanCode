import java.util.*;

/**
 * Class to create the huffmen code and then be able to encode String and
 * decode strings based off the huffman code created.
 * @author Kendra Lamb
 */
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
    public HuffmanCode(final String seed) {
        this.seed = seed;
        this.table = findFrequency(seed);
        this.hmap = new HashMap<Character, StringOfBits>();
        HuffmanTree huffmanTree = buildHuffmanTree();
        List<HuffmanTreeNodeValues> nodes = huffmanTree.inorderValues();
        nodes.stream().filter(node -> node.getSymbol() != null)
                .forEach(node -> { hmap.put(node.getSymbol(), node.getCode());
        });
    }

    /**
     * Creates a Huffman code for a given
     * frequency table.
     * @param table the symbol frequency
     *              table from which the
     *              code is generated
     */
    public HuffmanCode(final HashMap<Character, Double> table) {
        this.table = table;
        this.hmap = new HashMap<Character, StringOfBits>();
        HuffmanTree huffmanTree = buildHuffmanTree();
        List<HuffmanTreeNodeValues> nodes = huffmanTree.inorderValues();
        nodes.stream().filter(node -> node.getSymbol() != null)
                .forEach(node -> { hmap.put(node.getSymbol(), node.getCode());
        });
    }

    /**
     * Creates a Huffman code for a
     * given mapping of symbols to codes.
     * @param hmap the mapping from
     *              symbols to their encodings
     */
    public HuffmanCode(final Map<Character, StringOfBits> hmap) {
        this.hmap = hmap;
    }

    /**
     * Encodes a string using the Huffman code of this object.
     * @param inputString the string to be encoded
     * @return the compressed encoding of the parameter
     */
    public StringOfBits encode(final String inputString) {
        StringOfBits bitString = new StringOfBits();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.toUpperCase().charAt(i);
            StringOfBits code = hmap.get(c);
            bitString.append(code);
        }
        return bitString;
    }

    /**
     * Encodes the input String based on the Huffman Code Tree.
     * @param inputString The String to Encode
     * @param huffmanTree Tree holding Symbols and Frequencies
     * @return String encoded in Huffman Code
     */
    private StringOfBits encodedString(final String inputString,
                                       final HuffmanTree huffmanTree) {
        List<HuffmanTreeNodeValues> nodes = huffmanTree.inorderValues();
        StringOfBits encodedString = new StringOfBits();
        for (int i = 0; i < inputString.length() - 1; i++) {
            char c = inputString.charAt(i);
            for (HuffmanTreeNodeValues node: nodes) {
                if (node.getSymbol().equals(c)) {
                    encodedString.append(node.getCode());
                    break;
                }
            }
        }
        return encodedString;
    }


    /**
     * Decodes a bit string (0s and 1s) using
     * the Huffman code of this object.
     * @param encodedString the string to be decoded
     * @return the decoded version of the parameter
     */
    public String decode(final StringOfBits encodedString) {
        String decodedString = "";
        String encodedSubString;
        String stringToDecode = encodedString.toString();
        Set<Character> symbols = hmap.keySet();
        int beginIndex = 0;
        for (int i = 0; i < stringToDecode.length() + 1; i++) {
            encodedSubString = stringToDecode.substring(beginIndex, i);
            for (Character symbol : symbols) {
                String bits = hmap.get(symbol).toString();
                if (encodedSubString.equals(bits)) {
                    decodedString = decodedString + symbol;
                    beginIndex = i;
                    break;
                }
            }

        }
        return decodedString;
    }
    /**
     * Returns the mapping of symbols to codes for this object.
     * @return this Huffman code as a map
     */
    public Map<Character, StringOfBits> getCode() {
        return this.hmap;
    }

    /**
     * Finds the frequency of each character of the input String.
     * Normalizes the string to upper case before finding frequency.
     * @param inputString String to find the frequency of
     * @return Map of Characters and frequency count in inputString
     */
    private HashMap<Character, Double> findFrequency(final String
                                                             inputString) {
       String input = inputString.toUpperCase();
        HashMap<Character, Double> frequencyMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            Double val = frequencyMap.get(c);
            if (val != null) {
                frequencyMap.put(c, val + 1);
            } else {
                frequencyMap.put(c, 1.0);
            }
        }
        return frequencyMap;
    }
    /**
    * Builds a Huffman Code Tree from the inputString.
    * @return Tree holding Symbols, Frequencies
    */
    private HuffmanTree buildHuffmanTree() {
        List<HuffmanTreeNodeValues> nodes = getHuffmanNodes();
        Stack<HuffmanTree> nodeStack = getNodeStack(nodes);
        Stack<HuffmanTree> subTreeStack = getSubTreeStack(nodeStack,
                                                    new Stack<HuffmanTree>());
        HuffmanTree huffTree = buildTreeFromSubTrees(new HuffmanTree(null),
                subTreeStack);
        addCodesToTreeValues(huffTree);
        return huffTree;
    }


    /**
     * Creates Huffman Tree Nodes holding the Symbol and their frequency.
     * @return List of HummanTreeNodes
     */
    private List<HuffmanTreeNodeValues> getHuffmanNodes() {
        List<HuffmanTreeNodeValues> nodes = new ArrayList<>();
        this.table.forEach(((symbol, value) -> {
            nodes.add(new HuffmanTreeNodeValues(symbol, value, null));
        }));
        return nodes;
    }

    /**
     * Creates a priority queue that holds the lowest frequency value at the
     * top, and the highest frequency value at the bottom.
     * @param nodes List of HuffmanTreeNodes
     * @return queue
     */
    private  Stack<HuffmanTree> getNodeStack (final List<HuffmanTreeNodeValues>
                                                                     nodes) {
        Stack<HuffmanTree> nodeStack = new Stack<HuffmanTree>();
        nodes.sort((node1, node2) -> node1.getFrequency().compareTo
                (node2.getFrequency()));

        for (HuffmanTreeNodeValues node: nodes) {
            nodeStack.push(new HuffmanTree(node));
        }
        return nodeStack;
    }

    /**
     * Creates a Priority Queue based on the subtrees that were created from
     * individual nodes.
     * @param nodes nodes Create SubTree with
     * @return Prioritized queue of subtrees
     */
    private Stack<HuffmanTree> getSubTreeStack (final Stack<HuffmanTree>
                                                         nodes, final
                                                            Stack<HuffmanTree>
                                                                subTreeStack) {
        if (nodes.isEmpty()) {
            return subTreeStack;
        } else {
            HuffmanTree node1 = nodes.pop();
            HuffmanTree node2 = nodes.isEmpty() ? null : nodes.pop();

            Double node1Sum = node1 != null ? node1.getFrequency() : 0.0;
            Double node2Sum = node2 != null ? node2.getFrequency() : 0.0;
            Double sum = node1Sum + node2Sum;

            HuffmanTreeNodeValues root = new HuffmanTreeNodeValues(null, sum,
                    null);
            subTreeStack.push(new HuffmanTree(root, node1, node2));
            return getSubTreeStack(nodes, subTreeStack);
        }
    }

    /**
     * Builds a Huffman Tree from a Priority queue of Subtrees.
     * @param subTreeStack subTree Queue
     * @param tree HuffmanTree to build from
     * @return Huffman Tree
     */
    private HuffmanTree buildTreeFromSubTrees (final HuffmanTree tree, final
                                                    Stack<HuffmanTree>
                                                         subTreeStack) {
        if (subTreeStack.isEmpty()) {
            return tree;
        } else {
            HuffmanTree tree1 = subTreeStack.pop();
            HuffmanTree tree2 = subTreeStack.isEmpty() ? null : subTreeStack
                    .pop();

            HuffmanTree newTree = buildNewTree(tree1, tree2);

            return buildTreeFromSubTrees(buildNewTree(tree, newTree),
                                                                 subTreeStack);
        }
    }

    /**
     * Constructs a new tree given the left and right child.
     * @param tree1 Tree for Left child
     * @param tree2 Tree for right child
     * @return tree with root, left and right children.
     */
    private HuffmanTree buildNewTree(final HuffmanTree tree1, final HuffmanTree
            tree2) {
        Double sumSubOfTrees = sumOfTwoTrees(tree1, tree2);
        HuffmanTreeNodeValues root = new HuffmanTreeNodeValues(null,
                                                         sumSubOfTrees, null);
        return new HuffmanTree(root, tree1, tree2);
    }

    /**
     * Gets the frequency of the two tree's and returns the sum.
     * @param tree1 Tree to add frequency to tree2
     * @param tree2 Tree to add frequency to tree1
     * @return sum of tree1 and tree2 frequencies
     */
    private Double sumOfTwoTrees(final HuffmanTree tree1, final HuffmanTree
            tree2) {
        Double freq1 = !tree1.isEmpty() ? tree1.getFrequency() : 0.0;
        Double freq2 = !tree2.isEmpty() ? tree2.getFrequency() : 0.0;
        return freq1 + freq2;
    }

    /**
     * Add the code to the leaves of the tree.
     * @param huffmanTree Tree holding Symbols and Frequencies
     */
    private void addCodesToTreeValues (final HuffmanTree huffmanTree) {
        addCodes(huffmanTree);
    }

    /**
     * Recursively traverses the tree and add's the node's huffman code based
     * on the location in the tree.
     * @param huffmanTree Tree to traverse
     * @return HuffmanTree with non-null codes.
     */
    private HuffmanTree addCodes(final HuffmanTree huffmanTree) {
        if (huffmanTree.numberOfNodes() > 1) {
            if (!huffmanTree.getLeftChild().isEmpty()) {
                HuffmanTree leftChild = huffmanTree.getLeftChild();
                StringOfBits parentCode = huffmanTree.getCode();
                if (parentCode == null) {
                    leftChild.setCode(new StringOfBits("1"));
                } else {
                    leftChild.setCode(new StringOfBits(parentCode).append(1));
                }
                addCodes(huffmanTree.getLeftChild());
            }

            if (!huffmanTree.getRightChild().isEmpty()) {
                HuffmanTree rightChild = huffmanTree.getRightChild();
                StringOfBits parentCode = huffmanTree.getCode();
                if (huffmanTree.getCode() == null) {
                    rightChild.setCode(new StringOfBits("0"));
                } else {
                    rightChild.setCode(new StringOfBits(parentCode).append(0));
                }
                addCodes(huffmanTree.getRightChild());
            }
        }
        return huffmanTree;
    }
}
