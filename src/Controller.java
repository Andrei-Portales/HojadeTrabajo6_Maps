import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import javax.swing.JOptionPane;

public class Controller {

	private Map<String, String> map;
	private Factory<String,String> factory;
	
	
	
	public Controller() {
		map = null;
		factory = new Factory<String,String>();
	}
	
	
	public void setMap(String map) {
		this.map = factory.getMap(map);
	}
	
	public void fillMap() {
		try {
			String[] data = ArchivoTXT.leerTXT(ArchivoTXT.getPath());
			for (String d:data) {
				String[] p = getSplit(d,"|");
				map.put(p[0],p[1]);
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo llenar el mapa");
		}
	}
	
	public void print() {
		
	}
	
	/**
	 * Funcion para separa el string a clave y valor
	 * @param texto
	 * @param separador
	 * @return
	 */
	private String[] getSplit(String texto, String separador) {
		String[] retorno = new String[] {"",""}; 
		String[] s = texto.split("");
		int pos = 0;
		for (String h: s) {
			if (!h.equals("|"))
				retorno[pos] += h;
			if (h.equals("|"))
				pos++;
		}
		return retorno;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
