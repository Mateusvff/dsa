/**
 * Group Anagrams (medium)
 * 
 * A ideia principal é criar um HashMap onde a chave é uma representação única de cada grupo de anagramas 
 * e o valor é uma lista de palavras que pertencem a esse grupo.
 * 
 * Se a chave existir, adiciona a palavra à lista correspondente. Se não, cria uma nova lista e adiciona a palavra.
 * No final, retorna uma lista de todas as listas de anagramas.
 * 
 * Complexidade: O(n * k), onde n é o número de strings e k é o tamanho médio das strings.
 * 
 * @author Mateus Franco.
 */

class GroupedAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            String key = calculateKey(s);

            List<String> strValues = groups.get(key);
            
            if (strValues == null) {
                strValues = new ArrayList<>();
                groups.put(key, strValues);
            } 

            strValues.add(s);
        }

        return new ArrayList<>(groups.values());
    }

    public String calculateKey(String s) {
        int[] key = new int[26];

        for (int i = 0; i < s.length(); i++) {
            key[s.charAt(i) - 'a']++;
        }

        return Arrays.toString(key);
    }
}