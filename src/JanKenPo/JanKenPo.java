package JanKenPo;

import java.util.Random;
import java.util.Scanner;



//import Projeto3.Projeto3.JankenPoEnum;

import java.util.Arrays;

public class JanKenPo {
	
	
	public enum JankenPoEnum {
		PEDRA ("Pedra ", 0),
		PAPEL ("Papel ", 1),
		TESOURA ("Tesoura ", 2),
		EMPATE ("Empate ", 3);
		
		String nome;
		int valor;
		
		JankenPoEnum(String nome, int valor) {
			this.nome = nome;
			this.valor = valor;
		}

		public String getNome() {
			return nome;
		}

		public int getValor() {
			return valor;
		}

		public static JankenPoEnum getByValor(int valor) {
			for (JankenPoEnum item : JankenPoEnum.values()) {
				if (item.getValor() == valor) {
					return item;
				}
			}
			return null;
		}
	
		public JankenPoEnum combater(JankenPoEnum outro) {
			if (this == JankenPoEnum.PAPEL) {
				if (outro == JankenPoEnum.TESOURA)
					return outro;
				if (outro == JankenPoEnum.PEDRA)
					return this;
			}
			if (this == JankenPoEnum.PEDRA) {
				if (outro == JankenPoEnum.TESOURA)
					return this;
				if (outro == JankenPoEnum.PAPEL)
					return outro;
			}
			if (this == JankenPoEnum.TESOURA) {
				if (outro == JankenPoEnum.PEDRA)
					return outro;
				if (outro == JankenPoEnum.PAPEL)
					return this;
			}
			
			return JankenPoEnum.EMPATE;
		}
		
	}	
	
	public static void main(String[] args) {
				
		System.out.println("Escolha, PEDRA-0 PAPEL-1 TESOURA-2: ");
		
		JankenPoEnum resultado;
		do {
			JankenPoEnum escolhido = LerJankenPo();
			JankenPoEnum cpu = JankenPoEnum.getByValor(new Random().nextInt(3));
		
			resultado = escolhido.combater(cpu);
		
			if (resultado == JankenPoEnum.EMPATE) {
				System.out.println("Empate! Tente novamente");
			}
			if (resultado == escolhido) {
				System.out.println("Você ganhou!");
			}
			if (resultado == cpu) {
				System.out.println("Você perdeu!");
			}
		
			System.out.println("Jogador escolheu " + escolhido.getNome());
			System.out.println("CPU escolheu " + cpu.getNome());
		}
		while (resultado == JankenPoEnum.EMPATE);
	}

	private static JankenPoEnum LerJankenPo() {
		while (true) {
			String escolhido = new Scanner (System.in).nextLine();
			try
			{
				int valor = Integer.parseInt(escolhido);
				if (valor >= 0 && valor <= 2) {
					return JankenPoEnum.getByValor(valor);
				}
			}
			catch (Exception e) {
				System.out.println("Erro");
			}
		
			System.out.println("Erro! Digite somente numeros, 0, 1 OU 2");
		}
		
	}

	private static void compararvalores(int numEsc) {
		// TODO Auto-generated method stub
		
	}

}//teste
