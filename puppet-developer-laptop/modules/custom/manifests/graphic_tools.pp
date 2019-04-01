class custom::graphic_tools{
	
  package { [ "gimp", "inkscape" ]:
    ensure => "latest"
  }
}
