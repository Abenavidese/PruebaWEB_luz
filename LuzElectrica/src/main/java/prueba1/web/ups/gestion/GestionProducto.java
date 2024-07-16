package prueba1.web.ups.gestion;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import prueba1.web.ups.dao.ClienteDAO;
import prueba1.web.ups.dao.ProductoDAO;
import prueba1.web.ups.entity.Cliente;
import prueba1.web.ups.entity.Producto;

@Stateless

public class GestionProducto {

	  @Inject
	    private ProductoDAO daoProducto;
	    
	  
	    public Producto getProducto(int codigo)  {
			return getProducto(0);
		
		
		}
		
	
		public List<Producto> getClientes(){
			return daoProducto.getAll();
		}
		




}
