#!/bin/bash

echo "a) Downloading"
wget https://data.services.jetbrains.com/products/download?code=IIC&platform=linuxWithoutJDK
echo "b) Extracting"
tar zxf ideaIC-*.tar.gz
echo "c) Removing"
rm -rf ideaIC-*.tar.gz

# Move the versioned IDEA folder to a known location
ideaPath=$(find . -name 'idea-IC*' | head -n 1)
echo "D) Moving $ideaPath"
mv ${ideaPath} ./idea-IC