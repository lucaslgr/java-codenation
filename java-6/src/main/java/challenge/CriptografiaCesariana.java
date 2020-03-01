package challenge;

public class CriptografiaCesariana implements Criptografia {
    final int chave = 3;

    @Override
    public String criptografar(String texto) {
        texto = texto.trim(); //Retira os espaços do início e final da string

        //Testa se o argumento é vazio ou nulo
        if (texto.isEmpty())
            throw new IllegalArgumentException("String vazia ou nula");

        texto = texto.toLowerCase(); //Retorna a string com letras maiúsculas

        char[] answer = new char[texto.length()]; //String que guardará a resposta criptografada

        for(int i = 0; i < texto.length(); i++){
            if (texto.charAt(i) >= 0 && texto.charAt(i) <= 57) //Filtrando se é um número
                answer[i] = (texto.charAt(i));
            else
                if ( (int)(texto.charAt(i) + chave) > 122) //Se estiver na letra -> z
                    answer[i] = (char)((texto.charAt(i) + chave) - 26);
                else
                    answer[i]= (char)(texto.charAt(i) + chave);
        }
        return new String(answer);
    }

    @Override
    public String descriptografar(String texto) {
        texto = texto.trim(); //Retira os espaços do início e final da string

        //Testa se o argumento é vazio ou nulo
        if (texto.isEmpty())
            throw new IllegalArgumentException("String vazia ou nula");

        texto = texto.toLowerCase(); //Retorna a string com letras maiúsculas

        char[] answer = new char[texto.length()]; //String que guardará a resposta criptografada

        for(int i = 0; i < texto.length(); i++){
            if (texto.charAt(i) >= 0 && texto.charAt(i) <= 57) //Filtrando se é um número
                answer[i] = (texto.charAt(i));
            else
            if ( (int)(texto.charAt(i) - chave) < 97) //Se estiver na letra -> a
                answer[i] = (char)((texto.charAt(i) - chave) + 26);
            else
                answer[i]= (char)(texto.charAt(i) - chave);
        }
        return new String(answer);
    }
}
