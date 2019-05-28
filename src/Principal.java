/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplina: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 *
 * Baseado nos slides 27 da aula 04/08/2017 e slides 11 da aula 18/08/2017  
 *
 * Página 18 Thomas H. Cormen 3 ed
 *
 * Algoritmo InsertSort/Ordenação por Inserção
 *
 * Atenção:
 * Vetor em java inicia em 0, os algoritmos consideram início em 1.
 * A subtração de -1 ocorre somente no local de acesso ao vetor ou matriz 
 * para manter a compatibilidade entre os algoritmos.
 * 
 */

/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {
  
     /**
     * Ordenação por Inserção.
     *
     * Inicialmente, pega os dois primeiros elementos de um vetor, ou seja, posições 0 e 1
     * 1. Atribui o elemento na posição 1 como chave 
     *    Compara a chave com todos os elementos cujos respectivos índices sejam inferiores 
     *      - Até que encontre um menor valor menor que o da chave; OU 
     *      - O início do vetor seja atingido. 
     * 2. Repete o processo até o último elemento do vetor
     *
     * Complexidade de tempo no pior caso Theta(n^2) 
     * Complexidade de tempo no caso médio/esperado O(n^2) 
     * Complexidade de tempo no melhor caso O(n)
     * 
     * @param A Vetor a ser ordenado
     * @param n Quantidade de elementos do vetor
     */
    public static void ordenaPorInsercao(int A[], int n) {        
        for (int j = 2; j <= n; j++) {                                 //c1 * n
            int chave = A[j-1];                                        //c2 * n-1
            //Inserir A[j] dentro da sequência ordenada A[1..j-1]
            //Compara chave com elementos posicionados antes no vetor(j-1)
            //Para se pelo menos uma das situações ocorrer:
            //Alcançar o início do vetor(i>=0) ou a elemento anterior for maior que a chave
            int i = j - 1;                                             //c3 * n-1
            while ((i > 0) && (A[i-1] > chave)) {                      //c4 * Somatorio(2 até n)tj
                //Desloca os elementos para abrir espa;o
                A[i + 1 - 1] = A[i - 1];                               //c5 * Somatorio(2 até n)tj-1
                //Decrementa o contador até o inicio do vetor
                i = i - 1;                                             //c6 * Somatorio(2 até n)tj-1
            } 
            //posição de inserção
            A[i + 1 - 1] = chave;                                      //c7 * n - 1
        }
    }

    public static void main(String args[]) {

        //Vetor dos dados        
        int A[] = {50, 70, 60, 90, 10, 30, 20, 40};
     
        //Fim do vetor
        int r = A.length;

        System.out.println(">>> Algoritmo InsertSort/Ordenação por Inserção <<<");
        System.out.println("Original: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i+1) + " - " + A[i]);
        }
        
        ordenaPorInsercao(A, r);

        System.out.println("Depois: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i+1) + " - " + A[i]);
        }
    }
}