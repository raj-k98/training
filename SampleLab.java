package lab1project;

public class Main {

	public static void main(String[] args) {

		// int s = calculateSum(10);

		int s = calculateDifference(5);
		System.out.println(s);
	}

	// this method adds n natural numbers divisible by 3 or 5
	static int calculateSum(int n) {

		int sum = 0;

		for (int i = 1; i <= n; i++) {

			if (i % 3 == 0 || i % 5 == 0) {
				sum = sum + i; // sum += i;
			}
		}

		return sum;
	}

// this function calculates difference between sum of squares  and square of 
//  sum of n natural numbers
	static int calculateDifference(int n) {

		int sum = 0;
		int sumSqr = 0;

		for (int i = 1; i <= n; i++) {

			sum = sum + i;
			sumSqr = sumSqr + i * i;

		}

		sum = sum * sum;

		int result = sumSqr - sum;
		return result;

	}

}
