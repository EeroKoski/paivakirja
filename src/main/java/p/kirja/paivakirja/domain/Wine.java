package p.kirja.paivakirja.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity

public class Wine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long wineid;
	
	private String producer;
	private String name; 
	private String appellation;
	private String region;
	private String country;
	private String grapes;
	private String vintage;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	@JsonManagedReference
	private Type type;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "note")
	private List<Note> notes;

	public Wine() {
		super();
	}

	public Wine(String producer, String name, String appellation, String region, String country,
			String grapes, String vintage, Type type, List<Note> notes) {
		super();
		this.producer = producer;
		this.name = name;
		this.appellation = appellation;
		this.region = region;
		this.country = country;
		this.grapes = grapes;
		this.vintage = vintage;
		this.type = type;
		this.notes = notes;
	}

	public long getWineid() {
		return wineid;
	}

	public void setWineid(long wineid) {
		this.wineid = wineid;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGrapes() {
		return grapes;
	}

	public void setGrapes(String grapes) {
		this.grapes = grapes;
	}

	public String getVintage() {
		return vintage;
	}

	public void setVintage(String vintage) {
		this.vintage = vintage;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Wine [producer=" + producer + ", name=" + name + ", appellation=" + appellation
				+ ", region=" + region + ", country=" + country + ", grapes=" + grapes + ", vintage=" + vintage
				+ ", type=" + type + ", notes=" + notes + "]";
	}
	
	}
