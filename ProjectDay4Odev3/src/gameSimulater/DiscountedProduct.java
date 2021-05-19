package gameSimulater;

public class DiscountedProduct extends Product {

	int id;
	String discountName;
	double discountPerCent;
	double priceAfterDiscount;
	
	public DiscountedProduct(int id, String name, String type, double price, String discountName,
			double discountPerCent) {
		super(id, name, type, price);
		this.id = id;
		this.discountName = discountName;
		this.discountPerCent = discountPerCent;
		this.priceAfterDiscount = price - (price * discountPerCent/100);
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public double getDiscountPerCent() {
		return discountPerCent;
	}

	public void setDiscountPerCent(double discountPerCent) {
		this.discountPerCent = discountPerCent;
	}

	public double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}
}
