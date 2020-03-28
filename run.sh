#!/bin/sh

if [ $1 == "" ];then 
	echo "Usage: $0 project_path"
	echo "project_path - path where roject is located"
fi

PROJECT_DIR="$(readlink -f $1)"

function run_docker() {
	docker run \
		-it --rm \
		--name drools_container_app \
		-v "$PROJECT_DIR/src/":/usr/src/mymaven/src \
		-v "$PROJECT_DIR/pom.xml":/usr/src/mymaven/pom.xml \
		-v "$PROJECT_DIR/.m2/":/root/.m2 \
		-w /usr/src/mymaven \
		maven mvn $*
}

if [ $2 = "test" ]; then
	run_docker test
else
	run_docker clean package exec:java
fi
