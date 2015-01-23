import java.util.Scanner;

public class WalletDriver 
{

	public static void main(String[] args) 
	{
		int totalWallets = 5;//number of wallets
		Wallet [] wallets = new Wallet[totalWallets];

		//for wallet 1 and wallet 2
		Coins coins1 = new Coins (10,10,10,10,10);
		Coins copyCoins1 = new Coins(coins1);//coins for wallet[1]
		CreditCard [] creditCard1= new CreditCard[4];
		creditCard1[0] = new CreditCard("visa", "Heng", 8, 2015);
		creditCard1[1] = new CreditCard("Master", "Zhi", 8, 2015);
		creditCard1[2] = new CreditCard("AMES", "Lucien", 8, 2015);
		creditCard1[3] = new CreditCard("AMES", "Lucy", 8, 2015);		

		CreditCard [] creditCard2 = new CreditCard[3];
		creditCard2[0] = new CreditCard("Visa", "Jacura", 8, 2015);
		creditCard2[1] = new CreditCard("Master", "Jack", 8, 2015);
		creditCard2[2] = new CreditCard("AMES", "Franky", 8, 2015);

		wallets[0] = new Wallet(coins1, creditCard1);
		wallets[1] = new Wallet(copyCoins1, creditCard2);

		//for wallet 3
		Coins coins3 = new Coins(10,10,10,30,0);//same total value of coins in wallet[0] and wallet[1].
		CreditCard [] creditCard3 = new CreditCard[2];
		creditCard3[0] = new CreditCard("Visa", "Lily", 8, 2015);
		creditCard3[1] = new CreditCard("Visa", "Jennifer", 8, 2015);
		wallets[2] = new Wallet(coins3, creditCard3);

		//for wallet 4 and wallet 5
		Coins coins4 = new Coins(20,20,20,20,20);
		Coins copyCoins4 = new Coins(coins4);
		wallets[3] = new Wallet(coins4, null);//no credit card.
		wallets[4] = new Wallet(copyCoins4, null);//no credit card.

		boolean tryAgain;
		do// a do-while loop to screen out invalid input.
		{
			tryAgain = false;
			System.out.println("Welcome to use the Wallet Deriver.\n" + 
					"What would your like to do?\n" +
					"\t1. See the content of all wallets\n" + 
					"\t2. See the content of one wallet\n" + 
					"\t3. List wallets with same amount of money\n" + 
					"\t4. List wallets with same coins\n" + 
					"\t5. List wallets with same amout of money and same number of credit cards\n" + 
					"\t6. Ad a credit card to an existing wallet\n" + 
					"\t7. Remove an existing credit card from a wallet\n" + 
					"\t8. Update the expiry date of an existing credit card\n" + 
					"\t9. Add coins to a wallet\n" + 
					"\t0. To quit\n" + 
					"Please enter your choice and press <Enter>:");
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();

			if (option == 1)
			{
				for(int i = 0; i < wallets.length; i++)
				{
					if (wallets[i].creditCards == null)
					{
						System.out.println("In wallet " + (i+1));
						System.out.println("There is no credit card.");
						System.out.println(wallets[i].toString());
					}
					else
					{
						System.out.println("In wallet " + (i+1) + ".\nThere are " + wallets[i].numOfCard() + " credit cards.");
						System.out.println(wallets[i].toString() + "\n");
					}
				}
			}

			else if (option == 2)
			{
				boolean reTry;

				do// a do-while loop to screen out invalid wallet selection.
				{
					reTry = false;
					System.out.println("There are " + wallets.length + " wallets, please select a wallet from 1 to " + (wallets.length));
					int walletIndex = input.nextInt() - 1;

					if (walletIndex < wallets.length)
						System.out.println(wallets[walletIndex].toString());
					else
					{
						System.out.println("Sorry ,there is not such a wallet, please try again");
						reTry = true;
					}
				}while (reTry);


			}		

			else if (option == 3)
			{
				// a netted for loops to compare each credit card.
				for (int i = 0; i < totalWallets - 1; i++)
				{
					for (int j = i + 1; j < totalWallets; j++)
					{
						if (wallets[i].coinsValueEquals(wallets[j].coins))
						{
							System.out.print("Wallet " + (i+1) + " and wallet " + (j+1) + 
									" both have $" + 
									wallets[i].totalValue() + "\n");
						}
					}
				}
			}

			else if (option == 4)
			{
				System.out.println("List of wallets with same coins.");
				for (int i = 0; i < totalWallets - 1; i++)
				{
					for (int j = i + 1; j < totalWallets; j++)
					{
						if (wallets[i].coinsTypesEqual(wallets[j]))
						{
							System.out.print("Wallet " + (i+1) + " and wallet " + (j+1) + 
									" both have " + 
									wallets[j].coins.toString() + "\n");
						}
					}
				}
			}

			else if (option == 5)
			{
				System.out.println("List of wallets with same amount of money and same number of credit cards:");
				for (int i = 0; i < totalWallets - 1; i++)
				{
					for (int j = i + 1; j < totalWallets; j++)
					{
						if (wallets[i].equals(wallets[j]))
							System.out.print("Wallet " + (i+1) + " and wallet " + (j+1));
					}
				}
			}

			else if (option == 6)
			{
				System.out.println("There are " + wallets.length + " wallets, to which wallet you want to add a credit card?");Scanner keyBoard = new Scanner(System.in);
				int target = input.nextInt();
				System.out.println("You have selected wallet " + target + ", please input the holder's name and press <Enter>");
				String junk1 = input.nextLine();//skip the empty line.
				String name = input.nextLine();
				System.out.println("The card holder's name is " + name + ", please input the type of credit card, visa or master?");
				String junk2 = input.nextLine();//skip empty line
				String type = input.nextLine();

				System.out.println("One last step, please set the expired month and year (in numbers from 1 to 12 for " 
						+ name + "'s " + type + " card., separate by space");
				int month = input.nextInt();
				int year = input.nextInt();

				CreditCard newCard = new CreditCard(type, name, month, year);
				wallets[target - 1].addCreditCard(newCard);
				System.out.println("Right now you have " + wallets[target-1].numOfCard() + " credit cards");
			}

			else if (option == 7)
			{
				System.out.println("There are " + wallets.length + " wallets, from which wallet you want to remove a credit card?");
				int walletOption = input.nextInt();
				int walletIndex = walletOption - 1;

				if (wallets[walletOption-1].numOfCard() == 0)
					System.out.println("Sorry, there is not credit card in wallet " + walletOption);

				else
				{
					System.out.println("In wallet " + walletOption + ", there are " + 
							wallets[walletOption-1].numOfCard() + "credit cards");
					System.out.println("Which card you want to remove? From 1 to " + wallets[walletOption - 1].numOfCard());
					int choice = input.nextInt();
					int cardIndex = choice - 1;
					wallets[walletIndex].deleteCreditCard(cardIndex);
					System.out.println("Right now you have " + wallets[walletIndex].numOfCard() + " credit cards, with one card removed.");
				}
			}

			else if (option == 8)
			{
				System.out.println("There are " + wallets.length + " wallets, from which wallet you want to update a credit card? Please select from 1 to " +
						wallets.length);
				int walletIndex = input.nextInt() - 1;
				if (wallets[walletIndex].numOfCard() == 0)
					System.out.println("Sorry, there is no credit card.");

				System.out.println("There are " + wallets[walletIndex].numOfCard() + " credit cards in wallet " + (walletIndex + 1));
				System.out.println("Which card you want to upadte? From 1 to " + wallets[walletIndex].numOfCard());
				int cardIndex = input.nextInt() - 1;
				if ((cardIndex > 0) && (cardIndex < wallets[walletIndex].numOfCard()))
				{
					System.out.println("Enter new expiry month number and year (separate by a space):");
					int newMonth = input.nextInt();
					int newYear = input.nextInt();
					wallets[walletIndex].creditCards[cardIndex].setMonth(newMonth);
					wallets[walletIndex].creditCards[cardIndex].setYear(newYear);
					System.out.println("Expiry date is updated.");
				}
				else
					System.out.println("Card number " + (cardIndex + 1) + " does not exist.");
			}

			else if(option == 9)
			{
				System.out.println("There are " + wallets.length + " wallets, to which wallet you want to add coins?");
				int walletIndex = input.nextInt() - 1;
				System.out.println("There are " + wallets[walletIndex].totalValue() + " in the wallet");
				System.out.println("How many nickels, dimes, quarters, loonies and toonies do you want to add to "
						+ walletIndex + 1 + " ?\n" + "Enter 5 numbers separated by a space");
				int x1 = input.nextInt();
				int x2 = input.nextInt();
				int x3 = input.nextInt();
				int x4 = input.nextInt();
				int x5 = input.nextInt();
				wallets[walletIndex].coins.addCoins(x1, x2, x3, x4, x5);
				System.out.println("You now have " + wallets[walletIndex].totalValue());
			}

			else if (option == 0)
			{
				System.out.println("Thank you for using Lucien's wallet application, see u next time ^_^");
				System.exit(0);
			}
			else
			{
				System.out.println("Sorry, that is not a valid choice, please try again.");
				tryAgain = true;
			}
		} while (tryAgain);
	}
}
