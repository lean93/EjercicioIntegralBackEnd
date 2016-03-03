package Paquetes;

import org.springframework.beans.factory.annotation.Required;

import Compradores.*;

public class PrecioFijo implements TipoPaquete{
	private double precioBase;
	public PrecioFijo(){
		
	}
	
	public PrecioFijo(double unPrecio){
		precioBase = unPrecio;
	}
	
	public double calcularPrecioBase(Cliente unCliente){
		return precioBase;
	}
	
    @Required
	public void setPrecioBase(double unMonto){
		this.precioBase = unMonto;
	}

}
