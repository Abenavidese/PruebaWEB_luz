package prueba1.web.ups.dao;




import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import prueba1.web.ups.entity.Factura;


@Stateless

public class FacturaDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void insert(Factura factura) {
        em.persist(factura);
    }
    
    public void update(Factura factura) {
        em.merge(factura);
    }
    
    public void delete(int numero) {
        Factura factura = this.read(numero);
        em.remove(factura);
    }
    
    public Factura read(int numero) {
        Factura factura = em.find(Factura.class, numero);
        return factura;
    }
    
    public List<Factura> getAll() {
        String jpql = "SELECT f FROM Factura f"; 
        Query query = em.createQuery(jpql, Factura.class);
        return query.getResultList();
    }
}
