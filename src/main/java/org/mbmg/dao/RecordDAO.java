package org.mbmg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class RecordDAO implements RowMapper<Record>
{
    private JdbcTemplate jdbc;
    
    public void setDataSource(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }
    
    public void insert(Record r) {
        String SQL = "insert into Records (recordId, type, stationId, timestamp) values"
                + " (?, ?, ?, ?)";
        jdbc.update( SQL, r.getRecordId(), r.getType(), r.getStationID(),
                r.getTimestamp());
        // Need to insert map values in r.getChannelData()
    }
    
    public Record get() {
        return null;
    }
    
    public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
       Map<String, Double> map = new HashMap<>();
       map.put("Bla", new Double(9.8765));
      
       return new Record(rs.getLong("id"),
               rs.getString("RecordType"),
               rs.getString("StationId"),
               null,
               map
               );
    }
    
}
