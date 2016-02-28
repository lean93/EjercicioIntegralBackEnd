package Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import Compradores.*;
import Excepciones.FalloEnCompraExcepcion;
import Excepciones.SinSaldoException;
import Paquetes.*;


public class TestEjercicio3 {

	private Individuo leandro;
	private Individuo leanCortoDeEfectivo;
	private Empresa utn;
	private Paquete paquete1;
	private Paquete paqueteMardel;
	private Paquete elTercerPaquete;

	@Before
	public void setUp() {

		leanCortoDeEfectivo = new Individuo(200);
		leandro = new Individuo(900);
		paquete1 = new Paquete(1.25, new PrecioFijo(500));
		paqueteMardel = new Paquete(1.2, new SegunHabitacion(2, 50));
		elTercerPaquete = new Paquete(1.2, new SegunHabitacion(4, 50));
		utn = new Empresa(2000);
	}
	@Test
	public void leanNoTieneSaldoParaRealizarUnaCompra(){
		
		try{
			leanCortoDeEfectivo.realizarPago(paquete1.getPrecioPaquete(leandro));
			fail("Como no tiene suficiente saldo, deberia lanzar una excepcion");
		}catch(SinSaldoException e){
			//Como capturo un "SinSaldoException", el test cumple
		}
	}
	
	@Test
	public void falloEnLaCompraPorqueLeanSeQuedaSinSaldoPorTantasCompras(){
		try{
			
			leandro.comprarPaquete(paquete1);
			leandro.comprarPaquete(paqueteMardel);
			leandro.comprarPaquete(elTercerPaquete);
			fail("Como se queda sin saldo, deberia lanzar una excepcion para cortar el flujo de compra");
			
		}
		catch (FalloEnCompraExcepcion e){
			// Como capturo un "FalloEnCompraException" el test cumple
		}
		finally{
			assertEquals(leandro.getCantidadDeCompras(),2);
		}
	}
}
