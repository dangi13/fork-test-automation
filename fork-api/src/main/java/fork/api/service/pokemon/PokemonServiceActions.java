package fork.api.service.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import fork.api.service.pokemon.model.Pokemon;
import fork.api.service.pokemon.model.Result;
import fork.api.service.pokemon.model.Type;
import fork.api.utils.http.IRestResponse;
import fork.api.utils.http.RequestType;
import fork.api.utils.http.RestClient;
import fork.api.utils.http.RestResponse;
import io.restassured.response.Response;

/**
 * This class will contain the logics that will be helping us in testing the scenario.
 * @author jaikant
 *
 */
public class PokemonServiceActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(PokemonServiceActions.class);


	/** It will filter out the pokemons having type as [normal]
	 * @param results 
	 * @return List<Result>
	 */
	public static List<Result> getNormalPokemons(List<Result> results) {
		LOGGER.info("PokemonServiceActions >> getNormalPokemons()");
		List<Result> listOfPokemonsWithNormalType = new ArrayList<Result>();
		
		results.forEach(result -> {			
			Response response = RestClient.submitRequest(result.getUrl(), RequestType.GET);
			Assert.assertEquals(response.getStatusCode(), 200);
			IRestResponse<Pokemon> pokemon = new RestResponse<>(Pokemon.class, response);
			Optional<Type> pokemonWithNormalType = pokemon.getBody().getTypes().stream().filter(pokType -> pokType.getType().getName().trim().equals("normal")).findAny();
			if (pokemonWithNormalType.isPresent())		
				listOfPokemonsWithNormalType.add(result);
		}); 
		
		LOGGER.info("Normal pokemon list: ", listOfPokemonsWithNormalType.toString());
		
		return listOfPokemonsWithNormalType;
	}
}
