import sys

for line in sys.stdin:
        cj, mj, vj = list(map(float, line.split()))
        break

for line in sys.stdin:
        ck, mk, vk = list(map(float, line.split()))
        cjk = cj + ck
        vi = ((cj * vj + ck * vk) / cjk) + cj * ck * ((mj - mk) / cjk) ** 2
        cj, mj, vj = ck, mk, vi

print(vj)