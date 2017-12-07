package br.com.exercicio.test;

import java.util.List;

import br.com.exercicio.helper.ClienteHelper;
import br.com.exercicio.helper.PedidoHelper;
import br.com.exerciciojpa.entity.Cliente;
import br.com.exerciciojpa.entity.Pedido;

public class ListCliPedTest {



	/**
	 * Classe test para listar todos os clientes cadastrados
	 * 
	 * @param args
	 * @return toString de cliente
	 */
	
	
	public static void main(String[] args) {
		
		ClienteHelper helper = new ClienteHelper();
		
		List<Cliente> cli = helper.listClientes();
		for (Cliente cliente : cli) {
			System.out.println(cliente.toString());
		}
		helper.encerrar();

}
	
	PedidoHelper helper = new PedidoHelper();
	{
	for (Pedido ped : helper.listPedidos(1)) {
		System.out.println(ped.toString());
	}
	helper.encerrar();
}
}
