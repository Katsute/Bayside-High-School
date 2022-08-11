import java.util.Scanner;

public class InvestmentProgram {
/*       ^     InvestmentProgram is a class */
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		double r=0;
		double A=0;
		double t=0;
		double n=0;
		double P=0;


		System.out.println("Enter annual return rate");
		/*               \/    Return rate can be a decimal */
		r = input.nextDouble()/100.0;
		/* Integer division fix    ^    */

		System.out.println("Enter the number of years to invest");
		t = input.nextInt();

		System.out.println("Enter the number of compounding periods");
		n = input.nextInt();

		System.out.println("Enter the initial investment amount");
		P = input.nextDouble();
		/*              ^     Initial investment can be decimal */

		A = P * Math.pow(1 - r/n , n*t);
		/*    ^            ^ Should be subtraction not addition */
		/*    |     Missing multiplier */
		double increasedBy = A - P;
		/* ^                   ^   Increased should be A - P (Investment value - Initial) */
	    /* |   increasedBy must be defined */
		System.out.println("The initial investment amount is" + P);
		System.out.println("The value of the investment after " + t + " years is " + A);
		/*                              String concatenaton error   ^                ^   Investment value is A not P */
		System.out.println("The value of the initial investment increased by " + increasedBy);
		/*														      Should be lowercase  ^ */

	}

}