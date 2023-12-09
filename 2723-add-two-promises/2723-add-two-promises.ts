type P = Promise<number>

async function addTwoPromises(promise1: P, promise2: P): P {
	return Promise
        .all([promise1, promise2])
        .then(([a, b]) => Promise.resolve(a + b));
};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */