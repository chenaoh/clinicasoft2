package co.chenao.ws.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.chenao.entidades.Persona;

import co.chenao.ws.adapter.PersonaAdapter;
import co.chenao.ws.utilidades.JPAUtil;
import co.chenao.ws.vo.PersonaVo;

public class PersonaDao { 
	
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public PersonaDao() {
		//PersonasUtilidades.iniciarLista();
	}
	
	public PersonaVo consultarPersonaIndividual(String documento) {

		Persona miPersonaJPA=entityManager.find(Persona.class,Long.parseLong(documento));

		if (miPersonaJPA!=null) {
			PersonaAdapter miPersonaAdapter=new PersonaAdapter();

			PersonaVo miPersona=miPersonaAdapter.asignarPersona(miPersonaJPA);
			System.out.println("miPersona1: "+miPersonaJPA);
			System.out.println();
			System.out.println("miPersona: "+miPersona);
			return miPersona;	
		}else {
			return null;
		}
		
	}	

	public Persona consultarPersonaIndividualEntidad(String documento) {
		System.out.println("Llega Documento: "+documento);
		Persona miPersona=entityManager.find(Persona.class,Long.parseLong(documento));
		System.out.println("Despues del retorno, valor persona: "+miPersona);
		if (miPersona!=null) {
			return miPersona;
		}else {
			return null;
		}
	}
	
	public List<PersonaVo> obtenerListaPersonas(){

		PersonaAdapter miPersonaAdapter=new PersonaAdapter();
		
		List<Persona> listaPersonasJpa =new ArrayList<Persona>();
		Query query=entityManager.createQuery("SELECT p FROM Persona p");
		listaPersonasJpa=query.getResultList();
		List<PersonaVo> listaPersonas= miPersonaAdapter.asignarListaPersonas(listaPersonasJpa) ;
		
		return listaPersonas;
	}
		
	public String registrarPersona(Persona persona) {
		System.out.println("En registrar JPA llega:\n"+persona);
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(persona);
			entityManager.getTransaction().commit();
			
			resp="Persona Registrada!";
			
		} catch (Exception e) {
			System.out.println("No se puede registrar la persona");
			e.printStackTrace();
		}
	
		return resp;
	}

	public String actualizarPersona(String documento, Persona persona) {
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(persona);
			entityManager.getTransaction().commit();
			
			resp="Persona Actualizada!";
			
		} catch (Exception e) {
			System.out.println("No se puede Actualizar la persona");
			e.printStackTrace();
		}
	
		return resp;
	}

	public String eliminarPersona(String documento) {
		String resp="Persona no encontrada";
		Persona persona=consultarPersonaIndividualEntidad(documento);
		if (persona!=null) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(persona);
				entityManager.getTransaction().commit();
				resp="Persona Eliminada!";
			} catch (Exception e) {
				//e.printStackTrace();
				resp="No se puede eliminar, verifique que no tenga mascotas asociadas";
				System.out.println(resp);		
			}		
		}
		return resp;
	}
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}
	
}

