package Paquetes;

import Compradores.*;

public class PrecioFijo implements TipoPaquete{
	
	public double calcularPrecioBase(Paquete unPaquete, Cliente unCliente){
		return unPaquete.getPrecioBase();
	}

}
