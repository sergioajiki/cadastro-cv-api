package com.cadastrorh.cadastroRHapi.util;

public class StringUtil {
    public static String[] splitNomeSobrenome(String nomeCompleto) {
        int indiceEspaco = nomeCompleto.indexOf(' ');
        if (indiceEspaco == -1) {
            return new String[]{nomeCompleto};
        }
        String nome = nomeCompleto.substring(0, indiceEspaco);
        String sobrenome = nomeCompleto.substring(indiceEspaco + 1);

        return new String[]{nome, sobrenome};
    }
}
