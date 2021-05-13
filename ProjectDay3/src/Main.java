
public class Main {

	public static void main(String[] args) {

		Instructor instructor1 = new Instructor("Çılgın eğitmen","engin","demiroğ","1");
		Student student1 = new Student("Garip öğrenci","hüsrev","akbas","06156");
		Student student2 = new Student("İnek öğrenci","hüsnü","bakbam","06157");
		
		UserManager userManager = new UserManager();
		
		userManager.add(student1); //student gönderdim çalıştı
		userManager.add(instructor1); // instructor gönderdim çalıştı
		userManager.update(student1, student2);
		userManager.delete(student2);
		
		System.out.println(student1.firstName);

	}

}
