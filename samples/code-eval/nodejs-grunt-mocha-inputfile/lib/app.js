var fs  = require('fs')
  , fileToProcess = process.argv[2];

if (!fileToProcess || fileToProcess.charAt(0)==='-') {
  fileToProcess = './input/void-file.txt';
}

fs.readFileSync(fileToProcess).toString().split('\n').forEach(function (line) {
  if (line !== "") {
    var result = processLine(line);
    
    if (result !== null) {
      console.log(result);
    }
  }
});

function processLine(line) {
  return line;
}

exports.processLine = processLine;
