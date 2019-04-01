class custom::php {

  package { [ "php5", "php5-curl", "phpunit", "php5-xdebug" ]:
    ensure => "latest"
  }
}
