package seminars.fourth.book;


import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.*;

        import java.util.ArrayList;
        import java.util.List;

        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;


public class BookServiceTest {
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void testFindBookById() {
        Book expectedBook = new Book("1", "Book1", "Author1");

        when(bookRepository.findById("1")).thenReturn(expectedBook);

        Book actualBook = bookService.findBookById("1");

        assertEquals(expectedBook, actualBook);

        verify(bookRepository, times(1)).findById("1");
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void testFindAllBooks() {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("1", "Book1", "Author1"));
        expectedBooks.add(new Book("2", "Book2", "Author2"));

        when(bookRepository.findAll()).thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.findAllBooks();

        assertEquals(expectedBooks, actualBooks);

        verify(bookRepository, times(1)).findAll();
        verifyNoMoreInteractions(bookRepository);
    }
}
