# usage: cat AB_NYC_2019.csv | python standard.py 
import sys
import csv

def mean(arr):
    return sum(arr) / max(1, len(arr))

def var(arr):
    arr_mean = mean(arr)
    return sum([(x - arr_mean) ** 2 for x in arr]) / max(1, len(arr))

i = 0
price = list()
data = sys.stdin.readlines()
for line in csv.reader(data):
    if i > 0: # skip header
        p = line[9] # price column
        if len(p) > 0:
            price.append(float(line[9]))
    i+= 1

print('MEAN:', mean(price))
print('VAR:', var(price))

