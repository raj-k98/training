package labcollectionproject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabEx01 {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("MU", "Mumbai");
		map.put("Hy", "Hyderabad");
		map.put("CH", "Chennai");
		map.put("PU", "Pune");
		map.put("KO", "KolKotta");
		
		List<String> list =getValues(map);
		
		for(String s:list)
			System.out.println(s);
	}
	
	static List<String> getValues(HashMap<String,String> cityMap){
		
		Collection <String> cities= cityMap.values();
		
		List<String> list = new ArrayList<String>();
		list.addAll(cities);
		
		Collections.sort(list);
		return list;
	}
}
