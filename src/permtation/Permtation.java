/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permtation;

/**
 *
 * @author Alaa
 */
// Java implementation of the approach 
class permtation {

	private static final int TWO = 2;
	// The input array for permutation
	private final char Arr[];
	private int permutation_record = 1;
	// Index array to store indexes of input array
	private int Indexes_array[];

	// The index of the first "increase"
	// in the Index array which is the smallest
	// i such that Indexes[i] < Indexes[i + 1]
	private int Increase;

	// Constructor
	public permtation(char arr[]) {
		this.Arr = arr;
		this.Increase = -1;
		this.Indexes_array = new int[this.Arr.length];

	}

	// this function computes the possible number of all possible permutation of a
	// string
	private int factorial(int arry_lenth) {
		int _factorialNumber = 1;
		for (int i = 1; i <= arry_lenth; i++) {
			_factorialNumber = _factorialNumber * i;
		}
		return _factorialNumber;
	}
// this function prints out all the possible permutation of a given string 

	public void getStringPermutations() {
		GetFirst(Indexes_array);
		while (this.HasNext()) {
			this.GetNext();
		}
	}

	// Initialize and output
	// the first permutation
	private void GetFirst(int[] Indexes) {

		// Initialize the values in Index array
		// from 0 to n - 1
		for (int i = 0; i < Indexes.length; ++i) {
			this.Indexes_array[i] = i;
		}

		// Set the Increase to 0
		// since Indexes[0] = 0 < Indexes[1] = 1
		this.Increase = 0;

		// Output the first permutation
		PrintFactorialNumber();
		this.getPerumation();
	}

	/**
	 * @param Indexes_array
	 */
	private void PrintFactorialNumber() {
		System.out.print("The possiple numer of permutation is: " + this.factorial(Indexes_array.length) + "\n");
	}

	// Function that returns true if it is
	// possible to generate the next permutation
	private boolean HasNext() {

		// When Increase is in the end of the array,
		// it is not possible to have next one
		return this.Increase != (this.Indexes_array.length - 1);
	}

	// Output the next permutation
	private void GetNext() {

		// Increase is at the very beginning
		if (this.Increase == 0) {

			// Swap Index[0] and Index[1]
			this.Swap(this.Increase, this.Increase + 1);

			// Update Increase
			updateIncrease();
		} else {

			// Value at Indexes[Increase + 1] is greater than Indexes[0]
			// no need for binary search,
			// just swap Indexes[Increase + 1] and Indexes[0]
			if (this.Indexes_array[this.Increase + 1] > this.Indexes_array[0]) {
				this.Swap(this.Increase + 1, 0);
			} else {

				// Binary search to find the greatest value
				// which is less than Indexes[Increase + 1]
				int mid = searchArray();

				// Swap
				this.Swap(this.Increase + 1, mid);
			}

			// Invert 0 to Increase
			invertZero();

			// Reset Increase
			this.Increase = 0;
		}
		this.getPerumation();
	}

	/**
	 * @return
	 */
	private int searchArray() {
		int start = 0;
		int end = this.Increase;
		int mid = (start + end) / TWO;
		int tVal = this.Indexes_array[this.Increase + 1];
		while (!(this.Indexes_array[mid] < tVal && this.Indexes_array[mid - 1] > tVal)) {
			if (this.Indexes_array[mid] < tVal) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			mid = (start + end) / TWO;
		}
		return mid;
	}

	/**
	 * 
	 */
	private void updateIncrease() {
		this.Increase += 1;
		while (this.Increase < this.Indexes_array.length - 1
				&& this.Indexes_array[this.Increase] > this.Indexes_array[this.Increase + 1]) {
			++this.Increase;
		}
	}

	/**
	 * 
	 */
	private void invertZero() {
		for (int i = 0; i <= this.Increase / TWO; ++i) {
			this.Swap(i, this.Increase - i);
		}
	}

	// Function to output the input array
	private void getPerumation() {
		StringBuilder permtationBulder = new StringBuilder();
		for (int i = 0; i < this.Indexes_array.length; ++i) {

			// Indexes of the input array
			// are at the Indexes array
			permtationBulder.append(this.Arr[this.Indexes_array[i]]);

		}
		PrintPermutation(permtationBulder);
	}

	/**
	 * @param permtationBulder
	 */
	private void PrintPermutation(StringBuilder permtationBulder) {
		System.out.println("[" + permutation_record++ + "]" + permtationBulder.toString());
	}

	// Swap two values in the Indexes array
	private void Swap(int src, int dest) {
		
		try {
			int tmp = this.Indexes_array[src];
			this.Indexes_array[src] = this.Indexes_array[dest];
			this.Indexes_array[dest] = tmp;
		} catch (ArrayIndexOutOfBoundsException   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// This code is contributed by ghanshyampandey 
