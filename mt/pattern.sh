#!/bin/bash
grep -q -i 'june' 'allplus.csv' 
exitstatus=$?
if [ "$exitstatus" -eq "0" ]
then
echo "found"
else
echo "not found"
fi

