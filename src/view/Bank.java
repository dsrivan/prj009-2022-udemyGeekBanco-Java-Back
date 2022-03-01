package view;

import java.util.ArrayList;
import java.util.Scanner;

import helper.Utils;
import model.Account;
import model.Customer;

public class Bank {
	
	static String name = "dsrIvan Bank";
	static Scanner keyboard = new Scanner(System.in);
	static ArrayList<Account> accounts;

	public static void main(String[] args) {
		Bank.accounts = new ArrayList<Account>();
		Bank.menu();
	}

	private static void menu() {
		// ATM = Automatic Teller Machine (Caixa Eletrônico)
		
		System.out.println("*******************************");
		System.out.println("\n----------- ATM ------------");
		System.out.println("-------- "+ Bank.name +" ------");

		System.out.println("\nSelecione uma opção");
		System.out.println("1 - Criar conta");
		System.out.println("2 - Sacar");
		System.out.println("3 - Depositar");
		System.out.println("4 - Transferir");
		System.out.println("5 - Listar contas");
		System.out.println("6 - Sair do sistema");

		int option = 0;

		try {
			option = Integer.parseInt(Bank.keyboard.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("Opção inválida. Tente novamente.\n");
			Utils.pause(1);
			Bank.menu();
		}
		
		switch (option) {
		case 1:
			Bank.create();
			break;
		case 2:
			Bank.withdraw();
			break;
		case 3:
			Bank.deposit();
			break;
		case 4:
			Bank.transfer();
			break;
		case 5:
			Bank.list();
			break;
		case 6:
			System.out.println("Obrigado.\n");
			Utils.pause(2);
			System.exit(0);
			break;
		default:
			System.out.println("Opção inválida.\n");
			Utils.pause(2);
			Bank.menu();
			break;
		}
		
	}

	private static void create() {
		// Criar conta
		
		System.out.println();
		System.out.println("*******************************");
		System.out.println("------ Cadastrar cliente ------");
		System.out.println();

		System.out.println("Nome");
		String name = Bank.keyboard.nextLine();

		System.out.println("E-mail");
		String email = Bank.keyboard.nextLine();

		System.out.println("CPF");
		String cpf = Bank.keyboard.nextLine();

		System.out.println("Data de Nascimento");
		String bornDate = Bank.keyboard.nextLine();
		
		Customer customer = new Customer(
				name,
				email,
				cpf,
				Utils.stringToDate(bornDate));
		
		Account account = new Account(customer);
		
		Bank.accounts.add(account);
		
		System.out.println("Conta criada.\n");		
		System.out.println("Dados da conta.");
		System.out.println(account);
		System.out.println();
		
		Utils.pause(4);
		Bank.menu();
	}

	private static void withdraw() {
		// Sacar
		
		System.out.println();
		System.out.println("*******************************");
		System.out.println("------------ Saque ------------");
		System.out.println();

		System.out.println("Informe o número da conta");
		int number = Bank.keyboard.nextInt();
		
		Account account = Bank.findAccountByNumber(number);
		
		if (account == null) {
			System.out.println("A conta "+ number +" não foi encontrada.\n");
		} else {
			System.out.println("Informe o valor para saque");
			Double amount = Bank.keyboard.nextDouble();
			
			account.withdraw(amount);
		}
		Utils.pause(3);
		Bank.menu();
	}

	private static void deposit() {
		// Depositar
		
		System.out.println();
		System.out.println("*******************************");
		System.out.println("----------- Depósito ----------");
		System.out.println();

		System.out.println("Informe o número da conta");
		int number = Bank.keyboard.nextInt();
		
		Account account = Bank.findAccountByNumber(number);
		
		if (account == null) {
			System.out.println("A conta "+ number +" não foi encontrada.\n");
		} else {
			System.out.println("Informe o valor para depósito");
			Double amount = Bank.keyboard.nextDouble();
			
			account.deposit(amount);
		}
		Utils.pause(3);
		Bank.menu();
	}

	private static void transfer() {
		// Transferir
		
		System.out.println();
		System.out.println("*******************************");
		System.out.println("-------- Transferência --------");
		System.out.println();

		System.out.println("Informe o número da conta origem");
		int originNumber = Bank.keyboard.nextInt();	
		
		Account originAccount = Bank.findAccountByNumber(originNumber);
		
		if (originAccount == null) {
			System.out.println("A conta "+ originNumber +" não foi encontrada.\n");
		} else {
			System.out.println("Informe o número da conta destino");
			int destinationNumber = Bank.keyboard.nextInt();	
			
			Account destinationAccount = Bank.findAccountByNumber(destinationNumber);
			
			if (destinationAccount == null) {
				System.out.println("A conta "+ destinationNumber +" não foi encontrada.\n");
			} else {
				System.out.println("Informe o valor para transferência");
				Double amount = Bank.keyboard.nextDouble();
				
				originAccount.transfer(destinationAccount, amount);				
			}
		}
		Utils.pause(3);
		Bank.menu();
	}
	
	private static void list() {
		// Listar contas
		if (Bank.accounts.size() == 0) {
			System.out.println("Nenhuma conta encontrada.\n");
		} else {
			System.out.println();
			System.out.println("*******************************");
			System.out.println("------- Lista de contas -------");
			System.out.println();
			
			for (Account account: Bank.accounts) {
				System.out.println(account);
				System.out.println();
				Utils.pause(1);
			}
			System.out.println();
		}
		Utils.pause(3);
		Bank.menu();
	}

	private static Account findAccountByNumber(int number) {
		Account account = null;
		
		if (Bank.accounts.size() > 0) {
			for (Account acc: Bank.accounts) {
				if (acc.getNumber() == number) {
					account = acc;
				}
			}
		}
		return account;
	}
}