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
		// testa med Lundqvist 57 för att få status code 404
		// status code 200- elev finns i databas
		Response response = client.target("http://localhost:8080/EleverManagement/webservice/elever/Lundqvist/507")
				.request("application/JSON").buildGet().invoke();
		// om man vill ha respons i xml format
		// .request("application/xml").buildGet().invoke();

//skriv ut Headers, status code och resultat från databas
		System.out.println(response.getHeaders().toString());
		System.out.println("Status code: " + response.getStatus());
		if (response.getStatus() == 200) {
			System.out.println("Resultat fran databas: " + response.readEntity(String.class));
		} else if (response.getStatus() == 404) {
			System.out.println("Elever finns inte i databasen.");
		}
		System.out.println();
		response.close();

		// skapar en ny elev och skriva ut
		Elever nyElever = new Elever();
		nyElever.setFirstName("Anna22");
		nyElever.setSurname("Svensson");
		nyElever.setSkola("Yrgo");
		nyElever.setKlass(1);
//
//		Entity nyEleverEntity = Entity.entity(nyElever, "application/XML");
		Entity nyEleverEntity = Entity.entity(nyElever, "application/JSON");
		response = client.target("http://localhost:8080/EleverManagement/webservice/elever").request()
				.buildPost(nyEleverEntity).invoke();

		// skriver ut status kod nar programmet skapar en ny elev
		System.out.println("Om man skapar en ny elev får man code status: " + response.getStatus());
		if (response.getStatus() == 201) {
			// får man ProcessingException
			// System.out.println(response.readEntity(Elever.class).getId());
			// får code status 201
			System.out.println(response.readEntity(String.class));
		}

		response.close();
		//
//		// skriv ut alla elever
		response = client.target("http://localhost:8080/EleverManagement/webservice/elever").request("application/XML")
				.buildGet().invoke();
		System.out.println();
		// System.out.println(response.readEntity(String.class));
		List<Elever> eleverAlla = response.readEntity(new GenericType<List<Elever>>() {
		});

		for (Elever el : eleverAlla) {
			System.out.println(el);
		}
		response.close();

		// delete elev

		response = client.target("http://localhost:8080/EleverManagement/webservice/elever/834").request().buildDelete()
				.invoke();
		System.out.println("\nRadera status ar " + response.getStatus());
		if (response.getStatus() == 404) {
			System.out.println("Elev finns inte i databas.");
		} else if (response.getStatus() == 204) {
			System.out.println("Elev har blivit borttagen.");
		}

		response.close();

		// skriv ut alla elever
		response = client.target("http://localhost:8080/EleverManagement/webservice/elever").request("application/JSON")
				.buildGet().invoke();
		System.out.println();
		// System.out.println(response.readEntity(String.class));
		List<Elever> eleverAllaDelete = response.readEntity(new GenericType<List<Elever>>() {
		});

		for (Elever el : eleverAllaDelete) {
			System.out.println(el);
		}
		response.close();

		// uppdate elevs info,efternamn och ar
		Elever updatedElever = new Elever();
		updatedElever.setSurname("ny efternamn5");
		updatedElever.setKlass(2);

		Entity eEntity = Entity.entity(updatedElever, "application/JSON");

		// skriv ut som JSON
		response = client.target("http://localhost:8080/EleverManagement/webservice/elever/508").request()
				.buildPut(eEntity).invoke();

		// Skriv ut som xml
		// response =
		// client.target("http://localhost:8080/EleverManagement/webservice/elever/508").request("application/xml").buildPut(eEntity).invoke();

		System.out.println("Uppdatera status ar " + response.getStatus());
		System.out.println(response.readEntity(String.class));
		response.close();

		// skriv ut alla elever
		response = client.target("http://localhost:8080/EleverManagement/webservice/elever").request("application/JSON")
				.buildGet().invoke();
		System.out.println();
		// System.out.println(response.readEntity(String.class));
		List<Elever> elevUppdate = response.readEntity(new GenericType<List<Elever>>() {
		});

		for (Elever el : elevUppdate) {
			System.out.println(el);
		}
		response.close();
	}

}
