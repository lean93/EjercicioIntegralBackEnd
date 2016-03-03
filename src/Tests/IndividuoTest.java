package Tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;


import Compradores.Individuo;
import Excepciones.FalloEnCompraExcepcion;
import Excepciones.SinSaldoException;
import Excepciones.VariasComprasException;
import Paquetes.Paquete;


public class IndividuoTest {
	
	private Individuo leanIndividuo;
	private Paquete paqueteMock;
	private Paquete paqueteMock2;

	@Before
	public void setUp(){
		leanIndividuo = new Individuo(1000);
		paqueteMock= mock(Paquete.class);
		paqueteMock2 = mock(Paquete.class);
	
	}

	@Test
	public void leanReservaUnPaquete() throws SinSaldoException {
		when(paqueteMock.getMedioPrecio(leanIndividuo)).thenReturn(250.0);
		leanIndividuo.reservarPaquete(paqueteMock);
		
		assertEquals(750,leanIndividuo.getSaldo(),0.01);
		assertEquals(0, leanIndividuo.getCantidadDeCompras());
		assertEquals(paqueteMock,leanIndividuo.getPaqueteEnReserva());
	}
	
	@Test
	public void leanReservaUnPaqueteYLuegoFinalizaLaTransaccion() throws SinSaldoException {
		when(paqueteMock.getMedioPrecio(leanIndividuo)).thenReturn(250.0);
		leanIndividuo.reservarPaquete(paqueteMock);
		
		assertEquals(750,leanIndividuo.getSaldo(),0.01);
		assertEquals(0, leanIndividuo.getCantidadDeCompras());
		assertEquals(paqueteMock,leanIndividuo.getPaqueteEnReserva());
		
		leanIndividuo.terminarCompra();
		
		assertEquals(500,leanIndividuo.getSaldo(),0.01);
		assertEquals(1, leanIndividuo.getCantidadDeCompras());
		assertEquals(null,leanIndividuo.getPaqueteEnReserva());
	}

	@Test (expected = VariasComprasException.class)
	public void leanReservaUnPaqueteYNoPuedeComprarOtro() throws  VariasComprasException, FalloEnCompraExcepcion, SinSaldoException {
		when(paqueteMock.getMedioPrecio(leanIndividuo)).thenReturn(250.0);
		when(paqueteMock2.getPrecioPaquete(leanIndividuo)).thenReturn(300.0);
		
		leanIndividuo.reservarPaquete(paqueteMock);
		
		assertEquals(750,leanIndividuo.getSaldo(),0.01);
		assertEquals(0, leanIndividuo.getCantidadDeCompras());
		assertEquals(paqueteMock,leanIndividuo.getPaqueteEnReserva());
		
		leanIndividuo.comprarPaquete(paqueteMock2);
		
		fail("Al tener una reserva, no deberia poder comprar otro paquete hasta finalizar la anterior");
		
	}
}
