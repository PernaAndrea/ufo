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
		
		SightingDAO dao = new SightingDAO();
		
		List<String> formeUFO = dao.readShapes();
		
		for(String forma:formeUFO) {
			int count = dao.countByshape(forma);
			System.out.println("Ufo di forma "+forma +" sono : "+count);
		}
	}

}
