package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    public void testRemoveProduct() {
        Repository repo = new Repository();

        Book book1 = new Book(10, "Gone with the wind", 1000, "Margaret Mitchell");
        Book book2 = new Book(257, "Pride and Prejudice", 900, "Jane Austen");
        Book book3 = new Book(333, "The Mysterious Affair at Styles", 100, "Agatha Christie");
        Book book4 = new Book(47, "Mysterious", 100, "Mike Gordan");
        Smartphone smartphone1 = new Smartphone(5466, "Iphone 13 Pro", 86_000, "Apple");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(smartphone1);

        repo.removeById(10);
        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3, book4, smartphone1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveProductIfNotExist() {
        Repository repo = new Repository();

        Book book1 = new Book(10, "Gone with the wind", 1000, "Margaret Mitchell");
        Book book2 = new Book(257, "Pride and Prejudice", 900, "Jane Austen");
        Book book3 = new Book(333, "The Mysterious Affair at Styles", 100, "Agatha Christie");
        Book book4 = new Book(47, "Mysterious", 100, "Mike Gordan");
        Smartphone smartphone1 = new Smartphone(5466, "Iphone 13 Pro", 86_000, "Apple");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(smartphone1);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(100)
        );

    }

}