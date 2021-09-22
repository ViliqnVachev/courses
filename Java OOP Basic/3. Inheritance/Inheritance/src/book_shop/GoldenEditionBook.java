package book_shop;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    protected void setPrice(double price) {
        double priceGoldenBook = price + price * 0.3;
        super.setPrice(priceGoldenBook);
    }
}
