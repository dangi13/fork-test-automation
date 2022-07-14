package fork.api.service.pokemon;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fork.api.listeners.ExtentReporter;
import fork.api.model.Endpoint;
import fork.api.service.pokemon.model.PokemonData;
import fork.api.utils.common.Config;
import fork.api.utils.http.IRestResponse;
import fork.api.utils.http.RequestType;
import fork.api.utils.http.RestClient;
import fork.api.utils.http.RestResponse;
import io.restassured.response.Response;

public class PokemonService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PokemonService.class);
	private static final String BASE_URL = Config.getProperty("base.url.pokemon");
	private static final Map<String, Endpoint> OPERATIONS = new HashMap<String, Endpoint>() {
		private static final long serialVersionUID = 1L;
		{
			put("getPokemonList", new Endpoint(BASE_URL + "/api/v2/pokemon", RequestType.GET));
		}
	};

	/**
	 *  It will retrieve data for pokemons.
	 * @param searchParam e.g ?limit=30
	 * @return PokemonData
	 */
	public static IRestResponse<PokemonData> getPokemonList(String searchParam) {
		LOGGER.info("Getting pokemon list for search params", searchParam);
		ExtentReporter.info("Getting pokemon list");
		Endpoint endpointDetails = OPERATIONS.get("getPokemonList");
		String route = endpointDetails.getRoute() + searchParam;
		Response response = RestClient.submitRequest(route, endpointDetails.getRequestType());

		return new RestResponse<>(PokemonData.class, response);
	}
}
