package tqs.cucumber;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
 
public class Library {
	private final List<Book> store = new ArrayList<>();
 
	public void addBook(Book book) {
		store.add(book);
	}
 
	public List<Book> findBooks(LocalDate from,LocalDate to) {
		return store.stream().filter(book -> {
			return from.isBefore(book.getPublished()) && to.isAfter(book.getPublished());
		}).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
	}
}
