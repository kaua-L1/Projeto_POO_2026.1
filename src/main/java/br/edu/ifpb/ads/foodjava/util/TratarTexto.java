package br.edu.ifpb.ads.foodjava.util;

public class TratarTexto {
	public static String tratar(String textoCru) {
		String  texto= textoCru;
		String resultado = texto.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		return resultado;
	}
}
