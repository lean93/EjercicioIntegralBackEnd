package Paquetes;

import Compradores.*;

public class PrecioFijo implements TipoPaquete{
	private double precioBase;
	
	public PrecioFijo(double unPrecio){
		
		precioBase = unPrecio;
		
	}
	
	public double calcularPrecioBase(Cliente unCliente){
		return precioBase;
	}

}
