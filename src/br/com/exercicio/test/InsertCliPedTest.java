package br.com.exercicio.test;

import java.util.Date;

import br.com.exercicio.helper.ClienteHelper;
import br.com.exercicio.helper.PedidoHelper;
import br.com.exerciciojpa.entity.Cliente;
import br.com.exerciciojpa.entity.Pedido;

public class InsertCliPedTest {

	/**
	 * Classe de teste para persistir um cliente e Pedido
	 * 
	 * @param args
	 * @return String message
	 */
	public static void main(String[] args) {
		
		//Insert Cliente
		
		String msg = new ClienteHelper()
						.salvar(new Cliente("Teste Com Te","teste@teste.com.br"));
		System.out.println(msg);
		
		//Insert Pedido
		
		PedidoHelper helper = new PedidoHelper();
		Cliente c = new Cliente();
		c.setId(1);
		String msg1 = helper.criarPedido(new Pedido(new Date(), "Vestido", 280.0, c));
		helper.encerrar();
		System.out.println(msg1);
	}
}
