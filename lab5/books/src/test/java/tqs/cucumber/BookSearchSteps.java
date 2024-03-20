package tqs.cucumber;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookSearchSteps {
	Library library = new Library();
	List<Book> result = new ArrayList<>();

    @ParameterType("(\\d{2}\\.\\d{2}\\.\\d{4})")
    public LocalDate date(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

	@ParameterType("(\\d{1,2} \\w+ \\d{4})")
    public LocalDate datelong(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    @ParameterType("\\d{4}")
    public LocalDate year(String yearStr) {
        int year = Integer.parseInt(yearStr);
        return LocalDate.of(year, 1, 1);
    }

	@Given("^I have the following books in the store by list$")
	public void haveBooksInTheStoreByList(DataTable table) {
		
		List<List<String>> rows = table.asLists(String.class);
		
		for (List<String> columns : rows) {
			library.addBook(new Book(columns.get(0), columns.get(1),date(columns.get(2))));
		}
}
 
	@Given("a book with the title {string}, written by {string}, published in {date}")
	public void addNewBook(final String title, final String author,  LocalDate date) {
		Book book = new Book(title, author, date);
		library.addBook(book);
	}

	@And("another book with the title {string}, written by {string}, published in {datelong}")
	public void andAnother(String title,String author, LocalDate date){
		Book book = new Book(title, author, date);
		library.addBook(book);
	}
 
	@When("the customer searches for books published between {year} and {year}")
	public void setSearchParameters(LocalDate from, LocalDate to) {
		result = library.findBooks(from, to);
	}
 
	@Then("{int} books should have been found")
	public void verifyAmountOfBooksFound(final int booksFound) {
		assertThat(result.size(), equalTo(booksFound));
	}
 
	@Then("Book {int} should have the title {string}")
	public void verifyBookAtPosition(int position, final String title) {
		assertThat(result.get(position - 1).getTitle(), equalTo(title));
	}
}
