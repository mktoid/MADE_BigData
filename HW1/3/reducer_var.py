import sys

for line in sys.stdin:
        cj, mj, vj = line.split()

for line in sys.stdin:
        ck, mk, vk = line.split()
        cjk = cj + ck
        vi = ((cj*vj + ck*vk) / cjk) + cj * ck * ((mj - mk)/cjk)**2
        cj, mj, vj = ck, mk, vi

print(vj)