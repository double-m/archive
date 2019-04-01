class custom::nodejs {
	
  exec { "add node source to apt":
    command => "curl -sL https://deb.nodesource.com/setup | sudo bash - && apt-get update",
    onlyif => "test ! -f /etc/apt/sources.list.d/nodesource.list",
    path => "/usr/bin"
  }
  ->
  package { "nodejs":
    ensure => "latest"
  }

  exec { "install packages globally via npm":
    command => "npm install -g bower grunt-cli",
    path => "/usr/bin"
  }
}
