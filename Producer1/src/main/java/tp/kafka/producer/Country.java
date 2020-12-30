package tp.kafka.producer;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Country",
"CountryCode",
"Slug",
"NewConfirmed",
"TotalConfirmed",
"NewDeaths",
"TotalDeaths",
"NewRecovered",
"TotalRecovered",
"Date"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
	
	@JsonProperty("Country")
	private String country;
	@JsonProperty("CountryCode")
	private String countryCode;
	@JsonProperty("Slug")
	private String slug;
	@JsonProperty("NewConfirmed")
	private Integer newConfirmed;
	@JsonProperty("TotalConfirmed")
	private Integer totalConfirmed;
	@JsonProperty("NewDeaths")
	private Integer newDeaths;
	@JsonProperty("TotalDeaths")
	private Integer totalDeaths;
	@JsonProperty("NewRecovered")
	private Integer newRecovered;
	@JsonProperty("TotalRecovered")
	private Integer totalRecovered;
	@JsonProperty("Date")
	private String date;

	@JsonProperty("Country")
	public String getCountry() {
	return country;
	}

	@JsonProperty("Country")
	public void setCountry(String country) {
	this.country = country;
	}

	public Country withCountry(String country) {
	this.country = country;
	return this;
	}

	@JsonProperty("CountryCode")
	public String getCountryCode() {
	return countryCode;
	}

	@JsonProperty("CountryCode")
	public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
	}

	public Country withCountryCode(String countryCode) {
	this.countryCode = countryCode;
	return this;
	}

	@JsonProperty("Slug")
	public String getSlug() {
	return slug;
	}

	@JsonProperty("Slug")
	public void setSlug(String slug) {
	this.slug = slug;
	}

	public Country withSlug(String slug) {
	this.slug = slug;
	return this;
	}

	@JsonProperty("NewConfirmed")
	public Integer getNewConfirmed() {
	return newConfirmed;
	}

	@JsonProperty("NewConfirmed")
	public void setNewConfirmed(Integer newConfirmed) {
	this.newConfirmed = newConfirmed;
	}

	public Country withNewConfirmed(Integer newConfirmed) {
	this.newConfirmed = newConfirmed;
	return this;
	}

	@JsonProperty("TotalConfirmed")
	public Integer getTotalConfirmed() {
	return totalConfirmed;
	}

	@JsonProperty("TotalConfirmed")
	public void setTotalConfirmed(Integer totalConfirmed) {
	this.totalConfirmed = totalConfirmed;
	}

	public Country withTotalConfirmed(Integer totalConfirmed) {
	this.totalConfirmed = totalConfirmed;
	return this;
	}

	@JsonProperty("NewDeaths")
	public Integer getNewDeaths() {
	return newDeaths;
	}

	@JsonProperty("NewDeaths")
	public void setNewDeaths(Integer newDeaths) {
	this.newDeaths = newDeaths;
	}

	public Country withNewDeaths(Integer newDeaths) {
	this.newDeaths = newDeaths;
	return this;
	}

	@JsonProperty("TotalDeaths")
	public Integer getTotalDeaths() {
	return totalDeaths;
	}

	@JsonProperty("TotalDeaths")
	public void setTotalDeaths(Integer totalDeaths) {
	this.totalDeaths = totalDeaths;
	}

	public Country withTotalDeaths(Integer totalDeaths) {
	this.totalDeaths = totalDeaths;
	return this;
	}

	@JsonProperty("NewRecovered")
	public Integer getNewRecovered() {
	return newRecovered;
	}

	@JsonProperty("NewRecovered")
	public void setNewRecovered(Integer newRecovered) {
	this.newRecovered = newRecovered;
	}

	public Country withNewRecovered(Integer newRecovered) {
	this.newRecovered = newRecovered;
	return this;
	}

	@JsonProperty("TotalRecovered")
	public Integer getTotalRecovered() {
	return totalRecovered;
	}

	@JsonProperty("TotalRecovered")
	public void setTotalRecovered(Integer totalRecovered) {
	this.totalRecovered = totalRecovered;
	}

	public Country withTotalRecovered(Integer totalRecovered) {
	this.totalRecovered = totalRecovered;
	return this;
	}

	@JsonProperty("Date")
	public String getDate() {
	return date;
	}

	@JsonProperty("Date")
	public void setDate(String date) {
	this.date = date;
	}

	public Country withDate(String date) {
	this.date = date;
	return this;
	}

}
