const fs = require('fs').promises;

const Parser = class {
};

Parser.parseText = data => data.trim();

Parser.parseFile = async filePath => {
    const data = await fs.readFile(filePath, { encoding: 'utf-8' });
    return data.trim();
};

module.exports = Parser;
