const Challenge = class {

    constructor(input) {
        this.book = input;
    }

    solvePart1() {
        return this.book.match(/-?\d+/g).map(n => parseInt(n)).reduce((acc, n) => acc + n, 0);
    }

    solvePart2() {
        const json = JSON.parse(this.book);
        return this.sumForPart2(json);
    }

    sumForPart2(input) {
        if (!Array.isArray(input) && typeof input == 'object' && Object.values(input).some(val => val == "red"))
            return 0;

        let ctr = 0;
        for (const key in input)
            if (typeof input[key] === 'object') ctr += this.sumForPart2(input[key]);
            else if (!isNaN(input[key])) ctr += input[key];
            
        return ctr;
    }
}

module.exports = Challenge;
