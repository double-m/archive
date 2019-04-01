class custom::ssh_keygen {
	
  file { "${home}/.ssh":
    ensure => "directory",
    owner  => $real_id,
    group  => $real_id,
    mode   => 750
  }
  ->
  exec { "generate ssh key":
    command => "ssh-keygen -t rsa -N '' -f ${home}/.ssh/id_rsa",
    path => "/usr/bin",
    creates => "${home}/.ssh/id_rsa"
  }
  ->
  file { ["${home}/.ssh/id_rsa", "${home}/.ssh/id_rsa.pub"]:
    ensure => "file",
    owner  => $real_id,
    group  => $real_id,
    mode   => 400
  }
}
