package test;

public class TestDTO {
	private String id;
	private String pass;
	public TestDTO() { }

	public TestDTO(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "TestDTO [id=" + id + ", pass=" + pass + "]";
	}

	public String getId() {
		System.out.println("-------getId---------");
		return id;
	}

	public void setId(String id) {
		System.out.println("**********setId***********");
		this.id = id;
	}

	public String getPass() {
		System.out.println("-------getPass---------");
		return pass;
	}

	public void setPass(String pass) {
		System.out.println("**********setPass***********");
		this.pass = pass;
	}

	
	
	
	
	
	

}
