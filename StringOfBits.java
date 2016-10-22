

/**
 * A class that can take a given string and represent it as a string of bit
 * values (0 or 1).
 * @author  Kendra Lamb
 */
public class StringOfBits {
    /**
     * BinaryString converted from a CharSequence.
     */
    private String bitString = "";

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
        String charString = charSequence.toString();
        byte[] bytes = charString.getBytes();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            String stringToAppend = String.format("%8s",
                    Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            stringBuilder.append(stringToAppend);
        }
        this.bitString = stringBuilder.toString();
    }

    /**Copy constructor.
     * stringOfBits - the object to be cloned
     * @param  stringOfBits bitString to be cloned
     */
    public StringOfBits(final StringOfBits stringOfBits) {
        this.bitString = stringOfBits.getBitString().trim();
    }

    /** Returns the bitString convered in
     * StringOfBits(final CharSequence charSequence).
     * @see StringOfBits(final CharSequence)
     * @return String
     */
    public String getBitString() {
        return bitString;
    }

    /**
     * Returns the length of this bit string.
     * @return int
     */
    public int length() {
        return bitString.length();
    }

    /**Appends the bit string representation of
     * the parameter to this bit string. If the
     * parameter is not '0' or '1' the behavior
     * of this method is undefined.
     * @param c char to append
     * @return StringOfBits
     */
    public StringOfBits append(final char c) {
        if (c == '0' || c == '1') {
            bitString = bitString + c;
        }
        return new StringOfBits(bitString);
    }

    /**
     * Appends the bit string representation of
     * the parameter to this bit string; false
     * corresponds to 0, true corresponds to 1.
     * @param b boolean value to append
     * @return StringOfBits
     */
    public StringOfBits append(final boolean b) {
        if (b) {
            bitString = bitString + "1";
        } else {
            bitString = bitString + "0";
        }
        return new StringOfBits(bitString);
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
        if (i == 0 || i == 1) {
            bitString = bitString + String.valueOf(i);
        }
        return new StringOfBits(bitString);
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
       int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);
            if (c == '0' || c == '1') {
                bitString = bitString + c;
            }
        }
        return new StringOfBits(bitString);
    }

    /**
     * Appends the parameter to this bit string.
     * @param bitstr bit string to append
     * @return StringOfBits
     */
    public StringOfBits append(final StringOfBits bitstr) {
        bitString = bitString + bitstr.getBitString();
        return new StringOfBits(bitString);
    }

    /**
     * Returns a char corresponding to the bit
     * at the specified index.
     * @param index index Of where to set bit
     * @return char
     * @throws IndexOutOfBoundsException
     */
    public char charAt(final int index) throws IndexOutOfBoundsException {
        if (index > bitString.length()) {
            throw new IndexOutOfBoundsException("That index is out of bounds "
                    + "of the bit string.");
        }
        return bitString.charAt(index);
    }

    /**
     * Returns an int corresponding to the bit at
     * the specified index.
     * @param index index Of where to set bit
     * @return int
     * @throws IndexOutOfBoundsException
     */

    public int intAt(final int index) throws IndexOutOfBoundsException {
        if (index > bitString.length()) {
            throw new IndexOutOfBoundsException("That index is out of bounds "
                    + "of the bit string.");
        }
        String valueAtIndex = String.valueOf(bitString.charAt(index));
        return Integer.valueOf(valueAtIndex);
    }

    /**
     * Returns a boolean corresponding to the
     * bit at the specified index.  False
     * corresponds to 0, true corresponds to 1.
     * @param index index Of where to set bit
     * @return boolean
     * @throws IndexOutOfBoundsException
     */
    public boolean booleanAt(final int index) throws IndexOutOfBoundsException {
        if (index > bitString.length()) {
            throw new IndexOutOfBoundsException("That index is out of bounds"
                    + "of the bit string ");
        }
        char charAtIndex = bitString.charAt(index);
        return charAtIndex != '0';
    }

    /**
     * Sets the bit at the specified index.
     * If the parameter is not '0' or '1' the
     * behavior of this method is undefined.
     * @param index index Of where to set bit
     * @param c char to set bit at index
     */
    public void setBitAt(final int index, final char c) {
        if (c == '0' || c == '1') {
            if (bitString.isEmpty()) {
                createLongerBitStringFromEmptyString(index);
            } else if (index > bitString.length() - 1) {
                createLongerBitString(index);
            }
            StringBuilder stringBuild = new StringBuilder(bitString);
            stringBuild.setCharAt(index, c);
            bitString = stringBuild.toString();
        }
    }

    /**
     * Sets the bit at the specified index.
     * If the parameter is not 0 or 1 the
     * behavior of this method is undefined.
     * @param index index Of where to set bit
     * @param i int to set at bit index
     */
    public void setBitAt(final int index, final int i) {
        if (i == 0 || i == 1) {
            if (bitString.isEmpty()) {
                createLongerBitStringFromEmptyString(index);
            } else if (index > bitString.length() - 1) {
                createLongerBitString(index);
            }
            StringBuilder stringBuild = new StringBuilder(bitString);
            stringBuild.setCharAt(index, (char) (i + '0'));
            bitString = stringBuild.toString();

        }
    }

    /**
     * Sets the bit at the specified index.
     *  False corresponds to 0,
     *  true corresponds to 1.
     * @param index index Of where to set bit
     * @param b boolean value to set bit at index
     */

    public void setBitAt(final int index, final boolean b) {
        if (bitString.isEmpty()) {
            createLongerBitStringFromEmptyString(index);
        } else if (index > bitString.length() - 1) {
            createLongerBitString(index);
        }

        char charToSet = b ? '1' : '0';
        StringBuilder stringBuild = new StringBuilder(bitString);
        stringBuild.setCharAt(index, charToSet);
        bitString = stringBuild.toString();
    }

    /**
     * Overrides Object toString().
     * @return String representation of bitString
     */
    @Override
    public String toString() {
        return bitString;
    }

    /**
     * Creates a string long enough to set the bit at a specified index.
     * @param index index of where the bit will be set
     */
    private void createLongerBitString(final int index) {
        int bitStringLength = bitString.length() - 1;
        int amtOfBitsToAdd = index - bitStringLength;
        for (int i = 0; i < amtOfBitsToAdd; i++) {
            bitString = bitString + "0";
        }
    }
    /**
     * Creates a string long enough to set the bit at a specified index from
     * an empty string.
     * @param index index of where the bit will be set
     */
    private void createLongerBitStringFromEmptyString(final int index) {
        for (int i = 0; i <= index; i++) {
            bitString = bitString + "0";
        }
    }

}
