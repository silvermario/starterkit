package pl.spring.demo.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.searchcriteria.BookSearchCriteria;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class BookSearchCriteriaRepositoryTest {

	@Autowired
	@Qualifier("bookRepository")
	private BookSearchCriteriaRepository bookSearchCriteriaRepository;

	@Test
	// @Ignore
	public void testShouldFindBooksBySearchCriteria() {
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(null, null, null);
		System.out.println(bookSearchCriteriaRepository.findBooksByCriteria(bookSearchCriteria).get(0).getTitle());
	}
}
