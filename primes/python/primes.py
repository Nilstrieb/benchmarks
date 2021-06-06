import time
from math import sqrt


def primes(max):
    primes_list = [2]

    for i in range(3, max):
        is_prime = True
        for prime in primes_list:
            if prime > sqrt(i):
                break
            if i % prime == 0:
                is_prime = False
                break

        if is_prime:
            primes_list.append(i)

    return primes_list


start_millis = round(time.time() * 1000)
primes(10_000_000)
total_millis = round(time.time() * 1000) - start_millis

print(total_millis)
