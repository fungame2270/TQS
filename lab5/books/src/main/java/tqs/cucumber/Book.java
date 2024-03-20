package tqs.cucumber;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
 
@AllArgsConstructor
public class Book {
	private @Getter @Setter String title;
	private @Getter @Setter String author;
	private @Getter @Setter LocalDate published;
 
	// constructors, getter, setter ommitted
}
