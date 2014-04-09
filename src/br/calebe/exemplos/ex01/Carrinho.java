package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void add(Produto produto) {
        produtos.add(produto);
    }

    public Produto menorProduto() throws CarrinhoVazioExpected {
        if (produtos.isEmpty()) {
            throw new CarrinhoVazioExpected();
        }
        Produto menor = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getPreco() < menor.getPreco()) {
                menor = produto;
            }
        }
        return menor;
    }

    boolean vazio() {
        return produtos.isEmpty();
    }

    boolean contains(Produto livro) {
        return produtos.contains(livro);
    }

    void remove(Produto p1) throws CarrinhoVazioExpected {
        if (produtos.isEmpty())
        {
            throw new CarrinhoVazioExpected();
        }
        produtos.remove(p1);
    }
}
