package co.chenao.ws.vo;

import java.util.ArrayList;
import java.util.List;

import com.chenao.entidades.Mascota;
import com.chenao.entidades.Producto;


public class PersonaVo{

	private Long idPersona;
	private String nombre;
	private String telefono;
	private String profesion;
	private int tipo;
	private NacimientoVo nacimiento;
	private List<Mascota> listaMascotas;
	private List<Producto> listaProductos;
	
	public PersonaVo() {
		this.listaMascotas=new ArrayList<Mascota>();
	}
	
	public PersonaVo(Long idPersona, String nombre, String telefono, 
			String profesion, int tipo, NacimientoVo nacimiento) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.profesion = profesion;
		this.tipo = tipo;
		this.nacimiento = nacimiento;
		this.listaMascotas=new ArrayList<Mascota>();
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public NacimientoVo getNacimiento() {
		return nacimiento;
	}


	public void setNacimiento(NacimientoVo nacimiento) {
		this.nacimiento = nacimiento;
	}

	public List<Mascota> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<Mascota> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}
	
	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	
}
