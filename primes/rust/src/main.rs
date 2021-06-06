use std::time::{SystemTime};

fn main() {
    let mut times = Vec::new();

    for i in 0..2 {
        println!("Starting run {}", i);
        let start = SystemTime::now();
        let _ = primes(10_000_000);

        let time = start.elapsed().unwrap().as_millis();
        times.push(time);
    }

    assert_eq!(primes(10_000_000).len(), 664_579);

    let average = times.iter().sum::<u128>() / times.len() as u128;
    println!("Took {}ms on average", average);
}


fn primes(max: usize) -> Vec<usize> {
    let mut primes_list = Vec::new();

    primes_list.push(2);

    for i in 3..max { //go through all numbers
        for prime in &primes_list { //test each number
            if *prime > (i as f64).sqrt() as usize {
                primes_list.push(i);
                break;
            }
            if i % prime == 0 { //i = test number, j = some known prime
                break;
            }
        }
    }

    return primes_list;
}