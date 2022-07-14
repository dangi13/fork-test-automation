package fork.api.service.pokemon.model;

public class Result {
    private String name;
    private String url;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
	@Override
	public String toString() {
		return "Result [name=" + name + ", url=" + url + "]";
	}
    
}
