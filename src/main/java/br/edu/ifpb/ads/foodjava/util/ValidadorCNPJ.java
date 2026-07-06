package br.edu.ifpb.ads.foodjava.util;

public class ValidadorCNPJ {

    public static boolean validar(String cnpj) {

        cnpj = cnpj.replaceAll("\\D", "");

        if (cnpj.length() != 14)
            return false;

        if (cnpj.matches("(\\d)\\1{13}"))
            return false;

        int[] peso1 = {5,4,3,2,9,8,7,6,5,4,3,2};
        int[] peso2 = {6,5,4,3,2,9,8,7,6,5,4,3,2};

        int soma = 0;

        for (int i = 0; i < 12; i++) {
            soma += (cnpj.charAt(i) - '0') * peso1[i];
        }

        int resto = soma % 11;

        int digito1 = (resto < 2) ? 0 : 11 - resto;

        soma = 0;

        for (int i = 0; i < 13; i++) {

            int numero;

            if (i == 12)
                numero = digito1;
            else
                numero = cnpj.charAt(i) - '0';

            soma += numero * peso2[i];
        }

        resto = soma % 11;

        int digito2 = (resto < 2) ? 0 : 11 - resto;

        return digito1 == (cnpj.charAt(12) - '0')
                && digito2 == (cnpj.charAt(13) - '0');
    }
}
