use std::time::{SystemTime};

fn main() {
    let mut times = Vec::new();

    for i in 0..10 {
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


fn primes(max: u32) -> Vec<u32> {
    let mut primes_list: Vec<u32> = Vec::new();

    primes_list.push(2);

    for mut i in 3..max {
        let sqr_root: u32 = (i as f64).sqrt() as u32;
        for prime in &primes_list { //test each number
            if *prime > sqr_root {
                primes_list.push(i);
                break;
            }
            if i % prime == 0 { //i = test number, j = some known prime
                break;
            }
        }
        i += 1;
    }

    primes_list
}