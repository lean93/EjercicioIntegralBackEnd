package Tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;


import Compradores.Empresa;
import Excepciones.FalloEnCompraExcepcion;
import Paquetes.Paquete;
import static org.mockito.Mockito.when;

import java.util.Arrays;

public class EmpresaTest {

	private Empresa unaEmpresa;
	private Paquete paqueteMock;
	private Paquete paqueteMock2;
	private Paquete paqueteMock3;
	@Before
	public void setUp(){
		unaEmpresa = new Empresa(1000);
		paqueteMock= mock(Paquete.class);
		paqueteMock2 = mock(Paquete.class);
		paqueteMock3 = mock(Paquete.class);
	}
	@Test
	public void empresaPuedeComprarVariosPaquetesAlMismoTiempo() throws FalloEnCompraExcepcion {
		when(paqueteMock.getPrecioPaquete(unaEmpresa)).thenReturn(200.0);
		when(paqueteMock2.getPrecioPaquete(unaEmpresa)).thenReturn(300.0);
		when(paqueteMock3.getPrecioPaquete(unaEmpresa)).thenReturn(250.0);
		
		unaEmpresa.comprarVarios(Arrays.asList(paqueteMock,paqueteMock2,paqueteMock3));
		
		assertEquals(3, unaEmpresa.getCantidadDeCompras());
		assertEquals(750, unaEmpresa.getTotalGastado(),0.01);
		assertEquals(250, unaEmpresa.getSaldo(),0.01);
	}
	
	@Test (expected = FalloEnCompraExcepcion.class)
	public void empresaIntentaComprarVariosPAquetePeroFallaPorSaldoInsuficiente() throws FalloEnCompraExcepcion{
		when(paqueteMock.getPrecioPaquete(unaEmpresa)).thenReturn(700.0);
		when(paqueteMock2.getPrecioPaquete(unaEmpresa)).thenReturn(450.0);
		when(paqueteMock3.getPrecioPaquete(unaEmpresa)).thenReturn(250.0);
		
		unaEmpresa.comprarVarios(Arrays.asList(paqueteMock,paqueteMock2,paqueteMock3));
		
		fail("Debio Fallar porque se quedaria sin credito");
	}

}
