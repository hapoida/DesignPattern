package co.kr.hapoida.chapter01.iterator;


import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.hapoida.chapter01.iterator.Iterator;
import co.kr.hapoida.chapter01.iterator.array.Book;
import co.kr.hapoida.chapter01.iterator.array.Bookshelf;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIterator {
	
	String[] bookNames = {"Around the world in 80 Days","Bible","Cinderella","Daddy-long_legs"};
	
	private Bookshelf bookshelf;
	
	@Before
	public void init_������������(){
		bookshelf = new Bookshelf(4);
		bookshelf.appendBook(new Book(bookNames[0]));
		bookshelf.appendBook(new Book(bookNames[1]));
		bookshelf.appendBook(new Book(bookNames[2]));
		bookshelf.appendBook(new Book(bookNames[3]));
	}
	
	@Test
	public void test_Iterator����(){
		Iterator it = bookshelf.iterator();
		
		int bookNameIdx = 0;
		
		while (it.hasNext()) {
			Book book = (Book) it.next();
			
			assertThat(book.getName() , is(bookNames[bookNameIdx]));
			
			bookNameIdx++;
		}
		
	}
}