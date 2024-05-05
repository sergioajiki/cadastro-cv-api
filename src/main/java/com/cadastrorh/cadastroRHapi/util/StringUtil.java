package com.cadastrorh.cadastroRHapi.util;

public class StringUtil {
    public static String[] splitNomeSobrenome(String nomeCompleto) {
        String[] splitNomeCompleto = nomeCompleto.split(" ", 2);
        String nome = splitNomeCompleto[0];
        String sobrenome = splitNomeCompleto.length > 1 ? splitNomeCompleto[1] : "";

        return new String[]{nome, sobrenome};
    }
}
