package co.chenao.ws.adapter;

import java.util.ArrayList;
import java.util.List;

import com.chenao.entidades.Mascota;
import com.chenao.entidades.Persona;

import co.chenao.ws.vo.PersonaVo;


public class MascotaAdapter {
	
	public Mascota asignarMascota(Mascota m) {
				
		Mascota miMascota=null;
		
		if (m!=null) {
			miMascota=new Mascota();
			miMascota.setIdMascota(m.getIdMascota());
			miMascota.setNombre(m.getNombre());
			miMascota.setRaza(m.getRaza());
			miMascota.setSexo(m.getSexo());
			miMascota.setColorMascota(m.getColorMascota());
			
			Persona duenio=new Persona();
			if (m.getDuenio()!=null) {
				duenio.setIdPersona(m.getDuenio().getIdPersona());
				duenio.setNombre(m.getDuenio().getNombre());
				duenio.setProfesion(m.getDuenio().getProfesion());
				
				miMascota.setDuenio(duenio);
			}
					
		}
				
		return miMascota;
	}

	public List<Mascota> asignarListaMascotas(List<com.chenao.entidades.Mascota> lista) {
		List<Mascota> listaMascotas=new ArrayList<Mascota>();
		
		for (int i = 0; i < lista.size(); i++) {
			listaMascotas.add(asignarMascota(lista.get(i)));			
		}
		
		return listaMascotas;
	}
}
