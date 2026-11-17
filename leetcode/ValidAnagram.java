class ValidAnagram {

    /*
     * Ideia primária: 
     * Preencher dois HashMaps, um para a string s e outro para a string t, com a contagem dos caracteres presentes em cada string.
     * 
     * Ex.: 
     * sCharCount [a -> 3, n -> 1, g -> 1, r -> 1, m -> 1]
     * tCharCount [a -> 3, n -> 1, g -> 1, r -> 1, m -> 1]
     * 
     * Depois comparar cada chave/valor dos HashMaps para verificar se possuem as mesmas quantidades de caracteres.
     * Se sim -> true
     * Se não -> false
     *
     * Funcionou, mas tem um jeito mais otimizado e inteligente de fazer.
     * Complexidade: O(n)
     * */

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> sCharCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            sCharCount.merge(c, 1, Integer::sum);
        }
        
        Map<Character, Integer> tCharCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCharCount.merge(c, 1, Integer::sum);
        }

        // comparar os valores de cada HashMap
        for (char c : s.toCharArray()) {
            Integer valueS = sCharCount.get(c);
            Integer valueT = tCharCount.get(c);

            if  (!Objects.equals(valueS, valueT)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Aqui a ideia é utilizar um array de 26 posições, uma para cada letra do alfabeto.
     * Cada posição do array representa a quantidade de vezes que cada letra aparece na string s subtraída pela quantidade de vezes que ela aparece na string t.
     * 
     * Ele incrementa a posição correspondente à letra da string s e decrementa a posição correspondente à letra da string t.
     * No final, se todas as posições do array forem iguais a 0, significa que as duas strings são anagramas uma da outra.
     * 
     * A subtração do 'a' é feita para que a posição do array corresponda à letra do alfabeto (0 para 'a', 1 para 'b', 2 para 'c', etc.).
     * Pois cada letra tem um valor inteiro correspondente na tabela ASCII, e subtraindo o valor de 'a' (97) de cada letra, obtemos um índice de 0 a 25 para o array.
     * 
     * Complexidade: O(n)
     */

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // 26 posições, uma para cada letra do alfabeto

        for (int i=0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Verifica se todas as posições do array são iguais a 0 - Anagrama

        for (int i=0; i < count.length; i++){
            if (count[i] != 0) return false;
        }

        return true;
    }

}