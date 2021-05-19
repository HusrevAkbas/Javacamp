package gameSimulater;

public class PlayerManager {

	public void add(Player player) {
		CheckIfRealPersonManager checkIfRealPersonManager = new CheckIfRealPersonManager();
		
		if(checkIfRealPersonManager.isRealPerson(player)) {			
			System.out.println(player.getFirstName() + " oyuncusu eklendi");			
		} else {
			System.out.println(player.getFirstName() + " oyuncusu bilgileri onaylanmadığı için eklenmedi");
		}
	}
	public void update(Player player) {
		System.out.println(player.getFirstName() + " oyuncusu güncellendi");
	}
	public void delete(Player player) {
		System.out.println(player.getFirstName() + " oyuncusu silindi");
	}
}
