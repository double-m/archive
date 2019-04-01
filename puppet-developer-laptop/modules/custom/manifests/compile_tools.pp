class custom::compile_tools {

  package { [ "autoconf", "bison", "libxml2-dev" ]:
    ensure => "latest"
  }

}

