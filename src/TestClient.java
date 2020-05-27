import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;

/**
 * 
 * @author danijela
 *
 */

public class TestClient {

	public static void main(String[] args) {

		/**
		 * @author danijela hela klass
		 */

		Client client = ClientBuilder.newClient();
		// obs.firts letar efter med efternamn och sen med id
		// man letar efter elever som heter Lundqvist och har id=507
		//testa med Lundqvist 57 för att få status code 404
		Response response = client.target("http://localhost:8080/EleverManagement/webservice/elever/Lundqvist/507")
				.request("application/JSON").buildGet().invoke();

	
		System.out.println(response.getHeaders().toString());
		System.out.println("Status code: "+response.getStatus());
		if(response.getStatus()==200) {
			System.out.println("Resultat fran databas: "+response.readEntity(String.class));
		}		
		else if(response.getStatus()==404) {
			System.out.println("Elever finns inte i databasen.");
		}
		System.out.println();
		response.close();

		// skapar en ny elev och skriva ut
		Elever nyElever = new Elever();
		nyElever.setFirstName("Anna21");
		nyElever.setSurname("Svensson");
		nyElever.setSkola("Yrgo");
		nyElever.setKlass(1);
//
//		Entity nyEleverEntity = Entity.entity(nyElever, "application/XML");
		Entity nyEleverEntity = Entity.entity(nyElever, "application/JSON");
		response = client.target("http://localhost:8080/EleverManagement/webservice/elever").request().buildPost(nyEleverEntity).invoke();
		System.out.println("Om man skapar en ny elev får man code status: "+ response.getStatus());
		if(response.getStatus()==201) {
			//får man ProcessingException
			//System.out.println(response.readEntity(Elever.class).getId());
			//får code status 201
			System.out.println(response.readEntity(String.class));
		}

		response.close();
//
//		// skriv ut alla elever
		response = client.target("http://localhost:8080/EleverManagement/webservice/elever").request("application/XML").buildGet().invoke();
		System.out.println();
		// System.out.println(response.readEntity(String.class));
		List<Elever> eleverAlla = response.readEntity(new GenericType<List<Elever>>() {
		});

		for (Elever el : eleverAlla) {
			System.out.println(el);
		}
		response.close();
	}

}
