package prueba1.web.ups.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import prueba1.web.ups.entity.Producto;

@Stateless
public class ProductoDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(Producto producto) {
        em.persist(producto);
    }
    
    public void update(Producto producto) {
        em.merge(producto);
    }
    
    public void delete(int codigo) {
        Producto producto = this.read(codigo);
        em.remove(producto);
    }
    
    public Producto read(int codigo) {
        Producto producto = em.find(Producto.class, codigo);
        return producto;
    }
    
    public List<Producto> getAll() {
        String jpql = "SELECT p FROM Producto p"; 
        Query query = em.createQuery(jpql, Producto.class);
        return query.getResultList();
    }
}