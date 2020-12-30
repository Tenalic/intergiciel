package tp.kafka.producer;

import java.util.HashMap;
import java.util.List;
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
"Global",
"Countries",
"Date"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {
	
	@JsonProperty("Global")
	private Global global;
	@JsonProperty("Countries")
	private List<Country> countries = null;
	@JsonProperty("Date")
	private String date;
	
	

	@JsonProperty("Global")
	public Global getGlobal() {
	return global;
	}

	@JsonProperty("Global")
	public void setGlobal(Global global) {
	this.global = global;
	}

	public Summary withGlobal(Global global) {
	this.global = global;
	return this;
	}

	@JsonProperty("Countries")
	public List<Country> getCountries() {
	return countries;
	}

	@JsonProperty("Countries")
	public void setCountries(List<Country> countries) {
	this.countries = countries;
	}

	public Summary withCountries(List<Country> countries) {
	this.countries = countries;
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

	public Summary withDate(String date) {
	this.date = date;
	return this;
	}


}
