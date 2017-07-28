package fastrack.persons.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import fastrack.persons.entity.Interest;
import fastrack.persons.entity.Location;
import fastrack.persons.entity.Person;

public class PersonDao {
	
	public static Person get(Integer id) {
		Person person = new Person();
		try( Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/persons", "postgres",
				"bondstone")) {
			Statement st = connection.createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM person WHERE id = "+ id);
		    person = getData(rs).get(0);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return person;
	}
	
	private static List<Person> getData(ResultSet rs) throws SQLException {
		ArrayList<Person> result = new ArrayList<Person>();
		while(rs.next()) {
			result.add(new Person(rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("age"),
					rs.getInt("location_id")));
		}
		return result;
	}

	public void save(Person person) {
		try( Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/persons", "postgres",
				"bondstone")) {
			Statement st = connection.createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM person WHERE id = "+ id);
		    person = getData(rs).get(0);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Set<Person> findInterestGroup(Interest interest, Location location){
		return null;
	}
}
