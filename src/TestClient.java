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
		// man letar efter elever som heter Lundqvist och har id=4
		Response response = client.target("http://localhost:8080/EleverManagement/webservice/elever/Lundqvist/4")
				.request("application/JSON").buildGet().invoke();

		// Elever elever = response.readEntity(Elever.class);
		// System.out.println(elever);
	
		System.out.println(response.getHeaders().toString());
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

		response.close();

//		Elever nyElever = new Elever();
//		nyElever.setFirstName("Eva");
//		nyElever.setSurname("Adamsson");
//		nyElever.setSkola("Humanus");
//		nyElever.setKlass(1);
//
//		 //Entity nyEleverEntity = Entity.entity(nyElever, "application/XML");
//		Entity nyEleverEntity = Entity.entity(nyElever, "application/JSON");
//		response = client.target("http://localhost:8080/EleverManagement/webservice/elever").request().buildPost(nyEleverEntity).invoke();
//		System.out.println();
//		 System.out.println(response.readEntity(Elever.class).getId());
//		//System.out.println(response.readEntity(String.class));
//
//		response.close();
//
//		// får alla elever
//		response = client.target("http://localhost:8080/EleverManagement/webservice/elever").request("application/XML").buildGet().invoke();
//		System.out.println();
//		// System.out.println(response.readEntity(String.class));
//		List<Elever> eleverAlla = response.readEntity(new GenericType<List<Elever>>() {
//		});
//
//		for (Elever el : eleverAlla) {
//			System.out.println(el);
//		}
//		response.close();
	}

}
