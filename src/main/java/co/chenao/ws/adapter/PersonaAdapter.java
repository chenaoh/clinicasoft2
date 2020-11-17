package co.chenao.ws.adapter;

import java.util.ArrayList;
import java.util.List;

import com.chenao.entidades.Nacimiento;
import com.chenao.entidades.Persona;

import co.chenao.ws.vo.NacimientoVo;
import co.chenao.ws.vo.PersonaVo;

public class PersonaAdapter {
	
	public PersonaVo asignarPersona(Persona p) {
		
		PersonaVo miPersona=null;

		if (p!=null) {
			miPersona=new PersonaVo();
			miPersona.setIdPersona(p.getIdPersona());
			miPersona.setNombre(p.getNombre());
			miPersona.setProfesion(p.getProfesion());
			miPersona.setTelefono(p.getTelefono());
			miPersona.setTipo(p.getTipo());
			
			miPersona.setNacimiento(asignaNacimiento(p.getNacimiento()));
			
			MascotaAdapter miMascotaAdapter=new MascotaAdapter();
			
			miPersona.setListaMascotas(miMascotaAdapter.asignarListaMascotas(p.getListaMascotas()));
			
			ProductoAdapter miProductoAdapter=new ProductoAdapter();
			miPersona.setListaProductos(miProductoAdapter.asignarListaProductos(p.getListaProductos()));
		}
		
		return miPersona;
	}
	
	public NacimientoVo asignaNacimiento(com.chenao.entidades.Nacimiento nacimiento) {
		NacimientoVo miNacimiento=new NacimientoVo();
		miNacimiento.setIdNacimiento(nacimiento.getIdNacimiento());
		miNacimiento.setFechaNacimiento(nacimiento.getFechaNacimiento()); 
		miNacimiento.setCiudadNacimiento(nacimiento.getCiudadNacimiento());
		miNacimiento.setDepartamentoNacimiento(nacimiento.getDepartamentoNacimiento());
		miNacimiento.setPaisNacimiento(nacimiento.getPaisNacimiento());
		
		return miNacimiento;
	}

	public List<PersonaVo> asignarListaPersonas(List<Persona> listaPersonasJpa) {
		List<PersonaVo> lista=new ArrayList<PersonaVo>();
		
		for (Persona persona : listaPersonasJpa) {
			lista.add(asignarPersona(persona));
		}
		return lista;
	}

}
