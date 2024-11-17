public class BookPublishers {
    private int book_publisher;
    private int book_id;
    private int publisher_id;


    
    public BookPublishers(int book_publisher, int book_id, int publisher_id) {
        this.book_publisher = book_publisher;
        this.book_id = book_id;
        this.publisher_id = publisher_id;
    }

    public int getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(int book_publisher) {
        this.book_publisher = book_publisher;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }


    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }


    
}
