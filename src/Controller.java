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
				String[] p = d.toString().split("|");
				
				//map.put(d.split("|")[0], d.split("|")[1]);
				System.out.println(Arrays.toString(p));
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo llenar el mapa");
		}
	}
	
	public void print() {
		Collection<String> as = map.values();
		
		System.out.println(Arrays.toString(as.toArray()));
		
	}
	
}
