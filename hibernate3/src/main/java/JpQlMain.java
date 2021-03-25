import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.trng.entity.Employee;

public class JpQlMain {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EMPPU");
		EntityManager em = factory.createEntityManager();
		
		Query  q = em.createQuery("from Employee e  where e.salary between :low and :high");
		
		q.setParameter("low", new Float(10000));
		q.setParameter("high", 15000f);
		
		List<Employee> emps = q.getResultList();
		
		emps.forEach(System.out::println);
		
		em.close();

	}

}
