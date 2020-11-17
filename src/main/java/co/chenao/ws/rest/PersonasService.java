package co.chenao.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.chenao.entidades.Persona;

import co.chenao.ws.dao.PersonaDao;
import co.chenao.ws.vo.PersonaVo;

@Path("/personas")
public class PersonasService {
	
	PersonaDao personaDao=new PersonaDao();
	
	//http://localhost:8080/clinicasoft2/servicio/personas/111
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getPersonaIdJpa(@PathParam("id") String documento) {
		System.out.println();
		System.out.println("En getPersonaIdJpa(): id="+documento);
		PersonaVo persona=personaDao.consultarPersonaIndividual(documento);
		System.out.println("Valor de la Persona en el servicio: "+persona);
		if (persona!=null) {
			return Response.ok(persona).build();
		}
		return Response.status(Response.Status.NOT_FOUND).header("header", "No se encuentra la persona").build(); 
	}
	
	//http://localhost:8080/clinicasoft2/servicio/personas/personas
	@GET
	@Path("/personas")	
	@Produces({MediaType.APPLICATION_JSON})
	public List<PersonaVo> getPersonas() {
		return personaDao.obtenerListaPersonas();
	}
	

	//http://localhost:8080/clinicasoft2/servicio/personas/add
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response registrarPersona(Persona persona) {
		try {
			String resp=personaDao.registrarPersona(persona);
			if (resp.equals("Persona Registrada!")) {
				return Response.ok().build();    
			}else {
				return Response.status(Response.Status.NOT_FOUND).build(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//http://localhost:8080/clinicasoft2/servicio/personas/333
	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response actualizarPersona(@PathParam("id") String documento,Persona persona) {
		try {
			String resp=personaDao.actualizarPersona(documento,persona);
			if (resp.equals("Persona Actualizada!")) {
				return Response.ok(persona).build(); 
			}else {
				return Response.status(Response.Status.NOT_FOUND).build(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//http://localhost:8080/clinicasoft2/servicio/personas/777
	@DELETE
	@Path("/{id}")
	public Response eliminarPersona(@PathParam("id") String documento) {
		try {
			String resp=personaDao.eliminarPersona(documento);
			if (resp.equals("Persona Eliminada!")) {
				return Response.ok().build();    
			}else {
				if (!resp.equals("Persona no encontrada")) {
					return Response.status(204).build(); 
				}else {
					return Response.status(Response.Status.NOT_FOUND).build(); 
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}



