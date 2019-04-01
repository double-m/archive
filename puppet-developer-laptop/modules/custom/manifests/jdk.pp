class custom::jdk {

  package { "openjdk-8-jdk":
    ensure => "latest"
  }
}
