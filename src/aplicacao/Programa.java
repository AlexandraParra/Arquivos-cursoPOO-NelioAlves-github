package aplicacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Produto;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		System.out.print("Digite o caminho do arquivo: ");
		String caminho = sc.nextLine();
		File path = new File(caminho);
		
		List <Produto> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] item = line.split(",");
				String nome = item[0];
				double preco = Double.parseDouble(item[1]);
				int quantidade = Integer.parseInt(item[2]);
				Produto produto = new Produto(nome, preco, quantidade);
				list.add(produto);
				line = br.readLine();	
			}
			for (Produto p: list) {
				System.out.println(p);
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}