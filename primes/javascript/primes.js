
const times = [];

for (let i = 0; i < 10; i++) {
    console.log(`staring ${i} run`)
    const startTime = Date.now();
    primes(10_000_000)
    const totalTime = Date.now() - startTime;
    times.push(totalTime);
}

const average = times.reduce((a, b) => a + b, 0) / times.length;
console.log(`Average time was ${average}ms`)



function primes(max) {
    const primesList = [];

    primesList.push(2);

    for (let i = 3; i < max; i++) { //go through all numbers
        let isPrime = true;
        for (let j = 0; j < primesList.length; j++) { //test each number
            let prime = primesList[j];
            if (prime > Math.sqrt(i)) {
                break;
            }
            if (i % prime === 0) { //i = test number, j = some known prime
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            primesList.push(i);
        }
    }

    return primesList;
}