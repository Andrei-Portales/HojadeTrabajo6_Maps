import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Comparator;

import javax.swing.JOptionPane;

public class Controller {

	private Map<String, String> map;
	private Map<String, String> userData;
	
	private Factory<String,String> factory;
	private Object[] llaves;
	
	
	
	
	public Controller() {
		map = null;
		userData = null;
		factory = new Factory<String,String>();
		llaves = null;
	}
	
	
	/**
	 * Metodo que establece, mediante el patron factory, la implementacion de mapa que se utilizara 
	 * @param map, tipo de mapa
	 */
	public void setMap(String map) {
		this.map = factory.getMap(map);
		this.userData = factory.getMap(map);
	}
	
	/**
	 * Llena el mapa de cartas con la informacion en el txt
	 */
	public void fillMap() {
		try {
			ArrayList<String> data = ArchivoTXT.leerTXT(ArchivoTXT.getPath());
			
			for (int i = 0; i< data.size();i++) { 
				String[] p = getSplit(data.get(i),"|");
				map.put(p[0],p[1]);	
			}	
			
			llaves = map.keySet().toArray();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo llenar el mapa");
		}
	}
	
	/**
	 * retornar llaves para mostrar al usuario
	 * @return
	 */
	public Object[] getKEys() {
		return llaves;
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

			if (h.equals("|") || h.equals(" |")) {
				pos++;
			}else {
				retorno[pos] += h;
			}
				
		}
		return retorno;
		
	}
	/**
	 * 
	 * @param type
	 * @return obtiene el tipo de la carta
	 */
	public Object[] getListType(String type) {
		ArrayList<String> ap = new ArrayList<String>();
		Set<String> as = map.keySet();
		for (String i: as) {
			if (map.get(i).equals(type)) {
				ap.add(i);
			}
		}
		Object[] data = ap.toArray();
		Arrays.sort(data);
		return  data;
	}
	
	
	
	public int getTypeSize(String type) {
		int r = 0;
		Set<String> as = map.keySet();
		for (String i: as) {
			if (map.get(i).equals(type)) {
				r++;
			}
		}
		return r;
	}
	
	/**
	 * Funcion que retorna el tipo de la carta ingresada
	 * @param nombreCarta
	 * @return el tipo de la carta
	 * @throws IllegalArgumentException
	 */
	public String getType(String nombreCarta) throws IllegalArgumentException{        
		String tipo = null;                              
			if(map.containsKey(nombreCarta))
				tipo = map.get(nombreCarta);
			else if (userData.containsKey(nombreCarta))
				tipo = userData.get(nombreCarta);
		return tipo;
	}
	
	/**
	 * Retorna el size del mapa 
	 * @return
	 */
	public int getMapSize() {
		return map.size();
	}
	
	
	/**
	 * Retorna el size del mapa 
	 * @return
	 */
	public int getMapSizeUser() {
		return userData.size();
	}
	public Object[] getKeysMap() {
		ArrayList<String> data = new ArrayList<String>();
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
		  data.add(it.next().toString());
		}
		Object[] dat = data.toArray();
		Arrays.sort(dat);
		return dat;
	}
	
	  
	/**
	 * ordena las llaves del manojo global por tipo
	 * @return array de tipo object con llaves
	 */
	public Object getDeckKeysOrderedByValue() {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> dataHechizo = new ArrayList<String>();
		ArrayList<String> dataMounstro = new ArrayList<String>();
		ArrayList<String> dataTrampa = new ArrayList<String>();
		
		for (Map.Entry<String, String> carta : map.entrySet()) {
			if (carta.getValue().equals("Hechizo")) {
				dataHechizo.add(carta.getKey());
			}
			if (carta.getValue().equals("Monstruo")) {
				dataMounstro.add(carta.getKey());
			}
			if (carta.getValue().equals("Trampa")) {
				dataTrampa.add(carta.getKey());
			}
		}
		
		data.addAll(dataHechizo);
		data.addAll(dataMounstro);
		data.addAll(dataTrampa);
		
		
		
		return data.toArray();
	}
	
	
	/**
	 * ordena las llaves del manojo del usuario por tipo
	 * @return array de tipo object con llaves
	 */
	public Object[] getUserKeysOrderedByValue() {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> dataHechizo = new ArrayList<String>();
		ArrayList<String> dataMounstro = new ArrayList<String>();
		ArrayList<String> dataTrampa = new ArrayList<String>();
		
		for (Map.Entry<String, String> carta : userData.entrySet()) {
			if (carta.getValue().equals("Hechizo")) {
				dataHechizo.add(carta.getKey());
			}
			if (carta.getValue().equals("Monstruo")) {
				dataMounstro.add(carta.getKey());
			}
			if (carta.getValue().equals("Trampa")) {
				dataTrampa.add(carta.getKey());
			}
		}
		
		data.addAll(dataHechizo);
		data.addAll(dataMounstro);
		data.addAll(dataTrampa);
		
		
		
		return data.toArray();
	}
	
	
	/**
	 * Obtener cantidad de tipo de carta 
	 * @param type
	 * @return
	 */
	public int getTypeSizeUser(String type) {
		int r = 0;
		Set<String> as = userData.keySet();
		for (String i: as) {
			if (userData.get(i).equals(type)) {
				r++;
			}
		}
		return r;
	}
	
	
	/**
	 * Inserta la carta buscada en el deck del usuario
	 * @param key to search
	 * @throws IllegalArgumentException
	 */
	public void insertCard(String key) throws IllegalArgumentException{
		
		if(map.containsKey(key)) {
			
			userData.put(key,map.remove(key));
		}
		else {
			throw new IllegalArgumentException("La carta ingresada no esta en el deck global");
		}
		
	}
	
	/**
	 * 
	 * @param type
	 * @return obtiene el tipo de la carta
	 */
	public Object[] getListTypeUser(String type) {
		ArrayList<String> ap = new ArrayList<String>();
		Set<String> as = userData.keySet();
		for (String i: as) {
			if (userData.get(i).equals(type)) {
				ap.add(i);
			}
		}
		Object[] data = ap.toArray();
		Arrays.sort(data);
		return  data;
	}
	
	
}
