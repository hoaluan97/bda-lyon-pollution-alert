package bda.meteo.alert.config;

public class ConfigVars {
	    
    // Zookeeper
    public static final String ZOOKEEPER_TEMP_DIR_KEY = "zookeeper.temp.dir";
    public static final String ZOOKEEPER_PORT_KEY = "zookeeper.port";
    public static final String ZOOKEEPER_HOSTNAME_KEY = "zookeeper.hostname";
    public static final String ZOOKEEPER_CONNECTION_STRING_KEY = "zookeeper.connection.string";
    
    // Kafka
    public static final String KAFKA_TOPIC_KEY = "kafka.topic";
    public static final String KAFKA_HOSTNAME_KEY = "kafka.hostname";
    public static final String KAFKA_PORT_KEY = "kafka.port";
    public static final String KAFKA_CONNECTION_STRING = "kafka.connection.string";
    public static final String KAFKA_GROUP_ID = "kafka.group.id";
    
    // Kafka Spout
    public static final String KAFKA_SPOUT_START_OFFSET_KEY = "kafka.spout.start.offset";
    public static final String KAFKA_SPOUT_NAME_KEY = "kafka.spout.name";
    public static final String KAFKA_SPOUT_PARALLELISM_KEY = "kafka.spout.parallelism";
    public static final String KAFKA_SPOUT_SCHEME_CLASS_KEY = "kafka.spout.scheme.class";
    
    // Kafka Test - used for Unit Testing
    public static final String KAFKA_TEST_TEMP_DIR_KEY = "kafka.temp.dir";
    public static final String KAFKA_TEST_BROKER_LIST_KEY = "kafka.broker.list";
    public static final String KAFKA_TEST_BROKER_ID_KEY = "kafka.broker.id";
    public static final String KAFKA_TEST_MSG_COUNT_KEY = "kafka.test.msg.count";
    public static final String KAFKA_TEST_MSG_PAYLOAD_KEY = "kafka.test.msg.payload";
    
    // Hive
    public static final String HIVE_METASTORE_HOSTNAME_KEY = "hive.metastore.hostname";
    public static final String HIVE_METASTORE_PORT_KEY = "hive.metastore.port";
    public static final String HIVE_METASTORE_URI_KEY = "hive.metastore.uri";
    public static final String HIVE_METASTORE_DERBY_DB_DIR_KEY = "hive.metastore.derby.db.dir";
    public static final String HIVE_SCRATCH_DIR_KEY = "hive.scratch.dir";
    public static final String HIVE_SERVER2_HOSTNAME_KEY = "hive.server2.hostname";
    public static final String HIVE_SERVER2_PORT_KEY = "hive.server2.port";
    public static final String HIVE_WAREHOUSE_DIR_KEY = "hive.warehouse.dir";
    
    // Hive Bolt
    public static final String HIVE_BOLT_DATABASE_KEY = "hive.bolt.database";
    public static final String HIVE_BOLT_TABLE_KEY = "hive.bolt.table";
    public static final String HIVE_BOLT_NAME_KEY = "hive.bolt.name";
    public static final String HIVE_BOLT_COLUMN_LIST_KEY = "hive.bolt.column.list";
    public static final String HIVE_BOLT_PARTITION_LIST_KEY = "hive.bolt.partition.list";
    public static final String HIVE_BOLT_COLUMN_PARTITION_LIST_DELIMITER_KEY = 
            "hive.bolt.column.partition.list.delimiter";
    public static final String HIVE_BOLT_PARALLELISM_KEY = "hive.bolt.parallelism";
    public static final String HIVE_BOLT_AUTO_CREATE_PARTITIONS_KEY = "hive.bolt.auto.create.partitions";
    public static final String HIVE_BOLT_TXNS_PER_BATCH_KEY = "hive.bolt.txns.per.batch";
    public static final String HIVE_BOLT_MAX_OPEN_CONNECTIONS_KEY = "hive.bolt.max.open.connections";
    public static final String HIVE_BOLT_BATCH_SIZE_KEY = "hive.bolt.batch.size";
    public static final String HIVE_BOLT_IDLE_TIMEOUT_KEY = "hive.bolt.idle.timeout";
    public static final String HIVE_BOLT_HEARTBEAT_INTERVAL_KEY = "hive.bolt.heartbeat.interval";
    
