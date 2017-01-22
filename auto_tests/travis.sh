#!/bin/bash

chmod +x build-idea.sh
./build-idea.sh

# Run the tests
ant -f travis-ci.xml -Didea.home=./idea-IC -Djdk.bin=${JAVA_HOME}/bin test.modules

# Was our build successful?
stat=$?

if [ "${TRAVIS}" != true ]; then
    ant -f travis-ci.xml -q clean
    rm -rf idea-IC
fi

# Return the build status
exit ${stat}