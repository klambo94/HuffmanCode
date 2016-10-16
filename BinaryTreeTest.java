import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tests for the BinaryTree class
 * author: Jody Paul and Kendra Lamb
 */
public class BinaryTreeTest<T> {
	/** Number of nodes in standard test tree. */
	private static final int NUM_NODES_TEST_TREE = 9;
	/** Number of leaves in standard test tree. */
	private static final int NUM_LEAVES_TEST_TREE = 4;
	/** Height of standard test tree. */
	private static final int HEIGHT_TEST_TREE = 3;
	/** Number of nodes in small test tree. */
	private static final int NUM_NODES_SM_TREE = 3;
	/** Number of nodes in medium-sized test tree. */
	private static final int NUM_NODES_MED_TREE = 5;

	/*Data for Numeric Values*/
	/** Root indicator. */
	private static final Number ROOT = 42;
	/** Left child indicator. */
	private static final Number LEFT = new Integer(21);
	/** Right child indicator. */
	private static final Number RIGHT = new Integer(63);
	/** Left-Left child indicator. */
	private static final Number LEFT_LEFT = new Integer(10);
	/** Left-Right child indicator. */
	private static final Number LEFT_RIGHT = new Integer(30);
	/** Right-Left child indicator. */
	private static final Number RIGHT_LEFT = new Integer(50);
	/** Right-Right child indicator. */
	private static final Number RIGHT_RIGHT = new Integer(70);
	/** Right-Left-Right child indicator. */
	private static final Number RIGHT_LEFT_RIGHT = new Integer(55);
	/** Right-Right-LEFT child indicator. */
	private static final Number RIGHT_RIGHT_LEFT = new Integer(66);

	/** Default reject value. */
	private static final Number REJECT = new Byte((byte) 255);

	/** Test value for new tree. */
	private static final Number NEW_VALUE = new Byte((byte) 102);

	// Lettered value constants.
	private static final Number A =  0;
	private static final Number B =  1;
	private static final Number C =  2;
	private static final Number D =  3;
	private static final Number E =  4;
	private static final Number F =  5;
	private static final Number G =  6;
	private static final Number H =  7;
	private static final Number I =  8;
	private static final Number J =  9;
	private static final Number K = 10;



	/*Data for String Buffer values*/
	/** Root indicator. */
	private static final StringBuffer SB_ROOT = new StringBuffer("ROOT");
	/** Left child indicator. */
	private static final StringBuffer SB_LEFT = new StringBuffer("LEFT");
	/** Right child indicator. */
	private static final StringBuffer SB_RIGHT = new StringBuffer("RIGHT");
	/** Left-Left child indicator. */
	private static final StringBuffer SB_LEFT_LEFT = new StringBuffer("LEFT_LEFT");
	/** Left-Right child indicator. */
	private static final StringBuffer SB_LEFT_RIGHT = new StringBuffer("LEFT_RIGHT");
	/** Right-Left child indicator. */
	private static final StringBuffer SB_RIGHT_LEFT = new StringBuffer("RIGHT_LEFT");
	/** Right-Right child indicator. */
	private static final StringBuffer SB_RIGHT_RIGHT = new StringBuffer("RIGHT_RIGHT");
	/** Right-Left-Right child indicator. */
	private static final StringBuffer SB_RIGHT_LEFT_RIGHT = new StringBuffer("RIGHT_LEFT_RIGHT");
	/** Right-Right-LEFT child indicator. */
	private static final StringBuffer SB_RIGHT_RIGHT_LEFT = new StringBuffer("RIGHT_RIGHT_LEFT");;

	/** Default reject value. */
	private static final StringBuffer SB_REJECT = new StringBuffer("REJECT");

	/** Test value for new tree. */
	private static final StringBuffer SB_NEW_VALUE = new StringBuffer("NEW_VALUE");

	// Lettered value constants.
	private static final StringBuffer SB_A =  new StringBuffer("A");
	private static final StringBuffer SB_B =  new StringBuffer("B");
	private static final StringBuffer SB_C =  new StringBuffer("C");
	private static final StringBuffer SB_D =  new StringBuffer("D");
	private static final StringBuffer SB_E =  new StringBuffer("E");
	private static final StringBuffer SB_F =  new StringBuffer("F");
	private static final StringBuffer SB_G =  new StringBuffer("G");
	private static final StringBuffer SB_H =  new StringBuffer("H");
	private static final StringBuffer SB_I =  new StringBuffer("I");
	private static final StringBuffer SB_J =  new StringBuffer("J");
	private static final StringBuffer SB_K =  new StringBuffer("K");
	private static final StringBuffer[] alpha = {SB_A, SB_B, SB_C, SB_D, SB_E, SB_F, SB_G, SB_H, SB_I, SB_J, SB_K};
	/**
	 * Generates a standard tree for testing.
	 * @return testing tree
	 */
	private BinaryTree<Number> generateNumberStandardTestTree() {
		return new BinaryTree<Number>(
				ROOT,
				new BinaryTree<Number>(
						LEFT,
						new BinaryTree<Number>(LEFT_LEFT),
						new BinaryTree<Number>(LEFT_RIGHT)),
				new BinaryTree<Number>(
						RIGHT,
						new BinaryTree<Number>(
								RIGHT_LEFT,
								null,
								new BinaryTree<Number>(
										RIGHT_LEFT_RIGHT)),
						new BinaryTree<Number>(RIGHT_RIGHT,
								new BinaryTree<Number>(RIGHT_RIGHT_LEFT),
								null)));
	}

