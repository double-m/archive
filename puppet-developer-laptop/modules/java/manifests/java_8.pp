class java::java_8 {
  
  include 'apt'
  
  apt::source { 'webupd8team': 
    location    => 'http://ppa.launchpad.net/webupd8team/java/ubuntu',
    release     => 'trusty',
    repos       => 'main',
    include_src => true,
    key         => 'EEA14886',
    key_server  => 'keyserver.ubuntu.com'
  }
  ->
  exec { 'accept-java-license':
    command => '/bin/echo /usr/bin/debconf shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections;/bin/echo /usr/bin/debconf shared/accepted-oracle-license-v1-1 seen true | sudo /usr/bin/debconf-set-selections;',
    unless  => '/usr/bin/dpkg -s oracle-java8-installer'
  }
  ->
  package { 'oracle-java8-installer' :
    ensure => 'installed'
  }
}