package Paquetes;

import Compradores.*;
public class Paquete {

	
	private double impuesto;
	private TipoPaquete tipoPaquete;

	public Paquete(double unImpuesto, TipoPaquete unTipo) {
		impuesto = unImpuesto;
		tipoPaquete = unTipo;
	}

	public Paquete() {

	}

	

	public double getPrecioPaquete(Cliente unCliente) {
		return tipoPaquete.calcularPrecioBase(unCliente) * impuesto;
	}

	public double getMedioPrecio(Cliente unCliente) {
		return getPrecioPaquete(unCliente) / 2;
	}
	
	public void setTipoDePaquete(TipoPaquete unTipo){
		tipoPaquete = unTipo;
	}
}
