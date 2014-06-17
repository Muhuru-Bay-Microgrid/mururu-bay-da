package org.mbmg.dao;
import org.springframework.jdbc.core.JdbcTemplate;


public class DBSetup{

        private JdbcTemplate jdbcTemplate;
        
        public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
         }
        
        
        public void createTable(String table) {
            jdbcTemplate.execute("");
        }
        
        public void deleteTable() {
            jdbcTemplate.execute("");
        }
        
    
    
}
