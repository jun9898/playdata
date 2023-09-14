package factorypattern;
public class OracleConnection extends Connection {
	public OracleConnection(String url) {
		super(url);
	}

	public void connect() {
		System.out.println(url + "Oracle.");
	}
}
