public class AnytownLibrary {

    public static void main(String[] args) {
        Book b1 = new Book("Title 1", "Author A");
        Book b2 = new Book("Title 2", "Author A");
        Book b3 = new Book("Title 3", "Author B");
        Book b4 = new Book("Title 4", "Author B");
        Book b5 = new Book("Title 5", "Author C");
        Book b6 = new Book("Title 6", "Author C");
        Book b7 = new Book("Title 7", "Author D");
        Book b8 = new Book("Title 8", "Author D");
        Book b9 = new Book("Title 9", "Author E");
        Book b10 = new Book("Title 10", "Author E");

        Member m1 = new Member("Member 1", 101, false);
        Member m2 = new Member("Member 2", 202, true);

        System.out.println("Member 1's Books: " + m1.getNumberOfBooks());
        System.out.println( m1.getBooks() );

        if (m1.borrowBook(b1)) System.out.println("Member m1 borrows book b1");
        else System.out.println("Borrow operation failed");

        if (m1.borrowBook(b2)) System.out.println("Member m1 borrows book b2");
        else System.out.println("Borrow operation failed");

        if (m1.borrowBook(b3)) System.out.println("Member m1 borrows book b3");
        else System.out.println("Borrow operation failed");

        System.out.println("\nMember 1's Books: " + m1.getNumberOfBooks());
        System.out.println( m1.getBooks() );

        if (m1.borrowBook(b4)) System.out.println("Member m1 borrows book b4");
        else System.out.println("Borrow operation failed");

        if (m1.returnBook(b1)) System.out.println("Member m1 returns book b1");
        else System.out.println("Return operation failed");

        if (m1.returnBook(b4)) System.out.println("Member m1 returns book b4");
        else System.out.println("Return operation failed");

        System.out.println("\nMember 1's Books: " + m1.getNumberOfBooks());
        System.out.println( m1.getBooks() );

        if (m2.borrowBook(b5)) System.out.println("Member m2 borrows book b5");
        else System.out.println("Borrow operation failed");

        if (m2.borrowBook(b6)) System.out.println("Member m2 borrows book b6");
        else System.out.println("Borrow operation failed");

        if (m2.borrowBook(b7)) System.out.println("Member m2 borrows book b7");
        else System.out.println("Borrow operation failed");

        if (m2.borrowBook(b8)) System.out.println("Member m2 borrows book b8");
        else System.out.println("Borrow operation failed");

        if (m2.borrowBook(b9)) System.out.println("Member m2 borrows book b9");
        else System.out.println("Borrow operation failed");

        if (m2.borrowBook(b10)) System.out.println("Member m2 borrows book b10");
        else System.out.println("Borrow operation failed");

        System.out.println("\nMember 2's Books: " + m2.getNumberOfBooks());
        System.out.println( m2.getBooks() );

        m1.returnAll(); m2.returnAll();
        System.out.println("Returning all books");
        System.out.println("Member 1's Books: " + m1.getNumberOfBooks());
        System.out.println("Member 2's Books: " + m2.getNumberOfBooks());

        System.out.println("\nBorrowing additional books");
        m1.borrowBook(b1); m1.borrowBook(b2); m1.borrowBook(b3);
        m2.borrowBook(b4); m2.borrowBook(b5); m2.borrowBook(b6);
        System.out.print("Member 1 has " + m1.getNumberOfBooks() + " books and ");
        System.out.println(m1.borrowsAvailable() + " borrows available");
        System.out.print("Member 2 has " + m2.getNumberOfBooks() + " books and ");
        System.out.println(m2.borrowsAvailable() + " borrows available");


    }
}