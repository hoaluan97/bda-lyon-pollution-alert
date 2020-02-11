package bda.meteo.alert.topology;

import org.apache.storm.topology.TopologyBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.storm.kafka.spout.KafkaSpout;
import org.apache.storm.kafka.spout.KafkaSpoutConfig;


public class ConfigureKafkaSpout {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigureKafkaSpout.class);

    public static void configureKafkaSpout(TopologyBuilder builder, String zkHostString, String kafkaTopic, 
                                           String kafkaStartOffset, int parallelismHint, String spoutName, 
                                           String tempDir, String groupId) {

        LOG.info("KAFKASPOUT: Configuring the KafkaSpout");
        
        KafkaSpout kafkaSpout = new KafkaSpout<>(KafkaSpoutConfig.builder(zkHostString, kafkaTopic).setProp(ConsumerConfig.GROUP_ID_CONFIG, "group-AMZOHONG").build());

        // Add the spout and bolt to the topology
        LOG.info("KAFKASPOUT: spoutname: " + spoutName);
        LOG.info("KAFKASPOUT: zkHostString: " + zkHostString);
        LOG.info("KAFKASPOUT: kafkaTopic: " + kafkaTopic);
        LOG.info("KAFKASPOUT: parallelismHint: " + parallelismHint);
        
        builder.setSpout(spoutName, kafkaSpout, parallelismHint);

    }
}