package bda.meteo.alert.topology;

import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.topology.TopologyBuilder;

import bda.meteo.alert.config.ConfigVars;
import bda.meteo.alert.config.PropertyParser;

public class MeteoTopology {
	
	public static void main(String[] args) throws Exception {
    	
    	String propFilePath = "local.meteo.properties";
    	System.out.println("Filepath: " + propFilePath);

        // Parse the properties file
        PropertyParser propertyParser = new PropertyParser();
        propertyParser.parsePropsFile(propFilePath);
    	
    	TopologyBuilder builder = new TopologyBuilder();
    	
        // Setup the Kafka Spout
        ConfigureKafkaSpout.configureKafkaSpout(builder, 
                propertyParser.getProperty(ConfigVars.KAFKA_CONNECTION_STRING),
                propertyParser.getProperty(ConfigVars.KAFKA_TOPIC_KEY),
                propertyParser.getProperty(ConfigVars.KAFKA_SPOUT_START_OFFSET_KEY),
                Integer.parseInt(propertyParser.getProperty(ConfigVars.KAFKA_SPOUT_PARALLELISM_KEY)),
                propertyParser.getProperty(ConfigVars.KAFKA_SPOUT_NAME_KEY),
                propertyParser.getProperty(ConfigVars.ZOOKEEPER_TEMP_DIR_KEY),
                propertyParser.getProperty(ConfigVars.KAFKA_GROUP_ID));

        // Setup the Hive Bolt
        // Configure the HiveBolt
        ConfigureHiveBolt.configureHiveStreamingBolt(builder,
                propertyParser.getProperty(ConfigVars.HIVE_BOLT_COLUMN_LIST_KEY),
                propertyParser.getProperty(ConfigVars.HIVE_BOLT_COLUMN_PARTITION_LIST_DELIMITER_KEY),
                propertyParser.getProperty(ConfigVars.HIVE_METASTORE_URI_KEY),
                propertyParser.getProperty(ConfigVars.HIVE_BOLT_DATABASE_KEY),
                propertyParser.getProperty(ConfigVars.HIVE_BOLT_TABLE_KEY),
                propertyParser.getProperty(ConfigVars.HIVE_BOLT_NAME_KEY),
                propertyParser.getProperty(ConfigVars.KAFKA_SPOUT_NAME_KEY),
                Integer.parseInt(propertyParser.getProperty(ConfigVars.HIVE_BOLT_PARALLELISM_KEY)),
                Boolean.parseBoolean(propertyParser.getProperty(ConfigVars.HIVE_BOLT_AUTO_CREATE_PARTITIONS_KEY)),
                Integer.parseInt(propertyParser.getProperty(ConfigVars.HIVE_BOLT_TXNS_PER_BATCH_KEY)),
                Integer.parseInt(propertyParser.getProperty(ConfigVars.HIVE_BOLT_MAX_OPEN_CONNECTIONS_KEY)),
                Integer.parseInt(propertyParser.getProperty(ConfigVars.HIVE_BOLT_BATCH_SIZE_KEY)),
                Integer.parseInt(propertyParser.getProperty(ConfigVars.HIVE_BOLT_IDLE_TIMEOUT_KEY)),
                Integer.parseInt(propertyParser.getProperty(ConfigVars.HIVE_BOLT_HEARTBEAT_INTERVAL_KEY)));
        
        Config config = new Config();

        // Submit the topology
        StormSubmitter.submitTopologyWithProgressBar(propertyParser.getProperty(ConfigVars.STORM_TOPOLOGY_NAME_KEY),
        		config, builder.createTopology());

    }
}
