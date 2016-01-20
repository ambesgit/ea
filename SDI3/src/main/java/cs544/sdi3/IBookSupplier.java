package cs544.sdi3;

public interface IBookSupplier {
	public double computePrice(String isbn);
	public void order(Book book);
}
