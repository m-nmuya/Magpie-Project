import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Marie Muya
 * @version June 2023
 */
public class MagpieRunnerMM
{

	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		MagpieMM maggie = new MagpieMM();
		
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}

}

