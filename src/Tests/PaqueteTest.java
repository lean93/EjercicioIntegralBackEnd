package Tests;

import static org.junit.Assert.*;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import Compradores.Cliente;
import Paquetes.Paquete;
import Paquetes.TipoPaquete;

public class PaqueteTest {
	
	private Paquete paquete;
	private Cliente clienteMock;
	private TipoPaquete tipoPaqueteMock;
	
	@Before
	public void setUp(){
		paquete= new Paquete(1.5);
		clienteMock = mock(Cliente.class);
		tipoPaqueteMock = mock(TipoPaquete.class);
	}

	
	@Test
	public void precioDelPaqueteParaUnDeterminadoClienteEsELCorrecto() {
		when(tipoPaqueteMock.calcularPrecioBase(clienteMock)).thenReturn(200.0);
		paquete.setTipoPaquete(tipoPaqueteMock);
		assertEquals(300, paquete.getPrecioPaquete(clienteMock),0.01);	
	}

	@Test
	public void elPrecioMedioDelPaqueteParaUnDeterminadoClienteEsELCorrecto() {
		when(tipoPaqueteMock.calcularPrecioBase(clienteMock)).thenReturn(600.0);
		paquete.setTipoPaquete(tipoPaqueteMock);
		assertEquals(450, paquete.getMedioPrecio(clienteMock),0.01);	
	}
}