	private BinaryTree<StringBuffer> generteStringBufferStandardTestTree() {
		return new BinaryTree<StringBuffer>(
				SB_ROOT,
				new BinaryTree<StringBuffer>(
						SB_LEFT,
						new BinaryTree<StringBuffer>(SB_LEFT_LEFT),
						new BinaryTree<StringBuffer>(SB_LEFT_RIGHT)),
				new BinaryTree<StringBuffer>(
						SB_RIGHT,
						new BinaryTree<StringBuffer>(
								SB_RIGHT_LEFT,
								null,
								new BinaryTree<StringBuffer>(
										SB_RIGHT_LEFT_RIGHT)),
						new BinaryTree<StringBuffer>(SB_RIGHT_RIGHT,
								new BinaryTree<StringBuffer>(SB_RIGHT_RIGHT_LEFT),
								null)));
	}

	/**
	 * Generates a binary search tree.
	 * @return testing search tree
	 */
	private BinaryTree<Number> generateNumbericSearchTree() {
		return new BinaryTree<Number>(
				F,
				new BinaryTree<Number>(
						D,
						new BinaryTree<Number>(
								B,
								new BinaryTree<Number>(A),
								new BinaryTree<Number>(C)),
						new BinaryTree<Number>(E)),
				new BinaryTree<Number>(
						H,
						new BinaryTree<Number>(G),
						new BinaryTree<Number>(
								I,
								null,
								new BinaryTree<Number>(
										J,
										null,
										new BinaryTree<Number>(K)))));
	}
	/**
	 * Generates a binary search tree.
	 * @return testing search tree
	 */
	private BinaryTree<StringBuffer> generateStringBufferSearchTree() {
		return new BinaryTree<StringBuffer>(
				SB_F,
				new BinaryTree<StringBuffer>(
						SB_D,
						new BinaryTree<StringBuffer>(
								SB_B,
								new BinaryTree<StringBuffer>(SB_A),
								new BinaryTree<StringBuffer>(SB_C)),
						new BinaryTree<StringBuffer>(SB_E)),
				new BinaryTree<StringBuffer>(
						SB_H,
						new BinaryTree<StringBuffer>(SB_G),
						new BinaryTree<StringBuffer>(
								SB_I,
								null,
								new BinaryTree<StringBuffer>(
										SB_J,
										null,
										new BinaryTree<StringBuffer>(SB_K)))));
	}

	@Test
	public void testNumbericConstructorEqualsRootValue() {
		BinaryTree<Number> binTree = new BinaryTree<>(ROOT);
		assertEquals(binTree.getValue(), ROOT);
	}

