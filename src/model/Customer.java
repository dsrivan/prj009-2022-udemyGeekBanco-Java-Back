package model;

import java.util.Date;

import helper.Utils;

public class Customer {
	
	private static int counter = 101;
	
	private int id;
	private String name;
	private String email;
	private String cpf;
	private Date bornDate;
	private Date registrationDate;
	
	public Customer(String name, String email, String cpf, Date bornDate) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.bornDate = bornDate;		
		this.registrationDate = new Date();		
		this.id = Customer.counter;
		Customer.counter += 1;
	}
	
	public int getId () {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	
	public Date getRegistraDate() {
		return registrationDate;
	}

	@Override
	public String toString() {
		return "Código: "+ this.getId() +
				"\nNome: "+ this.getName() +
				"\nCPF: "+ this.getCpf() +
				"\nEmail: "+ this.getEmail() +
				"\nData de Nascimento: "+ Utils.dateToString(this.getBornDate()) + 
				"\nData de Cadastro: "+ Utils.dateToString(this.getRegistraDate());
	}
	
}
