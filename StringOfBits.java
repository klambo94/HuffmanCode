public class StringOfBits {
    /**
     * BinaryString convered from a CharSequence.
     */
    private String binaryString;

    /**
     * Constructs the empty bit string.
     * length() == 0
     */
    public StringOfBits() {

    }

    /**
     * Constructs a bit String from a sequence
     * of '0' and '1' characters.
     * @param charSequence sequence of Chars to turn
     *                     into a string of bits
     */
    public StringOfBits(final CharSequence charSequence) {

    }

    /**Copy constructor.
     * stringOfBits - the object to be cloned
     * @param  stringOfBits bitString to be cloned
     */
    public StringOfBits(final StringOfBits stringOfBits) {

    }

    /** Returns the bitString convered in
     * StringOfBits(final CharSequence charSequence).
     * @see StringOfBits(final CharSequence)
     * @return String
     */
    public String getBitString() {
        return binaryString;
    }

    /**
     * Returns the length of this bit string.
     * @return int
     */
    public int length() {
        return 0;
    }

    /**Appends the bit string representation of
     * the parameter to this bit string. If the
     * parameter is not '0' or '1' the behavior
     * of this method is undefined.
     * @param c char to append
     * @return StringOfBits
     */
    public StringOfBits append(final char c) {
        return new StringOfBits();
    }

    /**
     * Appends the bit string representation of
     * the parameter to this bit string; false
     * corresponds to 0, true corresponds to 1.
     * @param b boolean value to append
     * @return StringOfBits
     */
    public StringOfBits append(final boolean b) {
        return new StringOfBits();
    }

    /**
     * Appends the bit string representation of
     * the parameter to this bit string. Each
     * digit represents a single bit. If any
     * digit of the parameter is not 0 or 1
     * the behavior is undefined.
     * @param i int value to append
     * @return StringOfBits
     */
    public StringOfBits append(final int i) {
        return new StringOfBits();
    }

    /**
     * Appends the bit string representation
     * of the parameter to this bit string.
     * Each substring of "0" corresponds to 0;
     * each "1" corresponds to 1. If the string
     * contains other than "0" and "1" the
     * behavior of this method is undefined.
     * @param str CharSequence to append
     * @return The appended StringOfBits
     */
    public StringOfBits append(final CharSequence str) {
        return new StringOfBits();
    }

    /**
     * Appends the parameter to this bit string.
     * @param bitstr bit string to append
     * @return StringOfBits
     */
    public StringOfBits append(final StringOfBits bitstr) {
        return new StringOfBits();
    }

    /**
     * Returns a char corresponding to the bit
     * at the specified index.
     * @param index index Of where to set bit
     * @return char
     * @throws IndexOutOfBoundsException
     */
    public char charAt(final int index)
            throws IndexOutOfBoundsException {
        char c = '0';
        return c;
    }

    /**
     * Returns an int corresponding to the bit at
     * the specified index.
     * @param index index Of where to set bit
     * @return int
     * @throws IndexOutOfBoundsException
     */

    public int intAt(final int index)
            throws IndexOutOfBoundsException {
        return 0;
    }

    /**
     * Returns a boolean corresponding to the
     * bit at the specified index.  False
     * corresponds to 0, true corresponds to 1.
     * @param index index Of where to set bit
     * @return boolean
     * @throws IndexOutOfBoundsException
     */
    public boolean booleanAt(final int index)
            throws IndexOutOfBoundsException {
        return false;
    }

    /**
     * Sets the bit at the specified index.
     * If the parameter is not '0' or '1' the
     * behavior of this method is undefined.
     * @param index index Of where to set bit
     * @param c char to set bit at index
     */
    public void setBitAt(final int index, final char c) {

    }

    /**
     * Sets the bit at the specified index.
     * If the parameter is not 0 or 1 the
     * behavior of this method is undefined.
     * @param index index Of where to set bit
     * @param i int to set at bit index
     */
    public void setBitAt(final int index, final int i) {

    }

    /**
     * Sets the bit at the specified index.
     *  False corresponds to 0,
     *  true corresponds to 1.
     * @param index index Of where to set bit
     * @param b boolean value to set bit at index
     */

    public void setBitAt(final int index, final boolean b) {

    }

    /**
     * Overrides Object toString()
     * @return String representation of bitString
     */
    @Override
    public String toString() {
        return "";
    }
}
