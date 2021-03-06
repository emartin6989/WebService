package metier;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DiscriminatorValue("Routiere")
@XmlRootElement
public class CargaisonRoutiere extends Cargaison  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double temperatureConservation;

	/**
	 * @return the temperatureConservation
	 */
	public double getTemperatureConservation() {
		return temperatureConservation;
	}

	/**
	 * @param temperatureConservation the temperatureConservation to set
	 */
	public void setTemperatureConservation(double temperatureConservation) {
		this.temperatureConservation = temperatureConservation;
	}
	
	

}
