package view;

import helper.Utils;
import model.Account;
import model.Customer;

public class Tests {

	public static void main(String[] args) {
		
		Customer cJose = new Customer(
				"José Lorem",
				"loremJose@email.net",
				"123.123.123-12",
				Utils.stringToDate("01/01/2000")
				);

		Customer cHugo = new Customer(
				"Hugo Ipsum",
				"ipsumHugo@email.org",
				"456.456.456-45",
				Utils.stringToDate("12/12/1999")
				);
		
		/*
			System.out.println(cJose);
			System.out.println();
			System.out.println(cHugo);
		*/
		
		Account aJose = new Account(cJose);
		Account aHugo = new Account(cHugo);
		
		aJose.setBalance(200.00);
		aHugo.setBalance(200.00);
		
		// ---------------------------------
		// depósitos
		
		// valor < 0
		//aJose.deposit(-5.00);
		//aHugo.deposit(-5.00);
		
		// valor == 0
		//aJose.deposit(0.00);
		//aHugo.deposit(0.00);
		
		//valor > 0
		aJose.deposit(500.00);
		aHugo.deposit(500.00);
		
		// ---------------------------------
		// saques
		
		// valor dentro de saldo suficiente		
		//aJose.withdraw(300.00);
		//aHugo.withdraw(200.00);
		
		// valor = 0
		//aJose.withdraw(0.00);
		//aHugo.withdraw(0.00);
		
		// valor negativo
		//aJose.withdraw(-300.00);
		//aHugo.withdraw(-200.00);
		
		// valor acima de saldo suficiente		
		//aJose.withdraw(650.00);
		//aHugo.withdraw(500.00);
		
		// ---------------------------------
		// transferência
		
		//
		aJose.transfer(aHugo, 100.00);
		aHugo.transfer(aJose, 50.00);

		
		// ---------------------------------
		// contas
		
		System.out.println(aJose);
		System.out.println();
		System.out.println(aHugo);

	}

}
