class scala {
  
  include base::bin

  File {
    owner  => $real_id,
    group  => $real_id
  }

  $scala_dir = "${home}/bin/scala-2.11.4"  
  $scala_dir_exists = "/usr/bin/test -d ${scala_dir}"

  # for now we'll only install a single version of scala
  wget::fetch { 'http://downloads.typesafe.com/scala/2.11.4/scala-2.11.4.tgz':
    destination => "/tmp/scala-2.11.4.tgz",   
    unless      => $scala_dir_exists
  }
  ->
  exec { "/bin/tar -xzf /tmp/scala-2.11.4.tgz -C ${home}/bin/":
    unless => $scala_dir_exists, 
    user   => $real_id,
    group  => $real_id
  }
  ->
  file { "${home}/bin/scala-current":
    ensure => 'link',
    target => $scala_dir
  }
  ->
  file { "${home}/bin/scala":
    ensure => 'link',
    target => "${home}/bin/scala-current/bin/scala"
  }
  ->
  file { "${home}/bin/scalac":
    ensure => 'link',
    target => "${home}/bin/scala-current/bin/scalac"
  }
  ->
  file { "${home}/bin/scaladoc":
    ensure => 'link',
    target => "${home}/bin/scala-current/bin/scaladoc"
  }
}