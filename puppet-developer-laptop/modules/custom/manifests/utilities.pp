class custom::utilities{
	
  package { [ "markdown", "nmap", "whois" ]:
    ensure => "latest"
  }
}
