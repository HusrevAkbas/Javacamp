package gameSimulater;

public class CheckIfRealPersonManager implements CheckIfRealPersonService {

	@Override
	public boolean isRealPerson(Player player) {
		
		//System.out.println("tc no: " + player.getNationalId()+", adı: " + player.getFirstName()+", soyadı: "+ player.getLastName()+ ", doğum yılı: " + player.getBirthday().getYear());
		//mernis kodları buraya
		boolean result = true;
		if(result) {
			//System.out.println("kişi onaylandı");
			return true;
		} else {
		//System.out.println("hatalı kişi bilgisi");
		return false;			
		}
	}

}
