package co.grandcircus.coffeeshop.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.grandcircus.coffeeshop.entities.Product;

@Repository
@Transactional
public class ProductsDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Product> findAll() {

		List<Product> products = em.createQuery("FROM Product", Product.class).getResultList();
		return products;
	}

	// find specific Product with it's unique ID
	public Product findById(Long id) {
		return em.find(Product.class, id);
	}

	public void create(Product product) {
		em.persist(product);
	}

	// edit
	public void update(Product product) {
		em.merge(product);
	}

	public void delete(Long id) {
		Product product = em.getReference(Product.class, id);
		em.remove(product);
	}

}
