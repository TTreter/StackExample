package me.ttreter.StackExample;

import me.ttreter.StackExample.type.Stack;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Cria duas pilhas com 10 de tamanho.
    static Stack PILHA = new Stack(10);
    static Stack PILHA_2 = new Stack(10);

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int ESCOLHA = -1;

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
                                8 • Adicionar 10 números separados em 2 Pilhas por pares e ímpares.
                                9 • Mostrar dados atuais das 2 Pilhas.
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

            if (ESCOLHA == 8) {
                pilhaParEImpar();
            }

            if (ESCOLHA == 9) {
                // Cria dois vetores de objetos de 10 posições.
                Object[] arrP1 = new Object[10];
                Object[] arrP2 = new Object[10];
                // Armazena somente os dados presentes na Pilha dos pares.
                for (int i = 0; i <= PILHA.getSize(); i++) {
                    arrP1[i] = PILHA.get()[i];
                }
                // Armazena somente os dados presentes na Pilha dos ímpares.
                for (int i = 0; i <= PILHA_2.getSize(); i++) {
                    arrP2[i] = PILHA_2.get()[i];
                }
                // Mostra os valores que de fato estão presentes nas Pilhas.
                System.out.println("Pilha A: " + Arrays.toString(arrP1));
                System.out.println("Pilha B: " + Arrays.toString(arrP2));
            }

        }

    }

    public static void pilhaParEImpar() {

        // Solicita até 10 valores ao utilizador.
        for (int i = 0; i <= 9; i++) {

            System.out.print("Digite o " + (i + 1) + "º número: ");
            int valor = in.nextInt();

            // Se o valor for igual a zero.
            if (valor == 0) {
                // Se uma das pilhas está vazia não é possível remover dados.
                if (PILHA.isEmpty() || PILHA_2.isEmpty()) {
                    System.out.println("Uma das pilhas está vazia!");
                    return;
                } else {
                    // Remove dados da pilha se nenhuma das duas está vazia.
                    try {
                        PILHA.pop();
                        PILHA_2.pop();
                    } catch (Exception e) {
                        System.out.println("Uma das pilhas está vazia!");
                        return;
                    }

                }
            } else {
                // Se o mod retornar zero, o valor é par, se retornar qualquer coisa além de zero, é ímpar.
                if (valor % 2 == 0) {
                    // Adciona um dado na pilha dos números pares.
                    PILHA.push(valor);
                } else {
                    // Adciona um dado na pilha dos números ímpares.
                    PILHA_2.push(valor);
                }
            }

        }

    }

}