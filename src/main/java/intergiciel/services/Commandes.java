package intergiciel.services;

import java.util.Map;

/**
 * 
 * @author Stephane
 *
 */
public interface Commandes {

	/**
	 * retourne les valeurs globales clés Global du fichier json
	 */
	public String getGlobalValues();

	/**
	 * retourne les valeurs du pays demandé
	 * 
	 * @param v_pays est une chaine de caractère du pays demandé
	 */
	public long getCountryValues(String v_pays);

	/**
	 * retourne une moyenne des cas confirmés sum(pays)/nb(pays)
	 */
	public long getConfirmedAvg();

	/**
	 * retourne une moyenne des Décès sum(pays)/nb(pays)
	 */
	public long getDeathsAvg();

	/**
	 * retourne le pourcentage de Décès par rapport aux cas confirmés
	 */
	public float getCountriesDeathsPercent();

	/**
	 * affiche la liste des commandes et une explication comme ci-dessus
	 */
	public String help();

}
