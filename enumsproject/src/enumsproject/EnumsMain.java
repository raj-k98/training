package enumsproject;

import abc.GenderValue;
import abc.Season;

public class EnumsMain {

	public static void main(String[] args) {
		Employee e  = new Employee(123,"Abcdef",GenderValue.MALE);
		
		e.show();
		e.setGender(GenderValue.MALE);
		e.show();
		
		// Using Season Enum
		
		Season season = Season.WINTER;
		System.out.println(season);
		season.ShowState();
		
		//using values() method
		for(Season s: Season.values()) {
			System.out.println(s);
		}
	}

}
