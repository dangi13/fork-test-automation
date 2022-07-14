package fork.api.service.pokemon.model;

public class Type {
    private Integer slot;
    private Type_ type;
    public Integer getSlot() {
        return slot;
    }
    public void setSlot(Integer slot) {
        this.slot = slot;
    }
    public Type_ getType() {
        return type;
    }
    public void setType(Type_ type) {
        this.type = type;
    }
    
	@Override
	public String toString() {
		return "Type [slot=" + slot + ", type=" + type + "]";
	}
    
    
}