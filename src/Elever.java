import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Elever {
	
	private int id;
	private String firstName;
	private String surname;
	private String skola;
	private int klass;

//	public Elever() {}

	/**
	 * @author Danijela
	 * 
	 * @param firstName  fornamn
	 * @param surname	efternamn
	 * @param skola 	skola
	 * @param klass 	klass
	 */
//	public Elever(String firstName, String surname, String skola, int klass) {
//		this.firstName = firstName;
//		this.surname = surname;
//		this.skola = skola;
//		this.klass = klass;
//	}

	/**
	 * @author Danijela
	 */
	public String toString() {
		return "Elev:"  + this.firstName + " " + this.surname + ", "+ "id:" + this.id + ", " +"skola: "+ this.skola + ", "
				+ " klass:"+this.klass;
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id id
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return fornamn
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName efternamn
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return efternamn
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * 
	 * @param surname efternamn
	 */

	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * 
	 * @return skola
	 */

	public String getSkola() {
		return skola;
	}

	/**
	 * 
	 * @param skola skola
	 */

	public void setSkola(String skola) {
		this.skola = skola;
	}

	/**
	 * 
	 * @return klass 
	 */

	public int getKlass() {
		return klass;
	}

	/**
	 * 
	 * @param klass klass
	 */
	public void setKlass(int klass) {
		this.klass = klass;
	}
}
