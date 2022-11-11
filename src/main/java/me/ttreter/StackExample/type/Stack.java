package me.ttreter.StackExample.type;

public class Stack {

    Object[] stack; // Variável da Pilha.
    int pos; // Variável da posição atual na Pilha.

    // Cria a Pilha de um tamamanho especificado.
    public Stack(int size) {
        this.pos = -1;
        this.stack = new Object[size];
    }

    // Retorna a Pilha.
    public Object[] get() {
        return stack;
    }

    // Verifica se a Pilha está vazia.
    public boolean isEmpty() {
        return this.pos == -1;
    }

    // Verifica se a Pilha está cheia.
    public boolean isFull() {
        return this.pos >= stack.length;
    }

    // Retorna o tamanho atual da Pilha.
    public int getSize() {
        if (isEmpty()) {
            return 0;
        }
        return this.pos + 1;
    }

    // Empilha dados na Pilha.
    public void push(Object data) {
        if (this.pos < stack.length - 1) {
            this.stack[++pos] = data;
        }
    }

    // Remove um dado do topo da Pilha.
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return this.stack[this.pos--];
    }

}
