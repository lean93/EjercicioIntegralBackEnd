package Paquetes;

import Compradores.*;

public class SegunSaldoCliente implements TipoPaquete{
	public double calcularPrecioBase(Cliente unCliente){
		return unCliente.getSaldo()*0.1;
	}

}
