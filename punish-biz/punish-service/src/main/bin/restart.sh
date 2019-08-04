#!/bin/bash
pid=`ps axu|grep ${project.name}|grep -v grep |awk '{print $2}'`
if [ "$pid" ]; then
  kill $pid
fi
ACTIVE="$1"
if [ -z "$ACTIVE" ]; then
  ACTIVE="dev"
  echo "Use default profile: $ACTIVE"
fi
nohup ./catalina.sh ${project.name} -Heap 128m -Dspring.profiles.active=$ACTIVE 2&> /dev/null &