package kafka;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  消费者拦截器
 */
public class a5_消费者拦截器_ConsumerInterceptorTTL implements ConsumerInterceptor<String, String> {

    // 十秒钟
    private static final long EXPIRE_INTERVAL = 10 * 1000; // 10000

    @Override
    public void configure(Map<String, ?> configs) {

    }

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {
        // 打印输出消息
        for (ConsumerRecord<String, String> record : records) {
            System.out.println("==============================" + record.toString() + "==============================");
        }

        // 获取到当前时间
        long now = System.currentTimeMillis();
        // 创建一个map集合对象
        Map<TopicPartition, List<ConsumerRecord<String, String>>> newRecords = new HashMap<TopicPartition, List<ConsumerRecord<String, String>>>();
        // 循环遍历出消费者的消息分区
        for (TopicPartition tp : records.partitions()) {
            System.out.println(
                    "==============获取到的分区================" + tp.partition() + "==============================");
            // 获取到分区里面的消息
            List<ConsumerRecord<String, String>> tpRecords = records.records(tp);
            // 创建一个集合对象newTpRecords
            List<ConsumerRecord<String, String>> newTpRecords = new ArrayList<>();
            // 循环遍历消息
            for (ConsumerRecord<String, String> record : tpRecords) {
                // 如果消息的时间戳大于当前时间超过10秒，就放到集合中
                if (now - record.timestamp() > EXPIRE_INTERVAL) {
                    // 放到集合中
                    newTpRecords.add(record);
                }
            }
            // 判断是否为空
            if (!newTpRecords.isEmpty()) {
                // 将分区和新的消息放到map集合中
                newRecords.put(tp, newTpRecords);
            }
        }

        for (Map.Entry<TopicPartition, List<ConsumerRecord<String, String>>> map : newRecords.entrySet()) {
            for (int i = 0; i < map.getValue().size(); i++) {
                List<ConsumerRecord<String, String>> value = map.getValue();
                ConsumerRecord<String, String> consumerRecord = value.get(i);
                System.out.println("==============================" + consumerRecord.toString()
                        + "==============================");
            }
        }

        return new ConsumerRecords<String, String>(newRecords);
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> offsets) {
        offsets.forEach((tp, offset) -> System.out.println("获取到的offset位移： " + tp + " : " + offset.offset()));
    }

    @Override
    public void close() {

    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("zhangsan", "hello world zhangsan!!!");
        map.put("lisi", "hello world lisi!!!");
        map.put("wangwu", "hello world wangwu!!!");
        map.put("zhaoliu", "hello world zhaoliu!!!");

        map.forEach((key, value) -> System.out.println("key : " + key + " , value : " + value));
    }

}