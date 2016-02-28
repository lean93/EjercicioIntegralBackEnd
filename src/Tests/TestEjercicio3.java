package Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import Compradores.*;
import Excepciones.SinSaldoException;
import Paquetes.*;


public class TestEjercicio3 {

	private Individuo leandro;
	private Empresa utn;
	private Paquete paquete1;
	private Paquete paqueteMardel;
	private Paquete elTercerPaquete;

	@Before
	public void setUp() {

		leandro = new Individuo(200);
		paquete1 = new Paquete(1.25, new PrecioFijo(500));
		paqueteMardel = new Paquete(1.2, new SegunHabitacion(2, 50));
		elTercerPaquete = new Paquete(1.2, new SegunHabitacion(4, 50));
		utn = new Empresa(2000);
	}
	@Test
	public void leanNoTieneSaldoParaRealizarUnaCompra(){
		
		try{
			leandro.realizarPago(paquete1.getPrecioPaquete(leandro));
			fail("Como se quedo sin saldo, deberia fallar la compra");
			
		}catch(SinSaldoException e){
			//asd
		}
	}
}
