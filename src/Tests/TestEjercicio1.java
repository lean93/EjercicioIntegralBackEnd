package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Compradores.*;
import Excepciones.FalloEnCompraExcepcion;
import Paquetes.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
public class TestEjercicio1 {
	
	private Individuo leandro;
	private Paquete paquete1;
	private Paquete paqueteMock;
	private Paquete paqueteMock2;
	private Paquete paqueteMardelMock;
	private Paquete paquete2;
	private Paquete paqueteMardel;
	private Paquete paqueteDeImpuesto;
	
	@Before
	public void setUp(){
	
		 leandro = new Individuo(2000);
		 paqueteMock = mock(Paquete.class);
		 paqueteMock2 = mock(Paquete.class);
		 paqueteMardelMock = mock(Paquete.class);
		 paquete1 = new Paquete(1.25, new PrecioFijo(500));
		 paquete2 = new Paquete(1.1,new PrecioFijo(100));
		 paqueteMardel = new Paquete(1.2, new SegunHabitacion(2, 50));
		 paqueteDeImpuesto = new Paquete(1.3, new SegunSaldoCliente());
	}
	
	
	@Test
	public void leandroTiene2000DeSaldo(){
		assertEquals(2000.0, leandro.getSaldo(),0.001);
	}
	
	@Test
	public void leanCompraPaquete1YQuedaCon1375DeSaldo() throws FalloEnCompraExcepcion{
		leandro.comprarPaquete(paquete1);
		assertEquals(1375.0,leandro.getSaldo(),0.01);
	}
	
	@Test
	public void leanCompraPaqueteMockYQuedaCon1375DeSaldo() throws FalloEnCompraExcepcion{
		when(paqueteMock.getPrecioPaquete(leandro)).thenReturn(625.0);
		leandro.comprarPaquete(paqueteMock);
		assertEquals(1375.0, leandro.getSaldo(), 0.01);
		verify(paqueteMock,times(1)).getPrecioPaquete(leandro);
	}
	
	
	@Test 
	public void leanCompraPaquete2YQuedaCon1890DeSaldo() throws FalloEnCompraExcepcion{
		leandro.comprarPaquete(paquete2);
		assertEquals(1890, leandro.getSaldo(),0.01);
	}
	
	@Test
	public void precioDelPaqueteMardelEs120SegunHabitacion(){
		assertEquals(120, paqueteMardel.getPrecioPaquete(leandro), 0.01);
	}
	
	@Test
	public void precioDelPaqueteMardelEs240SiEsPrecioFijo(){
		paqueteMardel.setTipoDePaquete(new PrecioFijo(200));
		assertEquals(240, paqueteMardel.getPrecioPaquete(leandro), 0.01);
	}

	@Test
	public void leanTiene1740DeSaldoDespuesDeComprarPaqueteSegunSuSaldo() throws FalloEnCompraExcepcion{
		leandro.comprarPaquete(paqueteDeImpuesto);
		assertEquals(1740,leandro.getSaldo(),0.01);
	}
	
		

}
