package gameSimulater;

public class DiscountManager {

	
	public DiscountedProduct addDiscount(int id, Product product,String discountName, double discountPerCent) {
		DiscountedProduct discountedProduct = new DiscountedProduct(id,product.getName(),
				product.getType(),product.getPrice(),discountName,discountPerCent);
		
		System.out.println(product.getName()+ " ürünü %" + discountedProduct.getDiscountPerCent()+" indirimle "
				+ discountedProduct.getDiscountName()+" kampanyasıyla indirime girmiştir.");
		return discountedProduct;
	}
}

