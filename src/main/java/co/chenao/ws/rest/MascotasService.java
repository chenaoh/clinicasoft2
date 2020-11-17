package co.chenao.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.chenao.entidades.Mascota;

import co.chenao.ws.dao.MascotaDao;

@Path("/mascotas")
public class MascotasService {

	MascotaDao mascotaDao=new MascotaDao();
	
	//http://localhost:8080/clinicasoft2/servicio/mascotas/111
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getMascota(@PathParam("id") String codigo) {
		System.out.println();
		System.out.println("En getMascota(): id="+codigo);
		Mascota mascota=mascotaDao.consultarMascota(codigo);
		if (mascota!=null) {
			return Response.ok(mascota).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build(); 
	}
}

