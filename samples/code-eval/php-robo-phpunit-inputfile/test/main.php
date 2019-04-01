<?php
/**
 * CodeEval Challenge Test Suite
 * 
 * PHP version 5.3
 * 
 * @category TestSuite
 * @package  CodeEval
 * @author   Marcello Messori <marcello.mm.messori@gmail.com>
 * @license  MIT <http://opensource.org/licenses/MIT>
 * @link     http://www.codeeval.com/profile/double-m
 */

$phpunit = true;
require
    dirname(dirname(__FILE__))
    . DIRECTORY_SEPARATOR . 'src'
    . DIRECTORY_SEPARATOR . 'app.php';

/**
 * ChallengeTest Class - *** CHALLENGE TITLE
 * 
 * PHP version 5.3
 * 
 * @category TestSuite
 * @package  CodeEval
 * @author   Marcello Messori <marcello.mm.messori@gmail.com>
 * @license  MIT <http://opensource.org/licenses/MIT>
 * @link     http://www.codeeval.com/profile/double-m
 */
class ChallengeTest extends PHPUnit_Framework_TestCase
{
    protected $challenge;
    
    public function ChallengeTest()
    {
        $this->challenge = new Challenge;
    }
    
    public function testThisSuite()
    {
        $this->assertEquals('abc', $this->challenge->processTest('abc'));
    }
}

