import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnytownLibraryTest {

   @Test
   public void memberIsCreated() {
       Member m1 = new Member("Person", 123, false);
       assertEquals("Person (123)", m1.getMember());
   }

   @Test
   public void differentMemberIsCreated() {
       Member member = new Member("Someone Else", 456, false);

       assertNotNull(member);
       assertEquals("Someone Else (456)", member.getMember());
       assertEquals(0, member.getNumberOfBooks());
       assertFalse(member.getGoldStatus());
   }

   @Test
   public void bookIsBorrowed() {
       Member member = new Member("New User", 1, false);
       Book book = new Book("Test Book", "Test Author");

       boolean result = member.borrowBook(book);

       assertTrue(result);
       assertEquals(1, member.getNumberOfBooks());
   }

   @Test
   public void multipleBooksBorrowed() {
       Member member = new Member("New User", 1, false);
       Book book1 = new Book("Test Book 1", "Test Author 1");
       Book book2 = new Book("Test Book 2", "Test Author 2");

       member.borrowBook(book1);
       member.borrowBook(book2);

       assertEquals(2, member.getNumberOfBooks());
   }

   @Test
   public void bookIsAlreadyBorrowed() {
       Member member1 = new Member("Person One", 123, false);
       Member member2 = new Member("Person Two", 456, false);

       Book book = new Book("Test Book", "Test Author");

       boolean firstBorrow = member1.borrowBook(book);
       boolean secondBorrow = member2.borrowBook(book);

       assertTrue(firstBorrow);
       assertFalse(secondBorrow);
   }

   @Test
   public void bookCanBeBorrowedAfterReturn() {
       Member member1 = new Member("Person One", 123, false);
       Member member2 = new Member("Person Two", 456, false);

       Book book = new Book("Test Book", "Test Author");

       boolean firstBorrow = member1.borrowBook(book);
       boolean bookReturned = member1.returnBook(book);
       boolean secondBorrow = member2.borrowBook(book);

       assertTrue(firstBorrow);
       assertTrue(bookReturned);
       assertTrue(secondBorrow);
   }

   @Test
   public void onlyGoldMembersCanBorrowFourBooks() {
       Member nonGoldMember = new Member("Non Gold", 123, false);
       Member goldMember = new Member("Gold", 456, true);

       Book book1 = new Book("Book 1", "Author");
       Book book2 = new Book("Book 2", "Author");
       Book book3 = new Book("Book 3", "Author");
       Book book4 = new Book("Book 4", "Author");
       Book book5 = new Book("Book 5", "Author");
       Book book6 = new Book("Book 6", "Author");
       Book book7 = new Book("Book 7", "Author");
       Book book8 = new Book("Book 8", "Author");

       nonGoldMember.borrowBook(book1);
       nonGoldMember.borrowBook(book2);
       nonGoldMember.borrowBook(book3);
       boolean nonGoldFourthBorrow = nonGoldMember.borrowBook(book4);

       goldMember.borrowBook(book5);
       goldMember.borrowBook(book6);
       goldMember.borrowBook(book7);
       boolean goldFourthBorrow = goldMember.borrowBook(book8);

       assertFalse(nonGoldFourthBorrow);
       assertTrue(goldFourthBorrow);
   }

   @Test
   public void allBooksAreReturned() {
       Member member = new Member("Person", 123, false);

       Book book1 = new Book("Book 1", "Author 1");
       Book book2 = new Book("Book 2", "Author 2");

       member.borrowBook(book1);
       member.borrowBook(book2);
       member.returnAll();

       assertEquals(0, member.getNumberOfBooks());
   }

   @Test
   public void userCanBorrowAdditionalBooks() {
       Member nonGoldMember = new Member("Non Gold", 123, false);
       Member goldMember = new Member("Gold", 456, true);

       Book book1 = new Book("Book 1", "Author");
       Book book2 = new Book("Book 2", "Author");
       Book book3 = new Book("Book 3", "Author");
       Book book4 = new Book("Book 4", "Author");
       Book book5 = new Book("Book 5", "Author");
       Book book6 = new Book("Book 6", "Author");

       nonGoldMember.borrowBook(book1);
       nonGoldMember.borrowBook(book2);
       nonGoldMember.borrowBook(book3);

       goldMember.borrowBook(book4);
       goldMember.borrowBook(book5);
       goldMember.borrowBook(book6);

       assertEquals(0, nonGoldMember.borrowsAvailable());
       assertEquals(2, goldMember.borrowsAvailable());
   }
}