package metier;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Inheritance
@DiscriminatorColumn(name="CARGAISON_TYPE")
@XmlRootElement
@XmlSeeAlso({CargaisonAerienne.class, CargaisonRoutiere.class})
public class Cargaison implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idReference;
	private int distance;
	private Date dateLivraison;
	@OneToMany(mappedBy="cargaison", cascade = CascadeType.PERSIST)
	private List<Marchandise> marchandises;
	
	/**
	 * @return the idReference
	 */
	public long getIdReference() {
		return idReference;
	}
	/**
	 * @param idReference the idReference to set
	 */
	public void setIdReference(long idReference) {
		this.idReference = idReference;
	}
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	/**
	 * @return the dateLivraison
	 */
	public Date getDateLivraison() {
		return dateLivraison;
	}
	/**
	 * @param dateLivraison the dateLivraison to set
	 */
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	/**
	 * @return the marchandises
	 */
	@XmlTransient
	public List<Marchandise> getMarchandises() {
		return marchandises;
	}
	/**
	 * @param marchandises the marchandises to set
	 */
	public void setMarchandises(List<Marchandise> marchandises) {
		this.marchandises = marchandises;
	}
	
	

}
