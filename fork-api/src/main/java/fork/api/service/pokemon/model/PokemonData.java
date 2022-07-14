package fork.api.service.pokemon.model;

import java.util.ArrayList;
import java.util.List;

public class PokemonData {
	private Integer count;
	private String next;
	private Object previous;
	private List<Result> results = new ArrayList<Result>();

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public Object getPrevious() {
		return previous;
	}

	public void setPrevious(Object previous) {
		this.previous = previous;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "PokemonData [count=" + count + ", next=" + next + ", previous=" + previous + ", results=" + results
				+ "]";
	}
	
}