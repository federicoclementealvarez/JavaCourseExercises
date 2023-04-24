package entities;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class Producto{

	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;
	private boolean shippingIncluded;
	private LocalDateTime disabledOn;
	
	public LocalDateTime getDisabledOn() {
		return disabledOn;
	}

	public void setDisabledOn(LocalDateTime disabledOn) {
		this.disabledOn = disabledOn;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isShippingIncluded() {
		return shippingIncluded;
	}
	public void setShippingIncluded(boolean shippingIncluded) {
		this.shippingIncluded = shippingIncluded;
	}
	
	public String toString() {
		String dateFormat = "dd/MM/yyyy";
		String timeFormat = "HH:mm:ss";
		String dateTimeFormat = dateFormat+" "+timeFormat;
		DateTimeFormatter format = DateTimeFormatter.ofPattern(dateTimeFormat);
		return("Producto: [id: "+this.getId()+", nombre: "+this.getName()+", descrición: "+this.getDescription()+", precio: "+this.getPrice()+", stock: "+this.getStock()+", ¿envío incluído?: "+this.isShippingIncluded()+", disabled on: "+((disabledOn==null)?null:disabledOn.format(format))+"]\n");
	}
	
	
	/*DateTimeFormatter format = DateTimeFormatter.ofPattern(dateTimeFormat);
	System.out.println("Ingrese la fecha y hora del disabledOn ("+dateTimeFormat+"): ");
	prod.setDisabledOn(LocalDateTime.parse(lector.nextLine(), format));*/
}
