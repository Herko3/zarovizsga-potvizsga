package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private MariaDbDataSource dataSource;

    public PeopleDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }


    public String findIpByName(String firstName, String lastName) {
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?")
                ){
            stmt.setString(1,firstName);
            stmt.setString(2,lastName);

            return getIPByPreparedStatement(stmt);

        } catch (SQLException se){
            throw new IllegalStateException("Cannot connect");
        }
    }

    private String getIPByPreparedStatement(PreparedStatement stmt){
        try(ResultSet rs = stmt.executeQuery()){
            if(rs.next()){
                return rs.getString("ip_address");
            }
        } catch (SQLException se){
            throw new IllegalStateException("Cannot query");
        }
        throw new IllegalArgumentException("No data with that name");
    }
}
