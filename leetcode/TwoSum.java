/* Two Sum (easy)
 * 
 * Solução otimizada: Utilização de Tabela Hash (HashMap) para armazenar os valores já vistos e seus respectivos índices.
 * 
 * A ideia é verificar se o valor que falta para atingir o target já foi visto antes.
 * Se sim, recupera o índice do valor que falta e retorna junto com índice do valor atual, formando o par da solução.
 * 
 * Complexidade: O(n) 
 *
 * @author Mateus Franco.
*/

class TwoSum {
    public int[] twoSum(int[] arr, int target) {

        Map <Integer, Integer> pairs = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int complement = target - value;
        
            Integer v = pairs.get(complement);
            if  (v != null) {
                return new int[]{v, i};
            } 
        
            pairs.put(value, i);
        }

        return new int[0];
    }
}