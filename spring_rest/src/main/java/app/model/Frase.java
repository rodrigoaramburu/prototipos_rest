package app.model;


import java.util.Date;

import app.model.Autor;

public class Frase {

	private Long id;
	private String frase;
	private Autor autor;
	private Date created;
	
	
	public Frase(){
		this.created = new Date();
	}
	
	public Frase(Long id, String frase, Autor autor) {
		this.id = id;
		this.frase = frase;
		this.autor = autor;
		this.created = new Date();
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrase() {
		return frase;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frase other = (Frase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Frase [id=" + id + ", frase=" + frase + ", autor=" + autor + ", created=" + created + "]";
	}
	
	
}
