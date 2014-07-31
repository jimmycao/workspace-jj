#!/bin/bash
IFS=:

for file in $PATH; do
	echo $file

	if [ -d $file ]; then
		ls -ld $file  #-d  Directories are listed as plain files (not searched recursively).
	fi
done