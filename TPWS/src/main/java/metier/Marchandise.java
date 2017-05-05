package metier;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Marchandise implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private long numero;
private String nom;
private double poids;
private double volume;
@ManyToOne
private Cargaison cargaison;

/**
 * @return the numero
 */
public long getNumero() {
	return numero;
}
/**
 * @param numero the numero to set
 */
public void setNumero(long numero) {
	this.numero = numero;
}
/**
 * @return the nom
 */
public String getNom() {
	return nom;
}
/**
 * @param nom the nom to set
 */
public void setNom(String nom) {
	this.nom = nom;
}
/**
 * @return the poids
 */
public double getPoids() {
	return poids;
}
/**
 * @param poids the poids to set
 */
public void setPoids(double poids) {
	this.poids = poids;
}
/**
 * @return the volume
 */
public double getVolume() {
	return volume;
}
/**
 * @param volume the volume to set
 */
public void setVolume(double volume) {
	this.volume = volume;
}
/**
 * @return the cargaison
 */
public Cargaison getCargaison() {
	return cargaison;
}
/**
 * @param cargaison the cargaison to set
 */
public void setCargaison(Cargaison cargaison) {
	this.cargaison = cargaison;
}


}
