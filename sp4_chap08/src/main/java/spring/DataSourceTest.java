package spring;

public class DataSourceTest {
	 @Autowired
	    private DataSource dataSource;
	    
	    @Test
	    public void testConnection() {
	      
	        try(Connection con = dataSource.getConnection();){
	            
	            System.out.println("con = " + con);
	            
	        } catch(Exception e) {
	            
	            e.printStackTrace();
	            
	        }
	        
	    }
}
