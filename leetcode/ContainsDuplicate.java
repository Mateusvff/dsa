/**
 * Contains Duplicate (easy)
 * 
 * Solução otimizada: Utilização de Set (HashSet) para armazenar os valores já vistos.
 * Ao contrário do HashMap, o qual armazena pares chave-valor, o Set armazena somente os valores únicos.
 * 
 * Complexidade: O(n)
 * 
 * @author Mateus Franco.
 */

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        for (int x : nums) {
            if (seen.contains(x)) 
                return true;
                
            seen.add(x);
        }
        
        return false;
    }
}