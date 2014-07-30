#!/bin/bash

PARAMS=$@
CLASSPATH=$HADOOP_CONF_DIR:$YARN_CONF_DIR:$HDFS_CONF_DIR:../lib/cli/*:../lib/cli/lib/*:../conf:$CLASSPATH

echo "Starting submit YARN job"
echo "CLASSPATH:$CLASSPATH"

java $JAVA_OPTS -cp $CLASSPATH com.greenplum.hamster.cli.HamsterCli $PARAMS
