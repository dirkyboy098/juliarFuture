#!/bin/bash

echo "a) Downloading"
echo wget https://data.services.jetbrains.com/products/download?code=IIC&platform=linuxWithoutJDK
echo "b) Extracting"
tar zxf ideaIC-2016.3.3-no-jdk.tar.gz
echo "c) Removing"
rm -rf ideaIC-2016.3.3-no-jdk.tar.gz

# Move the versioned IDEA folder to a known location
ideaPath=$(find . -name 'idea-IC*' | head -n 1)
echo "D) Moving $ideaPath"
mv ${ideaPath} ./idea-IC