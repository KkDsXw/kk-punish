#!/bin/bash

if [ ! -f ~/run/${project.name}.pid ]; then
  echo "Server [${project.name}] doest not started!"
  exit
fi

pid=`cat ~/run/${project.name}.pid`
if [ ! -n "${pid}" ]; then
  echo "illegal content in ${project.name}.pid!"
  exit
fi

process=`ps -aux|awk '{print $2}' | grep ${pid}`
if [ -n "${process}" ]; then
  echo "Server [${project.name}] will be stop."
  kill ${pid}

  times=0
  while true
  do
    process=`ps -aux|awk '{print $2}' | grep ${pid}`
    if [ -n "${process}" ] && [ ${times} -lt 10 ]; then
      let times++
      sleep 1
    else
      break
    fi
  done

  process=`ps -aux|awk '{print $2}' | grep ${pid}`
  if [ -n "${process}" ]; then
    echo "Server [${project.name}] cannot stop, Please check pid file '${project.name}.pid' and stop it by manually!"
    exit
  fi
else
  echo "Server [${project.name}] has been stoped!"
fi

rm -f ~/run/${project.name}.pid