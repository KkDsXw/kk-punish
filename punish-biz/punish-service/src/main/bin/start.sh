#!/bin/bash

ACTIVE="$1"
if [ -z "$ACTIVE" ]; then
  ACTIVE="production"
  echo "Use default profile: $ACTIVE"
fi

[ ! -d ~/run/ ] && mkdir -p ~/run

if [ -f ~/run/${project.name}.pid ]; then
  echo "Server [${project.name}] pid file has been exists!";
  exit
fi

HEAP_MEMORY=1g
SERVER_JAR=`ls ../lib/${jar.name}`

exec "${JAVA_HOME}/bin/java" -server -Dspring.profiles.active=$ACTIVE -Xms${HEAP_MEMORY} -Xmx${HEAP_MEMORY} -XX:+HeapDumpOnOutOfMemoryError -jar ${SERVER_JAR} >/dev/null 2>&1 & echo $! > ~/run/${project.name}.pid