    // Hive Test - used for Unit Testing
    public static final String HIVE_TEST_TABLE_LOCATION_KEY = "hive.test.table.location";
    public static final String HIVE_TEST_HDFS_SESSION_PATH_KEY = "hive.test.hdfs.session.path";

    //HDFS
    public static final String HDFS_NAMENODE_PORT_KEY = "hdfs.namenode.port";
    public static final String HDFS_TEMP_DIR_KEY = "hdfs.temp.dir";
    public static final String HDFS_NUM_DATANODES_KEY = "hdfs.num.datanodes";
    public static final String HDFS_ENABLE_PERMISSIONS_KEY = "hdfs.enable.permissions";
    public static final String HDFS_FORMAT_KEY = "hdfs.format";
    
    // HDFS Bolt
    public static final String HDFS_BOLT_DFS_URI_KEY = "hdfs.bolt.dfs.uri";
    public static final String HDFS_BOLT_NAME_KEY = "hdfs.bolt.name";
    public static final String HDFS_BOLT_FIELD_DELIMITER_KEY = "hdfs.bolt.field.delimiter";
    public static final String HDFS_BOLT_OUTPUT_LOCATION_KEY = "hdfs.bolt.output.location";
    public static final String HDFS_BOLT_PARALLELISM_KEY = "hdfs.bolt.parallelism";
    public static final String HDFS_BOLT_SYNC_COUNT_KEY = "hdfs.bolt.sync.count";
    
    // HDFS Bolt RotationPolicy - Time Based
    public static final String HDFS_BOLT_USE_TIME_BASED_FILEROTATIONPOLICY_KEY = 
            "hdfs.bolt.use.time.based.filerotationpolicy";
    public static final String HDFS_BOLT_USE_TIME_BASED_FILEROTATIONPOLICY_UNIT_KEY =
            "hdfs.bolt.use.time.based.filerotationpolicy.unit";
    public static final String HDFS_BOLT_USE_TIME_BASED_FILEROTATIONPOLICY_DURATION_KEY =
            "hdfs.bolt.use.time.based.filerotationpolicy.duration";

    // HDFS Bolt RotationPolicy - Size Based
    public static final String HDFS_BOLT_USE_SIZE_BASED_FILEROTATIONPOLICY_KEY =
            "hdfs.bolt.use.size.based.filerotationpolicy";
    public static final String HDFS_BOLT_USE_SIZE_BASED_FILEROTATIONPOLICY_UNIT_KEY =
            "hdfs.bolt.use.size.based.filerotationpolicy.unit";
    public static final String HDFS_BOLT_USE_SIZE_BASED_FILEROTATIONPOLICY_SIZE_KEY =
            "hdfs.bolt.use.size.based.filerotationpolicy.size";

    
    // MongoDB
    public static final String MONGO_IP_KEY = "mongo.ip";
    public static final String MONGO_PORT_KEY = "mongo.port";
    public static final String MONGO_DATABASE_NAME_KEY = "mongo.database.name";
    public static final String MONGO_COLLECTION_NAME_KEY = "mongo.collection.name";
    
    // MongoDB Bolt
    public static final String MONGO_BOLT_NAME_KEY = "mongo.bolt.name";
    public static final String MONGO_BOLT_PARALLELISM_KEY = "mongo.bolt.parallelism";
    
    // Storm
    public static final String STORM_TOPOLOGY_NAME_KEY = "storm.topology.name";
    public static final String STORM_ENABLE_DEBUG_KEY = "storm.enable.debug";
    public static final String STORM_NUM_WORKERS_KEY = "storm.num.workers";
    
    // Storm - used for Unit Testing
    public static final String STORM_KILL_TOPOLOGY_WAIT_SECS_KEY = "storm.kill.topology.wait.secs";
	    
}
