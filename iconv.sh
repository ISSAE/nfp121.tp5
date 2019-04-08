#! /bin/bash
to="utf-8"
f=$(file -i $1)
from=${f#*charset=}
if [[ $from != $to ]]; then
    echo "iconv -f $from -t $to $1 -o $1"
    iconv -f $from -t $to $1 -o $1
fi
