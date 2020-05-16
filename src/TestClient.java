import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class TestClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		//obs.firts letar efter med efternamn och sen med id
		//man letar efter elever som heter Lundqvist och har id=4	
		Response response = client.target("http://localhost:8080/EleverManagement/webservice/elever/Lundqvist/4")
				.request().buildGet().invoke();
		
		System.out.println(response.readEntity(String.class));
		
	}

}
