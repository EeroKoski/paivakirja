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
	private long id;
	
	private String producer;
	private String name; 
	private String appellation;
	private String region;
	private String country;
	private String grapes;
	private String vintage;
	private String note;
	private String points;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	@JsonManagedReference
	private Type type;

	public Wine() {
		super();
	}

	public Wine(
			String producer, 
			String name, 
			String vintage, 
			String appellation, 
			String region, 
			String country, 
			String grapes,
			Type type, 
			String note, 
			String points) {
		super();
		this.producer = producer;
		this.name = name;
		this.vintage = vintage;
		this.appellation = appellation;
		this.region = region;
		this.country = country;
		this.grapes = grapes;
		this.type = type;
		this.note = note;
		this.points = points;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Wine [id=" + id + ", producer=" + producer + ", name=" + name + ", appellation=" + appellation
				+ ", region=" + region + ", country=" + country + ", grapes=" + grapes + ", vintage=" + vintage
				+ ", note=" + note + ", points=" + points + ", type=" + type + "]";
	}

	
	
	
	
}