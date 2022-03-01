package model;

public class Account {
	
	private static int id = 1001;
	
	// informações da conta
	private int number; // número
	private Customer customer; // cliente
	private Double balance = 0.0; // saldo
	private Double limit = 0.0; // limite
	private Double totalBalance; // saldo + limite
	
	public Account(Customer customer) {
		this.customer = customer;
		
		this.number = Account.id;
		Account.id += 1;
		this.updateTotalBalance();		
	}
	
	private void updateTotalBalance() {
		this.totalBalance = this.getBalance() + this.getLimit();
	}
	
	public void deposit(Double amount) {
		if (amount > 0) {
			this.balance = this.getBalance() + amount;
			this.updateTotalBalance();
			System.out.println("Depósito finalizado.\n");
		} else {
			System.out.println("Depósito não realizado. Tente novamente.\n");
		}
	}
	
	public void withdraw(Double amount) {
		if (amount > 0 && this.getTotalBalance() >= amount) {
			if (this.getBalance() >= amount) {
				this.balance =  this.getBalance() - amount;
				this.updateTotalBalance();
			} else {
				Double rest = this.getBalance() - amount;
				this.limit = this.getLimit() + rest;
				this.balance = 0.0;
				this.updateTotalBalance();				
			}
			System.out.println("Saque finalizado.\n");
		} else {
			System.out.println("Saque não realizado. Tente novamente.\n");
		}
	}
	
	public void transfer(Account destination, Double amount) {
		if (amount > 0 && this.getTotalBalance() >= amount) {
			if (this.getBalance() >= amount) {
				this.balance = this.getBalance() - amount;
				this.updateTotalBalance();
				
				destination.balance = destination.getBalance() + amount;
				destination.updateTotalBalance();
				
			} else {
				Double rest = this.getBalance() - amount;
				this.limit = this.getLimit() + rest;
				this.balance = 0.0;
				this.updateTotalBalance();
				
				destination.balance = destination.getBalance() + amount;
				destination.updateTotalBalance();
				
			}
			System.out.println("Transferência finalizada.\n");				
		} else {
			System.out.println("Transferência não realizada. Tente novamente.\n");
		}
	}
	
	@Override
	public String toString() {
		return "Número da Conta: "+ this.getNumber() +
				"\nCliente: "+ this.customer.getName() +
				"\nSaldo Total: "+ this.getTotalBalance();
	}
	
	public Customer getClient() {
		return customer;
	}
	public void setClient(Customer client) {
		this.customer = client;
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Double getLimit() {
		return limit;
	}
	public void setLimit(Double limit) {
		this.limit = limit;
		this.updateTotalBalance();
	}
	
	public int getNumber() {
		return number;
	}
	
	public Double getTotalBalance() {
		return totalBalance;
	}

}
