<?php
/**
 * CodeEval Challenge Suite
 * 
 * PHP version 5.3
 * 
 * @category Suite
 * @package  CodeEval
 * @author   Marcello Messori <marcello.mm.messori@gmail.com>
 * @license  MIT <http://opensource.org/licenses/MIT>
 * @link     http://www.codeeval.com/profile/double-m
 */

/**
 * Challenge Class - *** CHALLENGE TITLE
 * 
 * PHP version 5.3
 * 
 * @category Algorithm
 * @package  CodeEval
 * @author   Marcello Messori <marcello.mm.messori@gmail.com>
 * @license  MIT <http://opensource.org/licenses/MIT>
 * @link     http://www.codeeval.com/profile/double-m
 */
class Challenge
{
    /**
     * Method processTest
     * 
     * @param string $test line to be processed
     * 
     * @return int|string int for a valid input, empty string otherwise
     */ 
    public function processTest($test)
    {
        return $test;
    }
}

if (isset($phpunit) && $phpunit === true) {
    return null;
}

/**
 * Function output
 * 
 * @param string $message message to be displayed
 * 
 * @return null
 */
function output($message)
{
    echo PHP_EOL
       . $message
       . PHP_EOL
       . PHP_EOL;    
}

$challenge = new Challenge;

if (count($argv) < 2) {
    output(
        'Usage:'
        . PHP_EOL
        . '$ php ' . $argv[0] . ' test_file.txt'
    );
    exit(1);
}

$test_file = $argv[1];
if (! is_readable($test_file)) {
    output("'" . $test_file . "' doesn't exists or it is not readable");
    exit(1);
}

$fh = fopen($argv[1], "r");
while (true) {
    $test = fgets($fh);

    if ($test === false) {
        break;
    }

    echo $challenge->processTest(trim($test)) . PHP_EOL;
}
