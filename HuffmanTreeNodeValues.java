/**
 * Created by Kendra's Laptop on 10/15/2016.
 */
public class HuffmanTreeNodeValues {

	private Character symbol;
	private Double frequency;
	private StringOfBits code;
	/**
	 * Constructor that sets all values to null
	 */
	public HuffmanTreeNodeValues() {
		this.symbol = null;
		this.frequency = null;
		this.code = null;
	}

	/**
	 * Constructor that sets all values
	 * @param symbol Character symbol
	 * @param frequency Frequency of symbol
	 * @param code the code for the symbol
	 */
	public HuffmanTreeNodeValues(Character symbol, Double frequency,
								 StringOfBits code) {
		this.symbol = symbol;
		this.frequency = frequency;
		this.code = code;
	}

	/**
	 * Accesses the symbol.
	 * @return the symbol
	 */
	public Character getSymbol() {
		return this.symbol;
	}

	/**
	 * Accesses the code.
	 * @return the code
	 */
	public StringOfBits getCode() {
		return this.code;
	}

	/**
	 * Access the frequency
	 * @return the frequency
	 */
	public Double getFrequency() {
		return this.frequency;
	}

	/**
	 * Modifies the symbol
	 * @param newSymbol - the replacement symbol
	 */
	public void setSymbol(Character newSymbol) {
		this.symbol = newSymbol;
	}

	/**
	 * Modifies the code
	 * @param newCode - the replacement code
	 */
	public void setCode(StringOfBits newCode) {
		this.code = newCode;
	}

	/**
	 * Modifies the frequency.
	 * @param newFrequency - the replacement frequency
	 */
	public void setFrequency(Double newFrequency) {
		this.frequency = newFrequency;
	}
}
