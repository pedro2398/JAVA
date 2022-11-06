package ex56;
import java.util.Scanner;

import ex55.cliente;

import java.util.ArrayList;

public class index {
	static public void main(String[] args){
	Scanner ler = new Scanner(System.in);
	
	int opc, idx, id, idade;
	String resp ,nome, email, agencia, numero;
	double saldo;
	
	ArrayList<Cliente> clientes = new ArrayList<>();
	
	do{
		
		System.out.printf("Selecione uma opcao: \n"+
						"1 - Incluir \n" +
						"2 - Atualizar \n" +
						"3 - Excluir \n" + 
						"4 - Exibir \n " + 
						"5 - Sair \n"
						
		);
		opc = ler.nextInt();
		
		if(opc == 1){
			
			Cliente c = new Cliente();
			
			id = clientes.size() + 1;
			c.setId(id);
			
			System.out.printf("Infome o nome do Cliente: ");
			nome = ler.next();
			c.setNome(nome);
			
			System.out.print("Qual é a idade do cliente? : ");
			idade = ler.nextInt();
			c.setIdade(idade);
			
			System.out.print("Qual é o email do cliente? : ");
			email = ler.next();
			c.setEmail(email);

			System.out.print("O cliente tem conta bancaria? [S/N] : ");
			resp = ler.next().toUpperCase();
				
				while(resp != "S" && resp != "N"){
					
					System.out.print("Resposta invalida!");
					
					System.out.print("O cliente tem conta bancaria? [S/N] : ");
					resp = ler.next().toUpperCase();
					
				}
			
				if(resp == "S"){
					
					ContaBancaria cb = new ContaBancaria();
					
					System.out.print("Qual é a agencia? : ");
					agencia = ler.next();
					cb.setAgencia(agencia);
					
					System.out.print("Qual é o numero da conta? : ");
					numero = ler.next();
					cb.setNumero(numero);
					
					System.out.print("Qual é o saldo da conta? : ");
					saldo = ler.nextDouble();
					cb.setSaldo(saldo);
					
					c.setConta(cb);
					
				}else{
					
					c.setConta(null);
				}
				
				clientes.add(c);
				
		}else if(opc == 2){
			
			Cliente c = new Cliente();
			
			for(Cliente a: clientes){
				System.out.println("ID:" + a.getId() + " - Nome: " + a.getNome() + " - eMail: " + a.getEmail());
			}
			
			System.out.print("Informe o index do cliente que sera atualizado: ");
			idx = ler.nextInt();
			
			System.out.printf("Infome o nome do Cliente: ");
			nome = ler.next();
			c.setNome(nome);
			
			System.out.print("Qual é a idade do cliente? : ");
			idade = ler.nextInt();
			c.setIdade(idade);
			
			System.out.print("Qual é o email do cliente? : ");
			email = ler.next();
			c.setEmail(email);

			System.out.print("O cliente tem conta bancaria? [S/N] : ");
			resp = ler.next().toUpperCase();
				
				while(resp != "S" && resp != "N"){
					
					System.out.print("Resposta invalida!");
					
					System.out.print("O cliente tem conta bancaria? [S/N] : ");
					resp = ler.next().toUpperCase();
					
				}
			
				if(resp == "S"){
					
					ContaBancaria cb = new ContaBancaria();
					
					System.out.print("Qual é a agencia? : ");
					agencia = ler.next();
					cb.setAgencia(agencia);
					
					System.out.print("Qual é o numero da conta? : ");
					numero = ler.next();
					cb.setNumero(numero);
					
					System.out.print("Qual é o saldo da conta? : ");
					saldo = ler.nextDouble();
					cb.setSaldo(saldo);
					
					c.setConta(cb);
					
				}else{
					
					c.setConta(null);
				}
			
		}
		
		}while( opc != 5 );
	}
}