package Paquetes;

import Compradores.*;
public class Paquete {

	private double precioBase;
	private double impuesto;
	private TipoPaquete tipoPaquete;

	public Paquete(double unPrecio, double unImpuesto, TipoPaquete unTipo) {
		precioBase = unPrecio;
		impuesto = unImpuesto;
		tipoPaquete = unTipo;
	}

	public Paquete() {

	}

	public double getPrecioBase() {
		return precioBase;

	}

	public double getPrecioPaquete(Cliente unCliente) {
		return tipoPaquete.calcularPrecioBase(this, unCliente) * impuesto;
	}

	public double getMedioPrecio(Cliente unCliente) {
		return getPrecioPaquete(unCliente) / 2;
	}
	
	public void setTipoDePaquete(TipoPaquete unTipo){
		tipoPaquete = unTipo;
	}
}
