#!/bin/bash
while read -r line
do
	flag=0
	while read -r insample
	do
		if [[ "$line" = "$insample" ]]
		then
			flag=1
		fi
	done <"./allplussample.csv"

	if [ "$flag" -eq "0" ]
	then
		echo $line 
	fi
done <"./allplus.csv"

