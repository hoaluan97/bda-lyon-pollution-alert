//package bda.meteo.alert.operator;
//
//import org.apache.storm.task.OutputCollector;
//import org.apache.storm.task.TopologyContext;
//import org.apache.storm.topology.IRichBolt;
//import org.apache.storm.topology.OutputFieldsDeclarer;
//import org.apache.storm.tuple.Fields;
//import org.apache.storm.tuple.Tuple;
//import org.slf4j.LoggerFactory;
//import bda.meteo.alert.network.NetworkWriter;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Map;
//
//public class ExitBolt implements IRichBolt {
//
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//		
//	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
//	
//    private OutputCollector collector;
//
//    public ExitBolt() {
//    }
//
//
//    @Override
//    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
//        this.collector = collector;
//        
//    }
//
//    @Override
//    public void execute(Tuple input) {
//        String n = input.getValueByField("json").toString();
//        
//		try {
//			Class.forName(driverName);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			System.exit(1);
//		}
// 
//		Connection con = DriverManager.getConnection(
//				"jdbc:hive://node-2:10000/p1926956", "p1926956", "");
//		Statement stmt;
//		try {
//			stmt = con.createStatement();
//			String tableName = "empdata";
//			stmt.executeQuery("drop table " + tableName);
//			ResultSet res = stmt.executeQuery("create table " + tableName
//					+ " (id int, name string, dept string)");
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
// 
//		
// 
////		// show tables
////		String sql = "show tables '" + tableName + "'";
////		System.out.println("Running: " + sql);
////		res = stmt.executeQuery(sql);
////		if (res.next()) {
////			System.out.println(res.getString(1));
////		}
//// 
////	    // describe table
////	    sql = "describe " + tableName;
////	    System.out.println("Running: " + sql);
////	    res = stmt.executeQuery(sql);
////	    while (res.next()) {
////	      System.out.println(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(2));
////	    }
//	    
//	    // load data into table
//	    // NOTE: filepath has to be local to the hive server
//	    // NOTE: /home/user/input.txt is a ctrl-A separated file with three fields per line
//	    String filepath = "/home/user/input.txt";
//	    sql = "load data local inpath '" + filepath + "' into table " + tableName;
//	    System.out.println("Running: " + sql);
//	    res = stmt.executeQuery(sql);
//	    
//		sql = "select * from empdata where id='1'";
//		res = stmt.executeQuery(sql);
//		// show tables
//		System.out.println("Running: " + sql);
//		res = stmt.executeQuery(sql);
//		while (res.next()) {
//			System.out.println(res.getString(1));
//			System.out.println(res.getString(2));
//			System.out.println(res.getString(3));
//		}
//		res.close();
//		stmt.close();
//		con.close();
//        
//        collector.ack(input);
//        return;
//    }
//
//    @Override
//    public void cleanup() {
//    }
//
//    @Override
//    public void declareOutputFields(OutputFieldsDeclarer declarer) {
//        declarer.declare(new Fields("json"));
//    }
//
//    @Override
//    public Map<String, Object> getComponentConfiguration() {
//        return null;
//    }
//}
