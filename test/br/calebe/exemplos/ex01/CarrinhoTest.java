package br.calebe.exemplos.ex01;

import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class CarrinhoTest {

    @Test
    public void carrinhoVazio() throws CarrinhoVazioExpected {
        Carrinho carrinho = new Carrinho();
        Boolean result = carrinho.vazio();

        Assert.assertTrue(result);
    }

    @Test
    public void produtoNoCarrinho() {
        Carrinho carrinho = new Carrinho();
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        boolean result = carrinho.contains(livro);
        
        Assert.assertTrue(result);
    }

    @Test
    public void maisProdutosNoCarrinho() {
        Carrinho carrinho = new Carrinho();
        Produto p1 = new Produto("Coca-Cola", 5.00);
        Produto p2 = new Produto("Fanta Uva", 4.00);
        carrinho.add(p1);
        carrinho.add(p2);
        
        boolean contemCoca = carrinho.contains(p1);
        boolean contemFanta = carrinho.contains(p2);
        
        Assert.assertTrue(contemCoca);
        Assert.assertTrue(contemFanta);
    }        
    
    @Test
    public void removeProdutosDoCarrinho() throws CarrinhoVazioExpected{
        Carrinho carrinho = new Carrinho();
        Produto p1 = new Produto("Borracha", 15.00);
        carrinho.add(p1);
        boolean result = carrinho.contains(p1);
        Assert.assertTrue(result);
        carrinho.remove(p1);
        result = carrinho.contains(p1);
        Assert.assertFalse(result);
    }
    
    @Test(expected = CarrinhoVazioExpected.class)
    public void removeProdutoDeUmCarrinhoVazio() throws CarrinhoVazioExpected{
        Carrinho carrinho = new Carrinho();
        Produto p1 = new Produto("Caneta", 1.00);
        boolean result = carrinho.vazio();
        Assert.assertTrue(result);
        carrinho.remove(p1);
        result = carrinho.vazio();
        Assert.assertTrue(result);
    }       
    
    @Test
    public void removeProdutoQueNaoEstaNoCarrinho() throws CarrinhoVazioExpected {
        Carrinho carrinho = new Carrinho();
        Produto p1 = new Produto("Borracha", 15.00);
        Produto p2 = new Produto("Lapis", 15.00);
        carrinho.add(p1);
        boolean result = carrinho.contains(p1);
        Assert.assertTrue(result);
        carrinho.remove(p2);
        result = carrinho.contains(p1);
        Assert.assertTrue(result);
    }
}
