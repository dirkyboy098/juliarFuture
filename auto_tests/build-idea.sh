#!/bin/bash

ideaVersion="16.0.2"

if [ ! -d ./idea-IC ]; then
    # Get our IDEA dependency
    if [ -f ~/Tools/ideaIC-${ideaVersion}.tar.gz ];
    then
        cp ~/Tools/ideaIC-${ideaVersion}.tar.gz .
    else
        wget https://data.services.jetbrains.com/products/download?code=IIC&platform=linuxWithoutJDK
    fi

    # Unzip IDEA
    tar zxf ideaIC-${ideaVersion}.tar.gz
    rm -rf ideaIC-${ideaVersion}.tar.gz

    # Move the versioned IDEA folder to a known location
    ideaPath=$(find . -name 'idea-IC*' | head -n 1)
    mv ${ideaPath} ./idea-IC
fi