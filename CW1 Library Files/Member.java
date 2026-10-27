public class Member {
    private String name;
    private int memberID;
    private Book[] books;
    private int numberOfBooks;
    private boolean goldMember;

    private static final int MAX_BOOKS = 5;

    public Member(String aName, int aMemberID, boolean goldStatus) {
       this.name = aName;
       this.memberID = aMemberID;
       this.goldMember = goldStatus;
       this.numberOfBooks = 0;
       this.books = new Book[Member.MAX_BOOKS];
    }

    public String getMember() {
       return this.name + " (" + this.memberID + ")";
    }

    public String getBooks() {
       String outputStr = "";
       for (Book book : this.books) {
           if (book != null) {
               outputStr = outputStr + book + "\n";
           }
       }
       return outputStr;
    }

    public int getNumberOfBooks() {
       return this.numberOfBooks;
    }

    public boolean getGoldStatus() {
       return this.goldMember;
    }

    public boolean borrowBook(Book aBook) {
       int maxBooks = 3;
       if (this.getGoldStatus()) {
           maxBooks = Member.MAX_BOOKS;
       }

       if (aBook == null || aBook.isOnLoan()) {
           return false;
       }

       if (this.getNumberOfBooks() >= maxBooks) {
           return false;
       }

       for (int i = 0; i < Member.MAX_BOOKS; i++) {
           if (this.books[i] == null) {
               this.books[i] = aBook;
               this.numberOfBooks++;
               aBook.bookIsBorrowed();
               return true;
           }
       }

       return false;
    }

    public boolean returnBook(Book aBook) {
       for (int i = 0; i < Member.MAX_BOOKS; i++) {
           if (this.books[i] != null
                   && this.books[i].getTitle().equals(aBook.getTitle())
                   && this.books[i].getAuthor().equals(aBook.getAuthor())) {
               this.books[i] = null;
               this.numberOfBooks--;
               aBook.bookIsReturned();
               return true;
           }
       }
       return false;
    }

    public void returnAll() {
       for (int i = 0; i < Member.MAX_BOOKS; i++) {
           Book book = this.books[i];
           if (book != null) {
               returnBook(book);
           }
       }
    }

    public int borrowsAvailable() {
       int maxBooks = this.getGoldStatus() ? Member.MAX_BOOKS : 3;
       return maxBooks - this.getNumberOfBooks();
    }
}