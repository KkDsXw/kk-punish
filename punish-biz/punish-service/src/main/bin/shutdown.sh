#!/bin/bash
kill `ps axu|grep ${project.name}|grep -v grep |grep 'java' |awk '{print $2}'`