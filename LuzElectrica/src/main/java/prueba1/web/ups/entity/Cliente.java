package prueba1.web.ups.entity;


import jakarta.persistence.*;



@Table(name="TBL_CLIENTE")

@Entity

public class Cliente {
	

	@Id
	@Column(name = "cli_cedula")
	private String cedula;
	
	@Column(name = "cli_nombre")
	private String nombre;
	
	@Column(name = "cli_direccion")
	private String direccion;


    
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	

}




/** 
 * 
 * Desarrollar un servicio web utilizando Jakarta EE.
El servicio debe contar con un endpoint que reciba el número de cédula como parámetro y retorne la información del consumo y deudas pendientes de energía eléctrica.
Construir una aplicación en Angular que consuma el servicio web desarrollado.
La interfaz debe incluir un campo de texto para ingresar el número de cédula y un botón para realizar la consulta.
Mostrar los datos del cliente y adicional datos de consumo y deudas pendientes en una tabla.**/
 