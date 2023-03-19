package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class ManagerTest {

    @Test
    public void testProductFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Gone with the wind", 1000, "Margaret Mitchell");
        Book book2 = new Book(20, "Pride and Prejudice", 900, "Jane Austen");
        Book book3 = new Book(323, "The Mysterious Affair at Styles", 100, "Agatha Christie");
        Book book4 = new Book(45, "Mysterious", 100, "Mike Gordan");
        Smartphone smartphone1 = new Smartphone(588, "Iphone 13 Pro", 86_000, "Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("Mysterious");
        Product[] expected = {book3, book4};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testProductFoundOne() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(10, "Gone with the wind", 1000, "Margaret Mitchell");
        Book book2 = new Book(40, "Pride and Prejudice", 900, "Jane Austen");
        Book book3 = new Book(80, "The Mysterious Affair at Styles", 100, "Agatha Christie");
        Smartphone smartphone1 = new Smartphone(100, "Iphone 13 Pro", 86_000, "Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("Prejudice");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testProductNotFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(10, "Gone with the wind", 1000, "Margaret Mitchell");
        Book book2 = new Book(256, "Pride and Prejudice", 900, "Jane Austen");
        Book book3 = new Book(377, "The Mysterious Affair at Styles", 100, "Agatha Christie");
        Smartphone smartphone1 = new Smartphone(444, "Iphone 13 Pro", 86_000, "Apple");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);


        Product[] actual = manager.searchBy("Alice");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

}