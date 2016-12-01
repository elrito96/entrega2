package uva.poo.entrega2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PackTest {
	
	@Test
	public void testPackValido(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		Producto b=new Producto("PATATAS", 10.0, "098765432112");
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=b;
		Pack miPack = new Pack("miPack","1",listaDeLaCompra);
		assertEquals(miPack.getNombre(),"miPack");
		assertEquals(miPack.getPrecio(),12.0, 0.01);
		assertEquals(miPack.getIdentificador(),"1");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackInvalidoMenosDe2Productos(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[1];
		listaDeLaCompra[0]=a;
		Pack miPack = new Pack("miPack","1",listaDeLaCompra);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testPackInvalidoProductosIguales(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=a;
		Pack miPack = new Pack("miPack","1",listaDeLaCompra);
	}
	//no se si hace falta :cc
	@Test(expected=java.lang.AssertionError.class)
	public void testPackInvalidoNombreNull(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		Producto b=new Producto("PATATAS", 10.0, "098765432112");
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=b;
		Pack miPack = new Pack(null,"1",listaDeLaCompra);
	}
	@Test
	public void testDistintosValido() {
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		Producto b=new Producto("PATATAS", 10.0, "098765432112");
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=b;
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		assertTrue(miPack.distintos());
	}
	@Test
	public void testAgregaProductoValido(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		Producto b=new Producto("PATATAS", 10.0, "098765432112");
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=b;
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		Producto c=new Producto("COCACOLA", 10.0, "098765432112");
		miPack.agregaProducto(c);
		assertEquals(miPack.getContenido().get(2),c);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testAgregaProductoInvalidoProductoNull(){
		Producto a=new Producto("POLLO", 5.0, "123456789012");
		Producto[] listaDeLaCompra = new Producto[2];
		Producto b=new Producto("PATATAS", 10.0, "098765432112");
		listaDeLaCompra[0]=a;
		listaDeLaCompra[1]=b;
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		Producto c=null;
		miPack.agregaProducto(c);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testAgregaProductoInvalidoYaConteniaElProducto(){
		Producto repe=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {repe,patatas};
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		miPack.agregaProducto(repe);
	}
	@Test
	public void testQuitaProductoValido() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto cola=new Producto("COCACOLA", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas,cola};
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		miPack.quitaProducto(cola);
		assertEquals(miPack.getCantidad(),2);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testQuitaProductoInvalidoNull() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Producto nulo=null;
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		miPack.quitaProducto(nulo);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testQuitaProductoInvalidoQueNoEsta() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto cola=new Producto("COCACOLA", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		miPack.quitaProducto(cola);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testQuitaProductoInvalidoPackPequeño() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		miPack.quitaProducto(patatas);
		miPack.quitaProducto(pollo);
	}
	@Test
	public void testAgregaVariosProductoValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto cola=new Producto("COCACOLA", 10.0, "098765432112");
		Producto golosinas = new Producto ("OSITOS HARIBO", 0.99, "123456789012");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		Producto[] ampliacion = {cola,golosinas};
		miPack.agregaVariosProductos(ampliacion);
		assertEquals(miPack.getCantidad(),4);
	}
	@Test
	public void testQuitaVariosProductoValido(){
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto cola=new Producto("COCACOLA", 10.0, "098765432112");
		Producto golosinas = new Producto ("OSITOS HARIBO", 0.99, "123456789012");
		Producto[] listaDeLaCompra = {pollo,patatas,cola,golosinas};
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		Producto[] ampliacion = {cola,golosinas};
		miPack.quitaVariosProductos(ampliacion);
		assertEquals(miPack.getCantidad(),2);
	}
	@Test
	public void testGetCantidadValido() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		assertEquals(miPack.getCantidad(),2);
	}
	@Test
	public void testContieneValido() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		assertTrue(miPack.contiene(pollo));
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testContieneInvalidoProductoNull() {
		Producto pollo=new Producto("POLLO", 5.0, "123456789012");
		Producto patatas=new Producto("PATATAS", 10.0, "098765432112");
		Producto[] listaDeLaCompra = {pollo,patatas};
		Pack miPack = new Pack("nombre","1",listaDeLaCompra);
		miPack.contiene(null);
	}
	@Test
	public void testGetContenido() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetContenido() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsPack() {
		fail("Not yet implemented");
	}

	@Test
	public void testVendible() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrecio() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrecio() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdentificador() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIdentificador() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString1() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
