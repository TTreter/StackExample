package me.ttreter.StackExample;

import me.ttreter.StackExample.type.Stack;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Cria duas pilhas com 10 de tamanho.
        Stack PILHA = new Stack(10);
        Stack PILHA_2 = new Stack(10);

        int ESCOLHA = -1;

        Scanner in = new Scanner(System.in);

        while (ESCOLHA != 0) {

            System.out.println(
                    """
                            
                            Digite o número de sua escolha:
                                1 • Adicionar algo na Pilha.
                                2 • Remover algo da Pilha.
                                3 • Esvaziar a Pilha.
                                4 • Listar os dados da Pilha.
                                5 • Transferir os dados para uma Pilha Auxiliar.
                                6 • Listar os dados da Pilha Auxiliar.
                                7 • Esvaziar a Pilha Auxiliar.
                                0 • Sair do programa."""
            );

            ESCOLHA = in.nextInt();

            // Adiciona dados na Pilha.
            if (ESCOLHA == 1) {
                System.out.println("\nDigite o dado a ser adicionado:");
                PILHA.push(in.next());
            }

            // Remove dados da Pilha.
            if (ESCOLHA == 2) {
                try {
                    System.out.println("\n" + PILHA.pop().toString() + " foi removido da Pilha.");
                } catch(Exception e) {
                    System.out.println("\nNão há mais nenhum dado a ser removido");
                }
            }

            // Esvazia a Pilha (Retornando o valor da posição da pilha para 0, não apaga os dados de fato).
            if (ESCOLHA == 3) {
                while (!PILHA.isEmpty()) {
                    System.out.println("\n" + PILHA.pop().toString() + " foi removido da Pilha.");
                }
            }

            // Lista todos os dados presentes na Pilha.
            if (ESCOLHA == 4) {
                System.out.println("\nDados presentes na pilha:\n" + Arrays.toString(PILHA.get()));
            }

            // Move todos os valores da Pilha para uma Pilha Auxiliar.
            if (ESCOLHA == 5 && !PILHA.isEmpty()) {
                while (!PILHA.isEmpty()) {
                    Object VALOR = PILHA.pop();
                    PILHA_2.push(VALOR);
                    System.out.println("\n" + VALOR.toString() + " foi movido para Pilha Auxiliar.");
                }
            }

            // Lista todos os dados presentes na Pilha Auxiliar.
            if (ESCOLHA == 6) {
                System.out.println("\nDados presentes na pilha:\n" + Arrays.toString(PILHA_2.get()));
            }

            // Esvazia a Pilha Auxiliar (Retornando o valor da posição da pilha para 0, não apaga os dados de fato).
            if (ESCOLHA == 7) {
                while (!PILHA_2.isEmpty()) {
                    System.out.println("\n" + PILHA.pop().toString() + " foi removido da Pilha Auxiliar.");
                }
            }

        }

    }
}