package Models;

public class Ticket {
    private String movie;
    private int price;
    private String seat;


    public Ticket(String movie, int price, String seat) {
        this.movie = movie;
        this.price = price;
        this.seat = seat;
    }


    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
