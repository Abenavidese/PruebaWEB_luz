package prueba1.web.ups.gestion;


import java.util.List;


import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import prueba1.web.ups.dao.ClienteDAO;
import prueba1.web.ups.entity.Cliente;

@Stateless
public class Gestionclientes {
	
    @Inject
    private ClienteDAO daoCliente;
    
	
    public Cliente getCliente(String cedula) throws Exception {
		if(cedula.length() != 10) {
			throw new Exception("Cedula Incorrecta");
		}
		
		Cliente cliente = daoCliente.read(cedula);
		if(cliente == null)
			throw new Exception("Cliente no existe");
		return cliente;
	}
	
	public List<Cliente> getClientes(){
		return daoCliente.getAll();
	}
	
	public void createCliente(Cliente cliente) throws Exception {
		if(cliente.getCedula().length() != 10) {
			throw new Exception("Cedula Incorrecta");
		}
		daoCliente.insert(cliente);
	}
	
	public void updateCliente(Cliente cliente) throws Exception{
		
		
		if(cliente.getCedula().length() != 10) {
			throw new Exception("Cedula Incorrecta");
		}
		
		daoCliente.update(cliente);
	}
	
	
	public void deleteCliente(String cedula) throws Exception{
		Cliente cliente = daoCliente.read(cedula);
		if(cliente == null) {				
			throw new Exception("Cliente no existe");
		}
		else {
			daoCliente.delete(cedula);
		}
		
	}


	
}
