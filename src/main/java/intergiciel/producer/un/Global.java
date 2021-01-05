package intergiciel.producer.un;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"NewConfirmed",
"TotalConfirmed",
"NewDeaths",
"TotalDeaths",
"NewRecovered",
"TotalRecovered"
})
public class Global {
	
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
	
	@JsonProperty("NewConfirmed")
	public Integer getNewConfirmed() {
	return newConfirmed;
	}

	@JsonProperty("NewConfirmed")
	public void setNewConfirmed(Integer newConfirmed) {
	this.newConfirmed = newConfirmed;
	}

	public Global withNewConfirmed(Integer newConfirmed) {
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

	public Global withTotalConfirmed(Integer totalConfirmed) {
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

	public Global withNewDeaths(Integer newDeaths) {
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

	public Global withTotalDeaths(Integer totalDeaths) {
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

	public Global withNewRecovered(Integer newRecovered) {
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

	public Global withTotalRecovered(Integer totalRecovered) {
	this.totalRecovered = totalRecovered;
	return this;
	}



}
