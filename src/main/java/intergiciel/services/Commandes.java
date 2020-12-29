package intergiciel.services;

import java.util.Map;

/**
 * 
 * @author Stephane
 *
 */
public interface Commandes {

	/**
	 * retourne les valeurs globales cl�s Global du fichier json
	 */
	public String getGlobalValues();

	/**
	 * retourne les valeurs du pays demand�
	 * 
	 * @param v_pays est une chaine de caract�re du pays demand�
	 */
	public long getCountryValues(String v_pays);

	/**
	 * retourne une moyenne des cas confirm�s sum(pays)/nb(pays)
	 */
	public long getConfirmedAvg();

	/**
	 * retourne une moyenne des D�c�s sum(pays)/nb(pays)
	 */
	public long getDeathsAvg();

	/**
	 * retourne le pourcentage de D�c�s par rapport aux cas confirm�s
	 */
	public float getCountriesDeathsPercent();

	/**
	 * affiche la liste des commandes et une explication comme ci-dessus
	 */
	public String help();

}
