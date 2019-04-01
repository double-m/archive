class custom::apache {
	
  package { "apache2":
    ensure => "latest"
  }
  ->
  exec { "apache2 should be stopped":
    command => "/etc/init.d/apache2 stop"
  }
  ->
  exec { "apache2 should not start at boot":
    command => "/usr/sbin/update-rc.d -f apache2 remove"
  }
}
