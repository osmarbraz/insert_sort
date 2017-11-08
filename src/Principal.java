/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 * Baseado nos slides da aula 18/08/2017 
 * Classificação por Inserção/InsertSort
 */

/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {
  
    /**
     * Ordenação por Insercao.
     * 
     * Inicialmente, pega os dois primeiros elementos de um vetor, ou seja, posições 0 e 1
     * 1. Atribui o elemento na posição 1 como chave
     * Compara a chave com todos os elementos cujos respectivos índices sejam inferiores
     *    - Até que encontre um menor valor menor que o da chave; OU
     *    - O início do vetor seja atingido.
     * 2. Repete o processo até o último elemento do vetor     
     * 
     * Complexidade no pior caso Theta(n^2)
     * Complexidade no caso m~edio/esperado Theta(n log n)
     * Slide 11
     * @param A Vetor a ser ordenado
     * @param n Quantidade de elementos do vetor
     */
    public static void ordenaPorInsercao(int A[], int n) {        
        for (int j = 1; j <= n; j++) {                              //c1 * n
            int chave = A[j];                                       //c2 * n-1
            //Inserir A[j] dentro da sequencia ordenada A[1..j-1]
            //Compara chave com elementos posicionados antes no vetor(j-1)
            //Para se pelo menos uma das situações ocorrer:
            //Alcançar o início do vetor(i>=0) ou a elemento anterior for maior que a chave
            int i = j - 1;                                          //c3 * n-1
            while ((i >= 0) && (A[i] > chave)) {                    //c4 * Somatorio(2 até n)tj
                //Desloca os elementos para abrir espa;o
                A[i + 1] = A[i];                                    //c5 * Somatorio(2 até n)tj-1
                //Decrementa o contador até o inicio do vetor
                i = i - 1;                                          //c6 * Somatorio(2 até n)tj-1
            } 
            // posicao de insercao
            A[i + 1] = chave;                                       //c7 * n - 1
        }
    }

    public static void main(String args[]) {

        //Vetor dos dados    
        int A[] = {50, 70, 60, 90, 10, 30, 20, 40};
     
        //Fim do vetor
        int r = A.length - 1;

        System.out.println(">>> Inserção <<<");
        System.out.println("Original: ");
        for (int i = 0; i <= r; i++) {
            System.out.println((i) + " - " + A[i]);
        }

        ordenaPorInsercao(A, r);

        System.out.println("Depois: ");
        for (int i = 0; i <= r; i++) {
            System.out.println((i) + " - " + A[i]);
        }
    }
}
