/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex01.Carrinho;
import br.calebe.exemplos.ex02.controller.ClasseExemploController;
import br.calebe.exemplos.ex02.ClasseExemplo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.easymock.EasyMock;
import junit.framework.Assert;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 * @author Wanderson
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ClasseExemplo.class})
public class PagamentoTest {
    private Carrinho carrinho;
    
    

    
    @Before
    public void CriandoCarrinho() {
        carrinho = new Carrinho();
    }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void valortotalCarrinhoTest() {
         List<Double> listaPrecoProdutos;
        listaPrecoProdutos = new ArrayList<>();
         double Total=0.0;
         listaPrecoProdutos.add(50.0);
         listaPrecoProdutos.add(15.0);
         listaPrecoProdutos.add(1.0);
         
         for ( Double x : listaPrecoProdutos){
             Total= Total+ x.doubleValue();
         }
         assertArrayEquals(new Object[]{Total}, new Object[]{66.00});
     }
     
     @Test
     public void fazerPagamento() throws Exception{
         List<Double> listaPrecoProdutos;
        listaPrecoProdutos = new ArrayList<>();
         double Total=0.0;
         listaPrecoProdutos.add(50.0);
         listaPrecoProdutos.add(15.0);
         listaPrecoProdutos.add(1.0);
         
         for ( Double x : listaPrecoProdutos){
             Total= Total+ x.doubleValue();
         }
         ClasseExemploController controllerMockPag =PowerMock.createMock(ClasseExemploController.class);
         
         PowerMock.expectNew(ClasseExemploController.class).andReturn(controllerMockPag);
         
         EasyMock.expect(controllerMockPag.pagamentoCartao(Total)).andReturn("Pagamento Realizado: "+Total);
         
         PowerMock.replay(controllerMockPag, ClasseExemploController.class);
         
         ClasseExemplo compra = new ClasseExemplo();
         compra.PagamentoCartaoCredito(Total);
         
         Assert.assertEquals("Pagamento Realizado: "+Total, compra.getAnswer());
      
         PowerMock.verifyAll();
     }
}     
