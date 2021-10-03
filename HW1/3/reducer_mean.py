import sys

for line in sys.stdin:
        cj, mj = line.split()

for line in sys.stdin:
        ck, mk = line.split()
        mi = (cj*mj + ck*mk) / (cj + ck)
        cj, mj = ck, mi

print(mj)