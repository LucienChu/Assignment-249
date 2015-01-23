/**
 * Based on the values of five kinds of coins, class Coins
 * calculate the total value of the coins and display the
 * number of each coins.
 * @author Zhi Heng Zhu
 * @version 1.0
 */
public class Coins 
{
	private int numberOfNickels;
	private int numberOfDimes;
	private int numberOfQuarters;
	private int numberOfLoonies;
	private int numberOfToonies;
	
	static double valueOfNickel = 0.05, 
			valueOfDime = 0.1, 
			valueOfQuarter = 0.25, 
			valueOfLoonie = 1, 
			valueOfToonie = 2;
	
	public Coins(int x1,int x2,int x3,int x4, int x5)
	{
		numberOfNickels = x1;
		numberOfDimes = x2;
		numberOfQuarters = x3;
		numberOfLoonies = x4;
		numberOfToonies = x5;
	}
	
	/**
	 * This method access the number of nickels within coins.
	 * @return The number of nickels
	 */
	public int getNickels()
	{
		return numberOfNickels;
	}
	
	/**
	 * This method access the number of dimes within coins.
	 * @return The number of dimes
	 */
	public int getDimes()
	{
		return numberOfDimes;
	}
	
	/**
	 * This method access the number of quarters within coins.
	 * @return The number of quarters
	 */
	public int getQuarters()
	{
		return numberOfQuarters;
	}
	
	/**
	 * This method access the number of loonies within coins.
	 * @return The number of loonies
	 */
	public int getLoonies()
	{
		return numberOfLoonies;
	}
	
	/**
	 * This method access the number of toonies2s within coins.
	 * @return The number of toonies
	 */
	public int getToonies()
	{
		return numberOfToonies;
	}
	
	/**
	 * This method set the number of nickels.
	 * @param x1 the number of nickels to be set.
	 */
	public void setNickels(int x1)
	{
		numberOfNickels = x1;
	}
	
	/**
	 * This method set the number of dimes.
	 * @param x2 the number of dimes to be set.
	 */
	public void setDimes(int x2)
	{
		numberOfDimes = x2;
	}
	
	/**
	 * This method set the number of quarters.
	 * @param x3 the number of quarters to be set
	 */
	public void setQuarters(int x3)
	{
		numberOfQuarters = x3;
	}
	
	/**
	 * This method set the number of loonies.
	 * @param x4 the number of loonies to be set
	 */
	public void setLoonies(int x4)
	{
		numberOfLoonies = x4;
	}
	
	/**
	 * This method set the number of toonies.
	 * @param x5 the number of toonies to be set
	 */
	public void setToonies(int x5)
	{
		numberOfToonies = x5;
	}
	
	/**
	 * This constructor copies the numbers of different kinds
	 * of coins from origin to another object. 
	 * @param origin the origin coins which is about to be copied
	 */
	public Coins(Coins origin)
	{
		numberOfNickels = origin.getNickels();
		numberOfQuarters = origin.getQuarters();
		numberOfDimes = origin.getDimes();
		numberOfLoonies = origin.getLoonies();
		numberOfToonies = origin.getToonies();
	}
		
	/**
	 * This method respectively adds different numbers of coins to
	 * existing coins.
	 * @param x1 the number of nickels to be add
	 * @param x2 the number of dimes to be add
	 * @param x3 the number of quarters to be add
	 * @param x4 the number of loonies to be add
	 * @param x5 the number of toonies to be add
	 */
	public void addCoins(int x1, int x2, int x3, int x4, int x5)
	{
		numberOfNickels = numberOfNickels + x1;
		numberOfDimes = numberOfDimes + x2;
		numberOfQuarters = numberOfQuarters + x3;
		numberOfLoonies = numberOfLoonies + x4;
		numberOfToonies = numberOfToonies + x5;
	}
	
	/**
	 * This method calculate the total value of all coins, depending on the 
	 * specific value of each kind of coin.
	 * @return The total value of coins
	 */
	public double coinsTotal()
	{
		return (numberOfNickels * valueOfNickel + numberOfDimes * valueOfDime + 
				numberOfQuarters * valueOfQuarter + numberOfLoonies * valueOfLoonie + 
				numberOfToonies * valueOfToonie);
	}
	
	/**
	 * This method is to display the distribution of different coins.
	 *@return A string of the number of each kind of coin
	 */
	 
	public String toString()
	{
		return ("Coins are:\n" +
				"Nickels: " + numberOfNickels + "\n" +
				"Dimes: "+ numberOfDimes + "\n" +
				"Quarters: " + numberOfQuarters + "\n" +
				"Loonies: " + numberOfLoonies + "\n" + 
				"Toonies: " + numberOfToonies);
	}
	/**
	 * This method compares the number of each coin in two sets
	 * of coins to determine whether these sets are identical.
	 * @param Ncoins another set of coins to be compared
	 * @return True of identity otherwise false
	 */
	public boolean isEqual(Coins Ncoins)
	{
		return (Ncoins.getNickels()== this.getNickels() && 
				Ncoins.getDimes() == this.getDimes() &&
				Ncoins.getQuarters() == this.getQuarters() &&
				Ncoins.getLoonies() == this.getLoonies() &&
				Ncoins.getToonies() == this.getToonies());
	}
}
