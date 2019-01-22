package library.DTO;

public class RentBookDTO {
    private long myBookId;
    private long myCustomerId;

    public long getMyBookId() {
        return myBookId;
    }

    public void setMyBookId(long myBookId) {
        this.myBookId = myBookId;
    }

    public long getMyCustomerId() {
        return myCustomerId;
    }

    public void setMyCustomerId(long myCustomerId) {
        this.myCustomerId = myCustomerId;
    }
}
