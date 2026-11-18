/**
 * Valid Palindrome (easy)
 * 
 * A ideia é utilizar a técnica de dois ponteiros, um apontando para o início da string e outro para o final.
 * Os ponteiros se movem na direção um do outro, comparando os caracteres correspondentes.
 * 
 * Se os caracteres forem diferentes, retorna false. Se os ponteiros se cruzarem sem encontrar diferenças, retorna true.
 * 
 * Para lidar com caracteres que não são letras ou números, a string é convertida para minúsculas e todos os caracteres não alfanuméricos são removidos antes da comparação.
 * 
 * Complexidade: O(n)
 */

class ValidPalindrome {
    
    public boolean isPalindrome(String s) {
        String convertedString = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] arr = convertedString.toCharArray();

        int left = 0;  
        int right = arr.length - 1;
        
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}