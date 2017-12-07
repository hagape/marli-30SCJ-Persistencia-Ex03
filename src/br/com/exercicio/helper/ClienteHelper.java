package br.com.exercicio.helper;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.exercicio.core.HibernateUtil;
import br.com.exerciciojpa.entity.Cliente;



/**
 * Classe auxiliar com métodos básicos como:
 * persistir um novo cliente, retornar um cliente a partir de seu id
 * e uma listagem de clientes cadastrados
 * 
 * @author Henckes
 *
 */
public class ClienteHelper {

	Session session = null;
	Transaction transaction = null;

	public void encerrar(){
		session.close();
	}

	/**
	 * metodo de persistencia de um novo cliente
	 * @param cliente
	 * @return Cliente
	 */
	public String salvar(Cliente cliente){ 
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession(); 
			transaction = session.beginTransaction();
			session.save(cliente);
			transaction.commit();
			return "usuario salvo"; 
		}catch(Exception e){
			return e.getMessage();
		} 
	}
	
	/**
	 * Metodo que retorno um objeto cliente a partir de um id
	 * @param id
	 * @return objeto cliente
	 */
	public Cliente findClienteById(int id){
		Cliente cli = new Cliente();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			TypedQuery<Cliente> query = session.createQuery("from Cliente cli where cli.idCliente = :id", Cliente.class);
			query.setParameter("id", id);
			cli = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cli;
	}
	
	/**
	 * Metodo que retorna uma lista de clientes cadastrados
	 * @param none
	 * @return List<Cliente>
	 */
	public List<Cliente> listClientes(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			TypedQuery<Cliente> q = session.createQuery("from Cliente cli", Cliente.class);
			clientes = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

}
