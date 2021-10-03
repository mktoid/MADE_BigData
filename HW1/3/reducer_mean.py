import sys

for line in sys.stdin:
        cj, mj = list(map(float, line.split()))

for line in sys.stdin:
        ck, mk = list(map(float, line.split()))
        mi = (cj*mj + ck*mk) / (cj + ck)
        cj, mj = ck, mi

print(mj)