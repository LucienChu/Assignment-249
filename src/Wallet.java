/**
 * This class could add, delete and modify informatiom of credit cards
 * and also change the distribution of coins and compare the coins to other
 * wallet.
 * @author Zhi Heng Zhu
 *
 */
public class Wallet 
{
	public Coins coins;
	public CreditCard [] creditCards;
	
	public Wallet()
	{
		coins = null;
		creditCards = null;
	}
	/**
	 * It creates a new wallet with predetermined coins and credit cards.
	 * @param newCoins The coins to be in the wallet
	 * @param newCreditCards The set of credit card for the new wallet
	 */
	public Wallet(Coins newCoins, CreditCard [] newCreditCards)
	{
		coins = new Coins(newCoins);
		creditCards = newCreditCards;
	}
	
	/**
	 * It compares the total values of coins in different wallets.
	 * @param otherWallet The wallet that is to be compared with the original one
	 * @return True if the total values of two set of coins are identical, flase otherwise
	 */
	public boolean valuesEqual(Wallet otherWallet)
	{
		return (coins.coinsTotal() == otherWallet.coins.coinsTotal());
	}
	
	/**
	 * It considers whether two set of coins in different wallets have the same distribution.
	 * @param otherWallet The wallet contains the an other set of coins
	 * @return True if two set of coins have the same distribution, false otherwise
	 */
	public boolean coinsTypesEqual(Wallet otherWallet)
	{
		return (this.coins.isEqual(otherWallet.coins));
	}
	
	/**
	 * This method calculate the total value of coins in a wallet
	 * @return The total value of coins
	 */
	public double totalValue()
	{
		return (coins.coinsTotal());
	}
	
	/**
	 * This method shows the number of credit card in a wallet.
	 * @return The number of credit card in a wallet
	 */
	public int numOfCard()
	{
		if (creditCards != null)
			return (creditCards.length);
		else
			return 0;
	}
	
	/**
	 * It adds a new credit card into the current wallet.
	 * @param newCard A new card that is to be added
	 */
	public void addCreditCard(CreditCard newCard)
	{
		if (this.numOfCard() == 0)
		{
			 int i = 1;
			 CreditCard [] temp = new CreditCard[1];
			 temp[0] = new CreditCard(newCard);
			 this.creditCards = temp;
			 
		}
		else
		{
			CreditCard [] temp = new CreditCard[this.numOfCard() + 1];
		
			for (int i = 0; i < creditCards.length; i++)
				temp[i] = new CreditCard(creditCards[i]);
			temp[this.numOfCard()] = new CreditCard(newCard);
			this.creditCards = temp;
		}
	}
	
	/**
	 * This method is designed to delete an existing credit card from a wallet.
	 * @param indexedCard The position of the card which the user is about to delete
	 */
	public void deleteCreditCard(int indexedCard)
	{
		if (creditCards.length == 0)// If a wallet has no credit, it makes no sense to delete one.
			System.exit(0);
		else
		{
			CreditCard [] temp = new CreditCard [creditCards.length - 1];
		
			for (int i = 0; i < indexedCard; i++)
				temp[i] = new CreditCard(creditCards[i]);
			for (int i = 2; i < temp.length;i++)
				temp[i] =  new CreditCard(creditCards[i]);
			this.creditCards = temp;
		}
	}
	
	/**
	 * This method could modify the expiry date of a credit card.
	 * @param indexedCard The position of the card in the credit card array that the 
	 * 			user is about to update.
	 * @param otherYear A new year indicated by user to update
	 * @param otherMonth A new month indicated by user to update
	 */
	public void setExpiredDate(int indexedCard, int otherYear, int otherMonth)
	{
		creditCards[indexedCard].setYear(otherYear);
		creditCards[indexedCard].setMonth(otherMonth);
	}
	
	/**
	 * This method adds coins to a wallet and calculate the total value after modification.
	 * @param newNickels The number of nickels to user wants to add
	 * @param newDimes The number of dimes to user wants to add
	 * @param newQuarters The number of quarters to user wants to add
	 * @param newLoonies The number of loonies to user wants to add
	 * @param newToonies The number of toonies to user wants to add
	 * @return the total value of the updated coins
	 */
	public double addCoins(int newNickels, int newDimes, int newQuarters,
						 int newLoonies, int newToonies)
	{
		coins.addCoins(newNickels, newDimes, newQuarters, newLoonies, newToonies);
		return coins.coinsTotal();
	}
	
	/**
	 * This method can tell whether two total values of coins in two wallets are equal or not.
	 * @param fromOtherWallet A set of coins from the compared wallet
	 * @return True if the total values of two sets of coins are euqal, fale otherwise
	 */
	public boolean coinsValueEquals(Coins fromOtherWallet)
	{
		return (coins.coinsTotal() == fromOtherWallet.coinsTotal());
	}
	
	public boolean equals(Wallet otherWallet)
	{
		return(this.valuesEqual(otherWallet) && (this.numOfCard() == otherWallet.numOfCard()));
	}
	
	/**
	 * This method displays the details of a wallet including the distrution of coins and the information
	 * of its credit card.
	 *  @return Details of a wallet
	 */
	public String toString()
	{
		if(this.numOfCard() == 0)
			return ("There is no credit card in this wallet.\n" + coins.toString());
		else
		{
			for (int i = 0; i < creditCards.length; i++)
				System.out.println(creditCards[i].toString());
			return (coins.toString());
		}
	}
		
	/**
	 * This method is designed to display the constructure of coins in a wallet.
	 * @return The numbers of nickels, dimes, quarter, loonie, and toonie in the wallet
	 */
	public String coinsDetail()
	{
		return(coins.toString());
	}
						
	
}
