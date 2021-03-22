import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String  jdbcURL ="jdbc:mysql://localhost/ufo_sightings?user=root&password=And13rea4";
		
		try {
			//ora abbiamo aperto una connessione
			Connection conn = DriverManager.getConnection(jdbcURL);
			//qui in mezzo ci lavoro
			//per collegare la mia queary al server
			String sql ="SELECT DISTINCT shape FROM sighting WHERE shape<>'' ORDER BY shape ASC";
			PreparedStatement st = conn.prepareStatement(sql);
			
			
			ResultSet res = st.executeQuery(sql);
			
			//me li salvo in una mia struttura leggendoli uno alla volta 
			List<String> formeUFO =new ArrayList<String>();
			while(res.next()) {
				String forma = res.getString("shape");
				formeUFO.add(forma);
			}
			
			System.out.println(formeUFO);
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
