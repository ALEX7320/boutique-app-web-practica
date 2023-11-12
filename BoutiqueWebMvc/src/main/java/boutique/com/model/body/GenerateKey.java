package boutique.com.model.body;

public class GenerateKey {
	
	public Integer key_id;
	public String key_texto;
	public GenerateKey(Integer key_id, String key_texto) {
		super();
		this.key_id = key_id;
		this.key_texto = key_texto;
	}
	public GenerateKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getKey_id() {
		return key_id;
	}
	public void setKey_id(Integer key_id) {
		this.key_id = key_id;
	}
	public String getKey_texto() {
		return key_texto;
	}
	public void setKey_texto(String key_texto) {
		this.key_texto = key_texto;
	}
	
	

}
