package application;

import javafx.beans.property.SimpleStringProperty;

public class Pessoas {
	
	private String nomex;
	private String idx;
	private String colorx;
	
	public Pessoas(String ids, String nomes, String colors) {
		this.nomex = nomes;
		this.idx = ids;
		this.colorx = colors;
	}

	public String getNomex() {
		return nomex;
	}

	public void setNomex(String nomex) {
		this.nomex = nomex;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getColorx() {
		return colorx;
	}

	public void setColorx(String colorx) {
		this.colorx = colorx;
	}
	
	

}
