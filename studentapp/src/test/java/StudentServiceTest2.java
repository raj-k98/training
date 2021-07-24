import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.trg.crud.exceptions.StudentException;
import com.trg.student.dao.StudentDao;
import com.trg.student.dao.StudentDaoJpaImpl;
import com.trg.student.data.Student;
import com.trg.student.service.StudentService;
import com.trg.student.service.StudentServiceImpl;
import static org.mockito.Mockito.when;

class StudentServiceTest2 {
	
	StudentDao dao = Mockito.mock(StudentDao.class);
	StudentService service = new StudentServiceImpl(dao);

	@Test
	public void testGetStudent() {

		Student sd =new Student(100, "Kumar", LocalDate.of(1999, 10, 5), 25.6);
		when(dao.getStudent(100)).thenReturn(sd);
		
		Student s = service.getStudent(100);
		String name = s.getName();

		assertEquals("Kumar", name);
	}

	@Test
	public void testDeleteStudent() {
		try {
			
			
			service.deleteStudent(100);
			when(dao.getStudent(100)).thenReturn(null);
			
			Student s = service.getStudent(100);
			assertNull(s);

		} catch (StudentException e) {
			fail("Delete not working properly");
		}

	}

}
