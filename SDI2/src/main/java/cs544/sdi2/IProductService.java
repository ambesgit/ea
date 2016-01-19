package cs544.sdi2;

public interface IProductService {
	public Product getProduct(int productNumber);
        public int getNumberInstock(int productNumber);
}
