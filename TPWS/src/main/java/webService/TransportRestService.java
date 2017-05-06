package webService;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ITransportRemote;
import metier.Cargaison;
import metier.CargaisonAerienne;
import metier.CargaisonRoutiere;
import metier.Marchandise;

@Path("/trs")
public class TransportRestService {

	@EJB
	ITransportRemote itransport;

	@Path("/addaerien/{id}/{dist}/{poids}")
	@PUT
	public void addCargaisonAerienne(@PathParam("id") long id, @PathParam("dist") int dist,
			@PathParam("poids") double poids) {
		CargaisonAerienne ca = new CargaisonAerienne();
		ca.setIdReference(id);
		ca.setDistance(dist);
		ca.setPoidsMax(poids);
		itransport.addCargaison(ca);

	}

	@Path("/addroutier/{id}/{dist}/{temp}")
	@PUT
	public void addCargaisonRoutiere(@PathParam("id") long id, @PathParam("dist") int dist,
			@PathParam("temp") double temp) {
		CargaisonRoutiere cr = new CargaisonRoutiere();
		cr.setIdReference(id);
		cr.setDistance(dist);
		cr.setTemperatureConservation(temp);
		itransport.addCargaison(cr);

	}
	
	@Path("/addmarchandise/{numero}/{nom}/{poids}/{volume}/{refcarg}")
	@PUT
	public void addMarchandise(@PathParam("numero") long numero, @PathParam("nom") String nom,
			@PathParam("poids") double poids, @PathParam("volume") double volume, @PathParam("refcarg") long refcarg) {
	Marchandise m = new Marchandise();
	m.setNom(nom);
	m.setNumero(numero);
	m.setPoids(poids);
	m.setVolume(volume);
	itransport.addMarchandise(m, refcarg);
	}

	@Path("/listecarg")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cargaison> getAllCargaisons(){
		return itransport.getAllCargaisons();
	}
	
	@Path("/listemarmc/{mc}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marchandise> getMarchandiseParMc(@PathParam("mc") String mc){
		return itransport.getMarchandiseParMc(mc);
	}

	@Path("/deletemar/{ref}")
	@DELETE
	public void deleteMarchandise(@PathParam("ref") long refMarchandise){
	itransport.deleteMarchandise(refMarchandise);	
	}

}
