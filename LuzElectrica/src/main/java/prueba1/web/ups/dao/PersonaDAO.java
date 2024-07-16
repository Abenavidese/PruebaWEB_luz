package prueba1.web.ups.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import prueba1.web.ups.entity.Persona;

@Stateless

public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	public void delete(String cedula) {
		Persona persona = this.read(cedula);
		em.remove(persona);
	}
	
	public Persona read(String cedula) {
		Persona persona = em.find(Persona.class, cedula);
		return persona;
	}
	
	public List<Persona> getAll(){
		String jpql = "SELECT c FROM Persona c"; 
		Query query = em.createQuery(jpql, Persona.class);
		return query.getResultList();
	}

}