	@Test
	public void testStringBufferConstructorEqualsRootValue() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<>(SB_ROOT);
		assertEquals(binTree.getValue(), SB_ROOT);
	}

	@Test
	public void testNumbericConstructorValuesAreEqual() {
		BinaryTree<Number> binTree = new BinaryTree<Number>(ROOT,
												new BinaryTree<Number>(LEFT),
												new BinaryTree<Number>(RIGHT));
		assertEquals(binTree.getValue(), ROOT);
		assertEquals(binTree.getLeftChild().getValue(), LEFT);
		assertEquals(binTree.getRightChild().getValue(), RIGHT);
	}

	@Test
	public void testStringBufferConstructorValuesAreEqual() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<StringBuffer>(SB_ROOT,
				new BinaryTree<StringBuffer>(SB_LEFT),
				new BinaryTree<StringBuffer>(SB_RIGHT));
		assertEquals(binTree.getValue(), SB_ROOT);
		assertEquals(binTree.getLeftChild().getValue(), SB_LEFT);
		assertEquals(binTree.getRightChild().getValue(), SB_RIGHT);
	}

	/**
	 * Tests valid methods for empty tree.
	 */
	@Test
	public void emptyNumbericTreeTest() {
		BinaryTree<Number> binTree = new BinaryTree<Number>();
		assertEquals(true, binTree.isEmpty());
		assertEquals(0, binTree.numberOfNodes());
		assertEquals(-1, binTree.height());
	}

	/**
	 * Tests valid methods for empty tree.
	 */
	@Test
	public void emptyStringBufferTreeTest() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<StringBuffer>();
		assertEquals(true, binTree.isEmpty());
		assertEquals(0, binTree.numberOfNodes());
		assertEquals(-1, binTree.height());
	}

	/**
	 * Verifies exception for value accessor on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyNumbericTreeGetValueException() {
		BinaryTree<Number> binTree = new BinaryTree<Number>();
		Number x = binTree.getValue();
	}

	/**
	 * Verifies exception for value accessor on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyStringBufferTreeGetValueException() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<StringBuffer>();
		StringBuffer x = binTree.getValue();
	}
	/**
	 * Verifies exception for left child accessor on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyNumbericTreeGetLeftChildException() {
		BinaryTree<Number> binTree = new BinaryTree<Number>();
		BinaryTree<Number> x = binTree.getLeftChild();
	}

	/**
	 * Verifies exception for left child accessor on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyStringBufferTreeGetLeftChildException() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<StringBuffer>();
		BinaryTree<StringBuffer> x = binTree.getLeftChild();
	}

	/**
	 * Verifies exception for right child accessor on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyNumbericTreeGetRightChildException() {
		BinaryTree<Number> binTree = new BinaryTree<Number>();
		BinaryTree<Number> x = binTree.getRightChild();
	}

	/**
	 * Verifies exception for right child accessor on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyStringBufferTreeGetRightChildException() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<StringBuffer>();
		BinaryTree<StringBuffer> x = binTree.getRightChild();
	}

	/**
	 * Verifies exception for leaf predicate on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyNumbericTreeIsLeafException() {
		BinaryTree<Number> binTree = new BinaryTree<Number>();
		boolean b = binTree .isLeaf();
	}

	/**
	 * Verifies exception for leaf predicate on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyStringBufferTreeIsLeafException() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<StringBuffer>();
		boolean b = binTree .isLeaf();
	}


	/**
	 * Verifies exception for value on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyNumbericTreeSetValueException() {
		BinaryTree<Number> binTree = new BinaryTree<Number>();
		binTree.setValue(REJECT);
	}

	/**
	 * Verifies exception for value on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyStringBufferTreeSetValueException() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<StringBuffer>();
		binTree.setValue(SB_REJECT);
	}

	/**
	 * Verifies exception for left child mutator on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyNumbericTreeSetLeftChildException() {
		BinaryTree<Number> binTree = new BinaryTree<Number>();
		binTree.setLeftChild(new BinaryTree<Number>());
	}

	/**
	 * Verifies exception for left child mutator on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyStringBufferTreeSetLeftChildException() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<StringBuffer>();
		binTree.setLeftChild(new BinaryTree<StringBuffer>());
	}

	/**
	 * Verifies exception for right child mutator on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyNumbericTreeSetRightChildException() {
		BinaryTree<Number> binTree = new BinaryTree<Number>();
		binTree.setRightChild(new BinaryTree<Number>());
	}

	/**
	 * Verifies exception for right child mutator on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyStringBufferTreeSetRightChildException() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<StringBuffer>();
		binTree.setRightChild(new BinaryTree<StringBuffer>());
	}

	/**
	 * Verifies exception for numberOfLeaves accessor on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyNumbericTreeNumberOfLeavesException() {
		BinaryTree<Number> binTree = new BinaryTree<Number>();
		binTree.numberOfLeaves();
	}

	/**
	 * Verifies exception for numberOfLeaves accessor on empty tree.
	 */
	@Test(expected = NullPointerException.class)
	public void emptyStringBufferTreeNumberOfLeavesException() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<StringBuffer>();
		binTree.numberOfLeaves();
	}

	/**
	 * Tests for single-node tree.
	 */
	@Test
	public void oneNodeNumbericTest() {
		BinaryTree<Number> binTree = new BinaryTree<Number>(ROOT);
		assertEquals(false, binTree.isEmpty());
		assertEquals(1, binTree.numberOfNodes());
		assertEquals(0, binTree.height());
		assertNotNull(binTree.getValue());
		assertEquals(ROOT, binTree.getValue());
		assertEquals(1, binTree.numberOfLeaves());
		assertNull(binTree.getLeftChild());
		assertNull(binTree.getRightChild());
		binTree.setValue(NEW_VALUE);
		assertEquals(NEW_VALUE, binTree.getValue());
	}

	/**
	 * Tests for single-node tree.
	 */
	@Test
	public void oneNodeStringBufferTest() {
		BinaryTree<StringBuffer> binTree = new BinaryTree<StringBuffer>(SB_ROOT);
		assertEquals(false, binTree.isEmpty());
		assertEquals(1, binTree.numberOfNodes());
		assertEquals(0, binTree.height());
		assertNotNull(binTree.getValue());
		assertEquals(SB_ROOT, binTree.getValue());
		assertEquals(1, binTree.numberOfLeaves());
		assertNull(binTree.getLeftChild());
		assertNull(binTree.getRightChild());
		binTree.setValue(SB_NEW_VALUE);
		assertEquals(SB_NEW_VALUE, binTree.getValue());
	}

	/**
	 * Tests for single-node tree using parameterized constructor.
	 */
	@Test
	public void oneNodeSecondaryNumbericTest() {
		BinaryTree<Number> root = new BinaryTree<Number>(ROOT, null, null);
		assertEquals(false, root.isEmpty());
		assertEquals(1, root.numberOfNodes());
		assertEquals(0, root.height());
		assertNotNull(root.getValue());
		assertEquals(ROOT, root.getValue());
		assertEquals(1, root.numberOfLeaves());
		assertNull(root.getLeftChild());
		assertNull(root.getRightChild());
		root.setValue(NEW_VALUE);
		assertEquals(NEW_VALUE, root.getValue());
	}

	/**
	 * Tests for single-node tree using parameterized constructor.
	 */
	@Test
	public void oneNodeSecondaryStringBufferTest() {
		BinaryTree<StringBuffer> root = new BinaryTree<StringBuffer>(SB_ROOT, null, null);
		assertEquals(false, root.isEmpty());
		assertEquals(1, root.numberOfNodes());
		assertEquals(0, root.height());
		assertNotNull(root.getValue());
		assertEquals(SB_ROOT, root.getValue());
		assertEquals(1, root.numberOfLeaves());
		assertNull(root.getLeftChild());
		assertNull(root.getRightChild());
		root.setValue(SB_NEW_VALUE);
		assertEquals(SB_NEW_VALUE, root.getValue());
	}

	/**
	 * Tests for multiple-node tree using parameterized constructor.
	 */
	@Test
	public void multiNodeNumbericConstructionTest() {
		BinaryTree<Number> root = generateNumberStandardTestTree();
		assertFalse(root.isEmpty());
		assertEquals(NUM_NODES_TEST_TREE, root.numberOfNodes());
		assertEquals(NUM_LEAVES_TEST_TREE, root.numberOfLeaves());
		assertEquals(HEIGHT_TEST_TREE, root.height());
		assertEquals(ROOT, root.getValue());
		assertFalse(root.getLeftChild().isEmpty());
		assertFalse(root.getRightChild().isEmpty());

		assertFalse(root.getLeftChild().getLeftChild().isEmpty());
		assertFalse(root.getRightChild().getLeftChild().isEmpty());

		assertNull(root.getLeftChild().getLeftChild().getLeftChild());
		assertFalse(root.getRightChild().getLeftChild().getRightChild().isEmpty());

		assertNull(root.getRightChild().getLeftChild().getLeftChild());

		assertEquals(NUM_NODES_SM_TREE, root.getLeftChild().numberOfNodes());
		assertEquals(NUM_NODES_MED_TREE, root.getRightChild().numberOfNodes());
		assertEquals(1, root.getLeftChild().height());
		assertEquals(2, root.getRightChild().height());
		assertEquals(RIGHT_LEFT_RIGHT,
				root.getRightChild().getLeftChild().getRightChild().getValue());
		assertEquals(RIGHT_RIGHT_LEFT,
				root.getRightChild().getRightChild().getLeftChild().getValue());
	}

	/**
	 * Tests for multiple-node tree using parameterized constructor.
	 */
	@Test
	public void multiNodeStringBufferConstructionTest() {
		BinaryTree<StringBuffer> root = generteStringBufferStandardTestTree();
		assertFalse(root.isEmpty());
		assertEquals(NUM_NODES_TEST_TREE, root.numberOfNodes());
		assertEquals(NUM_LEAVES_TEST_TREE, root.numberOfLeaves());
		assertEquals(HEIGHT_TEST_TREE, root.height());
		assertEquals(SB_ROOT, root.getValue());
		assertFalse(root.getLeftChild().isEmpty());
		assertFalse(root.getRightChild().isEmpty());

		assertFalse(root.getLeftChild().getLeftChild().isEmpty());
		assertFalse(root.getRightChild().getLeftChild().isEmpty());

		assertNull(root.getLeftChild().getLeftChild().getLeftChild());
		assertFalse(root.getRightChild().getLeftChild().getRightChild().isEmpty());

		assertNull(root.getRightChild().getLeftChild().getLeftChild());

		assertEquals(NUM_NODES_SM_TREE, root.getLeftChild().numberOfNodes());
		assertEquals(NUM_NODES_MED_TREE, root.getRightChild().numberOfNodes());
		assertEquals(1, root.getLeftChild().height());
		assertEquals(2, root.getRightChild().height());
		assertEquals(SB_RIGHT_LEFT_RIGHT,
				root.getRightChild().getLeftChild().getRightChild().getValue());
		assertEquals(SB_RIGHT_RIGHT_LEFT,
				root.getRightChild().getRightChild().getLeftChild().getValue());
	}

	/**
	 * Tests for left child tree modification
	 */
	@Test
	public void testNumbericModifyLeftChild() {
		BinaryTree<Number> root = new BinaryTree<Number>(ROOT);
		assertEquals(1, root.numberOfNodes());
		assertEquals(0, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertNull(root.getLeftChild());
		assertNull(root.getRightChild());
		root.setLeftChild(null);
		assertEquals(1, root.numberOfNodes());
		assertNull(root.getLeftChild());
	}

	/**
	 * Tests for left child tree modification
	 */
	@Test
	public void testStringBufferModifyLeftChild() {
		BinaryTree<StringBuffer> root = new BinaryTree<StringBuffer>(SB_ROOT);
		assertEquals(1, root.numberOfNodes());
		assertEquals(0, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertNull(root.getLeftChild());
		assertNull(root.getRightChild());
		root.setLeftChild(null);
		assertEquals(1, root.numberOfNodes());
		assertNull(root.getLeftChild());
	}

	/**
	 * Tests for right child tree modification
	 */
	@Test
	public void testNumbericModifyRightChild() {
		BinaryTree<Number> root = new BinaryTree<Number>(ROOT);
		assertEquals(1, root.numberOfNodes());
		assertEquals(0, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertNull(root.getLeftChild());
		assertNull(root.getRightChild());
		root.setRightChild(null);
		assertEquals(1, root.numberOfNodes());
		assertNull(root.getRightChild());
	}

	/**
	 * Tests for right child tree modification
	 */
	@Test
	public void testStringBufferModifyRightChild() {
		BinaryTree<StringBuffer> root = new BinaryTree<StringBuffer>(SB_ROOT);
		assertEquals(1, root.numberOfNodes());
		assertEquals(0, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertNull(root.getLeftChild());
		assertNull(root.getRightChild());
		root.setRightChild(null);
		assertEquals(1, root.numberOfNodes());
		assertNull(root.getRightChild());
	}

	/**
	 * Tests for right child tree modification
	 */
	@Test
	public void testNumbericModifyRightChildren() {
		BinaryTree<Number> root = new BinaryTree<Number>(ROOT);
		assertNull(root.getLeftChild());
		assertNull(root.getRightChild());
		root.setRightChild(new BinaryTree<Number>(RIGHT));
		assertEquals(2, root.numberOfNodes());
		assertEquals(1, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertEquals(RIGHT, root.getRightChild().getValue());
		assertNull(root.getLeftChild());
		root.getRightChild().setLeftChild(new BinaryTree<Number>(RIGHT_LEFT));
		assertFalse(root.getRightChild().getLeftChild().isEmpty());
		assertEquals(NUM_NODES_SM_TREE, root.numberOfNodes());
		assertEquals(2, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertEquals(RIGHT_LEFT, root.getRightChild().getLeftChild().getValue());
	}

	/**
	 * Tests for right child tree modification
	 */
	@Test
	public void testStringBufferModifyRightChildren() {
		BinaryTree<StringBuffer> root = new BinaryTree<StringBuffer>(SB_ROOT);
		assertNull(root.getLeftChild());
		assertNull(root.getRightChild());
		root.setRightChild(new BinaryTree<StringBuffer>(SB_RIGHT));
		assertEquals(2, root.numberOfNodes());
		assertEquals(1, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertEquals(SB_RIGHT, root.getRightChild().getValue());
		assertNull(root.getLeftChild());
		root.getRightChild().setLeftChild(new BinaryTree<StringBuffer>(SB_RIGHT_LEFT));
		assertFalse(root.getRightChild().getLeftChild().isEmpty());
		assertEquals(NUM_NODES_SM_TREE, root.numberOfNodes());
		assertEquals(2, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertEquals(SB_RIGHT_LEFT, root.getRightChild().getLeftChild().getValue());
	}

	/**
	 * Tests for right child tree modification
	 */
	@Test
	public void testNumbericModifyLeftChildren() {
		BinaryTree<Number> root = new BinaryTree<Number>(ROOT);
		assertNull(root.getLeftChild());
		assertNull(root.getRightChild());
		root.setLeftChild(new BinaryTree<Number>(LEFT));
		assertEquals(2, root.numberOfNodes());
		assertEquals(1, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertEquals(LEFT, root.getLeftChild().getValue());
		assertNull(root.getLeftChild().getLeftChild());
		root.getLeftChild().setLeftChild(new BinaryTree<Number>(LEFT_LEFT));
		assertFalse(root.getLeftChild().getLeftChild().isEmpty());
		assertEquals(NUM_NODES_SM_TREE, root.numberOfNodes());
		assertEquals(2, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertEquals(LEFT_LEFT, root.getLeftChild().getLeftChild().getValue());
	}

	/**
	 * Tests for right child tree modification
	 */
	@Test
	public void testStringBufferModifyLeftChildren() {
		BinaryTree<StringBuffer> root = new BinaryTree<StringBuffer>(SB_ROOT);
		assertNull(root.getLeftChild());
		assertNull(root.getRightChild());
		root.setLeftChild(new BinaryTree<StringBuffer>(SB_LEFT));
		assertEquals(2, root.numberOfNodes());
		assertEquals(1, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertEquals(SB_LEFT, root.getLeftChild().getValue());
		assertNull(root.getLeftChild().getLeftChild());
		root.getLeftChild().setLeftChild(new BinaryTree<StringBuffer>(SB_LEFT_LEFT));
		assertFalse(root.getLeftChild().getLeftChild().isEmpty());
		assertEquals(NUM_NODES_SM_TREE, root.numberOfNodes());
		assertEquals(2, root.height());
		assertEquals(1, root.numberOfLeaves());
		assertEquals(SB_LEFT_LEFT, root.getLeftChild().getLeftChild().getValue());
	}

	/**
	 * Checks string rendering.
	 * Note that since no particular string rendering was specified,
	 * any returned string that satisfies the loose specification must
	 * be accepted.
	 * That is, the string must not be null, must not be empty,
	 * and must contain renderings of all of the values present
	 * in the tree.
	 */
	@Test
	public void treeNumbericToString() {
		BinaryTree<Number> root = new BinaryTree<Number>(ROOT);
		assertNotNull(root.toString());
		assertTrue(0 < ("" + root).length());
		String render = root.toString();
		assertTrue(0 <= render.indexOf("" + ROOT));
		root.setLeftChild(new BinaryTree<Number>(LEFT));
		root.setRightChild(new BinaryTree<Number>(RIGHT));
		root.getRightChild().setLeftChild(new BinaryTree<Number>(RIGHT_LEFT));
		assertNotNull(root.toString());
		assertTrue(0 < ("" + root).length());
		render = root.toString();
		assertTrue(0 <= render.indexOf("" + ROOT));
		assertTrue(0 <= render.indexOf("" + LEFT));
		assertTrue(0 <= render.indexOf("" + RIGHT));
		assertTrue(0 <= render.indexOf("" + RIGHT_LEFT));
		root = generateNumberStandardTestTree();
		render = root.toString();
		assertTrue(0 <= render.indexOf("" + ROOT));
		assertTrue(0 <= render.indexOf("" + LEFT));
		assertTrue(0 <= render.indexOf("" + RIGHT));
		assertTrue(0 <= render.indexOf("" + LEFT_LEFT));
		assertTrue(0 <= render.indexOf("" + LEFT_RIGHT));
		assertTrue(0 <= render.indexOf("" + RIGHT_LEFT));
		assertTrue(0 <= render.indexOf("" + RIGHT_RIGHT));
		assertTrue(0 <= render.indexOf("" + RIGHT_LEFT_RIGHT));
		assertTrue(0 <= render.indexOf("" + RIGHT_RIGHT_LEFT));
		root = generateNumbericSearchTree();
		render = root.toString();
		for (int i = (int) A; i < (int) K; i++) {
			assertTrue(0 <= render.indexOf("" + i));
		}
	}

	/**
	 * Checks string rendering.
	 * Note that since no particular string rendering was specified,
	 * any returned string that satisfies the loose specification must
	 * be accepted.
	 * That is, the string must not be null, must not be empty,
	 * and must contain renderings of all of the values present
	 * in the tree.
	 */
	@Test
	public void treeStringBufferToString() {
		BinaryTree<StringBuffer> root = new BinaryTree<StringBuffer>(SB_ROOT);
		assertNotNull(root.toString());
		assertTrue(0 < ("" + root).length());
		String render = root.toString();
		assertTrue(0 <= render.indexOf("" + SB_ROOT));
		root.setLeftChild(new BinaryTree<StringBuffer>(SB_LEFT));
		root.setRightChild(new BinaryTree<StringBuffer>(SB_RIGHT));
		root.getRightChild().setLeftChild(new BinaryTree<StringBuffer>(SB_RIGHT_LEFT));
		assertNotNull(root.toString());
		assertTrue(0 < ("" + root).length());
		render = root.toString();
		assertTrue(0 <= render.indexOf("" + SB_ROOT));
		assertTrue(0 <= render.indexOf("" + SB_LEFT));
		assertTrue(0 <= render.indexOf("" + SB_RIGHT));
		assertTrue(0 <= render.indexOf("" + SB_RIGHT_LEFT));
		root = generteStringBufferStandardTestTree();
		render = root.toString();
		assertTrue(0 <= render.indexOf("" + SB_ROOT));
		assertTrue(0 <= render.indexOf("" + SB_LEFT));
		assertTrue(0 <= render.indexOf("" + SB_RIGHT));
		assertTrue(0 <= render.indexOf("" + SB_LEFT_LEFT));
		assertTrue(0 <= render.indexOf("" + SB_LEFT_RIGHT));
		assertTrue(0 <= render.indexOf("" + SB_RIGHT_LEFT));
		assertTrue(0 <= render.indexOf("" + SB_RIGHT_RIGHT));
		assertTrue(0 <= render.indexOf("" + SB_RIGHT_LEFT_RIGHT));
		assertTrue(0 <= render.indexOf("" + SB_RIGHT_RIGHT_LEFT));
		root = generateStringBufferSearchTree();
		render = root.toString();
		for (int i = 0; i < alpha.length; i++) {
			assertTrue(render.contains(alpha[i]));
		}
	}



	/**
	 * Checks values returned by preorder traversal.
	 */
	@Test
	public void numbericPreorderValuesTest() {
		BinaryTree<Number> root = generateNumberStandardTestTree();
		List<Number> orderedV = Arrays.asList(
				ROOT, LEFT, LEFT_LEFT, LEFT_RIGHT,
				RIGHT, RIGHT_LEFT, RIGHT_LEFT_RIGHT,
				RIGHT_RIGHT, RIGHT_RIGHT_LEFT);
		assertNotNull(root.preorderValues());
		assertEquals(orderedV, root.preorderValues());
		orderedV = Arrays.asList(
				F, D, B, A, C, E, H, G, I, J, K);
		assertEquals(orderedV, generateNumbericSearchTree().preorderValues());
		BinaryTree<Number> mt = new BinaryTree<Number>();
		assertNotNull(mt.preorderValues());
		assertEquals(0, mt.preorderValues().size());
	}

	/**
	 * Checks values returned by preorder traversal.
	 */
	@Test
	public void stringBufferPreorderValuesTest() {
		BinaryTree<StringBuffer> root = generteStringBufferStandardTestTree();
		List<StringBuffer> orderedV = Arrays.asList(
				SB_ROOT, SB_LEFT, SB_LEFT_LEFT, SB_LEFT_RIGHT,
				SB_RIGHT, SB_RIGHT_LEFT, SB_RIGHT_LEFT_RIGHT,
				SB_RIGHT_RIGHT, SB_RIGHT_RIGHT_LEFT);
		assertNotNull(root.preorderValues());
		assertEquals(orderedV, root.preorderValues());
		orderedV = Arrays.asList(
				SB_F, SB_D, SB_B, SB_A, SB_C, SB_E, SB_H, SB_G, SB_I, SB_J, SB_K);
		assertEquals(orderedV, generateStringBufferSearchTree().preorderValues());
		BinaryTree<StringBuffer> mt = new BinaryTree<StringBuffer>();
		assertNotNull(mt.preorderValues());
		assertEquals(0, mt.preorderValues().size());
	}

	/**
	 * Checks values returned by inorder traversal.
	 */
	@Test
	public void numbericInorderValuesTest() {
		BinaryTree<Number> root = generateNumberStandardTestTree();
		List<Number> orderedV = Arrays.asList(
				LEFT_LEFT, LEFT, LEFT_RIGHT,
				ROOT, RIGHT_LEFT, RIGHT_LEFT_RIGHT, RIGHT,
				RIGHT_RIGHT_LEFT, RIGHT_RIGHT);
		assertNotNull(root.inorderValues());
		assertEquals(orderedV, root.inorderValues());
		orderedV = Arrays.asList(
				A, B, C, D, E, F, G, H, I, J, K);
		assertEquals(orderedV, generateNumbericSearchTree().inorderValues());
		BinaryTree<Number> mt = new BinaryTree<Number>();
		assertNotNull(mt.inorderValues());
		assertEquals(0, mt.inorderValues().size());
	}

	/**
	 * Checks values returned by inorder traversal.
	 */
	@Test
	public void stringBufferInorderValuesTest() {
		BinaryTree<StringBuffer> root = generteStringBufferStandardTestTree();
		List<StringBuffer> orderedV = Arrays.asList(
				SB_LEFT_LEFT, SB_LEFT, SB_LEFT_RIGHT,
				SB_ROOT, SB_RIGHT_LEFT, SB_RIGHT_LEFT_RIGHT, SB_RIGHT,
				SB_RIGHT_RIGHT_LEFT, SB_RIGHT_RIGHT);
		assertNotNull(root.inorderValues());
		assertEquals(orderedV, root.inorderValues());
		orderedV = Arrays.asList(
				SB_A, SB_B, SB_C, SB_D, SB_E, SB_F, SB_G, SB_H, SB_I, SB_J, SB_K);
		assertEquals(orderedV, generateStringBufferSearchTree().inorderValues());
		BinaryTree<StringBuffer> mt = new BinaryTree<StringBuffer>();
		assertNotNull(mt.inorderValues());
		assertEquals(0, mt.inorderValues().size());
	}

	/**
	 * Checks values returned by postorder traversal.
	 */
	@Test
	public void numbericPostorderValuesTest() {
		BinaryTree<Number> root = generateNumberStandardTestTree();
		List<Number> orderedV = Arrays.asList(
				LEFT, LEFT_LEFT, LEFT_RIGHT, RIGHT_LEFT,
				RIGHT_LEFT_RIGHT, RIGHT_RIGHT_LEFT,
				RIGHT_RIGHT, RIGHT, ROOT);
		assertNotNull(root.postorderValues());
		assertEquals(orderedV, root.postorderValues());
		orderedV = Arrays.asList(
				D, B, A, C, E, G, K, J, I, H, F);
		assertEquals(orderedV, generateNumbericSearchTree().postorderValues());
		BinaryTree<Number> mt = new BinaryTree<Number>();
		assertNotNull(mt.postorderValues());
		assertEquals(0, mt.postorderValues().size());
	}

	/**
	 * Checks values returned by postorder traversal.
	 */
	@Test
	public void stringBufferPostorderValuesTest() {
		BinaryTree<StringBuffer> root = generteStringBufferStandardTestTree();
		List<StringBuffer> orderedV = Arrays.asList(SB_LEFT,
				SB_LEFT_LEFT, SB_LEFT_RIGHT, SB_RIGHT_LEFT,
				SB_RIGHT_LEFT_RIGHT, SB_RIGHT_RIGHT_LEFT,
				SB_RIGHT_RIGHT, SB_RIGHT, SB_ROOT);
		assertNotNull(root.postorderValues());
		assertEquals(orderedV, root.postorderValues());
		orderedV = Arrays.asList(
				SB_D, SB_B, SB_A, SB_C,  SB_E,  SB_G, SB_K, SB_J, SB_I, SB_H, SB_F);
		assertEquals(orderedV, generateStringBufferSearchTree().postorderValues());
		BinaryTree<StringBuffer> mt = new BinaryTree<StringBuffer>();
		assertNotNull(mt.postorderValues());
		assertEquals(0, mt.postorderValues().size());
	}

	/**
	 * Checks nodes returned by preorder traversal.
	 */
	@Test
	public void numbericPreorderNodesTest() {
		BinaryTree<Number> root = generateNumberStandardTestTree();
		Number[] orderedV = {ROOT, LEFT, LEFT_LEFT, LEFT_RIGHT,
				RIGHT, RIGHT_LEFT, RIGHT_LEFT_RIGHT,
				RIGHT_RIGHT, RIGHT_RIGHT_LEFT};
		assertNotNull(root.preorderSubtrees());
		assertEquals(orderedV.length, root.preorderSubtrees().size());
		int i = 0;
		for (BinaryTree<Number> bt : root.preorderSubtrees()) {
			assertEquals(orderedV[i], bt.getValue());
			i++;
		}
		BinaryTree<Number> mt = new BinaryTree<Number>();
		assertNotNull(mt.preorderSubtrees());
		assertEquals(0, mt.preorderSubtrees().size());
	}

	/**
	 * Checks nodes returned by preorder traversal.
	 */
	@Test
	public void stringBufferPreorderNodesTest() {
		BinaryTree<StringBuffer> root = generteStringBufferStandardTestTree();
		StringBuffer[] orderedV = {SB_ROOT, SB_LEFT, SB_LEFT_LEFT, SB_LEFT_RIGHT,
				SB_RIGHT, SB_RIGHT_LEFT, SB_RIGHT_LEFT_RIGHT,
				SB_RIGHT_RIGHT, SB_RIGHT_RIGHT_LEFT};
		assertNotNull(root.preorderSubtrees());
		assertEquals(orderedV.length, root.preorderSubtrees().size());
		int i = 0;
		for (BinaryTree<StringBuffer> bt : root.preorderSubtrees()) {
			assertEquals(orderedV[i], bt.getValue());
			i++;
		}
		BinaryTree<StringBuffer> mt = new BinaryTree<StringBuffer>();
		assertNotNull(mt.preorderSubtrees());
		assertEquals(0, mt.preorderSubtrees().size());
	}

	/**
	 * Checks nodes returned by inorder traversal.
	 */
	@Test
	public void numbericInorderNodesTest() {
		BinaryTree<Number> root = generateNumberStandardTestTree();
		Number[] orderedV = {LEFT_LEFT, LEFT, LEFT_RIGHT,
				ROOT, RIGHT_LEFT, RIGHT_LEFT_RIGHT, RIGHT,
				RIGHT_RIGHT_LEFT, RIGHT_RIGHT};
		assertNotNull(root.inorderSubtrees());
		assertEquals(orderedV.length, root.inorderSubtrees().size());
		int i = 0;
		for (BinaryTree<Number> nbt : root.inorderSubtrees()) {
			assertEquals(orderedV[i], nbt.getValue());
			i++;
		}
		BinaryTree<Number> mt = new BinaryTree<Number>();
		assertNotNull(mt.inorderSubtrees());
		assertEquals(0, mt.inorderSubtrees().size());
	}

	/**
	 * Checks nodes returned by inorder traversal.
	 */
	@Test
	public void stringBufferInorderNodesTest() {
		BinaryTree<StringBuffer> root = generteStringBufferStandardTestTree();
		StringBuffer[] orderedV = {SB_LEFT_LEFT, SB_LEFT, SB_LEFT_RIGHT,
				SB_ROOT, SB_RIGHT_LEFT, SB_RIGHT_LEFT_RIGHT, SB_RIGHT,
				SB_RIGHT_RIGHT_LEFT, SB_RIGHT_RIGHT};
		assertNotNull(root.inorderSubtrees());
		assertEquals(orderedV.length, root.inorderSubtrees().size());
		int i = 0;
		for (BinaryTree<StringBuffer> bt : root.inorderSubtrees()) {
			assertEquals(orderedV[i], bt.getValue());
			i++;
		}
		BinaryTree<StringBuffer> mt = new BinaryTree<StringBuffer>();
		assertNotNull(mt.inorderSubtrees());
		assertEquals(0, mt.inorderSubtrees().size());
	}

	/**
	 * Checks nodes returned by postorder traversal.
	 */
	@Test
	public void numbericPostorderNodesTest() {
		BinaryTree<Number> root = generateNumberStandardTestTree();
		Number[] orderedV = {LEFT_LEFT, LEFT_RIGHT, LEFT,
				RIGHT_LEFT_RIGHT, RIGHT_LEFT,
				RIGHT_RIGHT_LEFT, RIGHT_RIGHT,
				RIGHT, ROOT};
		assertNotNull(root.postorderSubtrees());
		assertEquals(orderedV.length, root.postorderSubtrees().size());
		int i = 0;
		for (BinaryTree<Number> nbt : root.postorderSubtrees()) {
			assertEquals(orderedV[i], nbt.getValue());
			i++;
		}
		assertEquals(orderedV.length, root.postorderSubtrees().size());
		BinaryTree<Number> mt = new BinaryTree<Number>();
		assertNotNull(mt.postorderSubtrees());
		assertEquals(0, mt.postorderSubtrees().size());
	}

	/**
	 * Checks nodes returned by postorder traversal.
	 */
	@Test
	public void stringBufferPostorderNodesTest() {
		BinaryTree<StringBuffer> root = generteStringBufferStandardTestTree();
		StringBuffer[] orderedV = {SB_LEFT_LEFT, SB_LEFT_RIGHT, SB_LEFT,
				SB_RIGHT_LEFT_RIGHT, SB_RIGHT_LEFT,
				SB_RIGHT_RIGHT_LEFT, SB_RIGHT_RIGHT,
				SB_RIGHT, SB_ROOT};
		assertNotNull(root.postorderSubtrees());
		assertEquals(orderedV.length, root.postorderSubtrees().size());
		int i = 0;
		for (BinaryTree<StringBuffer> bt : root.postorderSubtrees()) {
			assertEquals(orderedV[i], bt.getValue());
			i++;
		}
		assertEquals(orderedV.length, root.postorderSubtrees().size());
		BinaryTree<StringBuffer> mt = new BinaryTree<StringBuffer>();
		assertNotNull(mt.postorderSubtrees());
		assertEquals(0, mt.postorderSubtrees().size());
	}

	/**
	 * Verifies behavior of values() method.
	 */
	@Test
	public void numbericValuesTest() {
		BinaryTree<Number> mt1 = new BinaryTree<Number>();
		BinaryTree<Number> mt2 = new BinaryTree<Number>();
		BinaryTree<Number> nbt1 = new BinaryTree<Number>(B);
		BinaryTree<Number> nbt2 = new BinaryTree<Number>(C);
		List<BinaryTree<Number>> alnbt = new ArrayList<BinaryTree<Number>>();
		alnbt.add(nbt1);
		List<Number> alnumber = BinaryTree.values(alnbt);
		assertNotNull(alnumber);
		assertEquals(1, alnumber.size());
		assertTrue(alnumber.contains(B));
		alnbt.add(nbt2);
		alnumber = BinaryTree.values(alnbt);
		assertNotNull(alnumber);
		assertEquals(2, alnumber.size());
		assertTrue(alnumber.contains(B));
		assertTrue(alnumber.contains(C));
		alnbt = new ArrayList<BinaryTree<Number>>();
		alnbt.add(mt1);
		alnumber = BinaryTree.values(alnbt);
		assertNotNull(alnumber);
		assertEquals(0, alnumber.size());
		alnbt.add(mt2);
		alnumber = BinaryTree.values(alnbt);
		assertNotNull(alnumber);
		assertEquals(0, alnumber.size());
	}

	/**
	 * Verifies behavior of values() method.
	 */
	@Test
	public void stringBufferValuesTest() {
		BinaryTree<StringBuffer> mt1 = new BinaryTree<StringBuffer>();
		BinaryTree<StringBuffer> mt2 = new BinaryTree<StringBuffer>();
		BinaryTree<StringBuffer> nbt1 = new BinaryTree<StringBuffer>(SB_B);
		BinaryTree<StringBuffer> nbt2 = new BinaryTree<StringBuffer>(SB_C);
		List<BinaryTree<StringBuffer>> alnbt = new ArrayList<BinaryTree<StringBuffer>>();
		alnbt.add(nbt1);
		List<StringBuffer> alnumber = BinaryTree.values(alnbt);
		assertNotNull(alnumber);
		assertEquals(1, alnumber.size());
		assertTrue(alnumber.contains(SB_B));
		alnbt.add(nbt2);
		alnumber = BinaryTree.values(alnbt);
		assertNotNull(alnumber);
		assertEquals(2, alnumber.size());
		assertTrue(alnumber.contains(SB_B));
		assertTrue(alnumber.contains(SB_C));
		alnbt = new ArrayList<BinaryTree<StringBuffer>>();
		alnbt.add(mt1);
		alnumber = BinaryTree.values(alnbt);
		assertNotNull(alnumber);
		assertEquals(0, alnumber.size());
		alnbt.add(mt2);
		alnumber = BinaryTree.values(alnbt);
		assertNotNull(alnumber);
		assertEquals(0, alnumber.size());
	}
}
