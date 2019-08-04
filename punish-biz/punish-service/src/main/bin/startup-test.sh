#!/bin/bash
ACTIVE="$1"
if [ -z "$ACTIVE" ]; then
  ACTIVE="test"
  echo "Use default profile: $ACTIVE"
fi
nohup bash catalina.sh ${project.name} -Heap 512m -Dspring.profiles.active=$ACTIVE 2&> /dev/null &