package factorypattern;
public class ConnectionFactory {
	public Connection getConnection(String str) {
		String url = str.toLowerCase();
		// 지금은 if문을 이용해서 객체를 가져오지만 자동으로 객체가 만들어질 수 있도록
		if (url.indexOf("oracle") >= 0) {
			return new OracleConnection(url);
		} else if (url.indexOf("mysql") >= 0) {
			return new MySQLConnection(url);
		} else if (url.indexOf("mongo") >= 0) {
			return new MongoDBConnection(url);
		} else {
			return null;
		}
	} 	
}
