package fork.api.test.pokemon;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fork.api.listeners.ExtentReporter;
import fork.api.service.pokemon.PokemonService;
import fork.api.service.pokemon.PokemonServiceActions;
import fork.api.service.pokemon.model.PokemonData;
import fork.api.service.pokemon.model.Result;
import fork.api.utils.http.IRestResponse;

public class PokemonTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(PokemonTest.class);

	@Test(testName = "FORK_01", description = "Retrieve all normal type pokemons")
	public void test_pokemon_having_normal_type() {
		IRestResponse<PokemonData> pokemonData = PokemonService.getPokemonList("?limit=30");
		Assert.assertEquals(pokemonData.getStatusCode(), 200);
		ExtentReporter.info(pokemonData.getResponse().prettyPrint());
		
		LOGGER.info("Filtering pokemon with type [normal]");
		List<Result> listOfPokemonsWithNormalType = PokemonServiceActions.getNormalPokemons(pokemonData.getBody().getResults());
		
		ExtentReporter.info("List of pokemons with [normal] type");
		ExtentReporter.info("Total: " + listOfPokemonsWithNormalType.size());
		ExtentReporter.info(listOfPokemonsWithNormalType.toString());
	}

}
