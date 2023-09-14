package factorypattern;
public class MySQLConnection extends Connection {
	public MySQLConnection(String url) {
		super(url);
	}

	public void connect() {
		System.out.println(url + " MySQL.");
	}
}
