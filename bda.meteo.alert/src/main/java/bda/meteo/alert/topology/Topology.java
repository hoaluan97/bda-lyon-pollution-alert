//package bda.meteo.alert.topology;
//
//import org.apache.storm.Config;
//import org.apache.storm.StormSubmitter;
//import org.apache.storm.generated.AlreadyAliveException;
//import org.apache.storm.generated.AuthorizationException;
//import org.apache.storm.generated.InvalidTopologyException;
//import org.apache.storm.kafka.spout.KafkaSpout;
//import org.apache.storm.kafka.spout.KafkaSpoutConfig;
//import org.apache.storm.topology.TopologyBuilder;
//
//import bda.meteo.alert.operator.IndicesBolt;
//
//public class Topology {
//	
//	private static final String TOPIC_INDICES = "group-AMZOHONG-indices";
//    private static final String KAFKA_BROKER = "node-5:9092";
//	
//    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException  {
//    	final TopologyBuilder tp = new TopologyBuilder();
//    	
//    	tp.setSpout("indices_spout", new KafkaSpout<>(KafkaSpoutConfig.builder(KAFKA_BROKER, TOPIC_INDICES).build()), 1);
//    	tp.setBolt("indices_bolt", new IndicesBolt(), 1).shuffleGrouping("indices_spout");
//    	
//    	Config config = new Config();
//    	
//		StormSubmitter.submitTopology("IndicesTopology", config, tp.createTopology());
//		
//	}
//    
//}