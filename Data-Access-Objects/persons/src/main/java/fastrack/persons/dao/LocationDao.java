package fastrack.persons.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fastrack.persons.entity.Location;

public class LocationDao {
	public static Location get(Integer id) {
		Location location = new Location();
		try( Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/persons", "postgres",
				"bondstone")) {
			Statement st = connection.createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM person WHERE id = "+ id);
		    location = getData(rs).get(0);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return location;
	}
	
	private static List<Location> getData(ResultSet rs) throws SQLException {
		ArrayList<Location> results = new ArrayList<Location>();
		while(rs.next()) {
			results.add(new Location(rs.getInt("id"), rs.getString("city"),rs.getString("state"),rs.getString("country")));
		}
		return null;
	}

	public void save(Location location) {
		
	}
}
