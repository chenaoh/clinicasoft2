package co.chenao.ws.adapter;

import java.util.ArrayList;
import java.util.List;

import com.chenao.entidades.Producto;



public class ProductoAdapter {

	public Producto asignarProducto(Producto p) {
				
		Producto miProducto=null;
		
		if (p!=null) {
			miProducto=new Producto();
			miProducto.setIdProducto(p.getIdProducto());
			miProducto.setNombreProducto(p.getNombreProducto());
			miProducto.setPrecioProducto(p.getPrecioProducto());
		}		

		return miProducto;
	}

	public List<Producto> asignarListaProductos(List<Producto> lista) {
		List<Producto> listaProductos=new ArrayList<Producto>();
		
		for (int i = 0; i < lista.size(); i++) {
			listaProductos.add(asignarProducto(lista.get(i)));
		}
		
		return listaProductos;
	}

}
