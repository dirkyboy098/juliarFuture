#!/bin/bash

echo "a) Downloading"
echo wget -O idea.tar.gz https://data.services.jetbrains.com/products/download?code=IIC&platform=linuxWithoutJDK 
echo "b) Extracting"
tar zxf idea.tar.gz
echo "c) Removing"
rm -rf idea.tar.gz

# Move the versioned IDEA folder to a known location
ideaPath=$(find . -name 'idea-IC*' | head -n 1)
echo "D) Moving $ideaPath"
mv ${ideaPath} ./idea-IC


# Run the tests
ant -f juliarfuture.xml -Didea.home=./idea-IC -Djdk.bin=${JAVA_HOME}/bin compile.module.juliarfuture.tests

# Was our build successful?
stat=$?

if [ "${TRAVIS}" != true ]; then
    ant -f travis-ci.xml -q clean
    rm -rf idea-IC
fi

# Return the build status
exit ${stat}