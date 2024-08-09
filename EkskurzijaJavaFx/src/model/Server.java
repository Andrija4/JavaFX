package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Server {
	
	private static Server instance = null;
	
	private final Set<Student> studenti = new TreeSet<Student>();
	private final List<Autobus> autobusi = new ArrayList<Autobus>();
	private final Map<Student, Autobus> raspored = new HashMap<Student, Autobus>();
	
	
	
	private Autobus dodajStudenta(Student student) {
		for(Autobus a: this.autobusi) {
			if(a.dodajStudenta()) {
				raspored.putIfAbsent(student, a);
				
				return a;
			}
		}
		
		return null;
	}
	
	
	public void izbaciStudenta(Student student) {
		this.raspored.remove(student);
	}
	
	public Autobus getAutobusZaStudenta(Student student) {
		return this.raspored.get(student);
	}

	
	public Set<Student> getStudenti() {
		return studenti;
	}


	public List<Autobus> getAutobusi() {
		return autobusi;
	}




	public static Server getInstance() {
		if(instance == null)
			instance = new Server();
		return instance;
	}
}
