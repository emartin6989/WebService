package metier;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Aerienne")
public class CargaisonAerienne extends Cargaison implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private double poidsMax;

/**
 * @return the poidsMax
 */
public double getPoidsMax() {
	return poidsMax;
}

/**
 * @param poidsMax the poidsMax to set
 */
public void setPoidsMax(double poidsMax) {
	this.poidsMax = poidsMax;
}


}
