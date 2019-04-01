class custom::mysql {
	
  package { "mysql-server":
    ensure => "latest"
  }
  ->
  exec { "mysql should be stopped":
    command => "/etc/init.d/mysql stop"
  }
  ->
  exec { "mysql should not start at boot":
    command => "/usr/sbin/update-rc.d -f mysql remove"
  }
}
