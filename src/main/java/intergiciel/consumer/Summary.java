package intergiciel.consumer;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Global", "Countries", "Date" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@JsonProperty("Global")
	private Global global;
	@JsonProperty("Countries")
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Country> countries = null;
	@JsonProperty("Date")
	private String date;

	public Summary() {

	}

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
