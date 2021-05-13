
public class UserManager {

	public void add(User user) {
		System.out.println(user.userName + " kullanıcısı eklendi");
	}
	public void update(User userNew,User userOld) {
		System.out.println(userOld.userName + " değişen elemanlarla" 
							+ userNew.userName + " olarak değiştirildi");
	}
	public void delete(User user) {
		System.out.println(user.userName + " kullanıcısı silindi");
	}

}
