'use strict';

let ary = [1, [], [3, 5, [7, [], 9]], 2, [3, 4, [5, 6], [], [7, [8]]]];

function flatten(ary, results) {
  console.log(ary, results);
  if (typeof ary === 'number') {
    results.push(ary);
  } else {
    inner(ary, 0, ary.length, results);
  }
}

function inner(ary, i, count, results) {
  if (i < count) {
    inner(ary, i + 1, count, results);
    flatten(ary[i], results);
  }
}

let results = [];
flatten(ary, results);
console.log(results);
