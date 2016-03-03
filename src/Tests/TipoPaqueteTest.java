package Tests;

import static org.junit.Assert.*;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import Compradores.Cliente;
import Paquetes.PrecioFijo;
import Paquetes.SegunHabitacion;
import Paquetes.SegunSaldoCliente;
import Paquetes.TipoPaquete;



public class TipoPaqueteTest {

	private TipoPaquete precioFijo;
	private TipoPaquete segunHabitacion;
	private TipoPaquete segunSaldo;
	private Cliente clienteMock;
	
	@Before
	public void setUp(){
		
		precioFijo = new PrecioFijo(200);
		segunHabitacion = new SegunHabitacion(3, 50);
		segunSaldo = new SegunSaldoCliente();
		clienteMock = mock(Cliente.class);
	}
	@Test
	public void precioBaseParaPaquetePrecioFijo() {
		//El precio base de este tipo de paquetes es un monto fijo asignado
		assertEquals(200, precioFijo.calcularPrecioBase(clienteMock),0.01);
		
	}
	
	@Test
	public void precioBaseParaPaquetesSegunSaldoDelCLiente(){
		when(clienteMock.getSaldo()).thenReturn(200.0);
		//El precio base de este tipo de paquetes es el 10% del saldo del cliente
		assertEquals(20,segunSaldo.calcularPrecioBase(clienteMock),0.01);
	}
	
	@Test
	public void precioBaseParaPaquetesSegunCantidadDeHabitaciones(){
		//El precio base de este tipos de paquetes es la cantidad de habitaciones * el costo indiviudal
		assertEquals(150, segunHabitacion.calcularPrecioBase(clienteMock),0.01);
	}

}
