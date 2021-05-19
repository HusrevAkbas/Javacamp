package gameSimulater;

public class ProductManager {

	public void add(Product product) {
		System.out.println(product.getName() + " ürünü satışa sunuldu");
		
	}

	public void update(Product product) {
		System.out.println(product.getName() + " ürünü güncellendi");
	}

	public void delete(Product product) {
		System.out.println(product.getName() + " ürünü satıştan kaldırıldı");
	}
	
	public void sell(Product product, Player player) {
		System.out.println(product.getName()+" ürünü " + player.getFirstName() + " oyuncusuna satıldı!");
	}

}
