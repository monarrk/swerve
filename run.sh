#!/bin/sh

cwd=`pwd`
cd build
java Driver
cd ${cwd}
