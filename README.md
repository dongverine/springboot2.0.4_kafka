### 설치참조 URL
https://devtimes.com/bigdata/2019/01/25/kafka-cluster/

### 카프카 다운로드
http://apache.mirror.cdnetworks.com/kafka/2.1.1/kafka_2.12-2.1.1.tgz

### 방화벽 (centos6.9-final)
iptables -I INPUT -p tcp --dport 2888 -j ACCEPT
iptables -I INPUT -p tcp --dport 3888 -j ACCEPT
iptables -I INPUT -p tcp --dport 2181 -j ACCEPT
iptables -I INPUT -p tcp --dport 9092 -j ACCEPT
/etc/rc.d/init.d/iptables save
/etc/rc.d/init.d/iptables restart

### 카프카 실행 (주키퍼 선행실행 필수)
./bin/zookeeper-server-start.sh ./config/zookeeper.properties
./bin/kafka-server-start.sh ./config/server.properties

### 토픽생성
bin/kafka-topics.sh --create --zookeeper 192.168.184.11:2181, 192.168.184.12:2181, 192.168.184.13:2181 --replication-factor 3 --partitions 1 --topic GameLog

