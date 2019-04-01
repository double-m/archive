class custom::latex {
	
  package { ['texlive',
             'texlive-fonts-extra',
             'texlive-lang-italian']:
             
	  ensure => 'latest'
  }
}
