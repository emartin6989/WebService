package webService;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ITransportRemote;
import metier.Cargaison;
import metier.CargaisonAerienne;
import metier.CargaisonRoutiere;
import metier.Marchandise;

@Path("trs")
public class TransportRestService {

	@EJB
	ITransportRemote itransport;

	@Path("/addaerien/{dist}/{poids}")
	@POST
	public void addCargaisonAerienne(@PathParam("dist") int dist, @PathParam("poids") double poids) {
		CargaisonAerienne ca = new CargaisonAerienne();
		ca.setDistance(dist);
		ca.setPoidsMax(poids);
		itransport.addCargaison(ca);

	}

	@Path("/addroutier/{dist}/{temp}")
	@POST
	public void addCargaisonRoutiere(@PathParam("dist") int dist, @PathParam("temp") double temp) {
		CargaisonRoutiere cr = new CargaisonRoutiere();
		cr.setDistance(dist);
		cr.setTemperatureConservation(temp);
		itransport.addCargaison(cr);

	}

	@Path("/addmarchandise/{nom}/{poids}/{volume}/{refcarg}")
	@POST
	public void addMarchandise(@PathParam("nom") String nom, @PathParam("poids") double poids,
			@PathParam("volume") double volume, @PathParam("refcarg") long refcarg) {
		Marchandise m = new Marchandise();
		m.setNom(nom);
		m.setPoids(poids);
		m.setVolume(volume);
		itransport.addMarchandise(m, refcarg);
	}

	@GET
	@Path("/listecargaison")
	@Produces(MediaType.APPLICATION_XML)
	public List<Cargaison> getAllCargaisons() {
		return itransport.getAllCargaisons();
	}

	@GET
	@Path("/listemarmc/{mc}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Marchandise> getMarchandiseParMc(@PathParam("mc") String mc) {
		return itransport.getMarchandiseParMc(mc);
	}

	@Path("/deletemar/{ref}")
	@DELETE
	public void deleteMarchandise(@PathParam("ref") long refMarchandise) {
		itransport.deleteMarchandise(refMarchandise);
	}

}
