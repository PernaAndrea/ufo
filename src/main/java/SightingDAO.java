import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {
	
	//stringa antipatica dovessi avere piu database , dovrei spotarmi in una classe a parte
	//String  jdbcURL ="jdbc:mysql://localhost/ufo_sightings?user=root&password=And13rea4";
	
	public List<String> readShapes(){
		
		Connection conn;
		try {
			conn = DBConnect.getConnection();
	
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
		
		st.close();
		conn.close();
		return formeUFO;
		
			} catch (SQLException e) {
				throw new RuntimeException("DataBase error readShapes",e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//	return null;
		}
	}

	public int countByshape(String shape) {
		
		try {
			Connection conn = DBConnect.getConnection();
		String sql2 = "SELECT COUNT(*) AS cnt FROM sighting WHERE shape= ? ";
		
		
		PreparedStatement st2 = conn.prepareStatement(sql2);
		//dopo lo statement e prima di eseguirlo imposto il parametro o i paramtri fosssero piu di 1 (parametro = ?) 
		st2.setString(1, shape);
		ResultSet res2 =st2.executeQuery();
		
		res2.first();
		int count =res2.getInt("cnt");
		
	//	System.out.println("Ufo di forma "+ shape+" sono : "+count);
		
		st2.close();
		conn.close();
		
		return count;
		
		}catch(SQLException e) {
			throw new RuntimeException("DataBase error countByshape",e);
		}
	
	}
}
