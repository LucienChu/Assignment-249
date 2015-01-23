/**
 * This class can access, mutate, copy and display the
 * type, the name, and the expired date of a credit card.
 * @author Zhi Heng Zhu
 * @version 1.0
 */
public class CreditCard {
	public String cardType;
	public String holderName;
	int expiredMonth;
	int expiredYear;

	/**
	 * It constructs a new credit card.
	 * @param type The type of a credit card
	 * @param name The name of the card holder
	 * @param month The expired month of the card
	 * @param year The expired year of the card
	 */
	public CreditCard(String type, String name, int month, int year) {
		cardType = type;
		holderName = name;
		if ((month > 0) && (month < 13))
			expiredMonth = month;
		else
			expiredMonth = 0;

		expiredYear = year;
	}


	/**
	 * This method is to get access the type of a credit card.
	 * @return The type of the credit card.
	 */
	public String getType() {
		return (cardType);
	}
	
	/**
	 *This method is to get access the name of a card holder. 
	 * @return The name of the card holder
	 */
	public String getName() {
		return (holderName);
	}
	
	/**
	 * This method is to get access the expired month of a credit card.
	 * @return the month that the card will be expired
	 */
	public int getExpiredMonth() {
		return (expiredMonth);
	}
	
	/**
	 * This method is to get access the expired year of a credit card.
	 * @return the year that the card will be expired
	 */
	public int getExpiredYear() {
		return (expiredYear);
	}

	/**
	 * This method is to reset the expired month of a credit card.
	 * @param otherMonth The updated expired month
	 */
	public void setMonth(int otherMonth) {
		if ((otherMonth > 0) && (otherMonth < 13))
			expiredMonth = otherMonth;
	}
	
	/**
	 * This method is to reset the expired year of a credit card.
	 * @param otherYear The updated expired year
	 */
	public void setYear(int otherYear) {
		expiredYear = otherYear;
	}
	
	/**
	 * This method can display the information of a credit card.
	 * @return A string contains the type, name of holder and date of expiration
	 * of a credit card.
	 */
	public String toString() {
		if (this.getExpiredMonth() < 10)
			return (cardType + " card " + holderName + " expired in 0" + expiredMonth + "/" + expiredYear);
		else
			return (cardType + " card " + holderName + " expired in " + expiredMonth + "/" + expiredYear);
	}

	/**
	 * This method can copy the information of an existing credit card
	 * to another credit cards.
	 * @param origin The existing credit card.
	 */
	public CreditCard(CreditCard origin) {
		cardType = origin.getType();
		holderName = origin.getName();
		expiredMonth = origin.getExpiredMonth();
		expiredYear = origin.getExpiredYear();
	}

	/**
	 * This method is to tell whether two credit cards are identical
	 * based on the information of each card.
	 * @param aCard The card that is to be compared
	 * @return True if they contains identical information, false otherwise
	 */
	public boolean equals(CreditCard aCard) {
		return ((aCard.getName().equals(this.getName()) && (aCard.getType()
				.equals(this.getType())
				&& (aCard.getExpiredMonth() == this.getExpiredMonth()) && (aCard
					.getExpiredYear() == this.getExpiredYear()))));
	}

}
