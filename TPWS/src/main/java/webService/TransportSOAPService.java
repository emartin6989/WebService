package webService;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import dao.ITransportRemote;
import metier.Cargaison;
import metier.Marchandise;

@WebService(serviceName ="SoapService")
public class TransportSOAPService {

	@EJB
	ITransportRemote itransport;
	
	
/* (non-Javadoc)
 * @see webService.ITransportSOAPService#addCargaison(metier.Cargaison)
 */
	@WebMethod
public void addCargaison(@WebParam(name="c") Cargaison c){
	itransport.addCargaison(c);
}
	
	/* (non-Javadoc)
	 * @see webService.ITransportSOAPService#addMarchandise(metier.Marchandise, long)
	 */
	@WebMethod
	public void addMarchandise(@WebParam(name="m") Marchandise m, @WebParam(name="refcarg") long refcarg){
		itransport.addMarchandise(m, refcarg);
	}
	
	/* (non-Javadoc)
	 * @see webService.ITransportSOAPService#getAllCargaisons()
	 */
	@WebMethod
	public List<Cargaison> getAllCargaisons(){
		return itransport.getAllCargaisons();
	}
	
	/* (non-Javadoc)
	 * @see webService.ITransportSOAPService#getMarchandiseParMc(java.lang.String)
	 */
	@WebMethod
	public List<Marchandise> getMarchandiseParMc(@WebParam(name="mc") String mc){
		return itransport.getMarchandiseParMc(mc);
	}
	
	/* (non-Javadoc)
	 * @see webService.ITransportSOAPService#deleteMarchandise(long)
	 */
	@WebMethod
	public void deleteMarchandise(@WebParam(name="refMarchandise")long refMarchandise){
		itransport.deleteMarchandise(refMarchandise);
	}
	
	
}
