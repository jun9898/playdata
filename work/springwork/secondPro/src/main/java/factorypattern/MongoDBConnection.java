package factorypattern;
public class MongoDBConnection extends Connection {
	public MongoDBConnection(String url) {
		super(url);
	}

	public void connect() {
		System.out.println(url + " MongoDB.");
	}
}
