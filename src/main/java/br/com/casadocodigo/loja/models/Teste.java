package br.com.casadocodigo.loja.models;

public class Teste {

	public static void main(String[] args) {
		TipoPreco[] tipo = TipoPreco.values();
		for (TipoPreco tipoPreco : tipo) {
			System.out.println(tipoPreco.name());
		}
	}

}
