package com.venta.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.venta.dto.Categoria;
import com.venta.dto.Producto;

public class DeleteTest {
	EntityManagerFactory emf;
	EntityManager em;
	
	@Before
	public void iniciar() {
		emf = Persistence.createEntityManagerFactory("venta");
		em = emf.createEntityManager();
	}
	
	@Test
	public void deletecategoria() {
		Categoria c = em.find(Categoria.class, 1);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
		Producto p = em.find(Producto.class, 7);
		Producto p1 = em.find(Producto.class, 8);
		em.getTransaction().begin();
		em.remove(p);
		em.remove(p1);
		em.getTransaction().commit();
		
		
		
	}
}

