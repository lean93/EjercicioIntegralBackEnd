package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import Compradores.Cliente;
import Excepciones.FalloEnCompraExcepcion;
import Excepciones.SinSaldoException;
import Paquetes.Paquete;

public class ClienteTest {
	
	private Cliente leandro;
	private Paquete paqueteMock;
	private Paquete paqueteMock2;
	@Before
	public void setUp(){
		leandro = new Cliente(1000);
		paqueteMock= mock(Paquete.class);
		paqueteMock2 = mock(Paquete.class);
	}

	@Test
	public void leandroCompraCorrectamenteUnPaquete() throws FalloEnCompraExcepcion {
		when(paqueteMock.getPrecioPaquete(leandro)).thenReturn(250.0);
		leandro.comprarPaquete(paqueteMock);
		assertEquals(750, leandro.getSaldo(), 0.01);
		assertEquals(1, leandro.getCantidadDeCompras());
	}
	
	@Test (expected = FalloEnCompraExcepcion.class) 
	public void leanIntentaComprarUnPaquetePeroFallaPorqueNoTieneSaldo() throws FalloEnCompraExcepcion{
		when(paqueteMock.getPrecioPaquete(leandro)).thenReturn(3500.0);
		leandro.comprarPaquete(paqueteMock);
		fail("Debio Fallar porque no tiene saldo para pagar");
	}
	
	@Test
	public void leandroRealizaUnPagoSinNingunProblema() throws SinSaldoException{
		leandro.realizarPago(500);
		assertEquals(500, leandro.getSaldo(), 0.01);
	}
	
	@Test (expected = SinSaldoException.class)
	public void leanIntentaRealizarUnPagoPeroNoTieneSaldoParaHacerlo() throws SinSaldoException{
		leandro.realizarPago(5000);
		fail("No tiene saldo suficiente, debe explotar");
	}
	
	@Test
	public void leanQuiereSaberSuTotalGastado() throws FalloEnCompraExcepcion{
		when(paqueteMock.getPrecioPaquete(leandro)).thenReturn(200.0);
		when(paqueteMock2.getPrecioPaquete(leandro)).thenReturn(450.0);
		leandro.comprarPaquete(paqueteMock);
		leandro.comprarPaquete(paqueteMock2);
		
		assertEquals(650, leandro.getTotalGastado(),0.01);
		assertEquals(350, leandro.getSaldo(),0.01);
	}
	
	@Test
	public void leanQuiereSaberElPaqueteMasCaroEntreUnosPaquetes(){
		when(paqueteMock.getPrecioPaquete(leandro)).thenReturn(200.0);
		when(paqueteMock2.getPrecioPaquete(leandro)).thenReturn(450.0);
		
		assertEquals(paqueteMock2,leandro.getPaqueteMasCaro(Arrays.asList(paqueteMock,paqueteMock2)));
		
	}

}
