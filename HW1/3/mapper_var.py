import sys
import csv

PRICE_COLUMN = 9

def mean(arr):
    return sum(arr) / max(1, len(arr))

def var(arr):
    arr_mean = mean(arr)
    return sum([(x - arr_mean) ** 2 for x in arr]) / max(1, len(arr))

price = list()
data = sys.stdin.readlines()
for line in csv.reader(data):
    p = line[PRICE_COLUMN]
    if len(p) > 0 and p != 'price': # skip csv header and empty values
        price.append(float(p))

print(len(price), mean(price), var(price))