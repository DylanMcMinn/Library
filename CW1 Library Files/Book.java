public class Book {
    private String title;
    private String author;
    private boolean borrowed;

    public Book(String aTitle, String anAuthor) {
        this.title = aTitle;
        this.author = anAuthor;
        this.borrowed = false;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void bookIsBorrowed() {
        this.borrowed = true;
    }

    public void bookIsReturned() {
        this.borrowed = false;
    }

    public boolean isBorrowed() {
        return this.borrowed;
    }

    public boolean isOnLoan() {
        return this.borrowed;
    }

    @Override
    public String toString() {
        return this.title + " by " + this.author;
    }
}