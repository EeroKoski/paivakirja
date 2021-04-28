package p.kirja.paivakirja.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long noteid;
	private String writer;
	private String note;
	private String points;
	
	@ManyToOne
	@JoinColumn(name = "wineid")
	@JsonManagedReference
	private Wine wine;

	public Note() {
		super();
	}

	public Note(long noteid, String writer, String note, String points) {
		super();
		this.noteid = noteid;
		this.writer = writer;
		this.note = note;
		this.points = points;
	}

	public long getNoteid() {
		return noteid;
	}

	public void setNoteid(long noteid) {
		this.noteid = noteid;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public Wine getWine() {
		return wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
	}

	@Override
	public String toString() {
		return "Note [noteid=" + noteid + ", writer=" + writer + ", note=" + note + ", points=" + points + ", wine="
				+ wine + "]";
	}
	
	
	
	

}
