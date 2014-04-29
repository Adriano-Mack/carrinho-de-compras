/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.calebe.exemplos.ex02;



import br.calebe.exemplos.ex02.controller.ClasseExemploController;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.Assert;
import org.easymock.EasyMock;
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
public class ControleEstoqueTest {
    List<String> produtos;
    
    @Before
    public void Inicializa() {
        produtos = new ArrayList <> ();
    }

    
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void controleEstoqueTest() throws Exception {
         int itens;
         produtos.add("Java em 24 horas");
         produtos.add("Borracha");
         produtos.add("Caneta");
     
     itens=produtos.size();
     
        ClasseExemploController controllerMockEstoque =PowerMock.createMock(ClasseExemploController.class);
        PowerMock.expectNew(ClasseExemploController.class).andReturn(controllerMockEstoque);
        
        EasyMock.expect(controllerMockEstoque.controleEstoque(itens)).andReturn("Qtd Itens Pedido"+itens);
        
        PowerMock.replay(controllerMockEstoque, ClasseExemploController.class);
        
        ClasseExemplo estoque = new ClasseExemplo();
        estoque.EstoqueProduto(itens);
        
        Assert.assertEquals("Qtd Itens Pedido"+itens, estoque.getAnswer());
      
         PowerMock.verifyAll();
     }
}
