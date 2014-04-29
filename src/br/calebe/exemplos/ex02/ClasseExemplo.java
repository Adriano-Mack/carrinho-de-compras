package br.calebe.exemplos.ex02;

import br.calebe.exemplos.ex02.controller.ClasseExemploController;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class ClasseExemplo {

    private ClasseExemploController controller;
    private String answer;

    public ClasseExemplo() throws Exception {
        controller = new ClasseExemploController();
    }

    public void run(int i) {
        answer = controller.metodo(i);
    }
    public void PagamentoCartaoCredito(double valor){
        try{
            Thread.sleep(70);
            System.out.println("Processando Pagamento");
            Thread.sleep(300);
            answer = controller.pagamentoCartao(valor);
            System.out.println("Pagamento Efetuado");
        }catch(InterruptedException e){
            System.out.println("Falha no Pagamento "+e);
        }
    }
    public void EstoqueProduto(int itens){
        try{
            answer = controller.controleEstoque(itens);
            Thread.sleep(40);
            System.out.println("Empacotado");
            Thread.sleep(500);
            System.out.println("Saiu para Entrega");
            Thread.sleep(200);
            System.out.println("Entrega Efetuada");
        }catch(InterruptedException e){
            System.out.println("Produto Em Falta"+e);
        }
    
    }
    public String getAnswer() {
        return answer;
    }
}
