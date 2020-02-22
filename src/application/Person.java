package application;

import javafx.beans.property.SimpleStringProperty;

public class Person {
	
	private final SimpleStringProperty nomex;
	private final SimpleStringProperty idx;
	private final SimpleStringProperty colorx;
	
	public Person(String nomes, String ids, String colors) {
		this.nomex = new SimpleStringProperty(nomes);
		this.idx = new SimpleStringProperty(ids);
		this.colorx = new SimpleStringProperty(colors);
	}
	
	//**

	public SimpleStringProperty nomeProp() {
		return nomex;
	}
	
	public String getNome() {
		return nomex.get();
	}
	
	public void setNome(String nome) {
		this.nomex.set(nome);
	}
	
	//**
	
	public String getId() {
		return idx.get();
	}
	
	public void setId(String id) {
		this.idx.set(id);
	}
	
	public SimpleStringProperty idProp() {
		return idx;
	}
	
	//**
	
	public String getColor() {
		return colorx.get();
	}
	
	public void setColor(String color) {
		this.colorx.set(color);
	}
	
	public SimpleStringProperty colorProp() {
		return colorx;
	}
	
	

}
