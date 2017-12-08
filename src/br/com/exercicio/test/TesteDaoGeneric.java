package br.com.exercicio.test;

import java.util.Date;

import br.com.exerciciojpa.entity.Cliente;
import br.com.exerciciojpa.entity.Pedido;
import br.com.exercico.dao.GenericDao;

public class TesteDaoGeneric {

	public static void main(String[] args) {

		Cliente client = new Cliente();
		client.setNome("Pedro lucena");
		client.setEmail("PedroLucena@gmail.com");

		Pedido pedido = new Pedido(null, null, 0, client);
		pedido.setData(new Date());
		pedido.setDescricao("Terreno 600 metros");
		pedido.setValor(25.000);

		GenericDao<Cliente> daoCliente = new GenericDao<>(Cliente.class);

		GenericDao<Pedido> daoPedido = new GenericDao<>(Pedido.class);

		daoCliente.adicionar(client);
		daoPedido.adicionar(pedido);

		System.out.println("Buscando cliente com o ID 1" + daoCliente.buscar(1).getNome());
		System.out.println("Buscando pedido com o ID 1" + daoPedido.buscar(1).getDescricao());

		daoCliente.remover(client);
		daoPedido.remover(pedido);

	}

}
