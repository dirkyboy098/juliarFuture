#!/bin/bash

if [ ! -d ./idea-IC ]; then
    wget https://data.services.jetbrains.com/products/download?code=IIC&platform=linuxWithoutJDK
    tar zxf ideaIC-*.tar.gz
    rm -rf ideaIC-*.tar.gz

    # Move the versioned IDEA folder to a known location
    ideaPath=$(find . -name 'idea-IC*' | head -n 1)
    mv ${ideaPath} ./idea-IC
fi