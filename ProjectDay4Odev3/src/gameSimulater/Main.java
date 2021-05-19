package gameSimulater;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		//LocalDate date = LocalDate.parse("1992-05-16");
		//System.out.println(date.getMonthValue());
		
		Player player1 = new Player(1,"engin","demir",LocalDate.parse("1982-07-06"),"1111111111");
		Player player2 = new Player(2,"hüsrev","akbaş",LocalDate.parse("1992-05-16"),"2222222222");
		
		PlayerManager playerManager = new PlayerManager();
		playerManager.add(player1);
		playerManager.update(player2);
		playerManager.delete(player1);
		
		Product product1 = new Product(0,"Heart of Tarrasque","aksesuar",10);
		
		ProductManager productManager = new ProductManager();
		productManager.add(product1);
		productManager.update(product1);
		productManager.delete(product1);
		
		DiscountManager discountManager = new DiscountManager();
		DiscountedProduct discountedProduct = discountManager.addDiscount(1,product1, "bahar gelir hoşgelir", 10);
		productManager.update(discountedProduct);
		productManager.delete(discountedProduct);
		productManager.sell(discountedProduct, player2);

	}

}
