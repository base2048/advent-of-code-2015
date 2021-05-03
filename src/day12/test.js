const Parser = require('./Parser');
const Challenge = require('./Challenge');

const input = JSON.stringify({
    first: 'abc',
    'aloha': 3,
    second: [1, 2, 3, 'red'],
    third: {
        first: 3,
        second: 4,
        third: ['a', 'b', 'c', 1, { a: 2, b: 1, c: 'red' }],
        fourth: {
            first: 'a',
            second: 'b'
        }
    },
    "fourth": {
        a: 'red',
        b: '1'
    }
});

const challenge = new Challenge(Parser.parseText(input));

const resultPart1 = challenge.solvePart1();     // 21
const resultPart2 = challenge.solvePart2();     // 17

console.log("Part1 Test passed: " + (resultPart1 === 21));
console.log("Part2 Test passed: " + (resultPart2 === 17));
